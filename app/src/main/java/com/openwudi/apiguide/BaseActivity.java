package com.openwudi.apiguide;

import android.support.v7.app.ActionBarActivity;

/**
 * Created by wudi on 15/7/3.
 */
public class BaseActivity extends ActionBarActivity {
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
