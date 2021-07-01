package com.eugenia.spring.dao;

import com.eugenia.spring.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDAO {
//connect to DB
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> index(){
//we can use default RawMapper(it reads all info from our table by raws' fields)
        return jdbcTemplate.query("SELECT * FROM Customers", new BeanPropertyRowMapper<>(Customer.class));

//        List<Customer> customers = new ArrayList<>();
//
//        try {
//            Statement statement = connection.createStatement();
//            String sql = "select * from customers";
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            while(resultSet.next()){
//                Customer customer = new Customer();
////              get all params
//                customer.setId(resultSet.getInt("id"));
//                customer.setName(resultSet.getString("name"));
////              we can add new cust to our base
//                customers.add(customer);
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return customers;
    }
    public Customer show(int id){

        return jdbcTemplate.query("SELECT * FROM Customers WHERE id=?",
                new Object[]{id}, //array of founded customers by id
                new BeanPropertyRowMapper<>(Customer.class))
                .stream().findAny().orElse(null);
//        return customers.stream().filter(customer -> customer.getId() == id).findAny().orElse(null);
//        Customer customer = null;
//tId(resultSet.getInt("id"));
//            customer.set
////        try {
////            PreparedStatement preparedStatement =
////                    connection.prepareStatement("select * from customers where id = ?");
////            preparedStatement.setInt(1,id);
////
////            ResultSet resultSet = preparedStatement.executeQuery();
////            resultSet.next();
////
////            customer = new Customer();
////            customer.seName(resultSet.getString("name"));
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return customer;
    }

    public void save(Customer customer) {

        jdbcTemplate.update("INSERT INTO Customers VALUES(default ,?)", customer.getName());
//        customer.setId(++CUSTOMERS_COUNT);
//        customers.add(customer);
//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("insert into customers values(1,?)");
//            preparedStatement.setString(1, customer.getName());
//            preparedStatement.executeUpdate();
//
////            String sql = "insert into customers values ("+ 1 + ",'" + customer.getName() + "'" +
//
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }

    public void update(int id, Customer updatedCustomer) {

        jdbcTemplate.update("UPDATE Customers SET name=? WHERE id=?", updatedCustomer.getName(), id);
//        Customer custToUpdate = show(id);
//        custToUpdate.setName(updatedCustomer.getName());

//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("update customers set name=? where id=?");
//
//            preparedStatement.setString(1, updatedCustomer.getName());
//            preparedStatement.setInt(2, id);
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }

    public void delete(int id) {

        jdbcTemplate.update("DELETE FROM Customers WHERE id=?", id);
    }
//        customers.removeIf(cust -> cust.getId() == id);

//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("delete from customers where id = ?");
//
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//    }
}
