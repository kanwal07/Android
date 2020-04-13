package com.example.prcars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.R.layout;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.*;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] cars = { "Select Brand","Toyota", "Honda", "Ford", "Hyundai"};
    Spinner spinner;

    /*
    Spinner spinner;
    Intent intent;
    DatabaseReference carsDatabase;
    ArrayAdapter<String> brandAdapter;

     */
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        spinner = findViewById(R.id.spinnerCars);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cars);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        String brand = String.valueOf(spinner.getSelectedItem());

        if(brand != "Select Brand"){
            Intent intent= new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("data", brand);
            startActivity(intent);
        }
    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
/*
        carsDatabase.child("cars").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<String> brandsArr = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String brandName = ds.child("brand").getValue(String.class);
                    if(brandName != null){
                        brandsArr.add(brandName);
                    }

                }
                    brandAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,brandsArr);
                    brandAdapter.setDropDownViewResource(simple_spinner_dropdown_item);
                    spinner.setAdapter(brandAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }




 */

}
