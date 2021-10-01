package com.pojo;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            String username = "root";
            String password = "Eldar2002";
            String url = "jdbc:mysql://localhost:3306/test";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            statement.executeUpdate(
                    "INSERT customers(customer_id, customer_first_name, customer_last_name) " +
                            "VALUES (1, 'Eldar', 'Altymyshov')"
            );

            statement.executeUpdate(
                    "INSERT customers(customer_id, customer_first_name, customer_last_name) " +
                            "VALUES (2, 'Natasha', 'Sila')"
            );

            System.out.println("Insert:");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");

            while (resultSet.next()){
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }

            statement.executeUpdate("UPDATE customers SET customer_last_name = 'Grigorievna' WHERE customer_last_name = 'Sila'");

            resultSet = statement.executeQuery("SELECT * FROM customers");

            System.out.println("Update:");

            while (resultSet.next()){
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }

            statement.executeUpdate("DELETE FROM customers WHERE customer_id = 2");

            resultSet = statement.executeQuery("SELECT * FROM customers");

            System.out.println("Delete:");

            while (resultSet.next()){
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
