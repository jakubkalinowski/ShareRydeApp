package com.example.jakubkalinowski.sharerydeapp;

import android.app.Application;

import com.firebase.client.Firebase;

// Life-cycle of the entire app
public class ShareRyde extends Application {

    // Pass Android context to Firebase
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
