package com.example.demoui_tuan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.demoui_tuan.adapter.ChatAdapter;
import com.example.demoui_tuan.databinding.FragmentChatBinding;
import com.example.demoui_tuan.model.ChatModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FragmentChatBinding mBinding;
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    List<ChatModel> models = new ArrayList<>();
    ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.fragment_chat);
        models.add(new ChatModel(ChatModel.TYPE_RECEIVE,"Xin chao toi ten la A"));
        models.add(new ChatModel(ChatModel.TYPE_SENT,"Xin chao toi ten la A"));
        models.add(new ChatModel(ChatModel.TYPE_RECEIVE,"Xin chao toi ten la B"));
        models.add(new ChatModel(ChatModel.TYPE_RECEIVE,"Xin chao toi ten la C"));
        models.add(new ChatModel(ChatModel.TYPE_SENT,"Xin chao toi ten la D"));
        models.add(new ChatModel(ChatModel.TYPE_RECEIVE,"Xin chao toi ten la E"));
        chatAdapter = new ChatAdapter(models);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBinding.recyclerViewChat.setLayoutManager(layoutManager);
        mBinding.recyclerViewChat.setAdapter(chatAdapter);
    }
}