package com.pojo;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/neobis";
        String username = "root";
        String password = "root"; // please change your password

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement request = connection.createStatement();

        request.executeUpdate("INSERT INTO cars VALUES(239 ,2336, 1, 800000, 'Toyota', 'Mark 2', 'Test JDBC')");

        request.executeUpdate("INSERT INTO cars VALUES(1322 ,2023, 1, 20000, 'ToyotaDelete', 'Mark 2', 'Test JDBC')");

        ResultSet resultSet = request.executeQuery("SELECT * FROM cars");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("NameMark") + " " + resultSet.getString("Price"));
        }

        System.out.println();

        request.executeUpdate("UPDATE cars SET Price = Price + 10000 WHERE NameMark = 'Toyota';");

        request.executeUpdate("DELETE FROM cars WHERE NameMark = 'ToyotaDelete'");

        resultSet = request.executeQuery("SELECT * FROM cars");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("NameMark") + " " + resultSet.getString("Price"));
        }
    }

}
