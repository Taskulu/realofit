package com.taskulu.armanso.realofit.Interfaces.API;

import com.taskulu.armanso.realofit.RealmObjects.Reddit.LastQuestion;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface RedditService {

    @GET(".json")
    Call<LastQuestion> lastQuestion();

}
