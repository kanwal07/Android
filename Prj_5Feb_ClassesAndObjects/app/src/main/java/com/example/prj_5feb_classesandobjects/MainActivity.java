package com.example.prj_5feb_classesandobjects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prj_5feb_classesandobjects.model.Order;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener {

    private EditText editTextClientNumber, editTextNbSlices;
    private RadioGroup rgPizza;
    private TextView textViewAmount;
    private Button btnOrder, btnShowOrder, btnShowAllOrders;
    private Order order;
    private ArrayList<Order> listOfOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        editTextClientNumber = findViewById(R.id.editTextClientNumber);
        editTextNbSlices = findViewById(R.id.editTextNbSlices);
        rgPizza = findViewById(R.id.rgPizza);
        textViewAmount = findViewById(R.id.textViewAmount);
        btnOrder = findViewById(R.id.buttonOrder);
        btnShowOrder = findViewById(R.id.buttonShowOrder);
        btnShowAllOrders = findViewById(R.id.buttonShowAllOrders);
        editTextNbSlices.addTextChangedListener(this);
        btnShowOrder.setOnClickListener(this);
        btnShowOrder.setOnClickListener(this);
        btnShowAllOrders.setOnClickListener(this);
        listOfOrders = new ArrayList<Order>();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        try {
            int clientNumber;
            clientNumber = Integer.valueOf(editTextClientNumber.getText().toString());
            int nbSlices;
            nbSlices = Integer.valueOf(editTextNbSlices.getText().toString());
            int rbId = rgPizza.getCheckedRadioButtonId();
            String pizza = null;
            switch (rbId) {
                case R.id.rbVegetarian:
                    pizza = "vegetarian";
                    break;
                case R.id.rbCheese:
                    pizza = "cheese";
                    break;
                case R.id.rbMexican:
                    pizza = "mexican";
                    break;
            }

            order = new Order(clientNumber, pizza, nbSlices);
            float amount = order.getAmount();
            textViewAmount.setText("Amount: $" + String.valueOf(amount));
        }
        catch(Exception e) { }
    }

    @Override
    public void onClick(View view) {
        int btnId = view.getId();
        switch(btnId)
        {
            case R.id.buttonOrder:
               saveOrder(view);
               break;
            case R.id.buttonShowOrder:
                showOrder();
                break;
            case R.id.buttonShowAllOrders:
                break;
        }
    }

    private void saveOrder(View view) {
        listOfOrders.add(order);
        Toast.makeText(this,"Saved!!!",Toast.LENGTH_LONG);
        //String client = editTextClientNumber.getText().toString();
        //Snackbar.make(view,resid:"The order of client "+ client +" is saved!",SnackBar.LENGTH_LONG).show();
    }

    private void showOrder() {
        Intent intent = new Intent(this, ShowOrder.class);
        intent.putExtra("order",listOfOrders);
        startActivity(intent);
    }


}
