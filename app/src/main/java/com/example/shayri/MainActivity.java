package com.example.shayri;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;

    String array[] = {"morning", "afternoon", "evening", "night", "birthday", "anniversary", "happy", "sad", "angry", "love", "motivation"};

    int imagearray[] = {R.drawable.morning,R.drawable.afternoon,R.drawable.evening,R.drawable.night,R.drawable.birthday,R.drawable.anniversary,R.drawable.happy,R.drawable.sad,R.drawable.angry,R.drawable.love,R.drawable.motivate};
    int colr[]={R.drawable.aaa,R.drawable.aab,R.drawable.aac,R.drawable.aad,R.drawable.aae,
            R.drawable.aaa,R.drawable.aab,R.drawable.aac,R.drawable.aad,R.drawable.aae,R.drawable.aaa};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);

        MyClass ad = new MyClass(array, MainActivity.this,imagearray,colr);
        list.setAdapter(ad);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.d("+-*/+-*/", "onItemClick: " + position);

                Intent p = new Intent(MainActivity.this, MainActivity2.class);
                p.putExtra("ds", array[position]);
                startActivity(p);
//                finish();

            }
        });
    }
}