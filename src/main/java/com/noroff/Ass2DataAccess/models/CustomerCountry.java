package com.noroff.Ass2DataAccess.models;

public class CustomerCountry extends Customer{
    private Integer numberOfCustomers;

    public Integer getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(Integer numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }
}
