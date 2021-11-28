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
public class RegistrationPage2 extends AppCompatActivity {

    TextInputEditText teamname, teamEmail, teamPassword, teamJoincode;
    Button team_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page2);

        teamname = findViewById(R.id.team_name);
        teamEmail = findViewById(R.id.team_email);
        teamPassword = findViewById(R.id.team_password);
        teamJoincode = findViewById(R.id.team_joincode);
        team_button = findViewById(R.id.team_button);



        team_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(teamEmail.getText().toString()) || TextUtils.isEmpty(teamPassword.getText().toString()) || TextUtils.isEmpty(teamname.getText().toString()) || TextUtils.isEmpty(teamJoincode.getText().toString())){
                    Toast.makeText(RegistrationPage2.this, "Please Enter all Required Fields", Toast.LENGTH_LONG).show();
                }else{
                    AddTeam();
                }
            }
        });


    }

    private void AddTeam() {
        TeamRequest teamRequest = new TeamRequest();
        teamRequest.setName(teamname.getText().toString());
        teamRequest.setEmail(teamEmail.getText().toString());
        teamRequest.setPassword(teamPassword.getText().toString());
        teamRequest.setJoinCode(teamJoincode.getText().toString());


        Call<TeamResponse> teamResponseCall = ApiClient.getUserService().addTeam(teamRequest);
        teamResponseCall.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(RegistrationPage2.this, "Team Added", Toast.LENGTH_SHORT).show();
                    TeamResponse teamResponse = response.body();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(RegistrationPage2.this,Tester.class).putExtra( "data",teamResponse.getSid()));
                        }
                    },  700);
                }
                else{
                    Toast.makeText(RegistrationPage2.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                Toast.makeText(RegistrationPage2.this, "Throwable"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    }
