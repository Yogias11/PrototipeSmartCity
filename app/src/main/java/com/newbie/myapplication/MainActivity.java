package com.newbie.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    EditText etUsername, etPassword;
    Button btnLogin;
    TextView txt1, txt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        relativeLayout = findViewById(R.id.relative_layout);
        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        txt1 = findViewById(R.id.txt_links);
        txt2 = findViewById(R.id.txt_forgot_pass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validasi();
            }
        });

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), register.class);
                startActivity(i);
            }
        });

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goForgot = new Intent(getApplicationContext(), ForgotPassActivity.class);
                startActivity(goForgot);
            }
        });
    }

    public void validasi() {
        String user, pass;
        user = etUsername.getText().toString();
        pass = etPassword.getText().toString();
        if (etUsername.getText().toString().length()==0){
            etUsername.setError("Username diperlukan");
        } else if (etPassword.getText().toString().length()==0) {
            etPassword.setError("Password diperlukan");
        } else if(user.equals("test") && pass.equals("12345")) {
//            Toast.makeText(getApplicationContext(),"Sukses", Toast.LENGTH_SHORT).show();
            Intent moveToHome = new Intent(MainActivity.this, Home.class);
            startActivity(moveToHome);
        } else {
            Toast.makeText(getApplicationContext(), "Username atau Password salah",Toast.LENGTH_SHORT).show();
        }
    }
}


