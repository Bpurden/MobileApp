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

import com.google.android.material.textfield.TextInputEditText;

public class Activity3 extends AppCompatActivity {

    TextInputEditText emailreg, passwordreg;
    Button reg_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        emailreg = findViewById(R.id.reg_email);
        passwordreg = findViewById(R.id.reg_password);
        reg_button = findViewById(R.id.reg_button);

        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(emailreg.getText().toString()) || TextUtils.isEmpty(passwordreg.getText().toString())){
                    Toast.makeText(Activity3.this, "Please Enter all Required Fields", Toast.LENGTH_LONG).show();
                }else{
                    Register();
                }
            }
        });

    }

    private void Register() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail(emailreg.getText().toString());
        registerRequest.setPassword(passwordreg.getText().toString());

        Call<RegisterResponse> registerResponseCall = ApiClient.getUserService().userRegister(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(Activity3.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    RegisterResponse registerResponse = response.body();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(Activity3.this,RegistrationPage2.class).putExtra( "data",registerResponse.getSid()));
                        }
                    },  700);
                }
                else{
                    Toast.makeText(Activity3.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(Activity3.this, "Throwable"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}