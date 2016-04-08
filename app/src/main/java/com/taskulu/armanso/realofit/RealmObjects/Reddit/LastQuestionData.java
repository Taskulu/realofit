package com.taskulu.armanso.realofit.RealmObjects.Reddit;

import com.taskulu.armanso.realofit.annotion.Realofit;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class LastQuestionData extends RealmObject {

    @PrimaryKey
    private String id = "LastQuestionData";

    @Realofit(LastQuestionDataChildren.class)
    private RealmList<LastQuestionDataChildren> children;

    public RealmList<LastQuestionDataChildren> getChildren() {
        return children;
    }

    public void setChildren(RealmList<LastQuestionDataChildren> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
