package com.largeproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class RecentChecks extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_checks);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch (menuitem.getItemId()) {
                    case R.id.recent_checks:
                        return true;
                    case R.id.status:
                        startActivity(new Intent(getApplicationContext(), Logout.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), BottomNavbar.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });
        String[] category = {"football", "cricket", "baseball"};
        String[] array2 = getIntent().getStringArrayExtra("name");
        String[] buttcheeks = getIntent().getStringArrayExtra("timestamp");
        Bundle myBundle = getIntent().getExtras();
        int[] oneorzero = myBundle.getIntArray("status");
        int arraySize = array2.length;
        ArrayList<Integer> ar = new ArrayList<Integer>();
        for(int k = 0; k<arraySize; k++)
        {
            if(array2[k] != null)
            {
                ar.add(k);
            }
        }

        Spinner spin = (Spinner) findViewById(R.id.spinner1);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item, ar);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);


        String saveme = array2[0];
        if (saveme != null) {
            TextView t = (TextView) findViewById(R.id.display);
            t.setText("" + saveme);
        }

        String save = buttcheeks[0];
        if (save != null) {
            TextView t = (TextView) findViewById(R.id.first);
            t.setText("" + save);
        }
        String save2 = buttcheeks[1];
        if (save2 != null) {
            TextView t = (TextView) findViewById(R.id.second);
            t.setText("" + save2);
        }
        String save3 = buttcheeks[2];
        if (save3 != null) {
            TextView t = (TextView) findViewById(R.id.third);
            t.setText("" + save3);
        }
        String save4 = buttcheeks[3];
        if (save4 != null) {
            TextView t = (TextView) findViewById(R.id.fourth);
            t.setText("" + save4);
        }
        String save5 = buttcheeks[4];
        if (save5 != null) {
            TextView t = (TextView) findViewById(R.id.fifth);
            t.setText("" + save5);
        }

        if(oneorzero[0] == 1) {
            ImageView mainImage = (ImageView) findViewById(R.id.firstphoto);
            mainImage.setImageResource(R.drawable.ic_check);
        }
        else
        {
            ImageView mainImage = (ImageView) findViewById(R.id.firstphoto);
            mainImage.setImageResource(R.drawable.ic_redx);
        }

        if(oneorzero[1] == 1) {
            ImageView mainImage = (ImageView) findViewById(R.id.secondphoto);
            mainImage.setImageResource(R.drawable.ic_check);
        }
        else
        {
            ImageView mainImage = (ImageView) findViewById(R.id.secondphoto);
            mainImage.setImageResource(R.drawable.ic_redx);
        }
        if(oneorzero[2] == 1) {
            ImageView mainImage = (ImageView) findViewById(R.id.thirdphoto);
            mainImage.setImageResource(R.drawable.ic_check);
        }
        else
        {
            ImageView mainImage = (ImageView) findViewById(R.id.thirdphoto);
            mainImage.setImageResource(R.drawable.ic_redx);
        }
        if(oneorzero[3] == 1) {
            ImageView mainImage = (ImageView) findViewById(R.id.fourthphoto);
            mainImage.setImageResource(R.drawable.ic_check);
        }
        else
        {
            ImageView mainImage = (ImageView) findViewById(R.id.fourthphoto);
            mainImage.setImageResource(R.drawable.ic_redx);
        }
        if(oneorzero[4] == 1) {
            ImageView mainImage = (ImageView) findViewById(R.id.fifthphoto);
            mainImage.setImageResource(R.drawable.ic_check);
        }
        else
        {
            ImageView mainImage = (ImageView) findViewById(R.id.fifthphoto);
            mainImage.setImageResource(R.drawable.ic_redx);
        }

        for(int j=0; j<20; j++) {
            System.out.println("ffffffffffffffffffffffffffff " + buttcheeks[j]);

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] array2 = getIntent().getStringArrayExtra("name");
        String[] buttcheeks = getIntent().getStringArrayExtra("timestamp");
        Bundle myBundle = getIntent().getExtras();
        int[] oneorzero = myBundle.getIntArray("status");
        String text = parent.getItemAtPosition(position).toString();
        switch (position){
            case 1:
                Intent i=new Intent(RecentChecks.this,Case1.class);
                i.putExtra("timestamp", buttcheeks);
                i.putExtra("status", oneorzero);
                i.putExtra("name", array2);
                startActivity(i);
                break;
            case 2:
                Intent in=new Intent(RecentChecks.this,Case1.class);
                in.putExtra("timestamp", buttcheeks);
                in.putExtra("status", oneorzero);
                in.putExtra("name", array2);
                startActivity(in);
                break;
            case 3:
                Intent it=new Intent(RecentChecks.this,Case3.class);
                it.putExtra("timestamp", buttcheeks);
                it.putExtra("status", oneorzero);
                it.putExtra("name", array2);
                startActivity(it);
                break;
            case 4:
                Intent a=new Intent(RecentChecks.this,Case4.class);
                a.putExtra("timestamp", buttcheeks);
                a.putExtra("status", oneorzero);
                a.putExtra("name", array2);
                startActivity(a);
                break;
            case 5:
                Intent s=new Intent(RecentChecks.this,Case5.class);
                s.putExtra("timestamp", buttcheeks);
                s.putExtra("status", oneorzero);
                s.putExtra("name", array2);
                startActivity(s);
                break;
            case 6:
                Intent intent=new Intent(RecentChecks.this,Case6.class);
                intent.putExtra("timestamp", buttcheeks);
                intent.putExtra("status", oneorzero);
                intent.putExtra("name", array2);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
