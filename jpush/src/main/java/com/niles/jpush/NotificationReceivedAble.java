package com.niles.jpush;

import android.content.Context;

/**
 * Created by Niles
 * Date 2018/9/27 11:34
 * Email niulinguo@163.com
 */
public interface NotificationReceivedAble extends JPushListener {
    void onNotificationReceived(Context context, NotificationReceivedModel model);
}
