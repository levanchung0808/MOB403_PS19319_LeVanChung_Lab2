package com.example.ps19319_levanchung_lab2;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncTaskCheckLogin extends AsyncTask<String, Void, String> {

    URL url;
    String str = "";

    @Override
    protected String doInBackground(String... params) {
        try {
            url = new URL("http://192.168.0.13/Project/Lab2/checkLogin.php?username=" + params[0] + "&password=" + params[1] + "");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (conn.getResponseCode() == 200) {
                InputStreamReader isr = new InputStreamReader(conn.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                StringBuffer sb = new StringBuffer();
                while ((str = br.readLine()) != null) {
                    sb.append(str);
                }
                str = sb.toString();
                MainActivity.strAsync = str;
                conn.disconnect();
            } else {
                Log.i("RS", "ERROR");
            }
//
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    protected void onPostExecute(String unused) {
        super.onPostExecute(unused);
    }
}
