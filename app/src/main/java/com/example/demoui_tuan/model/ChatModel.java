package com.example.demoui_tuan.model;

public class ChatModel {
    public static final String TYPE_RECEIVE = "TYPE_RECEIVE";
    public static final String TYPE_SENT = "TYPE_SEND";

    private String chatType;
    private String chatContent;

    public ChatModel(String chatType, String chatContent) {
        this.chatType = chatType;
        this.chatContent = chatContent;
    }

    public String getChatType() {
        return chatType;
    }

    public void setChatType(String chatType) {
        this.chatType = chatType;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }
}
