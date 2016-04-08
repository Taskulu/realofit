package com.taskulu.armanso.realofit.RealmObjects.Reddit;

import com.taskulu.armanso.realofit.annotion.Realofit;
import com.taskulu.armanso.realofit.helper.BooleanRealm;
import com.taskulu.armanso.realofit.helper.StringRealm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class LastQuestion extends RealmObject {

    @PrimaryKey
    private String id = "LastQuestion";

    private String kind;

    @Realofit(LastQuestionData.class)
    private LastQuestionData data;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public LastQuestionData getData() {
        return data;
    }

    public void setData(LastQuestionData data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
