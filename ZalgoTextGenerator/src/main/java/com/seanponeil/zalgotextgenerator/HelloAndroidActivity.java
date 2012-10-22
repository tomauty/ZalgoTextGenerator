package com.seanponeil.zalgotextgenerator;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

public class HelloAndroidActivity extends Activity {

    private static String TAG = "ZalgoTextGenerator";

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after
     * previously being shut down then this Bundle contains the data it most
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        WebView wv = new WebView(this);
        setContentView(wv);

        wv.loadDataWithBaseURL("file:///android_asset/", ZalgoString.generateHTML("Welcome to Zalgo Text"),"text/html", "utf-8", null);

    }

}

