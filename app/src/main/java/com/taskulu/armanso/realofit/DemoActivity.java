package com.taskulu.armanso.realofit;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.widget.EditText;

import com.taskulu.armanso.realofit.Adapter.RVAdapter;
import com.taskulu.armanso.realofit.Interfaces.API.RedditService;
import com.taskulu.armanso.realofit.RealmObjects.Reddit.LastQuestion;
import com.taskulu.armanso.realofit.RealmObjects.Reddit.LastQuestionDataChildrenData;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DemoActivity extends AppCompatActivity implements TextWatcher {

    private String _url = "http://reddit.com/";
    RecyclerView rv;
    LinearLayoutManager llm;
    private RVAdapter adapter;
    ProgressDialog loading;
    EditText search;
    Realm realmObj;
    RealmResults<LastQuestionDataChildrenData> result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_demo);

        realmObj = Realm.getInstance(getApplicationContext());
        rv = (RecyclerView)findViewById(R.id.rv);
        search = (EditText)findViewById(R.id.search);
        search.addTextChangedListener(this);
        llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        loading = ProgressDialog.show(this, "", "Loading. Please wait...", false);
        sendRequest();
    }
    private Retrofit builder(Class input)
    {
        return new Retrofit.Builder()
                .baseUrl(_url)
                .addConverterFactory(GsonConverterFactory.create(new RealofitLib(getApplicationContext()).build(input)))
                .build();
    }
    private void sendRequest()
    {
        Retrofit retrofit = builder(LastQuestion.class);
        RedditService service = retrofit.create(RedditService.class);
        service.lastQuestion().enqueue(new Callback<LastQuestion>() {
            @Override
            public void onResponse(Call<LastQuestion> call, Response<LastQuestion> response) {

                // save it in realm easily
                realmObj.beginTransaction();
                realmObj.copyToRealmOrUpdate(response.body().getData().getChildren());
                realmObj.commitTransaction();

                result = realmObj.where(LastQuestionDataChildrenData.class).findAll();
                render(result);
                loading.hide();
            }

            @Override
            public void onFailure(Call<LastQuestion> call, Throwable t) {
                loading.hide();
                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(DemoActivity.this, R.style.AlertDialogCustom));
                builder.setMessage("Request faild").setPositiveButton("RETRY", dialogClickListener).setCancelable(false).show();
            }
        });
    }
    private void render(RealmResults<LastQuestionDataChildrenData> data)
    {
        adapter = new RVAdapter(getApplicationContext(), data);
        rv.setAdapter(adapter);
    }
    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    loading.show();
                    sendRequest();
                    break;
            }
        }
    };

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(!s.toString().equals("")) {
            result = realmObj.where(LastQuestionDataChildrenData.class).contains("title", s.toString()).findAll();
        }
        else
        {
            result = realmObj.where(LastQuestionDataChildrenData.class).findAll();
        }
        render(result);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
