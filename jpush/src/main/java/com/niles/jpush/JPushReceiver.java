package com.niles.jpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import java.util.Set;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Niles
 * Date 2018/9/26 16:47
 * Email niulinguo@163.com
 * <p>
 * https://docs.jiguang.cn/jpush/client/Android/android_api/#receiver
 */
public final class JPushReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        switch (action) {
            case JPushInterface.ACTION_NOTIFICATION_RECEIVED: {
                onNotificationReceived(context, intent);
                break;
            }
        }
    }

    /**
     * 功能描述
     * <p>
     * 收到了通知 Push。
     * 如果通知的内容为空，则在通知栏上不会展示通知。
     * 但是，这个广播 Intent 还是会有。开发者可以取到通知内容外的其他信息。
     */
    private void onNotificationReceived(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            return;
        }
        /*
        保存服务器推送下来的通知的标题。
        对应 API 通知内容的 title 字段。
        对应 Portal 推送通知界面上的“通知标题”字段。
         */
        String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
        /*
        保存服务器推送下来的通知内容。
        对应 API 通知内容的 alert 字段。
        对应 Portal 推送通知界面上的“通知内容”字段。
         */
        String content = bundle.getString(JPushInterface.EXTRA_ALERT);
        /*
        SDK 1.2.9 以上版本支持。
        保存服务器推送下来的附加字段。这是个 JSON 字符串。
        对应 API 通知内容的 extras 字段。
        对应 Portal 推送消息界面上的“可选设置”里的附加字段。
         */
        String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
        /*
        SDK 1.3.5 以上版本支持。
        通知栏的 Notification ID，可以用于清除 Notification
        如果服务端内容（alert）字段为空，则 Notification ID 为 0
         */
        int notificationId = bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
        /*
        SDK 1.4.0 以上版本支持。
        富媒体通知推送下载的 HTML 的文件路径，用于展现 WebView。
         */
        String fileHtml = bundle.getString(JPushInterface.EXTRA_RICHPUSH_HTML_PATH);
        /*
        SDK 1.4.0 以上版本支持。
        富媒体通知推送下载的图片资源的文件名，多个文件名用 “，” 分开。与 “JPushInterface.EXTRA_RICHPUSH_HTML_PATH” 位于同一个路径。
         */
        String fileStr = bundle.getString(JPushInterface.EXTRA_RICHPUSH_HTML_RES);
        String[] fileNames = null;
        if (!TextUtils.isEmpty(fileStr)) {
            fileNames = fileStr.split(",");
        }
        /*
        SDK 1.6.1 以上版本支持。
        唯一标识通知消息的 ID，可用于上报统计等。
         */
        String msgID = bundle.getString(JPushInterface.EXTRA_MSG_ID);
        /*
        SDK 3.0.0 以上版本支持，支持 api 16 以上的 rom。
        大文本通知样式中大文本的内容。
         */
        String bigText = bundle.getString(JPushInterface.EXTRA_BIG_TEXT);
        /*
        SDK 3.0.0 以上版本支持，支持 api 16 以上的 rom。
        可支持本地图片的路径，或者填网络图片地址。
        大图片通知样式中大图片的路径/地址。
         */
        String bigPicPath = bundle.getString(JPushInterface.EXTRA_BIG_PIC_PATH);
        /*
        SDK 3.0.0 以上版本支持，支持 api 16 以上的 rom。
        获取的是一个 JSONObject，json 的每个 key 对应的 value 会被当作文本条目逐条展示。
        收件箱通知样式中收件箱的内容。
         */
        String inboxJson = bundle.getString(JPushInterface.EXTRA_INBOX);
        /*
        SDK 3.0.0 以上版本支持，支持 api 16 以上的 rom。
        默认为 0，范围为 -2～2，其他值将会被忽略而采用默认。
        通知的优先级。
         */
        String prio = bundle.getString(JPushInterface.EXTRA_NOTI_PRIORITY);
        /*
        SDK 3.0.0 以上版本支持，支持 api 21 以上的 rom。
        完全依赖 rom 厂商对每个 category 的处理策略，比如通知栏的排序。
        通知分类。
         */
        String cate = bundle.getString(JPushInterface.EXTRA_NOTI_CATEGORY);

        NotificationReceivedModel notificationReceivedModel = NotificationReceivedModel
                .newBuilder()
                .setTitle(title)
                .setContent(content)
                .setExtras(extras)
                .setNotificationID(notificationId)
                .setFileHtml(fileHtml)
                .setFileNames(fileNames)
                .setMsgID(msgID)
                .setBigText(bigText)
                .setBigPicPath(bigPicPath)
                .setInboxJson(inboxJson)
                .setPrio(prio)
                .setCate(cate)
                .build();

        onNotificationReceived(context, notificationReceivedModel);
    }

    protected void onNotificationReceived(Context context, NotificationReceivedModel model) {
        Set<JPushListener> listeners = JPushManager.getListeners();
        for (JPushListener listener : listeners) {
            if (listener instanceof NotificationReceivedAble) {
                ((NotificationReceivedAble) listener).onNotificationReceived(context, model);
            }
        }
    }
}
