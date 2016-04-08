package com.taskulu.armanso.realofit.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.taskulu.armanso.realofit.helper.IntegerRealm;
import java.io.IOException;
import io.realm.RealmList;

public class IntegerTypeAdapter {
    public TypeAdapter generate() {
        return new TypeAdapter<RealmList<IntegerRealm>>() {
            @Override
            public void write(JsonWriter out, RealmList<IntegerRealm> value) throws IOException {
                // Ignore
            }

            @Override
            public RealmList<IntegerRealm> read(JsonReader in) throws IOException {
                RealmList<IntegerRealm> list = new RealmList<IntegerRealm>();
                in.beginArray();
                while (in.hasNext()) {
                    list.add(new IntegerRealm(in.nextInt()));
                }
                if (in.peek() == JsonToken.END_ARRAY) {
                    in.endArray();
                }
                return list;
            }
        };
    }
}
