package com.taskulu.armanso.realofit;

import android.content.Context;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.taskulu.armanso.realofit._retrofit.LibModule;
import com.taskulu.armanso.realofit.annotion.Realofit;
import com.taskulu.armanso.realofit.helper.BooleanRealm;
import com.taskulu.armanso.realofit.helper.DoubleRealm;
import com.taskulu.armanso.realofit.helper.IntegerRealm;
import com.taskulu.armanso.realofit.helper.LongRealm;
import com.taskulu.armanso.realofit.helper.StringRealm;
import com.taskulu.armanso.realofit.typeadapter.BooleanTypeAdapter;
import com.taskulu.armanso.realofit.typeadapter.DoubleTypeAdapter;
import com.taskulu.armanso.realofit.typeadapter.IntegerTypeAdapter;
import com.taskulu.armanso.realofit.typeadapter.LongTypeAdapter;
import com.taskulu.armanso.realofit.typeadapter.StringTypeAdapter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;

public class RealofitLib {

    String TAG = "Realofit";
    ArrayList<Class> classes;
    private final RealmConfiguration realmConfig;

    TypeAdapter StringRealmtypeadp;
    TypeAdapter Integerrealmtypeadp;
    TypeAdapter BooleanRealmtypeadp;
    TypeAdapter DoubleRealmtypeadp;
    TypeAdapter LongRealmtypeadp;

    Type StringRealmtype;
    Type DoubleRealmtype;
    Type LongRealmtype;
    Type Integerrealmtype;
    Type Booleanrealmtype;

    public RealofitLib(Context context)
    {
        //prevent realm lib issue
        realmConfig = new RealmConfiguration.Builder(context)
                .name("library.realofit.realm")
                .setModules(new LibModule())
                .build();
        Realm.getInstance(realmConfig);
        classes = new ArrayList<Class>();
    }

    private void search(Class baseclass)
    {
        for (Field f: baseclass.getDeclaredFields()) {
            Realofit column = f.getAnnotation(Realofit.class);
            if (column != null) {
                if(!classes.equals(column.value()))
                {
                    classes.add(column.value());
                }
                search(column.value());
            }
        }
    }

    public Gson build(Class classbase) {

        if(classes != null) {
            classes.add(classbase);
            search(classbase);
        }

        StringRealmtypeadp = new StringTypeAdapter().generate();
        Integerrealmtypeadp = new IntegerTypeAdapter().generate();
        BooleanRealmtypeadp = new BooleanTypeAdapter().generate();
        DoubleRealmtypeadp = new DoubleTypeAdapter().generate();
        LongRealmtypeadp = new LongTypeAdapter().generate();

        StringRealmtype = new TypeToken<RealmList<StringRealm>>() {}.getType();
        DoubleRealmtype = new TypeToken<RealmList<DoubleRealm>>() {}.getType();
        LongRealmtype = new TypeToken<RealmList<LongRealm>>() {}.getType();
        Integerrealmtype = new TypeToken<RealmList<IntegerRealm>>() {}.getType();
        Booleanrealmtype = new TypeToken<RealmList<BooleanRealm>>() {}.getType();

        return new GsonBuilder()
                .setExclusionStrategies(strategy)
                .registerTypeAdapter(StringRealmtype, StringRealmtypeadp)
                .registerTypeAdapter(DoubleRealmtype, DoubleRealmtypeadp)
                .registerTypeAdapter(LongRealmtype, LongRealmtypeadp)
                .registerTypeAdapter(DoubleRealmtype, DoubleRealmtypeadp)
                .registerTypeAdapter(Integerrealmtype, Integerrealmtypeadp)
                .create();
    }

    ExclusionStrategy strategy = new ExclusionStrategy() {
        @Override
        public boolean shouldSkipField(FieldAttributes f) {
            String mname = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
            Method methodToFind = null;
            for(Class eachclass:classes)
            {
                try {
                    methodToFind = eachclass.getMethod("get" + mname, (Class<?>[]) null);
                } catch (NoSuchMethodException e) {
                    //e.printStackTrace();
                }
            }
            if (methodToFind != null) {
                return false;
            }
            return true;
        }
        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }
    };

}
