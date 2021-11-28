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
                            historyRequest.setSid("69");

                            Call<HistoryResponse> historyResponseCall = ApiClient.getUserService().statusHistory(historyRequest);
                            historyResponseCall.enqueue(new Callback<HistoryResponse>() {
                                @Override
                                public void onResponse(Call<HistoryResponse> call, Response<HistoryResponse> response) {
                                    if(response.isSuccessful()){
                                        Toast.makeText(MainActivity.this, "it worked", Toast.LENGTH_SHORT).show();
                                        HistoryResponse historyResponse = response.body();


                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                startActivity(new Intent(MainActivity.this,BottomNavbar.class));
                                            }
                                        },  700);
                                    }
                                    else{
                                        Toast.makeText(MainActivity.this, "didnt work", Toast.LENGTH_SHORT).show();
                                    }

                                }

                                @Override
                                public void onFailure(Call<HistoryResponse> call, Throwable t) {
                                    Toast.makeText(MainActivity.this, "Throwable"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
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
