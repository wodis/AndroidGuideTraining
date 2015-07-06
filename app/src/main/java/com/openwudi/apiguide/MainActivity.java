package com.openwudi.apiguide;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    ListView listView;
    MainAdapter adapter;

    List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();
        data.add("Activities");
        data.add("Services");
        data.add("MessengerServices");
        data.add("Handler");
        data.add("LooperHandler");


        adapter = new MainAdapter(this, data);
        listView = (ListView) findViewById(R.id.lv);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class MainAdapter extends BaseAdapter {
        Context context;
        List<String> data;

        public MainAdapter(Context context, List<String> data) {
            this.context = context;
            this.data = data;
        }

        public void reset(List<String> updateData) {
            data.clear();
            data.addAll(updateData);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            String title = data.get(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_main, parent, false);
                convertView.setTag(new ViewHolder(convertView));
            }

            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.textView.setText(title);

            viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, position + "", Toast.LENGTH_SHORT).show();

                    Intent intent = null;

                    switch (position) {
                        case 0:
                            intent = new Intent(context, SavedInstanceStateActivity.class);
                            break;
                        case 1:
                            intent = new Intent(context, ServicesActivity.class);
                            break;
                        case 2:
                            intent = new Intent(context, ServiceMessengerActivity.class);
                            break;
                        case 3:
                            intent = new Intent(context, HandlerActivity.class);
                            break;
                        case 4:
                            intent = new Intent(context, LooperHandlerActivity.class);
                            break;
                    }

                    if (intent != null) {
                        context.startActivity(intent);
                    }
                }
            });

            return convertView;
        }


        class ViewHolder {
            TextView textView;

            public ViewHolder(View view) {
                textView = (TextView) view.findViewById(R.id.textView);
            }
        }
    }
}
