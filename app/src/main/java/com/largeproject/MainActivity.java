package com.largeproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    TextInputEditText email, password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.username);
        password = findViewById(R.id.password);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(MainActivity.this, "Email / Password Required", Toast.LENGTH_LONG).show();
                }else{
                        login();
                }

            }
        });

        Button registration = findViewById(R.id.regnow_button);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openRegister();
            }
        });

    }


    public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email.getText().toString());
        loginRequest.setPassword(password.getText().toString());

        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    LoginResponse loginResponse = response.body();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                                HistoryRequest historyRequest = new HistoryRequest();
                                historyRequest.setSid(loginResponse.getSid());
                                String[] strArray = new String[100];
                                String[] service = new String[100];
                                String[] history = new String[100];
                                Boolean[] array = new Boolean[10000];


                            int arrayLength = strArray.length;

                                Call<HistoryResponse> historyResponseCall = ApiClient.getUserService().statusHistory(historyRequest);
                                historyResponseCall.enqueue(new Callback<HistoryResponse>() {
                                    @Override
                                    public void onResponse(Call<HistoryResponse> call, Response<HistoryResponse> response) {
                                        if (response.isSuccessful()) {
                                            HistoryResponse historyResponse = response.body();

                                            new Handler().postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    int currArrayIndex = 0;
                                                    int currArrayHist = 0;
                                                    ArrayList<Teams> tms = new ArrayList<Teams>(historyResponse.getTeams());
                                                    for(int i = 0; i < tms.size(); i++)
                                                    {
                                                        Teams t = tms.get(i);


                                                    }
                                                    for (Teams t : tms) {
                                                        for (int i=0; i<t.getMachines().size(); i++) {
                                                            Machines m = t.getMachines().get(i);
                                                            System.out.println("\t\tName:" + m.getName());
                                                            service[i] = m.getName();

                                                            for (int k =0; k<m.getServices().size(); k++, currArrayIndex++) {
                                                                Services s = m.getServices().get(k);
                                                                System.out.println("Assigning "+s.getName() + " to index of "+currArrayIndex);
                                                                strArray[currArrayIndex] = s.getName();

                                                                for(int l=0; l<s.getHistory().size(); l++, currArrayHist++)
                                                                {
                                                                    History h = s.getHistory().get(l);
                                                                    System.out.println("time "+h.getTimestamp() + " boolean "+h.getStatus());
                                                                    history[currArrayHist] = h.getTimestamp();
                                                                    array[currArrayHist] = h.getStatus();
                                                                }
                                                            }

                                                        }
                                                    }
                                                    Intent i=new Intent(MainActivity.this,BottomNavbar.class);
                                                    i.putExtra("key",service);
                                                    i.putExtra("key2", strArray);
                                                    startActivity(i);
                                                }
                                            }, 700);
                                        } else {
                                            Toast.makeText(MainActivity.this, "didn't work", Toast.LENGTH_SHORT).show();
                                        }

                                    }

                                    @Override
                                    public void onFailure(Call<HistoryResponse> call, Throwable t) {
                                        Toast.makeText(MainActivity.this, "Throwable" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });


                        }
                    },100);
                }
                else{
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
                
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Throwable"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void openRegister() {

        Intent intent2 = new Intent(this, Activity3.class);
        startActivity(intent2);
    }


}
