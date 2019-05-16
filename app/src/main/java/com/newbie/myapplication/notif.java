package com.newbie.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.newbie.myapplication.adapter.ContentAdapter;
import com.newbie.myapplication.adapter.NotifyAdapter;
import com.newbie.myapplication.model.Notify;

import java.util.ArrayList;

public class notif extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView2;
    private RecyclerView recyclerView;
    private NotifyAdapter adapter;
    private ArrayList<Notify> notifyArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_notif);

        addData();
        recyclerView = findViewById(R.id.rv_notif);
        adapter = new NotifyAdapter(notifyArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(notif.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        bottomNavigationView2 = findViewById(R.id.btm_nav2);
        bottomNavigationView2.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_home :
//                        Toast.makeText(getApplication(), "Home", Toast.LENGTH_SHORT).show();
                        Intent goHome = new Intent(getApplication(), Home.class);
                        startActivity(goHome);
                        break;
                    case R.id.action_bell :
//                        Toast.makeText(getApplication(), "Notify", Toast.LENGTH_SHORT).show();
//                        Intent goNotif = new Intent(getApplication(), notif.class);
//                        startActivity(goNotif);
                        break;
                    case R.id.action_user :
//                        Toast.makeText(getApplication(), "User", Toast.LENGTH_SHORT).show();
                        Intent goProfil = new Intent(getApplication(), Profile.class);
                        startActivity(goProfil);
                        break;
                }
                return true;
            }
        });
    }

    void addData() {
        notifyArrayList = new ArrayList<>();
        notifyArrayList.add(new Notify("Yogi", "10 minutes ago", "Jalan Sarimanah Blok 7 No 34", "Jalan rusak"));
    }
}