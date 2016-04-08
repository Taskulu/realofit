package com.taskulu.armanso.realofit.RealmObjects.Reddit;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class LastQuestionDataChildrenData extends RealmObject {
    private String kind;
    private String thumbnail;
    private String title;
    private String permalink;

    @PrimaryKey
    private String id;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
