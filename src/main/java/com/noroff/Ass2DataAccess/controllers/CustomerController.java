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
    @GetMapping("/{customerId}")
    public Customer get(@PathVariable("customerId") int customerId) {
        CustomerRepository repo = new CustomerRepository();
        Customer customer = repo.get(customerId);
        return customer;
    }

    // 3. Read a specific customer by name
    @GetMapping("/search/{name}")
    public Customer get(@PathVariable("name") String name) {
        CustomerRepository repo = new CustomerRepository();
        Customer customer = repo.get(name);
        return customer;
    }

    // 4. Return a page of customers
    @GetMapping("/paged/{limit}/{offset}")
    public List<Customer> getPaged(@PathVariable("limit") int limit, @PathVariable("offset") int offset) {
        CustomerRepository repo = new CustomerRepository();
        List<Customer> resultList = repo.getPaged(limit, offset);
        return resultList;
    }

    // 5. Add new customer
    @PostMapping("/new")
    public boolean add(@RequestBody Customer newCustomer) {
        CustomerRepository repo = new CustomerRepository();
        return repo.add(newCustomer);
    }

    // 6. Update customer
    @PutMapping("/update/{customerId}")
    public boolean updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer updatedCustomer) {
        CustomerRepository repo = new CustomerRepository();
        return repo.update(customerId, updatedCustomer);
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
