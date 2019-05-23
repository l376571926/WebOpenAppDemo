package com.zontek.webopenappdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.socks.library.KLog;

public class IntentReceiverActivity extends AppCompatActivity {

    private static final String TAG = IntentReceiverActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_intent_receiver);
        Intent intent = getIntent();
        KLog.e( "intent.toString(): " + intent.toString());
        String dataString = intent.getDataString();
        KLog.e( "intent.getDataString(): " + dataString);
        Uri uri = intent.getData();
        if (uri != null) {
            String uriString = uri.toString();
            KLog.e( "uri.toString(): " + uriString);
        }
        String toUri = intent.toUri(0);
        KLog.e( "intent.toUri(0): " + toUri);
        String scheme = intent.getScheme();
//        KLog.e( "intent.getScheme();: " + scheme);
        viewDataBinding.setVariable(BR.data, dataString);
    }
}
