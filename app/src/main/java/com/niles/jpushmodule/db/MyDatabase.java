package com.niles.jpushmodule.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Niles
 * Date 2018/9/26 18:09
 * Email niulinguo@163.com
 */
@Database(
        entities = {
                MessageEntity.class
        },
        version = 1,
        exportSchema = false
)
public abstract class MyDatabase extends RoomDatabase {

    public static MyDatabase create(Context context) {
        return Room.databaseBuilder(context, MyDatabase.class, "jpush_data.db")
                .allowMainThreadQueries()
                .build();
    }

    public abstract MessageDao messageDao();
}
