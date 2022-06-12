package com.example.citylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class showActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Intent intent = getIntent();
        String city_name=intent.getStringExtra("cityList");
        TextView tView= findViewById(R.id.city);
        tView.setText(city_name);

        Button btn=findViewById(R.id.button_back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(showActivity.this,MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });

    }
}