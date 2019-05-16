package com.newbie.myapplication;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {

    RelativeLayout relativeLayout1;
    Button btnRegis;
    EditText et1, et2, et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);

        relativeLayout1 = findViewById(R.id.relative_layout1);
        btnRegis = findViewById(R.id.btnRegister);
        et1 = findViewById(R.id.username1);
        et2 = findViewById(R.id.password1);
        et3 = findViewById(R.id.fullname1);

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasi_register();
            }
        });
    }

    public void validasi_register() {
        String user, pass, full;
        user = et1.getText().toString();
        pass = et2.getText().toString();
        full = et3.getText().toString();

        if (et3.getText().toString().length()==0){
            et3.setError("Fullname diperlukan");
        } else if (et1.getText().toString().length()==0) {
            et1.setError("Username diperlukan");
        } else if (et2.getText().toString().length()==0) {
            et2.setError("Password diperlukan");
        } else if(full.equals("Testing") && user.equals("test") && pass.equals("12345")) {
            Toast.makeText(getApplicationContext(),"Sukses Register", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Fullname / Username / Password salah atau kosong",Toast.LENGTH_SHORT).show();
        }
    }
}
