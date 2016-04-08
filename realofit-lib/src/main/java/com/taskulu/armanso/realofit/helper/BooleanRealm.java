package com.taskulu.armanso.realofit.helper;

import io.realm.RealmObject;

/**
 * Boolean for supporting Realmlist
 */
public class BooleanRealm extends RealmObject {

    private boolean val;

    public BooleanRealm() {}

    public BooleanRealm(boolean val) {
        this.val = val;
    }

    public boolean getVal() {
        return val;
    }

    public void setVal(boolean val) {
        this.val = val;
    }
}
