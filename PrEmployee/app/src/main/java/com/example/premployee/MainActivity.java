package com.example.premployee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.premployee.Model.Employee;
import com.example.premployee.Model.FileManagement;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener, AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener, DialogInterface.OnClickListener {

    EditText editTextEmployeeId, editTextSalary;
    Button btnLoad, btnUpdate, btnSort;
    ListView listViewEmployees;

    ArrayList<Employee> listOfEmployees;
    ArrayAdapter<Employee> employeeAdapter;

    AlertDialog.Builder alertDialog;
    int currentPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        editTextEmployeeId = findViewById(R.id.editTextId);
        editTextSalary = findViewById(R.id.editTextSalary);

        listViewEmployees = findViewById(R.id.listViewEmployees);
        listViewEmployees.setOnItemClickListener(this);
        listViewEmployees.setOnItemLongClickListener(this);

        btnLoad = findViewById(R.id.btnLoad);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnSort = findViewById(R.id.btnSort);

        btnLoad.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnSort.setOnClickListener(this);


        alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Delete Employee");
        alertDialog.setMessage("Do you want to delete ?");

        alertDialog.setPositiveButton("Yes",this);
        alertDialog.setNegativeButton("No",this);
    }

    @Override
    public void onClick(View view) {
        int btnId = view.getId();
        switch (btnId){
            case R.id.btnLoad:
                load();
                break;
            case R.id.btnUpdate:
                update();
                break;
            case R.id.btnSort :
                sort();
                break;
        }
    }

    private void sort() {
        Collections.sort(listOfEmployees);
        employeeAdapter.notifyDataSetChanged();
    }

    private void update() {
        String empId = editTextEmployeeId.getText().toString();
        String salary = editTextSalary.getText().toString();
        Employee emp = listOfEmployees.get(currentPosition);

        Employee employee = new Employee(empId, emp.getLastName(), salary,emp.getPhone(),emp.getEmail());

        if(listOfEmployees.contains(employee))
        {
            int position = listOfEmployees.indexOf(employee);
            listOfEmployees.set(position,employee);
            employeeAdapter.notifyDataSetChanged();
            Toast.makeText(this,"Employee Updated.",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Not exists",Toast.LENGTH_LONG).show();
        }

    }

    private void load() {

        listOfEmployees = FileManagement.readFile(this,"employees.txt");
        employeeAdapter = new ArrayAdapter<>(this,R.layout.one_item,listOfEmployees);
        listViewEmployees.setAdapter(employeeAdapter);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {
        currentPosition = i;
        alertDialog.create().show();
        return false;
    }

    @Override
    public void onClick(DialogInterface dialog, int i) {
        switch(i) {
            case DialogInterface.BUTTON_POSITIVE:
                listOfEmployees.remove(currentPosition);
                break;
                case DialogInterface.BUTTON_NEGATIVE:
                    break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Employee employee = listOfEmployees.get(i);
        String msg = employee.getLastName()+" "+employee.getPhone()+" "+ employee.getEmail();
        editTextEmployeeId.setText(employee.getEmpId());
        editTextSalary.setText(employee.getSalary());
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
        //snackbar
    }
}
