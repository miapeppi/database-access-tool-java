package com.noroff.Ass2DataAccess.controllers;

import com.noroff.Ass2DataAccess.models.Customer;
import com.noroff.Ass2DataAccess.models.CustomerCountry;
import com.noroff.Ass2DataAccess.models.CustomerGenre;
import com.noroff.Ass2DataAccess.models.CustomerSpender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.noroff.Ass2DataAccess.data.CustomerRepository;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    // 1. Read all customers
    @GetMapping("/all")
    public List<Customer> getAll() {
        CustomerRepository repo = new CustomerRepository();
        List<Customer> resultList = repo.getAll();
        return resultList;
    }

    // 2. Read a specific customer by id
    @GetMapping("/:customerId")
    public Customer get(int customerId) {
        return null;
    }

    // 3. Read a specific customer by name
    @GetMapping("/:name")
    public Customer get(String name) {
        return null;
    }

    // 4. Return a page of customers
    @GetMapping("/paged")
    public List<Customer> getPaged(int limit, int offset) {
        return null;
    }

    // 5. Add new customer
    @PostMapping("/new")
    public boolean add(Customer newCustomer) {
        return true;
    }

    // 6. Update customer
    @PutMapping("/:customerId/update")
    public Customer updateCustomer(int customerId, Customer updatedCustomer) {
        return null;
    }

    // 7. Return number of customers in each country, desc
    @GetMapping("/customersInCountries")
    public List<CustomerCountry> getNumberOfCustomersInEachCountry() {
        CustomerRepository repo = new CustomerRepository();
        List<CustomerCountry> resultList = repo.getNoOfCustomersPerCountry();
        return resultList;
    }

    // 8. Return customers who are highest spenders, desc
    @GetMapping("/highestSpenders")
    public List<CustomerSpender> getHighestSpenders() {
        CustomerRepository repo = new CustomerRepository();
        List<CustomerSpender> resultList = repo.getHighestSpenders();
        return resultList;
    }

    // 9. Return most popular genre for given customer
    @GetMapping("/{customerId}/popular/genre")
    public List<CustomerGenre> getMostPopularGenre(@PathVariable("customerId") int customerId) {
        CustomerRepository repo = new CustomerRepository();
        List<CustomerGenre> resultList = repo.getMostPopularGenre(customerId);
        return resultList;
    }


}
