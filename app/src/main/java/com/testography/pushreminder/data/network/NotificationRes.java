package com.testography.pushreminder.data.network;

public class NotificationRes {
    private int id;
    private String title;
    private String content;
    private String date;

    public NotificationRes(Integer id, String title,
                           String content, String dateGmt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = dateGmt;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }
}
