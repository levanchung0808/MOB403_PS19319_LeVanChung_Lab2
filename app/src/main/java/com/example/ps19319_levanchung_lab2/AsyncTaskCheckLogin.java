package com.example.ps19319_levanchung_lab2;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncTaskCheckLogin extends AsyncTask<String, Void, String> {

    URL url;
    Context context;
    String tvUsername, tvPassword;

    public AsyncTaskCheckLogin(Context context, String user, String pass){
        this.context = context;
        this.tvUsername = user;
        this.tvPassword = pass;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            url = new URL("http://192.168.1.220/lab2/checkLogin.php?username=" + tvUsername + "&password=" + tvPassword + "");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStreamReader isr = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
//                sb.toString();
            }
            Handler handler = new Handler(context.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, sb.toString(), Toast.LENGTH_SHORT).show();
                }
            });
            conn.disconnect();
//
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String unused) {
        super.onPostExecute(unused);
    }
}
