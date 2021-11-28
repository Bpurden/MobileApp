package com.largeproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Logout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        Button button;

        button = findViewById(R.id.logout_button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openLogout();
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch (menuitem.getItemId()){
                    case R.id.recent_checks:
                        startActivity(new Intent(getApplicationContext(),RecentChecks.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.status:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),BottomNavbar.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
    }

    private void openLogout() {
            Intent intent2 = new Intent(this, MainActivity.class);
            startActivity(intent2);
        }

    }

