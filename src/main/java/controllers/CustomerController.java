package controllers;

import models.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    // 1. Read all customers
    @GetMapping("/all")
    public List<Customer> getAll() {
        return null;
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
    public HashMap<String, Integer> getNumberOfCustomersInEachCountry() {
        return null;
    }

    // 8. Return customers who are highest spenders, desc
    @GetMapping("/highestSpenders")
    public HashMap<Customer, Double> getHighestSpenders() {
        return null;
    }

    // 9. Return most popular genre for given customer
    @GetMapping("/:customerId/popular/genre")
    public List<String> getMostPopularGenre(int customerId) {
        return null;
    }


}
