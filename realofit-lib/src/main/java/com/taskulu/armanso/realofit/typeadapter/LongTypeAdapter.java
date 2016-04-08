package com.taskulu.armanso.realofit.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.taskulu.armanso.realofit.helper.LongRealm;
import java.io.IOException;
import io.realm.RealmList;


public class LongTypeAdapter {
    public TypeAdapter generate() {
        return new TypeAdapter<RealmList<LongRealm>>() {
            @Override
            public void write(JsonWriter out, RealmList<LongRealm> value) throws IOException {
                // Ignore
            }

            @Override
            public RealmList<LongRealm> read(JsonReader in) throws IOException {
                RealmList<LongRealm> list = new RealmList<LongRealm>();
                in.beginArray();
                while (in.hasNext()) {
                    list.add(new LongRealm(in.nextLong()));
                }
                if (in.peek() == JsonToken.END_ARRAY) {
                    in.endArray();
                }
                return list;
            }
        };
    }
}
