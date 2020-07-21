package com.example.tk5;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import bean.VpBean;

public class MyRecyAdapter extends RecyclerView.Adapter<MyRecyAdapter.Handle> {
    private ArrayList<VpBean.DataBean.DatasBean> list;
    private Context context;

    public MyRecyAdapter(ArrayList<VpBean.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyRecyAdapter.Handle onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.rec_pro_item_layout, null);
        return new Handle(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyAdapter.Handle handle, int i) {
             handle.title.setText(list.get(i).getTitle());
//        RequestOptions options = RequestOptions.circleCropTransform();
        Glide.with(context).load(list.get(i).getEnvelopePic()).into(handle.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Handle extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;
        public Handle(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title_pro);
        }
    }

}
