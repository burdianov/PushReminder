package com.testography.pushreminder.data.storage.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class NotificationRealm extends RealmObject {
    @PrimaryKey
    private int id;
    private String title;
    private String content;
    private String date;
}
