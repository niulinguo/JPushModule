package com.niles.jpushmodule;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guanguan.testDemo.R;
import com.niles.jpushmodule.db.MessageEntity;

import java.util.List;

/**
 * Created by Niles
 * Date 2018/9/27 00:52
 * Email niulinguo@163.com
 */
public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.ViewHolder> {

    private List<MessageEntity> mDataList;

    void setDataList(List<MessageEntity> list) {
        if (mDataList == null) {
            mDataList = list;
        } else {
            mDataList.clear();
            mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_message_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.mTextView.setText(mDataList.get(i).getContent());
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    static final class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextView = itemView.findViewById(R.id.tv_text);
        }
    }
}
