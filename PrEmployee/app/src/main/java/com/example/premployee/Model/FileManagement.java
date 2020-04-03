package com.example.premployee.Model;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileManagement {
    public static ArrayList<Employee> readFile(Context context, String fileName) {
        ArrayList<Employee> list = new ArrayList<Employee>();

        //1. Access to the asset folder
        AssetManager assetManager = context.getResources().getAssets();

        //2.Open the file
        try {
            InputStreamReader isr = new InputStreamReader(assetManager.open(fileName));
            //3. Read the buffer
            BufferedReader br = new BufferedReader(isr);
            String oneLine = br.readLine();
            while (oneLine != null && !oneLine.equals("")) // not end of file
            {
                StringTokenizer str = new StringTokenizer(oneLine, "%");
                //divide many word = token
                String empId = str.nextToken();
                String lastName = str.nextToken();
                String salary = str.nextToken();
                String phone = str.nextToken();
                String email = str.nextToken();

                Employee employee = new Employee(empId, lastName, salary, phone, email);
                list.add(employee);
                oneLine = br.readLine();
            }

            //4. close the file and the buffer
            br.close();
            isr.close();


        } catch (IOException e) {
            Log.d("ERROR", e.getMessage());
        }
        return list;
    }
}
