//package com.eugenia.spring.dao;
//
//import com.eugenia.spring.models.Customer;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class CustMapper implements RowMapper<Customer> {
//
//    @Override
//    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
//        Customer customer = new Customer();
//
//        customer.setId(resultSet.getInt("id"));
//        customer.setName(resultSet.getString("name"));
//
//        return customer;
//    }
//}
