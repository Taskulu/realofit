package com.taskulu.armanso.realofit.typeadapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.taskulu.armanso.realofit.helper.StringRealm;
import java.io.IOException;
import io.realm.RealmList;


public class StringTypeAdapter {
    public TypeAdapter generate() {
        return new TypeAdapter<RealmList<StringRealm>>() {
            @Override
            public void write(JsonWriter out, RealmList<StringRealm> value) throws IOException {
                // Ignore
            }

            @Override
            public RealmList<StringRealm> read(JsonReader in) throws IOException {
                RealmList<StringRealm> list = new RealmList<StringRealm>();
                in.beginArray();
                while (in.hasNext()) {
                    list.add(new StringRealm(in.nextString()));
                }
                if (in.peek() == JsonToken.END_ARRAY) {
                    in.endArray();
                }
                return list;
            }
        };
    }
}
