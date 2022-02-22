package com.noroff.Ass2DataAccess.data;

import com.noroff.Ass2DataAccess.models.Customer;
import com.noroff.Ass2DataAccess.models.CustomerCountry;
import com.noroff.Ass2DataAccess.models.CustomerGenre;
import com.noroff.Ass2DataAccess.models.CustomerSpender;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerRepository implements com.noroff.Ass2DataAccess.data.interfaces.CustomerRepository {

    public List<Customer> getAll() {
        List<Customer>list = new ArrayList<>();

        try (ConnectionManager mng = ConnectionManager.getInstance()){
            Connection conn = mng.getConnection();
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

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return list;
    }

    public Customer get(int customerId) {
        Customer customer = new Customer();

        try (ConnectionManager mng = ConnectionManager.getInstance()){
            Connection conn = mng.getConnection();
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

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return customer;
    }

    public Customer get(String name) {
        Customer customer = new Customer();

        try (ConnectionManager mng = ConnectionManager.getInstance()){
            Connection conn = mng.getConnection();
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

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return customer;
    }

    public List<Customer> getPaged(int limit, int offset) {
        List<Customer>list = new ArrayList<>();

        try (ConnectionManager mng = ConnectionManager.getInstance()){
            Connection conn = mng.getConnection();
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

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return list;
    }

    public boolean add(Customer newCustomer) {
        try (ConnectionManager mng = ConnectionManager.getInstance()){
            Connection conn = mng.getConnection();
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
            return false;
        }

        return true;
    }

    public boolean update(int customerId, Customer updatedCustomer) {
        try (ConnectionManager mng = ConnectionManager.getInstance()){
            Connection conn = mng.getConnection();
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
            return false;
        }
        return true;
    }

    public List<CustomerCountry> getNoOfCustomersPerCountry() {
        List<CustomerCountry> list = new ArrayList<>();

        try (ConnectionManager mng = ConnectionManager.getInstance()){
            Connection conn = mng.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT COUNT(CustomerId), Country FROM Customer GROUP BY Country ORDER BY COUNT(CustomerId) DESC");

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                CustomerCountry custCountry = new CustomerCountry();
                custCountry.setCountry(resultSet.getString("Country"));
                custCountry.setNumberOfCustomers(Integer.valueOf(resultSet.getString("COUNT(CustomerId)")));
                list.add(custCountry);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return list;
    }

    public List<CustomerSpender> getHighestSpenders() {
        List<CustomerSpender> list = new ArrayList<>();

        try (ConnectionManager mng = ConnectionManager.getInstance()){
            Connection conn = mng.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT Invoice.CustomerId AS CustomerId, " +
                            "SUM(Total) AS Tot, " +
                            "Customer.FirstName AS FirstName, " +
                            "Customer.LastName AS LastName, " +
                            "Customer.Country AS Country, " +
                            "Customer.PostalCode AS PostalCode, " +
                            "Customer.Phone AS Phone, " +
                            "Customer.Email AS Email " +
                            "FROM Invoice " +
                            "INNER JOIN Customer ON Invoice.CustomerId = Customer.CustomerId " +
                            "GROUP BY Invoice.CustomerId, Customer.FirstName, Customer.LastName " +
                            "ORDER BY tot " +
                            "DESC");

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                CustomerSpender custSpender = new CustomerSpender();
                custSpender.setTotal(Double.parseDouble(resultSet.getString("Tot")));

                custSpender.setCustomerId(resultSet.getInt("CustomerId"));
                custSpender.setFirstName(resultSet.getString("FirstName"));
                custSpender.setLastName(resultSet.getString("LastName"));
                custSpender.setCountry(resultSet.getString("Country"));
                custSpender.setPostalCode(resultSet.getString("PostalCode"));
                custSpender.setPhone(resultSet.getString("Phone"));
                custSpender.setEmail(resultSet.getString("Email"));
                list.add(custSpender);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return list;
    }

    public List<CustomerGenre> getMostPopularGenre(int id) {
        List<CustomerGenre> list = new ArrayList<>();

        try (ConnectionManager mng = ConnectionManager.getInstance()){
            Connection conn = mng.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT Customer.CustomerId AS CustomerId, Customer.FirstName AS FirstName, " +
                            "Customer.LastName AS LastName, " +
                            "Customer.Country AS Country, " +
                            "Customer.PostalCode AS PostalCode, " +
                            "Customer.Phone AS Phone, " +
                            "Customer.Email AS Email, " +
                            "COUNT(Track.GenreId) AS GenreCount, " +
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
                custGenre.setCount(Integer.valueOf(resultSet.getString("GenreCount")));
                custGenre.setGenre(resultSet.getString("GenreName"));
                custGenre.setCustomerId(resultSet.getInt("CustomerId"));
                custGenre.setFirstName(resultSet.getString("FirstName"));
                custGenre.setLastName(resultSet.getString("LastName"));
                custGenre.setCountry(resultSet.getString("Country"));
                custGenre.setPostalCode(resultSet.getString("PostalCode"));
                custGenre.setPhone(resultSet.getString("Phone"));
                custGenre.setEmail(resultSet.getString("Email"));

                list.add(custGenre);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return list;
    }
}
