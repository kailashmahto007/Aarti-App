package com.example.aartiapp;

import android.content.Context;

public class ModelClass {


    private Context context;
    private  int image ;
    private String title;
    private int song;


    public ModelClass(Context context, int image, String title,int song) {
        this.context = context;
        this.image = image;
        this.title = title;
        this.song=song;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }
}
