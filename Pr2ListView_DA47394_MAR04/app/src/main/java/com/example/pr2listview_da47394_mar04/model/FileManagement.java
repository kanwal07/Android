package com.example.pr2listview_da47394_mar04.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileManagement {
    public static ArrayList<Country> readFile(Context context, String fileName){
        ArrayList<Country> list = new ArrayList<Country>();

        //1. Access to the asset folder
        AssetManager assetManager = context.getResources().getAssets();

        //2.Open the file
        try {
            InputStreamReader isr = new InputStreamReader(assetManager.open(fileName));
            //3. Read the buffer
            BufferedReader br = new BufferedReader(isr);
            String oneLine = br.readLine();
            while(oneLine!=null) // not end of file
            {
                StringTokenizer str = new StringTokenizer(oneLine,",");
                //divide many word = token
                String cName = str.nextToken();
                String cCapital = str.nextToken();

                Country country = new Country(cName, cCapital);
                list.add(country);
                oneLine = br.readLine();
            }

            //4. close the file and the buffer
            br.close();
            isr.close();


        } catch (IOException e) {
            Log.d("ERROR",e.getMessage());
        }
        return list;
    }
}
