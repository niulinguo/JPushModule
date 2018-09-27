package com.niles.jpushmodule.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Niles
 * Date 2018/9/26 18:08
 * Email niulinguo@163.com
 */
@Dao
public interface MessageDao {

    @Insert
    void insert(MessageEntity... entities);

    @Query("SELECT * FROM tb_message")
    LiveData<List<MessageEntity>> getAll();
}
