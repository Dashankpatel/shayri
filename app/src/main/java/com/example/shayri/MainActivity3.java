package com.example.shayri;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

public class MainActivity3 extends AppCompatActivity {

    TextView kp;

    Button btn1,btn2;

    ViewPager vpager;
    int p=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);

//        kp=findViewById(R.id.all);
        btn1=findViewById(R.id.back);
        btn2=findViewById(R.id.next);

        vpager = findViewById(R.id.vpager);

        String[] array = getIntent().getStringArrayExtra("array");
//        String t = getIntent().getStringExtra("dp");

        int k = getIntent().getIntExtra("ds",0);

        MyPagerAdapter pg = new MyPagerAdapter(this,array);
        vpager.setAdapter(pg);

        vpager.setCurrentItem(k);
        p=vpager.getCurrentItem();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p--;
                vpager.setCurrentItem(p);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p++;
                vpager.setCurrentItem(p);
            }
        });

    }
}