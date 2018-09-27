package com.niles.jpushmodule;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.guanguan.testDemo.R;
import com.niles.jpushmodule.db.MessageDao;
import com.niles.jpushmodule.db.MessageEntity;
import com.niles.jpushmodule.db.MyDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MessageListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.rv_list);
        mAdapter = new MessageListAdapter();
        recyclerView.setAdapter(mAdapter);

        MyDatabase database = ((MyApp) getApplication()).getDatabase();
        final MessageDao messageDao = database.messageDao();
        messageDao.getAll().observe(this, new Observer<List<MessageEntity>>() {
            @Override
            public void onChanged(@Nullable List<MessageEntity> messageEntities) {
                if (messageEntities != null) {
                    mAdapter.setDataList(messageEntities);
                } else {
                    mAdapter.setDataList(new ArrayList<MessageEntity>());
                }
            }
        });
    }
}
