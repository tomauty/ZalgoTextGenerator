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
        setContentView(R.layout.main);

        TextView tv = (TextView) findViewById(R.id.hello);
        //tv.setTypeface(Typeface.createFromAsset(getAssets(), "DejaVuSans.ttf"));

        tv.setText(Html.fromHtml(ZalgoString.generate("Welcome to Zalgo Text")));
    }

}

