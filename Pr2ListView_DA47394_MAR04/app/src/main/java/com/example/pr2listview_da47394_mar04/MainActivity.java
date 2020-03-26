package com.example.pr2listview_da47394_mar04;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pr2listview_da47394_mar04.model.Country;
import com.example.pr2listview_da47394_mar04.model.FileManagement;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, AdapterView.OnItemClickListener
, AdapterView.OnItemLongClickListener,
        DialogInterface.OnClickListener {

    EditText editTextCName,editTextCCapital;
    Button btnAdd,btnUpdate,btnSort;
    ListView listViewCountries;

    ArrayList<Country> listOfCountries;
    ArrayAdapter<Country> countryAdapter;

    AlertDialog.Builder alertDialog;
    int currentPosition;

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

        /*
        listOfCountries = new ArrayList<Country>();

        listOfCountries.add(new Country("India","New Delhi"));
        listOfCountries.add(new Country("Canada","Ottawa"));
        */

        listOfCountries = FileManagement.readFile(this,"countries.txt");
        countryAdapter =
                new ArrayAdapter<Country>(this,
                        R.layout.one_item,
                        listOfCountries);
        listViewCountries.setAdapter(countryAdapter);

        alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Delete a country");
        alertDialog.setMessage("Do you want to delete(Y/N)");
        //we need to implement the interface-Dialog interface
        alertDialog.setPositiveButton("Yes",this);
        alertDialog.setNegativeButton("No",this);

    }

    @Override
    public void onClick(View view) {

        int btnId = view.getId();
        switch (btnId){

            case R.id.btnAdd :
                add();break;
            case R.id.btnUpdate:
                update();break;
            case R.id.btnSort :
                sort();break;
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

        if (listOfCountries.contains(country)){
           int position = listOfCountries.indexOf(country);
           listOfCountries.set(position,country);

        }
        else
            Toast.makeText(this,"Not exists",
                    Toast.LENGTH_LONG).show();

    }

    private void add() {

        String cName = editTextCName.getText().toString();
        String cCapital = editTextCCapital.getText().toString();
        Country country = new Country(cName,cCapital);
        listOfCountries.add(country);
        countryAdapter.notifyDataSetChanged();
        editTextCName.setText(null);
        editTextCCapital.setText(null);
        editTextCName.requestFocus();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Country country = listOfCountries.get(i);
        editTextCName.setText(country.getcName());
        editTextCCapital.setText(country.getcCapital());

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView,
                                   View view, int i, long l) {

        // Need to dialog interface to validate deletion
        currentPosition = i;
        alertDialog.create().show();

        return false;
    }

    @Override
    public void onClick(DialogInterface dialog, int i) {
        switch(i){
            case DialogInterface.BUTTON_POSITIVE:
                listOfCountries.remove(currentPosition);
                countryAdapter.notifyDataSetChanged();
                break;
                case DialogInterface.BUTTON_NEGATIVE:
                    break;
        }
    }
}
