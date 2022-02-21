package com.noroff.Ass2DataAccess.data;

import com.noroff.Ass2DataAccess.models.Customer;

import java.util.List;

public class CustomerRepository implements com.noroff.Ass2DataAccess.data.interfaces.CustomerRepository {
    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Customer get(int customerId) {
        return null;
    }

    @Override
    public Customer get(String name) {
        return null;
    }

    @Override
    public List<Customer> getPaged(int limit, int offset) {
        return null;
    }

    @Override
    public boolean add(Customer neCustomer) {
        return false;
    }

    @Override
    public Customer update(int customerId, Customer updatedCustomer) {
        return null;
    }
}
