package com.example.sampleapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AActivity extends Activity {

	private static String TAG = "AActivity";

	// MainActivity -> MyApplication -> AActivity
	// -->>> startActivity
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_activity_main);
		Log.i(TAG, "AActivity onCreate()");

		TextView tv = (TextView) findViewById(R.id.text_view);

		MyApplication app = (MyApplication) getApplicationContext();
		tv.setText(app.getAppData());
	}

	public void onClick(View v) {
		MyApplication app = (MyApplication) getApplicationContext();
		app.finishApp(this);
	}
}
