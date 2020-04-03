package com.example.premployee.Model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Employee implements Comparable{
    private String empId;
    private String lastName;
    private String salary;
    private String phone;
    private String email;
//flost - salary
    @NonNull
    @Override
    public String toString() {
        return lastName;
    }


    public Employee(String empId, String lastName, String salary, String phone, String email) {
        this.empId = empId;
        this.lastName = lastName;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        Employee emp = (Employee) obj;
        if(lastName.equalsIgnoreCase(emp.getLastName()))
            return true;
        else
            return false;
    }

    @Override
    public int compareTo(Object o) {
        Employee emp = (Employee) o;
        if(lastName.compareTo(emp.getLastName())>0)
            return 1;
        else if (lastName.compareTo(emp.getLastName())==0)
            return 0;
        else
            return -1;
    }
}
