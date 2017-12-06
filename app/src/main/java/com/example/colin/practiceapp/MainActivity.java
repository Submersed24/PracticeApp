package com.example.colin.practiceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ToggleButton;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    String APIKey = "KQF5FMYB2IYS1QBZ";
    int light1on = 1;
    int light2on = 2;
    int light3on = 3;
    int autoon = 4;
    int light1off = 5;
    int light2off = 6;
    int light3off = 7;
    int autooff = 8;
    int sendcode = 9;
    public void clickFunction(View view)
    {
        Log.i("info", "Button Pressed");
    }
    //EditText writeAPI;
    //EditText codeCommand;
    ProgressBar mProgressBar;
    CountDownTimer mCountDownTimer;
    Boolean check = false;
    int i = 0;
    /*changeAPI()//use if api channel is changed
    {

    }*/
    void light1(View view)
    {
        sendcode = light1on;
        // Is the toggle on?
           /* mTB = (ToggleButton) findViewById(R.id.toggleButton1);
            boolean on = ((ToggleButton) v).isChecked();

            if (on) {
                sendcode = light1on;
            } else {
                sendcode = light1off;
            }
            */
    }

    void light2(View view)
    {
        sendcode = light2on;
        // Is the toggle on?
           /* boolean on = ((ToggleButton) v).isChecked();

            if (on) {
                sendcode = light2on;
            } else {
                sendcode = light2off;
            }
            */
    }

   void light3(View view)
    {
       sendcode = light3on;
        // Is the toggle on?
           /* boolean on = ((ToggleButton) v).isChecked();

            if (on) {
                sendcode = light3on;
            } else {
                sendcode = light3off;
            }*/
    }

    void autolights(View view)
    {
        sendcode = autoon;
        // Is the toggle on?
            /*boolean on = ((ToggleButton) v).isChecked();

            if (on) {
                sendcode = autoon;
            } else {
                sendcode = autooff;
            }*/
    }
    OkHttpClient okHttpClient = new OkHttpClient();
    Request.Builder builder = new Request.Builder();
    Request request = builder.url("https://api.thingspeak.com/update?api_key=" + APIKey + "&field1=" + sendcode).build();
    okHttpClient.newCall(request).enqueue(new Callback()
    {
        @Override
        public void onResponse(Response response) {
            if (response.isSuccessful()) {
                try {
                    updateView(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                    updateView("Error - " + e.getMessage());
                }
            } else {
                updateView("Not Success - code : " + response.code());
            }
        }

        public void updateView(final String strResult) {
            runOnUiThread(new Runnable() {
               @Override
               public void run() {
               }
            });
    }
    });

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
