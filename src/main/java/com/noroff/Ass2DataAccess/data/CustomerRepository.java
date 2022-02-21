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
        List<CustomerCountry> list = new ArrayList<>();
        Connection conn = ConnectionManager.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT COUNT(CustomerId), Country FROM Customer GROUP BY Country ORDER BY COUNT(CustomerId) DESC");

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                CustomerCountry custCountry = new CustomerCountry();
                custCountry.setCountry(resultSet.getString("Country"));
                custCountry.setNumberOfCustomers(Integer.valueOf(resultSet.getString("COUNT(CustomerId)")));
                list.add(custCountry);
            }

            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        return list;
    }

    @Override
    public List<CustomerSpender> getHighestSpenders() {
        List<CustomerSpender> list = new ArrayList<>();
        Connection conn = ConnectionManager.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT Invoice.CustomerId, SUM(Total) AS tot, Customer.FirstName, Customer.LastName " +
                            "FROM Invoice " +
                            "INNER JOIN Customer ON Invoice.CustomerId = Customer.CustomerId " +
                            "GROUP BY Invoice.CustomerId, Customer.FirstName, Customer.LastName " +
                            "ORDER BY tot " +
                            "DESC");

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                CustomerSpender custSpender = new CustomerSpender();
                custSpender.setFirstName(resultSet.getString("FirstName"));
                custSpender.setLastName(resultSet.getString("LastName"));
                custSpender.setTotal(Double.parseDouble(resultSet.getString("tot")));
                list.add(custSpender);
            }

            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        return list;
    }

    @Override
    public List<CustomerGenre> getMostPopularGenre(int id) {
        List<CustomerGenre> list = new ArrayList<>();
        Connection conn = ConnectionManager.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT Customer.FirstName AS FirstName, " +
                            "Customer.LastName AS LastName, COUNT(Track.GenreId) AS GenreCount, " +
                            "Genre.Name AS GenreName " +
                            "FROM Customer " +
                            "INNER JOIN Invoice ON Customer.CustomerId = Invoice.CustomerId " +
                            "INNER JOIN InvoiceLine ON Invoice.InvoiceId = InvoiceLine.InvoiceId " +
                            "INNER JOIN Track ON Track.TrackId = InvoiceLine.TrackId " +
                            "INNER JOIN Genre ON Genre.GenreId = Track.GenreId " +
                            "WHERE Customer.CustomerId = ? " +
                            "GROUP BY FirstName, LastName, Track.GenreId, Genre.Name " +
                            "ORDER BY COUNT(Track.GenreId) " +
                            "DESC");

            preparedStatement.setString(1, String.valueOf(id));

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                CustomerGenre custGenre = new CustomerGenre();
                custGenre.setFirstName(resultSet.getString("FirstName"));
                custGenre.setLastName(resultSet.getString("LastName"));
                custGenre.setCount(Integer.valueOf(resultSet.getString("GenreCount")));
                custGenre.setGenre(resultSet.getString("GenreName"));
                list.add(custGenre);
            }

            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        return list;
    }
}
