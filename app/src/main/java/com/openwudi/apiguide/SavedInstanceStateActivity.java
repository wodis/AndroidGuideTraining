package com.openwudi.apiguide;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by wudi on 15/7/3.
 */
public class SavedInstanceStateActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("onCreate", "create");

        if (savedInstanceState != null && savedInstanceState.containsKey("save")) {
            Log.i("onCreate", savedInstanceState.getString("save"));
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        SharedPreferences.Editor editor = getPreferences(Activity.MODE_PRIVATE).edit();
        editor.putString("save", "onSaveInstanceState");
        editor.apply();

        outState.putString("save", "onSaveInstanceState");

        super.onSaveInstanceState(outState);

        Log.i("onSaveInstanceState", "saved");
    }
}
