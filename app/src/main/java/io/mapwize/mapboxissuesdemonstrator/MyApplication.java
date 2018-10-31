package io.mapwize.mapboxissuesdemonstrator;

import android.app.Application;
import android.content.Context;

import io.mapwize.mapwizeformapbox.AccountManager;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AccountManager.start(this, "YOUR_API_KEY");
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

}
