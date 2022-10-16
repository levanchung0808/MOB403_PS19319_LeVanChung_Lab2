package com.example.ps19319_levanchung_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnLogin, btnAddPodcast;
    public static String strAsync;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnAddPodcast = findViewById(R.id.btnAddPodcast);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncTaskCheckLogin asyncTaskCheckLogin = new AsyncTaskCheckLogin(MainActivity.this, edtUsername.getText().toString(), edtPassword.getText().toString());
                asyncTaskCheckLogin.execute();

            }
        });

        btnAddPodcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddPodcastActivity.class);
                startActivity(intent);
            }
        });

    }
}