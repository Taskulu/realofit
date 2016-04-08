package com.taskulu.armanso.realofit.helper;

import io.realm.RealmObject;

/**
 * Double for supporting Realmlist
 */
public class DoubleRealm extends RealmObject {

    private Double val;

    public DoubleRealm() {}

    public DoubleRealm(Double val) {
        this.val = val;
    }

    public Double getVal() {
        return val;
    }

    public void setVal(Double val) {
        this.val = val;
    }
}
