package com.pojo;

import java.sql.*;

public class Main {

    private static Connection connection;

    public static void main(String[] args) throws SQLException{

        try {
            connection = DriverManager.getConnection(
                    ConnectJDBC.URL.getName(),
                    ConnectJDBC.USERNAME.getName(),
                    ConnectJDBC.PASSWORD.getName()
            );
        }
        catch (SQLException e)
        {
            System.out.println("Error connect to database.");
            System.out.println(e);
            return;
        }

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

    }

    public static void insert(String firstName, String lastName) {

        PreparedStatement statementInsert;

        try {

            statementInsert = connection.prepareCall("" +
                    "INSERT customers(customer_first_name, customer_last_name) " +
                    "VALUES (?, ?)");

            //statementInsert.setInt(1, id);
            statementInsert.setString(1, firstName);
            statementInsert.setString(2, lastName);

            statementInsert.executeUpdate();

            statementInsert.close();

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

            statementUpdate = connection.prepareCall("" +
                    "UPDATE customers " +
                    "SET customer_first_name = ?" +
                    "WHERE customer_first_name ?");

            statementUpdate.setString(2, oldFirstName);
            statementUpdate.setString(1, newFirstName);

            statementUpdate.executeUpdate();

            statementUpdate.close();

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

            statementUpdate.setString(2, oldLastName);
            statementUpdate.setString(1, newLastName);

            statementUpdate.executeUpdate();

            //statementUpdate.executeUpdate("UPDATE customers SET customer_last_name = 'Grigorievna' WHERE customer_last_name = 'Sila'");

            statementUpdate.close();

            System.out.println("Complete method - updateLastName()");

        }
        catch (SQLException e){
            System.out.println("Error - method updateLastName(). Error: " + e);
        }

    }

    public static void deleteById(int id) {

        PreparedStatement statementDelete;

        try {

            statementDelete = connection.prepareCall("" +
                    "DELETE FROM customers " +
                    "WHERE customer_id = ?");

            statementDelete.setInt(1, id);

            statementDelete.executeUpdate();

            statementDelete.close();

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
