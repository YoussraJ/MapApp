package com.example.location;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeletePositionTask extends AsyncTask<String, Void, JSONObject> {

    private JSONParser jsonParser;
    public DeletePositionTask(JSONParser jsonParser) {
        this.jsonParser = jsonParser;
    }

    @Override
    protected JSONObject doInBackground(String... params) {
        String url = params[0];
        HttpURLConnection conn = null;
        try {
            // Set up connection
            URL urlObj = new URL(url);
            conn = (HttpURLConnection) urlObj.openConnection();
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");

            // Get response
            int responseCode = conn.getResponseCode();
            Log.d("HTTP Response", "Response Code: " + responseCode);

            InputStream in = conn.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            StringBuilder result = new StringBuilder();
            int read;
            while ((read = reader.read()) != -1) {
                result.append((char) read);
            }

            if (result.length() == 0) {
                Log.e("DeletePositionTask", "Received empty response.");
                return null;
            }

            return new JSONObject(result.toString());
        } catch (Exception e) {
            Log.e("DeletePositionTask", "Error during DELETE request: " + e.getMessage());
            return null;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    @Override
    protected void onPostExecute(JSONObject result) {
        if (result != null) {
            Log.d("DeletePositionTask", "Delete successful: " + result.toString());
        } else {
            Log.e("DeletePositionTask", "Failed to delete position.");
        }
    }
}
