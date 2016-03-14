package com.example.sampleapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AReceiver extends BroadcastReceiver {

	private static String TAG = "AReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		MyApplication app = (MyApplication) context.getApplicationContext();
		Log.i(TAG, "Receiver : " + app.getAppData());

	}

}
