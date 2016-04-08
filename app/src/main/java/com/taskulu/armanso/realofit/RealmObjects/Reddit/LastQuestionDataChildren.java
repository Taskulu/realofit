package com.taskulu.armanso.realofit.RealmObjects.Reddit;

import com.taskulu.armanso.realofit.annotion.Realofit;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class LastQuestionDataChildren extends RealmObject {

    @PrimaryKey
    private String id = "LastQuestionDataChildren";

    @Realofit(LastQuestionDataChildrenData.class)
    private LastQuestionDataChildrenData data;

    public LastQuestionDataChildrenData getData() {
        return data;
    }

    public void setData(LastQuestionDataChildrenData data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
