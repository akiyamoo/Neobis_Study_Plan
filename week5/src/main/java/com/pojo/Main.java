package com.pojo;

import java.sql.*;

public class Main {

    private static Connection connection;

    public static void main(String[] args) throws SQLException{

        try {
            // Try connect to database
            connection = DriverManager.getConnection(
                    ConnectJDBC.URL.getName(),
                    ConnectJDBC.USERNAME.getName(),
                    ConnectJDBC.PASSWORD.getName()
            );

            System.out.println("INSERT:");
            insert("Vanya", "Petrashov");
            insert("Igor", "Seleznov");
            insert("Elena", "Akoeva");
            //example
            System.out.println();

            System.out.println("SELECT:");
            selectAll();
            System.out.println();

            System.out.println("UPDATE first_name:");
            updateFirstName("Vanya", "Sanya");
            System.out.println();

            System.out.println("SELECT:");
            selectAll();
            System.out.println();

            System.out.println("UPDATE last_name:");
            updateLastName("Seleznov", "Borodino");
            System.out.println();

            System.out.println("SELECT:");
            selectAll();
            System.out.println();

            System.out.println("DELETE id:");
            deleteById(1);
            deleteById(2);
            System.out.println();

            System.out.println("SELECT:");
            selectAll();

            connection.close();
        }
        catch (SQLException e) // If don't connect to database
        {
            System.out.println("Error connect to database.");
            System.out.println(e);
            return;
        }

    }

    public static void insert(String firstName, String lastName) {

        PreparedStatement statementInsert;

        try {
            //INSERT
            statementInsert = connection.prepareCall("" +
                    "INSERT customers(customer_first_name, customer_last_name) " +
                    "VALUES (?, ?)");

            //statementInsert.setInt(1, id);
            statementInsert.setString(1, firstName); // Set value of customer_first_name
            statementInsert.setString(2, lastName); // Set value of customer_last_name

            statementInsert.executeUpdate(); // request

            statementInsert.close(); // close statement connection to database

            System.out.println("Complete method - insert()");

        }
        catch (SQLException e){
            System.out.println("Error - method insert(). Error: " + e);
        }

    }

    public static void selectAll(){

        Statement statementSelect;
        ResultSet resultSet;

        try {
            statementSelect = connection.createStatement();
            // create statement connection to database

            resultSet = statementSelect.executeQuery("SELECT * FROM customers"); // getting result from the statement

            while (resultSet.next()){
                String id = resultSet.getString("customer_id");
                String firstName = resultSet.getString("customer_first_name");
                String lastName = resultSet.getString("customer_last_name");
                System.out.println(id + " " + firstName + " " + lastName);
            }

            statementSelect.close(); // close statement connection to database
            resultSet.close(); // close result thread

            System.out.println("Complete method - selectAll()");

        }
        catch (SQLException e){
            System.out.println("Error - method selectAll(). Error: " + e);
        }

    }

    public static void updateFirstName(String oldFirstName,String newFirstName) {

        PreparedStatement statementUpdate;

        try {
            //UPDATE
            statementUpdate = connection.prepareCall("" +
                    "UPDATE customers " +
                    "SET customer_first_name = ?" +
                    "WHERE customer_first_name ?");

            statementUpdate.setString(2, oldFirstName); // Set value of - WHERE customer_first_name ?
            statementUpdate.setString(1, newFirstName); // Set value of - SET customer_first_name = ?

            statementUpdate.executeUpdate(); // request

            statementUpdate.close(); // close statement connection to database

            System.out.println("Complete method - updateFirstName()");

        }
        catch (SQLException e){
            System.out.println("Error - method updateFirstName(). Error: " + e);
        }

    }

    public static void updateLastName(String oldLastName,String newLastName) {

        PreparedStatement statementUpdate;

        try {

            statementUpdate = connection.prepareCall("" +
                    "UPDATE customers " +
                    "SET customer_last_name = ?" +
                    "WHERE customer_last_name ?");

            statementUpdate.setString(2, oldLastName); // Set value of - WHERE customer_last_name ?
            statementUpdate.setString(1, newLastName); // Set value of - SET customer_last_name = ?

            statementUpdate.executeUpdate(); // request

            statementUpdate.close(); // close statement connection to database

            System.out.println("Complete method - updateLastName()");

        }
        catch (SQLException e){
            System.out.println("Error - method updateLastName(). Error: " + e);
        }

    }

    public static void deleteById(int id) {

        PreparedStatement statementDelete;

        try {
            //DELETE
            statementDelete = connection.prepareCall("" +
                    "DELETE FROM customers " +
                    "WHERE customer_id = ?");

            statementDelete.setInt(1, id); // Set value of - WHERE customer_id = ?

            statementDelete.executeUpdate(); // request

            statementDelete.close(); // close statement connection to database

            System.out.println("Complete method - deleteById(). Delete id = " + id);

        }
        catch (SQLException e){
            System.out.println("Error - method deleteById(). Error: " + e);
        }

    }

}

enum ConnectJDBC{
    USERNAME("root"), PASSWORD("root"), URL("jdbc:mysql://localhost:3306/test");

    private String name;

    ConnectJDBC(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
