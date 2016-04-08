package com.taskulu.armanso.realofit.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.taskulu.armanso.realofit.helper.DoubleRealm;
import java.io.IOException;
import io.realm.RealmList;

public class DoubleTypeAdapter {
    public TypeAdapter generate() {
        return new TypeAdapter<RealmList<DoubleRealm>>() {
            @Override
            public void write(JsonWriter out, RealmList<DoubleRealm> value) throws IOException {
                // Ignore
            }

            @Override
            public RealmList<DoubleRealm> read(JsonReader in) throws IOException {
                RealmList<DoubleRealm> list = new RealmList<DoubleRealm>();
                in.beginArray();
                while (in.hasNext()) {
                    list.add(new DoubleRealm(in.nextDouble()));
                }
                if (in.peek() == JsonToken.END_ARRAY) {
                    in.endArray();
                }
                return list;
            }
        };
    }
}
