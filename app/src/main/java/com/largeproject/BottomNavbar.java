package com.largeproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
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
    public boolean [] checksDataIn;
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
                        String[] timestamp = getIntent().getStringArrayExtra("timestamp");
                        Bundle myBundle = getIntent().getExtras();
                        int[] oneorzero = myBundle.getIntArray("intarray");
                        String[] array2 = getIntent().getStringArrayExtra("key2");
                        String[] array = getIntent().getStringArrayExtra("key");
                        Intent i=new Intent(BottomNavbar.this,RecentChecks.class);
                        i.putExtra("timestamp", timestamp);
                        i.putExtra("status", oneorzero);
                        i.putExtra("name", array2);
                        i.putExtra("key", array);
                        startActivity(i);
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
            String[] timestamp = getIntent().getStringArrayExtra("timestamp");
            Bundle myBundle = getIntent().getExtras();
            int[] oneorzero = myBundle.getIntArray("intarray");
            int[] nutsack = myBundle.getIntArray("intstatus");
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
            if(nutsack[0] == 1) {
                ImageView mainImage = (ImageView) findViewById(R.id.firstpic);
                mainImage.setImageResource(R.drawable.ic_check);
            }
            else
            {
                ImageView mainImage = (ImageView) findViewById(R.id.firstpic);
                mainImage.setImageResource(R.drawable.ic_redx);
            }

            if(nutsack[1] == 1) {
                ImageView mainImage = (ImageView) findViewById(R.id.secondpic);
                mainImage.setImageResource(R.drawable.ic_check);
            }
            else
            {
                ImageView mainImage = (ImageView) findViewById(R.id.secondpic);
                mainImage.setImageResource(R.drawable.ic_redx);
            }
            if(nutsack[2] == 1) {
                ImageView mainImage = (ImageView) findViewById(R.id.thirdpic);
                mainImage.setImageResource(R.drawable.ic_check);
            }
            else
            {
                ImageView mainImage = (ImageView) findViewById(R.id.thirdpic);
                mainImage.setImageResource(R.drawable.ic_redx);
            }
            if(nutsack[3] == 1) {
                ImageView mainImage = (ImageView) findViewById(R.id.fourthpic);
                mainImage.setImageResource(R.drawable.ic_check);
            }
            else
            {
                ImageView mainImage = (ImageView) findViewById(R.id.fourthpic);
                mainImage.setImageResource(R.drawable.ic_redx);
            }
            if(nutsack[4] == 1) {
                ImageView mainImage = (ImageView) findViewById(R.id.fifthpic);
                mainImage.setImageResource(R.drawable.ic_check);
            }
            else
            {
                ImageView mainImage = (ImageView) findViewById(R.id.fifthpic);
                mainImage.setImageResource(R.drawable.ic_redx);
            }
            if(nutsack[5] == 1) {
                ImageView mainImage = (ImageView) findViewById(R.id.sixpic);
                mainImage.setImageResource(R.drawable.ic_check);
            }
            else
            {
                ImageView mainImage = (ImageView) findViewById(R.id.sixpic);
                mainImage.setImageResource(R.drawable.ic_redx);
            }

        }


    }

    }


