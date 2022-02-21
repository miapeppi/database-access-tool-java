package data.interfaces;

import models.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAll();
    Customer get(int customerId);
    Customer get(String name);
    List<Customer> getPaged(int limit, int offset);
    boolean add(Customer neCustomer);
    Customer update(int customerId, Customer updatedCustomer);
}
