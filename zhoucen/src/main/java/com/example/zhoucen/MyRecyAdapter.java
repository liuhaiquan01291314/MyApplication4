package com.example.zhoucen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MyRecyAdapter extends RecyclerView.Adapter {
    private ArrayList<Bean.DataBean.DatasBean> list;
    private Context context;

    public MyRecyAdapter(ArrayList<Bean.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recy, viewGroup, false);
        View view = ViewGroup.inflate(context, R.layout.layout_recy, null);
        return new ViewHandle(view);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
         ViewHandle viewHandle= (ViewHandle) viewHolder;
          viewHandle.tit.setText(list.get(i).getChapterName());
        //        RequestOptions options = RequestOptions.circleCropTransform();
        RequestOptions options = RequestOptions.circleCropTransform();
        Glide.with(context).load(list.get(i).getEnvelopePic()).apply(options).into(viewHandle.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
     class ViewHandle extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tit;
         public ViewHandle(@NonNull View itemView) {
             super(itemView);
              img=itemView.findViewById(R.id.img);
              tit=itemView.findViewById(R.id.title);
         }
     }
}
