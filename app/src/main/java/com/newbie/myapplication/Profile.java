package com.newbie.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    Button btnLogout;
    private BottomNavigationView bottomNavigationView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_profile);

        bottomNavigationView1 = findViewById(R.id.btm_nav1);
        bottomNavigationView1.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_home :
                        Toast.makeText(getApplication(), "Home", Toast.LENGTH_SHORT).show();
                        Intent goHome = new Intent(getApplication(), Home.class);
                        startActivity(goHome);
                        break;
                    case R.id.action_bell :
                        Toast.makeText(getApplication(), "Notify", Toast.LENGTH_SHORT).show();
                        Intent goNotif = new Intent(getApplication(), notif.class);
                        startActivity(goNotif);
                        break;
                    case R.id.action_user :
//                        Toast.makeText(getApplication(), "User", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        btnLogout = findViewById(R.id.btn_logoutProfil);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Profile.this);
                alertDialogBuilder.setTitle("Keluar dari aplikasi ?");

                alertDialogBuilder
                        .setMessage("Klik Ya untuk keluar..")
                        .setCancelable(false)
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Profile.this.finish();
                                Intent goOut = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(goOut);
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }
}
