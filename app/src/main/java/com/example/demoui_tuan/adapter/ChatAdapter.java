package com.example.demoui_tuan.adapter;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoui_tuan.R;
import com.example.demoui_tuan.databinding.ItemReceivedMessagesBinding;
import com.example.demoui_tuan.databinding.ItemSentMessageBinding;
import com.example.demoui_tuan.model.ChatModel;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    List<ChatModel> mChatModel;
    private final int TYPE_SEND = 1;
    private final int TYPE_RECEIVE = 0;

    public ChatAdapter(List<ChatModel> mChatModel) {
        this.mChatModel = mChatModel;
    }

    @Override
    public int getItemViewType(int position) {
        if (mChatModel.get(position).getChatType().equals(ChatModel.TYPE_RECEIVE)){
            return TYPE_RECEIVE;
        }
        return TYPE_SEND;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType ==TYPE_RECEIVE){
            ItemReceivedMessagesBinding receivedMessagesBinding = DataBindingUtil.inflate(inflater, R.layout.item_received_messages,parent,false);
            return new ChatViewHolder(receivedMessagesBinding);
        }
        else {
            ItemSentMessageBinding sentMessageBinding = DataBindingUtil.inflate(inflater,R.layout.item_sent_message,parent,false);
            return new ChatViewHolder(sentMessageBinding);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ChatViewHolder holder, int position) {
        ChatModel chatModel = mChatModel.get(position);
        if (chatModel.getChatType().equals(ChatModel.TYPE_SENT)&&holder.sentMessageBinding!=null){
            holder.sentMessageBinding.txtSentContent.setText(chatModel.getChatContent());
        }
        else if (chatModel.getChatType().equals(ChatModel.TYPE_RECEIVE)&&holder.receivedMessagesBinding!=null){
            holder.receivedMessagesBinding.receivedMessagesContent.setText(chatModel.getChatContent());
        }

    }

    @Override
    public int getItemCount() {
        return mChatModel.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        ItemSentMessageBinding sentMessageBinding;
        ItemReceivedMessagesBinding receivedMessagesBinding;
        public ChatViewHolder(@NonNull View itemView,int itemType) {
            super(itemView);
        }
        public ChatViewHolder(ItemSentMessageBinding sentMessageBinding){
            super(sentMessageBinding.getRoot());
            this.sentMessageBinding = sentMessageBinding;
        }
        public ChatViewHolder(ItemReceivedMessagesBinding receivedMessagesBinding){
            super(receivedMessagesBinding.getRoot());
            this.receivedMessagesBinding = receivedMessagesBinding;
        }
    }
}
