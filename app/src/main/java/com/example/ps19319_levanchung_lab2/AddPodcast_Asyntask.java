package com.example.ps19319_levanchung_lab2;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AddPodcast_Asyntask extends AsyncTask<Void, Void, Void> {
    String podcast;
    Context context;
    StringBuffer str;

    public AddPodcast_Asyntask(String podcast, Context context) {
        this.podcast = podcast;
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("http://192.168.1.220/lab2/addPodcast.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            JSONObject jsonParam = new JSONObject();
            jsonParam.put("podcast", podcast);

            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
//            os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
            os.writeBytes(jsonParam.toString());
            Log.e("=>>>>>>>> Podcast: ", jsonParam.toString());

            os.flush();
            os.close();
            InputStreamReader is = new InputStreamReader(conn.getInputStream());
            BufferedReader reader = new BufferedReader(is);
            str = new StringBuffer("");
            String line;
            while ((line = reader.readLine()) != null) {
                str.append(line);
            }
            Toast.makeText(context, str.toString(), Toast.LENGTH_SHORT).show();
            conn.disconnect();

        } catch (Exception e) {

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        Toast.makeText(context, "" + str, Toast.LENGTH_LONG).show();
        super.onPostExecute(unused);
    }
}
