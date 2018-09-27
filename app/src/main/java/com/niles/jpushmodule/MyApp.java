package com.niles.jpushmodule;

import android.app.Application;
import android.content.Context;

import com.niles.jpush.JPushManager;
import com.niles.jpush.NotificationReceivedAble;
import com.niles.jpush.NotificationReceivedModel;
import com.niles.jpushmodule.db.MessageEntity;
import com.niles.jpushmodule.db.MyDatabase;

/**
 * Created by Niles
 * Date 2018/9/26 13:42
 * Email niulinguo@163.com
 */
public class MyApp extends Application implements NotificationReceivedAble {

    MyDatabase mMyDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        mMyDatabase = MyDatabase.create(this);

        JPushManager.init(this);
        JPushManager.addListener(this);
    }

    public MyDatabase getDatabase() {
        return mMyDatabase;
    }

    @Override
    public void onNotificationReceived(Context context, NotificationReceivedModel model) {
        String msgID = model.getMsgID();
        String title = model.getTitle();
        String content = model.getContent();
        String extras = model.getExtras();

        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMsgID(msgID);
        messageEntity.setTitle(title);
        messageEntity.setContent(content);
        messageEntity.setExtras(extras);
        messageEntity.setCreateTime(System.currentTimeMillis());

        MyDatabase database = ((MyApp) context.getApplicationContext()).getDatabase();
        database.messageDao().insert(messageEntity);
    }
}
