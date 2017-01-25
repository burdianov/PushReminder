package com.testography.pushreminder.data.managers;

import io.realm.Realm;
import io.realm.RealmObject;

public class RealmManager {
    private Realm mRealmInstance;

    public void deleteFromRealm(Class<? extends RealmObject> entityRealmClass,
                                String id) {
        Realm realm = Realm.getDefaultInstance();
        RealmObject entity = realm
                .where(entityRealmClass).equalTo("id", id).findFirst();
        if (entity != null) {
            realm.executeTransaction(realm1 -> entity.deleteFromRealm());
            realm.close();
        }
    }

    private Realm getQueryRealmInstance() {
        if (mRealmInstance == null || mRealmInstance.isClosed()) {
            mRealmInstance = Realm.getDefaultInstance();
        }
        return mRealmInstance;
    }
}
