package com.example.prnavigationdrawer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.prnavigationdrawer.Model.Country;
import com.example.prnavigationdrawer.Model.CountryFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,
        View.OnClickListener {

    DrawerLayout drawerLayout;
    ListView listViewCountries;
    ArrayList<Country> listOfCountries;
    ArrayAdapter<Country> countryAdapter;
    ImageButton btnOpenClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        drawerLayout = findViewById(R.id.drawer_layout);
        listViewCountries = findViewById(R.id.listViewCountries);
        listViewCountries.setOnItemClickListener(this);
        listOfCountries = new ArrayList<Country>();
        listOfCountries.add(new Country("France","Paris"));
        listOfCountries.add(new Country("India","New Delhi"));
        listOfCountries.add(new Country("Tunisia","Tunis"));

        countryAdapter = new ArrayAdapter<Country>(this,android.R.layout.simple_list_item_1,listOfCountries);
        listViewCountries.setAdapter(countryAdapter);

        //Set the custom toolbar
        //1. To get the actual toolbar (we have to replace this predefined toolbar with our own)
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowTitleEnabled(false); //hide the title

        //2. Do a layout inflation : Convert xml file to a view object
        //We have a layout and convert it to view - inflation
        LayoutInflater li = LayoutInflater.from(this);
        View customToolbar = li.inflate(R.layout.custom_toolbar, null);

        //3. Attach the custom toolbar to our app
        mActionBar.setCustomView(customToolbar);
        mActionBar.setDisplayShowCustomEnabled(true);

        //Set Image button
        btnOpenClose = customToolbar.findViewById(R.id.btnOpenClose);
        btnOpenClose.setOnClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //save the data to send
        Bundle bundle = new Bundle();
        bundle.putSerializable("country",listOfCountries.get(i));

        //steps of sending the data to the Fragment

        //1, Attach the data to the countryFragment class
        CountryFragment countryFragment = new CountryFragment();
        countryFragment.setArguments(bundle);

        //2. Reference the FragmentManager
        android.app.FragmentManager fragmentManager = getFragmentManager();

        //3. Replace the linear layout by the Fragment (fragment_country.xml)
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_ui, countryFragment);
        fragmentTransaction.commit();

        //4. Assign a title to the fragments
        setTitle(listOfCountries.get(i).getcName());

        //5. Close the drawer layout
        drawerLayout.closeDrawer(listViewCountries);
    }

    @Override
    public void onClick(View v) {
        if (drawerLayout.isDrawerOpen(listViewCountries)){
            drawerLayout.closeDrawer(listViewCountries);
        }
        else
        {
            drawerLayout.openDrawer(listViewCountries);
        }
    }
}
