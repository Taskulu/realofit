package com.taskulu.armanso.realofit.Adapter;

import android.support.v7.widget.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.taskulu.armanso.realofit.R;
import com.taskulu.armanso.realofit.RealmObjects.Reddit.LastQuestionDataChildren;
import com.taskulu.armanso.realofit.RealmObjects.Reddit.LastQuestionDataChildrenData;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmResults;

public class RVAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private RealmResults<LastQuestionDataChildrenData> feedItemList;
    private Context mContext;

    public RVAdapter(Context context, RealmResults<LastQuestionDataChildrenData> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list_row, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        LastQuestionDataChildrenData feedItem = feedItemList.get(i);
        if(!feedItem.getThumbnail().equals("")) {
            Picasso.with(mContext).load(feedItem.getThumbnail()).placeholder(R.drawable.placeholder).into(customViewHolder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }
}

class CustomViewHolder extends RecyclerView.ViewHolder {
    protected ImageView imageView;

    public CustomViewHolder(View view) {
        super(view);
        imageView = (ImageView)view.findViewById(R.id.image);
    }
}
