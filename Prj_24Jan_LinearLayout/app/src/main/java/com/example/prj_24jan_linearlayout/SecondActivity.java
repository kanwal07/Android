package com.example.prj_24jan_linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textViewSport, textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textViewName = findViewById(R.id.textViewName);
        textViewSport = findViewById(R.id.textViewSport);
        String name = getIntent().getStringExtra("name");
        textViewName.setText(name);
        int sportId = getIntent().getIntExtra("sport",0);
        String sport = null;
        switch(sportId)
        {
            case R.id.rbSoccer: sport = "Soccer";
                break;
            case R.id.rbHand: sport = "Handball";
                break;
            case R.id.rbHockey: sport = "Hockey";
                break;
            default: sport = "No sport";
                break;
        }
        textViewSport.setText(sport);
    }
}
