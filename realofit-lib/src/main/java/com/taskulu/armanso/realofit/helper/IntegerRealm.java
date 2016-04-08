package com.taskulu.armanso.realofit.helper;

import io.realm.RealmObject;

/**
 * Integer for supporting Realmlist
 */
public class IntegerRealm extends RealmObject {

    private int val;

    public IntegerRealm() {}

    public IntegerRealm(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}


