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

    TextInputEditText sesid;
    Button ses_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tester);

        sesid = findViewById(R.id.ses_id);
        ses_button = findViewById(R.id.ses_button);

        ses_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(sesid.getText().toString())){
                    Toast.makeText(Tester.this, "Please Enter all Required Fields", Toast.LENGTH_LONG).show();
                }else{
                    SesionID();
                }
            }
        });

    }

    private void SesionID() {
        HistoryRequest historyRequest = new HistoryRequest();
        historyRequest.setSid(sesid.getText().toString());
        ArrayList<String> stupid = new ArrayList<String>();


        Call<HistoryResponse> historyResponseCall = ApiClient.getUserService().statusHistory(historyRequest);
        historyResponseCall.enqueue(new Callback<HistoryResponse>() {
            @Override
            public void onResponse(Call<HistoryResponse> call, Response<HistoryResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(Tester.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    HistoryResponse historyResponse = response.body();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(Tester.this,BottomNavbar.class).putExtra( "data",historyResponse.getError()));

                        }
                    },  700);
                }
                else{
                    Toast.makeText(Tester.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<HistoryResponse> call, Throwable t) {
                Toast.makeText(Tester.this, "Throwable"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}