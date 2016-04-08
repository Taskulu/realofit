package com.taskulu.armanso.realofit.helper;

import io.realm.RealmObject;

/**
 * String for supporting Realmlist
 */
public class StringRealm extends RealmObject {

    private String val;

    public StringRealm() {}

    public StringRealm(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
