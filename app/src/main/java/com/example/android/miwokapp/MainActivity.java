package com.example.android.miwokapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView nView = (TextView)findViewById(R.id.number_id);

        nView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , NumberActivity.class );
                startActivity(i);
            }
        });

        TextView fview = findViewById(R.id.family_text_view);
        fview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,FamilyActivity.class);
                startActivity(i);
            }
        });
        TextView cview = findViewById(R.id.colors_text_view);
        cview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  i =new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(i);
            }
        });
        TextView pview =  findViewById(R.id.phrases_text_view);
        pview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  i =new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(i);
            }
        });
    }
}
