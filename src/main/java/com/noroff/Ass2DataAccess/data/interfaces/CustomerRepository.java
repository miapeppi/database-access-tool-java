package com.noroff.Ass2DataAccess.data.interfaces;

import com.noroff.Ass2DataAccess.models.Customer;
import com.noroff.Ass2DataAccess.models.CustomerCountry;
import com.noroff.Ass2DataAccess.models.CustomerGenre;
import com.noroff.Ass2DataAccess.models.CustomerSpender;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAll();
    Customer get(int customerId);
    Customer get(String name);
    List<Customer> getPaged(int limit, int offset);
    boolean add(Customer neCustomer);
    boolean update(int customerId, Customer updatedCustomer);
    List<CustomerCountry> getNoOfCustomersPerCountry();
    List<CustomerSpender> getHighestSpenders();
    List<CustomerGenre> getMostPopularGenre(int id);

}
