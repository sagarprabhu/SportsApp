package com.software_engg.sportsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class SportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        // Get the Intent that started this activity and extract the string
        //Intent intent = getIntent();
       // String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        final TextView mTxtDisplay;
        ImageView mImageView;
        mTxtDisplay = (TextView) findViewById(R.id.sports_textview);
        String url = "http://cricapi.com/api/cricket/?apikey=iWGtOmLRWndAJ4lOUbHrupEbZ982";

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        mTxtDisplay.setText("Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        mTxtDisplay.setText("error");

                    }
                });

// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
    }
}
