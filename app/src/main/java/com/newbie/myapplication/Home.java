package com.newbie.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.newbie.myapplication.adapter.ContentAdapter;
import com.newbie.myapplication.model.Content;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    RecyclerView recyclerView;
    private ContentAdapter contentAdapter;
    private ArrayList<Content> ContentList;

    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        addData();
        recyclerView = findViewById(R.id.rv_content);
        contentAdapter = new ContentAdapter(ContentList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Home.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(contentAdapter);

        fab = findViewById(R.id.fab_camera);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goCamera = new Intent(getApplicationContext(), PostingActivity.class);
                startActivity(goCamera);
            }
        });

        bottomNavigationView = findViewById(R.id.btm_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_home :
//                        Toast.makeText(getApplication(), "Home", Toast.LENGTH_SHORT).show();
//                        Intent goHome = new Intent(getApplication(), Home.class);
//                        startActivity(goHome);
                        break;
                    case R.id.action_bell :
                        Toast.makeText(getApplication(), "Notify", Toast.LENGTH_SHORT).show();
                        Intent goNotif = new Intent(getApplication(), notif.class);
                        startActivity(goNotif);
                        break;
                    case R.id.action_user :
                        Toast.makeText(getApplication(), "User", Toast.LENGTH_SHORT).show();
                        Intent goProfil = new Intent(getApplication(), Profile.class);
                        startActivity(goProfil);
                        break;
                }
                return true;
            }
        });
//        super.onCreate(savedInstanceState);
    }

    public void addData() {
        ContentList = new ArrayList<>();
        ContentList.add(
                new Content("Yogi",
                        "1 Minutes Ago",
                        "Jalan Sarimanah Blok 7 No 34",
                        "Jalan Berlubang"));
        ContentList.add(
                new Content("Lusia",
                        "10 Minutes Ago",
                        "Jalan Sarijadi Blok 7 No 34",
                        "Jalan Rusak"));
        ContentList.add(
                new Content("Teduh",
                        "1 Hours Ago",
                        "Jalan Cibogo Tengah Blok 7 No 34",
                        "Jalan Bergelombang"));
    }
}
