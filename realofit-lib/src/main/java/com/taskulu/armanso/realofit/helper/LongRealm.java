package com.taskulu.armanso.realofit.helper;

import io.realm.RealmObject;

/**
 * Long for supporting Realmlist
 */
public class LongRealm extends RealmObject {

    private long val;

    public LongRealm() {}

    public LongRealm(long val) {
        this.val = val;
    }

    public long getVal() {
        return val;
    }

    public void setVal(long val) {
        this.val = val;
    }
}
