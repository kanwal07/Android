package com.example.prj_5feb_classesandobjects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.prj_5feb_classesandobjects.model.Order;

import java.util.ArrayList;

public class ShowOrder extends AppCompatActivity implements View.OnClickListener {

    EditText editTextClientNumber;
    TextView textViewPizza, textViewNbSlices, textViewAmount;
    Button btnFind;
    ArrayList<Order> listOfOrders;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_order);
        initialize();
    }

    private void initialize(){

        editTextClientNumber = findViewById(R.id.editTextClientNumber);
        textViewPizza = findViewById(R.id.textViewPizza);
        textViewAmount = findViewById(R.id.textViewAmount);
        textViewNbSlices = findViewById(R.id.textViewNbSlices);
        btnFind = findViewById(R.id.btnFind);
        btnFind.setOnClickListener(this);
        listOfOrders = (ArrayList<Order>) getIntent().getExtras().getSerializable("order");
    }


    @Override
    public void onClick(View v) {
        int clientNumber = Integer.valueOf(editTextClientNumber.getText().toString());
        for(Order order:listOfOrders)
            if (clientNumber==order.getClientNumber()){
                String pizza = order.getPizza();
                int nbSlices = order.getNbSlices();
                float amount = order.getAmount();
                textViewPizza.setText("Pizza" + pizza);
                textViewNbSlices.setText("Nb Slices " + String.valueOf(nbSlices));
                textViewAmount.setText("Amount " + String.valueOf(amount));
            }
    }
}
