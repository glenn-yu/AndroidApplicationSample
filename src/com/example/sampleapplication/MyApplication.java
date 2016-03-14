package com.example.sampleapplication;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.util.Log;

public class MyApplication extends Application implements
		ActivityLifecycleCallbacks {

	// 안드로이드 앱에서는 Application을 상속받아 재정의하여 사용할 수 있다.
	// AndroidManifest.xml에서 application에서 android:name=".MyApplication을 추가한다.

	// 모든 컴포넌트는 애플리케이션 객체로 접근 가능하다.
	// 그뿐만 아니라 특정 컴포넌트에서 애플리케이션 객체에 접근하여 데이터를 저장하고,
	// 또 다른 컴포넌트에서 애플리케이션 객체를 통해 저장된 데이터를 참조할 수 있다.
	private static String TAG = "MyApplication";

	// Application을 이용한 Activity 간 데이터 공유.
	// AndroidManifest.xml에 AActivity를 추가.
	// <activity android:name=".AActivity"/>
	private String mAppData = "";

	public String getAppData() {
		return mAppData;
	}

	public void setAppData(String mAppData) {
		this.mAppData = mAppData;
	}

	// ActivityLifecycleCallbacks를 활용한 앱 종료
	private boolean mIsAppFinishState = false;

	// 애플리케이션 객체는 어떤 컴포넌트보다 먼저 생성되고 한 번 생성된 객체는
	// 프로세스가 종료되지 않는 한 유지된다.
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();

		Log.i(TAG, "Application onCreate() ");
	}

	// 앱의 프로세스가 종료되어야 실행된다.
	// 프로세스가 종료되지 않는 한 애플리케이션 객체도 소멸되지 않는다.
	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		Log.i(TAG, "Application onTerminate() ");

		super.onTerminate();
	}

	public void finishApp(Activity activity) {
		mIsAppFinishState = true;
		activity.finish();
	}

	// 애플리케이션이ㅡ 액티비티 생명주기 콜백 인터페이스
	// API 14부터 추가.
	@Override
	public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.i(TAG, "ActivityLifecycleCallbacks onActivityCreate()");
	}

	@Override
	public void onActivityStarted(Activity activity) {
		// TODO Auto-generated method stub
		Log.i(TAG, "ActivityLifecycleCallbacks onActivityStarted()");
	}

	// ActivityLifecycleCallbacks를 활용한 앱 종료
	@Override
	public void onActivityResumed(Activity activity) {
		// TODO Auto-generated method stub
		Log.i(TAG, "ActivityLifecycleCallbacks onActivityResumed()");

		if (mIsAppFinishState == true) {
			activity.finish();

			if (activity.isTaskRoot() == true) {
				mIsAppFinishState = false;
			}
		}
	}

	@Override
	public void onActivityPaused(Activity activity) {
		// TODO Auto-generated method stub
		Log.i(TAG, "ActivityLifecycleCallbacks onActivityPaused()");
	}

	@Override
	public void onActivityStopped(Activity activity) {
		// TODO Auto-generated method stub
		Log.i(TAG, "ActivityLifecycleCallbacks onActivityStopped()");
	}

	@Override
	public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
		// TODO Auto-generated method stub
		Log.i(TAG, "ActivityLifecycleCallbacks onActivitySaveInstanceState()");
	}

	@Override
	public void onActivityDestroyed(Activity activity) {
		// TODO Auto-generated method stub
		Log.i(TAG, "ActivityLifecycleCallbacks onActivityDestroyed()");
	}

}
