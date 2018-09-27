package com.niles.jpush;

import android.app.Application;

import java.util.LinkedHashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Niles
 * Date 2018/9/26 13:41
 * Email niulinguo@163.com
 */
public class JPushManager {

    private static Set<JPushListener> sListeners = new LinkedHashSet<>();

    public static void init(Application app) {
        JPushInterface.setDebugMode(BuildConfig.DEBUG);
        JPushInterface.init(app);
    }

    public static void addListener(JPushListener jPushListener) {
        sListeners.add(jPushListener);
    }

    public static void removeListener(JPushListener jPushListener) {
        sListeners.remove(jPushListener);
    }

    static Set<JPushListener> getListeners() {
        return sListeners;
    }
}
