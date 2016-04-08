package com.taskulu.armanso.realofit.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.taskulu.armanso.realofit.helper.BooleanRealm;
import java.io.IOException;
import io.realm.RealmList;

public class BooleanTypeAdapter {
    public TypeAdapter generate() {
        return new TypeAdapter<RealmList<BooleanRealm>>() {
            @Override
            public void write(JsonWriter out, RealmList<BooleanRealm> value) throws IOException {
                // Ignore
            }

            @Override
            public RealmList<BooleanRealm> read(JsonReader in) throws IOException {
                RealmList<BooleanRealm> list = new RealmList<BooleanRealm>();
                in.beginArray();
                while (in.hasNext()) {
                    list.add(new BooleanRealm(in.nextBoolean()));
                }
                if (in.peek() == JsonToken.END_ARRAY) {
                    in.endArray();
                }
                return list;
            }
        };
    }
}
