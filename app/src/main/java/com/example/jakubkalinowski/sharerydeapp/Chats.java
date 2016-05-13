package com.example.jakubkalinowski.sharerydeapp;

public class Chats {
    private String name;
    private String text;

    public Chats() {
        // necessary for Firebase's deserializer
    }
    public Chats(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}
