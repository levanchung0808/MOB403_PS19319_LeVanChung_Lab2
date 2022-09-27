package com.example.ps19319_levanchung_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;

public class AddPodcastActivity extends AppCompatActivity implements AsyncTask<> {

    EditText edtNamePodcast, edtDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_podcast);

        edtNamePodcast = findViewById(R.id.edtName);
        edtDes = findViewById(R.id.edtDes);


    }
}