package com.example.prj_04march_listviewdynamic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.prj_04march_listviewdynamic.Model.Country;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    EditText editTextCName, editTextCCapital;
    Button btnAdd, btnUpdate, btnSort;
    ListView listViewCountries;

    ArrayList<Country> listOfCountries;
    ArrayAdapter<Country> countryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        editTextCName = findViewById(R.id.editTextCName);
        editTextCCapital = findViewById(R.id.editTextCCapital);

        listViewCountries = findViewById(R.id.listViewCountries);

        listViewCountries.setOnItemClickListener(this);
        listViewCountries.setOnItemLongClickListener(this);

        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnSort = findViewById(R.id.btnSort);

        btnAdd.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnSort.setOnClickListener(this);

        listOfCountries = new ArrayList<Country>();

        //add two countries to the list view and don't forget to set adapter
        listOfCountries.add(new Country("India","New Delhi"));
        listOfCountries.add(new Country("Canada","Ottawa"));

        countryAdapter = new ArrayAdapter<Country>(this,android.R.layout.simple_list_item_1,listOfCountries);

        //for adding items to the list
        listViewCountries.setAdapter(countryAdapter);
    }

    @Override
    public void onClick(View view) {
        int btnId = view.getId();
        switch (btnId)
        {
            case R.id.btnAdd:
                add();
                break;
            case R.id.btnUpdate:
                update();
                break;
            case R.id.btnSort:
                sort();
                break;
        }
    }

    private void sort() {
        Collections.sort(listOfCountries);
        countryAdapter.notifyDataSetChanged();
    }

    private void update() {
        String cName = editTextCName.getText().toString();
        String cCapital = editTextCCapital.getText().toString();
        Country country = new Country(cName,cCapital);

        if(listOfCountries.contains(country))
        {
            //Toast.makeText(this,"Exists",Toast.LENGTH_LONG).show();
            int position = listOfCountries.indexOf(country);
            listOfCountries.set(position,country);
        }
        else
        {
            Toast.makeText(this,"Not Exists",Toast.LENGTH_LONG).show();
        }
    }

    private void add() {
        String cName = editTextCName.getText().toString();
        String cCapital = editTextCCapital.getText().toString();
        Country country = new Country(cName,cCapital);
        listOfCountries.add(country);

        //to refresh adapter with new data
        countryAdapter.notifyDataSetChanged();

        //after the data is added, clear the edit text
        editTextCName.setText(null);
        editTextCCapital.setText(null);
        editTextCName.requestFocus();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Country country = listOfCountries.get(i);
        editTextCName.setText(country.getcName());
        editTextCCapital.setText(country.getcCapital());
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {
        listOfCountries.remove(i);
        countryAdapter.notifyDataSetChanged();
        return false;
    }
}
