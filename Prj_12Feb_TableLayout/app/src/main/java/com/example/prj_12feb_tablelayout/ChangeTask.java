package com.example.prj_12feb_tablelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChangeTask extends AppCompatActivity implements View.OnClickListener{

    EditText editTextTask;
    Button btnReturn;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_task);
        initialize();
    }

    private void initialize() {
        editTextTask = findViewById(R.id.editTextTaskDesc);
        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);
        data = getIntent().getStringExtra("task");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        String desc = editTextTask.getText().toString();
        if(desc.equalsIgnoreCase(data))
        {
            setResult(RESULT_CANCELED, intent);
        }
        else {
            intent.putExtra("task",desc);
            setResult(RESULT_OK,intent);
        }
        finish();
    }
}
