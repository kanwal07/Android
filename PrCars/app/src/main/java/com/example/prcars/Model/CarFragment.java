package com.example.prcars.Model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.prcars.R;

public class CarFragment extends android.app.Fragment {
    TextView textViewId, textViewBrand, textViewModel, textViewYear,textViewPrice;

    public CarFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_car,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textViewId = getActivity().findViewById(R.id.textViewId);
        textViewBrand = getActivity().findViewById(R.id.textViewBrand);
        textViewModel = getActivity().findViewById(R.id.textViewModel);
        textViewYear = getActivity().findViewById(R.id.textViewYear);
        textViewPrice = getActivity().findViewById(R.id.textViewPrice);

        Cars car = (Cars)getArguments().getSerializable("car");
        textViewId.setText(car.getId());
        textViewBrand.setText(car.getBrand());
        textViewModel.setText(car.getModel());
        textViewYear.setText(String.valueOf(car.getYear()));
        textViewPrice.setText(String.valueOf(car.getPrice()));
    }
}
