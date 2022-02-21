package com.noroff.Ass2DataAccess.data;

import com.noroff.Ass2DataAccess.models.Customer;
import com.noroff.Ass2DataAccess.models.CustomerCountry;
import com.noroff.Ass2DataAccess.models.CustomerGenre;
import com.noroff.Ass2DataAccess.models.CustomerSpender;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    @Override
    public List<CustomerCountry> getNoOfCustomersPerCountry() {
        List<CustomerCountry> listOfCountries = new ArrayList<>();
        Connection conn = ConnectionManager.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT COUNT(CustomerId), Country FROM Customer GROUP BY Country ORDER BY COUNT(CustomerId) DESC");

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                CustomerCountry custCountry = new CustomerCountry();
                custCountry.setCountry(resultSet.getString("Country"));
                //custCountry.setNumberOfCustomers(resultSet.getString());
                listOfCountries.add(custCountry);
            }

            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        return listOfCountries;

    }

    @Override
    public List<CustomerSpender> getHighestSpenders() {
        return null;
    }

    @Override
    public List<CustomerGenre> getMostPopularGenre(int id) {
        return null;
    }
}
