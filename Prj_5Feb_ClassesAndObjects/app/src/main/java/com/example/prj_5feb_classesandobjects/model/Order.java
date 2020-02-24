package com.example.prj_5feb_classesandobjects.model;

import androidx.annotation.NonNull;

public class Order {
    private int clientNumber;
    private String pizza;
    private int nbSlices;

    public Order(int clientNumber, String pizza, int nbSlices) {
        this.clientNumber = clientNumber;
        this.pizza = pizza;
        this.nbSlices = nbSlices;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public int getNbSlices() {
        return nbSlices;
    }

    public void setNbSlices(int nbSlices) {
        this.nbSlices = nbSlices;
    }

    @NonNull
    @Override
    public String toString() {
        return "Client Number: " +clientNumber+" Pizza: "+pizza+" Nb Slices: "+nbSlices+" Amount: "+getAmount();
    }

    public float getAmount() {
        float amount = 0;
        if(pizza.equals("vegetarian"))
        {
            amount = nbSlices*2.0f;
        }
        else if(pizza.equals("cheese"))
        {
            amount = nbSlices*1.8f;
        }
        else
        {
            amount = nbSlices*1.6f;
        }

        return amount;
    }
}
