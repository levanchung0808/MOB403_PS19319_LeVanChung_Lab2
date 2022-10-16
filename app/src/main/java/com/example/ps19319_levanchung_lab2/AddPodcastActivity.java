package com.example.ps19319_levanchung_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AddPodcastActivity extends AppCompatActivity{

    EditText edtNamePodcast, edtDescription;
    Button btnAddPodcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_podcast);

        edtNamePodcast = findViewById(R.id.edtName);
        edtDescription = findViewById(R.id.edtDes);
        btnAddPodcast = findViewById(R.id.btnAdd);

        btnAddPodcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName = edtNamePodcast.getText().toString().trim();
                String strDes = edtDescription.getText().toString().trim();
                if(strName.length() == 0 || strDes.length() == 0){
                    Toast.makeText(AddPodcastActivity.this, "Name, Description is empty !", Toast.LENGTH_SHORT).show();
                    return;
                }
                String strPodcast =  strName+ " - " + strDes;
                AddPodcast_Asyntask addPodcast_asyntask = new AddPodcast_Asyntask(strPodcast, AddPodcastActivity.this);
                addPodcast_asyntask.execute();
            }
        });
    }
}