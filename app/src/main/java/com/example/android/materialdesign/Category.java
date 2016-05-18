package com.example.android.materialdesign;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by flopez on 18-05-2016.
 */

public class Category {
    String title;
    String detail;

    Category(String title, String detail) {
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

