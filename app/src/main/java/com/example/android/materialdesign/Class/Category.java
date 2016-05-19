package com.example.android.materialdesign.Class;

/**
 * Created by flopez on 18-05-2016.
 */

public class Category {

    public String title;
    public String detail;

    public Category(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

