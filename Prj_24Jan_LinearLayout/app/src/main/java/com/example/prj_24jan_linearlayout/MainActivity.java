package com.example.prj_24jan_linearlayout;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //1. Implement the interface OnClickListener
    EditText editText;
    RadioGroup rgSport;
    Button btnClear, btnNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextName);
        rgSport = findViewById(R.id.rgSport);
        btnClear = findViewById(R.id.buttonClear);
        btnNext = findViewById(R.id.buttonNext);
        // Enable the clicks for buttons clear and next
        btnClear.setOnClickListener(this);
        btnNext.setOnClickListener(this);

    }

    //Implement the OnClick method
    @Override
    public void onClick(View v) {
        if(v == btnClear)
        {
            editText.setText(null);
            rgSport.clearCheck();
            editText.requestFocus();
        }
        else
        {
            Intent i = new Intent(this, SecondActivity.class);
            startActivity(i);
            i.putExtra("name",editText.getText().toString());
            i.putExtra("sport",rgSport.getCheckedRadioButtonId());
            startActivity(i);
        }
    }
}
