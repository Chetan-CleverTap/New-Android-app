package com.example.ctdemo;

import android.app.Application;

import com.clevertap.android.sdk.ActivityLifecycleCallback;
import com.clevertap.android.sdk.CleverTapAPI;

public class MyApplication extends Application {
    private static CleverTapAPI cleverTapDefaultInstance;

    public static CleverTapAPI getCleverTapDefaultInstance() {
        return cleverTapDefaultInstance;
    }

    @Override
    public void onCreate() {
        CleverTapAPI.setUIEditorConnectionEnabled(true);//Set to false in production
        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG); //Set to OFF in production
        ActivityLifecycleCallback.register(this);
//        registerActivityCallback();


//        JSONObject configSetting = new JSONObject();
//        try {
//            configSetting.put("accountId", "TEST-549-W7Z-775Z");
//            configSetting.put("accountToken", "TEST-1a0-c45");
//            configSetting.put("enableABTesting", true);
//            configSetting.put("enableUIEditor", true);
//            configSetting.put("debugLevel", 2);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        CleverTapInstanceConfig config = CleverTapInstanceConfig.createInstance(getApplicationContext(),
//                "TEST-549-W7Z-775Z", "TEST-1a0-c45");
//        config.setAnalyticsOnly(false);
//
//        config.setDebugLevel(CleverTapAPI.LogLevel.DEBUG);
//        config.setEnableABTesting
//        registerUninstallBroadcastReceiver();
        super.onCreate();


//        cleverTapDefaultInstance = CleverTapAPI.instanceWithConfig(getApplicationContext(), config);
//        new Thread(() -> {
//            Looper.prepare();
//            cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
//            cleverTapDefaultInstance.enableDeviceNetworkInfoReporting(true);
//        }).start();

        cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(
                getApplicationContext());

        cleverTapDefaultInstance.enablePersonalization();

//        CleverTapAPI.createNotificationChannelGroup(getApplicationContext(), "group_id", "group_name");
//
//        CleverTapAPI.createNotificationChannel(getApplicationContext(), "chnl_1", "channel_name",
//                "channel_description", NotificationManager.IMPORTANCE_MIN, "group_id",
//                true, "ct_test_ring_tone.mp3");
//
//
//        CleverTapAPI.createNotificationChannelGroup(getApplicationContext(), "group_id2", "group_name2");
//
//        CleverTapAPI.createNotificationChannel(getApplicationContext(), "chnl_2", "channel_name2",
//                "channel_description2", NotificationManager.IMPORTANCE_MAX, "group_id2", true);
    }

//    private void registerActivityCallback() {
//        this.registerActivityLifecycleCallbacks(
//                new android.app.Application.ActivityLifecycleCallbacks() {
//
//                    @Override
//                    public void onActivityCreated(Activity activity, Bundle bundle) {
//                        CleverTapAPI.setAppForeground(true);
//                        try {
//                            CleverTapAPI.getDefaultInstance(MyApplication.this).pushNotificationClickedEvent(activity.getIntent().getExtras());
//                        } catch (Throwable t) {
//                            // Ignore
//                        }
//                        try {
//                            Intent intent = activity.getIntent();
//                            Uri data = intent.getData();
//                            CleverTapAPI.getDefaultInstance(MyApplication.this).pushDeepLink(data);
//                        } catch (Throwable t) {
//                            // Ignore
//                        }
//                    }
//
//                    @Override
//                    public void onActivityStarted(Activity activity) {
//                    }
//
//                    @Override
//                    public void onActivityResumed(Activity activity) {
//                        try {
//                            CleverTapAPI.getDefaultInstance(MyApplication.this).onActivityResumed(activity);
//                        } catch (Throwable t) {
//                            // Ignore
//                        }
//                    }
//
//                    @Override
//                    public void onActivityPaused(Activity activity) {
//                        try {
//                            CleverTapAPI.getDefaultInstance(MyApplication.this).onActivityPaused();
//                        } catch (Throwable t) {
//                            // Ignore
//                        }
//                    }
//
//                    @Override
//                    public void onActivityStopped(Activity activity) {
//                    }
//
//                    @Override
//                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
//                    }
//
//                    @Override
//                    public void onActivityDestroyed(Activity activity) {
//                    }
//                }
//        );
//    }

//    private void registerUninstallBroadcastReceiver() {
//
//        BroadcastReceiver uninstallApplication = new BroadcastReceiver() {
//
//            @Override
//            public void onReceive(Context context, Intent intent) {
//
//                Log.d("Uninstall ", "Bye");
//
//                String packageName = Objects.requireNonNull(intent.getData()).getEncodedSchemeSpecificPart();
//
//                Toast.makeText(context, "USER UNINSTALL : " + packageName, Toast.LENGTH_SHORT).show();
//
//            }
//        };
//
//        IntentFilter filter = new IntentFilter();
//        filter.addCategory(Intent.CATEGORY_DEFAULT);
//        filter.addAction(Intent.ACTION_PACKAGE_ADDED);
//        filter.addAction(Intent.ACTION_PACKAGE_CHANGED);
//        filter.addAction(Intent.ACTION_PACKAGE_INSTALL);
//        filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
//        filter.addAction(Intent.ACTION_PACKAGE_REPLACED);
//        filter.addAction(Intent.ACTION_PACKAGE_RESTARTED);
////        filter.addAction(Intent.ACTION_QUERY_PACKAGE_RESTART);
//        filter.addDataScheme("package");
//        getApplicationContext().registerReceiver(uninstallApplication, filter);
////
////        IntentFilter intentFilter = new IntentFilter();
////        intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
////        intentFilter.addDataScheme("package");
////        registerReceiver(uninstallApplication, intentFilter);
//
////        UninstallIntentReceiver br = new UninstallIntentReceiver();
////        IntentFilter intentFilter = new IntentFilter();
//////        intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
////        intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
//////        intentFilter.addAction(Intent.ACTION_PACKAGE_INSTALL);
////        intentFilter.addDataScheme("package");
////        registerReceiver(br, intentFilter);
//    }
}
