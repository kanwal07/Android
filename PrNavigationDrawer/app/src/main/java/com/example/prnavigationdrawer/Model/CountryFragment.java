package com.example.prnavigationdrawer.Model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.prnavigationdrawer.R;

public class CountryFragment extends android.app.Fragment {
    TextView textViewCCapital;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_country,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textViewCCapital = getActivity().findViewById(R.id.textViewCCapital);
        Country country = (Country)getArguments().getSerializable("country");
        textViewCCapital.setText(country.getcCapital());
    }
}
