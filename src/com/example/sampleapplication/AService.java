package com.example.sampleapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class AService extends Service {
	
	private static String TAG = "AService";
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		MyApplication app = (MyApplication)getApplicationContext();
		Log.i(TAG, "Service : " + app.getAppData());
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
}
