package com.newbie.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.newbie.myapplication.R;
import com.newbie.myapplication.model.Content;
import com.newbie.myapplication.model.Notify;

import java.util.ArrayList;
import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {

    private ArrayList<Content> contents;
    private Context context;

    public ContentAdapter(ArrayList<Content> contentList) {
        this.contents = contentList;
    }

    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View vieww = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        return new ContentViewHolder(vieww);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder Holder, int position) {
        Content content = contents.get(position);

        Holder.txt_lokasi.setText(content.getLokasi());
        Holder.txt_keterangan.setText(content.getKeterangan());
        Holder.txt_user.setText(content.getUser());
        Holder.txt_times.setText(content.getTimes());
    }

    @Override
    public int getItemCount() {
       return (contents != null) ? contents.size() : 0;
    }

    public class ContentViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_lokasi, txt_keterangan, txt_user, txt_times;
        private ImageView imgUser, imgContent;
        public ContentViewHolder(View view) {
            super(view);
            txt_lokasi = view.findViewById(R.id.txt_lokasi);
            txt_keterangan = view.findViewById(R.id.txt_ket);
            txt_times = view.findViewById(R.id.txt_times);
            txt_user = view.findViewById(R.id.txt_user);
            imgUser = view.findViewById(R.id.img_profile);
            imgContent = view.findViewById(R.id.img_lokasi);
        }
    }
}
