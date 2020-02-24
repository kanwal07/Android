package com.example.prj_12feb_tablelayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.prj_12feb_tablelayout.Model.Task;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView[] listOfTextViews;
    int widgets[] = {R.id.textViewMData, R.id.textViewTMorning, R.id.textViewTAfternoon};//top to bottom, left to right
    TextView clickedTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        //Populate the task
        Task[] listOfTasks = new Task[widgets.length];
        listOfTasks[0] = new Task(0,"Android", Color.BLUE);
        listOfTasks[1] = new Task(1,"Sport",Color.RED);
        listOfTasks[2] = new Task(2,"Shopping");
        listOfTextViews = new TextView[widgets.length];

        for (int i=0;i<widgets.length;i++)
        {
            listOfTextViews[i] = findViewById(widgets[i]);
            Task task = listOfTasks[i];
            listOfTextViews[i].setText(task.toString());
            listOfTextViews[i].setTextColor(task.getTaskColor());
            listOfTextViews[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        clickedTV = (TextView)view;
        String taskDesc = clickedTV.getText().toString();
        Intent intent = new Intent(this,ChangeTask.class);
        intent.putExtra("task",clickedTV.getText().toString());
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1 && resultCode==RESULT_OK)
        {
            String newDesc = (String)data.getStringExtra("task");
            clickedTV.setText(newDesc);
        }
    }
}
