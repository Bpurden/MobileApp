package com.largeproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class Tester extends AppCompatActivity {
    TextView display;
    TextInputEditText sesid;
    Button ses_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tester);
        if(getIntent().getExtras() != null) {
            String[] array = getIntent().getStringArrayExtra("key");
            int arraySize = array.length;
            String save = array[2];
            if(save != null) {
                TextView t = (TextView) findViewById(R.id.display);
                t.setText("" + array[0]);
            }
            String save1 = array[15];
            if(save1 != null) {
                TextView t = (TextView) findViewById(R.id.display);
                t.setText("" + array[15]);
            }
        }
    }




}



