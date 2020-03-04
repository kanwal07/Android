package com.example.prj_04march_listviewdynamic.Model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Country implements Comparable{
    private String cName;
    private String cCapital;

    @Override
    public boolean equals(@Nullable Object obj) {
        Country other = (Country)obj;
        if(cName.equalsIgnoreCase(other.getcName()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @NonNull
    @Override
    public String toString() {
        return cName;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcCapital() {
        return cCapital;
    }

    public void setcCapital(String cCapital) {
        this.cCapital = cCapital;
    }

    public Country(String cName, String cCapital) {
        this.cName = cName;
        this.cCapital = cCapital;
    }

    @Override
    public int compareTo(Object o) {
        Country other = (Country)o;
        if(cName.compareTo(other.getcName()) > 0)
            return 1;
        else if (cName.compareTo(other.getcName())==0)
            return 0;
        else
            return -1;
    }
}
