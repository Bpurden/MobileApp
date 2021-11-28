package com.largeproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Response;


public class BottomNavbar extends AppCompatActivity {
    private TextView myText = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navbar);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch (menuitem.getItemId()) {
                    case R.id.recent_checks:
                        startActivity(new Intent(getApplicationContext(), RecentChecks.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.status:
                        startActivity(new Intent(getApplicationContext(), Logout.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        return true;

                }
                return false;
            }
        });
        if(getIntent().getExtras() != null) {
            String[] array = getIntent().getStringArrayExtra("key");
            String[] array2 = getIntent().getStringArrayExtra("key2");
            int arraySize = array.length;
            String save = array[0];
            String me = array2[0];
            if(save != null) {
                TextView t = (TextView) findViewById(R.id.first);
                t.setText("" + save + " " + me);
            }
            String save1 = array[0];
            String me1 = array2[1];
            if((save1 != null) & (me1 != null)) {
                TextView t = (TextView) findViewById(R.id.second);
                t.setText("" + save1 + " " + me1);
            }
            String save2 = array[1];
            String me2 = array2[2];
            if((save2 != null) & (me2 != null)) {
                TextView t = (TextView) findViewById(R.id.third);
                t.setText("" + save2 + " " + me2);
            }
            String save3 = array[1];
            String me3 = array2[3];
            if((save3 != null) & (me3 != null)) {
                TextView t = (TextView) findViewById(R.id.fourth);
                t.setText("" + save3 + " " + me3);
            }
            String save4 = array[2];
            String me4 = array2[4];
            if((save4 != null) & (me4 != null)) {
                TextView t = (TextView) findViewById(R.id.fifth);
                t.setText("" + save4 + " " + me4);
            }
            String save5 = array[2];
            String me5 = array2[5];
            if((save5 != null) & (me5 != null)) {
                TextView t = (TextView) findViewById(R.id.six);
                t.setText("" + save5 + " " + me5);
            }




        }

        }

    }


