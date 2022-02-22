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
        List<Customer>list = new ArrayList<>();
        Connection conn = ConnectionManager.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer");

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("CustomerId"));
                customer.setFirstName(resultSet.getString("FirstName"));
                customer.setLastName(resultSet.getString("LastName"));
                customer.setCountry(resultSet.getString("Country"));
                customer.setPostalCode(resultSet.getString("PostalCode"));
                customer.setPhone(resultSet.getString("Phone"));
                customer.setEmail(resultSet.getString("Email"));
                list.add(customer);
            }

            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        return list;
    }

    @Override
    public Customer get(int customerId) {
        Customer customer = new Customer();
        Connection conn = ConnectionManager.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer WHERE CustomerId = ?");
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                customer.setCustomerId(resultSet.getInt("CustomerId"));
                customer.setFirstName(resultSet.getString("FirstName"));
                customer.setLastName(resultSet.getString("LastName"));
                customer.setCountry(resultSet.getString("Country"));
                customer.setPostalCode(resultSet.getString("PostalCode"));
                customer.setPhone(resultSet.getString("Phone"));
                customer.setEmail(resultSet.getString("Email"));

            }

            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        return customer;
    }

    @Override
    public Customer get(String name) {
        Customer customer = new Customer();
        Connection conn = ConnectionManager.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer WHERE FirstName LIKE ? OR LastName LIKE ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                customer.setCustomerId(resultSet.getInt("CustomerId"));
                customer.setFirstName(resultSet.getString("FirstName"));
                customer.setLastName(resultSet.getString("LastName"));
                customer.setCountry(resultSet.getString("Country"));
                customer.setPostalCode(resultSet.getString("PostalCode"));
                customer.setPhone(resultSet.getString("Phone"));
                customer.setEmail(resultSet.getString("Email"));

            }

            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        return customer;
    }

    @Override
    public List<Customer> getPaged(int limit, int offset) {
        List<Customer>list = new ArrayList<>();
        Connection conn = ConnectionManager.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer ORDER BY CustomerId LIMIT ? OFFSET ?");
            preparedStatement.setInt(1, limit);
            preparedStatement.setInt(2, offset);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("CustomerId"));
                customer.setFirstName(resultSet.getString("FirstName"));
                customer.setLastName(resultSet.getString("LastName"));
                customer.setCountry(resultSet.getString("Country"));
                customer.setPostalCode(resultSet.getString("PostalCode"));
                customer.setPhone(resultSet.getString("Phone"));
                customer.setEmail(resultSet.getString("Email"));
                list.add(customer);
            }

            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        return list;
    }

    @Override
    public boolean add(Customer newCustomer) {
        Connection conn = ConnectionManager.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO Customer (FirstName, LastName, Country, PostalCode, Phone, Email) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, newCustomer.getFirstName());
            preparedStatement.setString(2, newCustomer.getLastName());
            preparedStatement.setString(3, newCustomer.getCountry());
            preparedStatement.setString(4, newCustomer.getPostalCode());
            preparedStatement.setString(5, newCustomer.getPhone());
            preparedStatement.setString(6, newCustomer.getEmail());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        return true;
    }

    @Override
    public boolean update(int customerId, Customer updatedCustomer) {
        Connection conn = ConnectionManager.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "UPDATE Customer SET FirstName = ?, LastName = ?, Country = ?, PostalCode = ?, Phone = ?, Email = ? WHERE CustomerId = ?");
            preparedStatement.setString(1, updatedCustomer.getFirstName());
            preparedStatement.setString(2, updatedCustomer.getLastName());
            preparedStatement.setString(3, updatedCustomer.getCountry());
            preparedStatement.setString(4, updatedCustomer.getPostalCode());
            preparedStatement.setString(5, updatedCustomer.getPhone());
            preparedStatement.setString(6, updatedCustomer.getEmail());
            preparedStatement.setInt(7, customerId);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
        return true;
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
