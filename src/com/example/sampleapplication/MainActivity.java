package com.example.sampleapplication;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private static String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btn = (Button) findViewById(R.id.start_a_activity_btn);
		btn.setOnClickListener(this);

		Log.i(TAG, "MainActivity onCreate()");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		Log.i(TAG, "MainActivity onDestory()");
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// Activity 간 데이터 공유
		MyApplication app = (MyApplication) getApplicationContext();
		app.setAppData("Application Sample App");

		// 1. 내부 액티비티 실행
		startActivity(new Intent(this, AActivity.class));

		// 2. 내부 서비스 실행
		Intent serviceIntent = new Intent("android.sampleapplication.AService");
		startService(serviceIntent);

		// 3. 내부 리시버 실행
		Intent receiverIntent = new Intent(
				"android.sampleapplication.AReceiver");
		sendBroadcast(receiverIntent);

		// 4. 내부 콘텐트 프로바이더 실행
		Uri providerUri = Uri
				.parse("content://com.sampleapplication.AProvider");
		getContentResolver().insert(providerUri, null);
	}

	// 엑티액티비티에 모든 생명주기 함수 추가

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		Log.i(TAG, "MainActivity onStart()");
		super.onStart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		Log.i(TAG, "MainActivity onResume()");
		super.onResume();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		Log.i(TAG, "MainActivity onSaveInstanceState()");
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		Log.i(TAG, "MainActivity onPause()");
		super.onPause();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		Log.i(TAG, "MainActivity onStop()");
		super.onStop();
	}
}
