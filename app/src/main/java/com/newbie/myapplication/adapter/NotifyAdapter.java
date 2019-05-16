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
import com.newbie.myapplication.model.Notify;

import java.util.ArrayList;
import java.util.List;

public class NotifyAdapter extends RecyclerView.Adapter<NotifyAdapter.NotifyViewHolder> {
    private static final String TAG =  NotifyAdapter.class.getSimpleName();

    private Context context;
    private ArrayList<Notify> notifyArrayList;

    public NotifyAdapter(ArrayList<Notify> notifyArrayList) {
        this.notifyArrayList = notifyArrayList;
    }

    @NonNull
    @Override
    public NotifyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list_notify, viewGroup, false);
        return new NotifyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotifyViewHolder viewHolder, int i) {
        Notify notify = notifyArrayList.get(i);
        viewHolder.txt_user.setText(notify.getUser());
        viewHolder.txt_times.setText(notify.getTimes());
        viewHolder.txt_lokasi.setText(notify.getLokasi());
        viewHolder.txt_keterangan.setText(notify.getKeterangan());
    }

    @Override
    public int getItemCount() {
        return (notifyArrayList != null) ? notifyArrayList.size() : 0;
    }

    public class NotifyViewHolder extends RecyclerView.ViewHolder{

        private TextView txt_user,txt_times, txt_lokasi, txt_keterangan;
        private ImageView img;

        public NotifyViewHolder(View item) {
            super(item);
            txt_user = item.findViewById(R.id.notif_user);
            txt_times = item.findViewById(R.id.notif_times);
            txt_lokasi = item.findViewById(R.id.notif_lokasi);
            txt_keterangan = item.findViewById(R.id.notif_ket);
            img = item.findViewById(R.id.notif_img_lokasi);
        }
    }


}
