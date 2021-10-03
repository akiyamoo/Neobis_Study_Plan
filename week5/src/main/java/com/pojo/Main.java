package com.pojo;

import java.sql.*;

public class Main {

    private static Connection connection;

    public static void main(String[] args) throws SQLException{

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

        PreparedStatement statementInsert = null;
        connection = null;

        try {
            connection = DriverManager.getConnection(
                    ConnectJDBC.URL.getName(),
                    ConnectJDBC.USERNAME.getName(),
                    ConnectJDBC.PASSWORD.getName()
            );
            statementInsert = connection.prepareCall("" +
                    "INSERT customers(customer_first_name, customer_last_name) " +
                    "VALUES (?, ?)"
            );

            //statementInsert.setInt(1, id);
            statementInsert.setString(1, firstName); // Set value of customer_first_name
            statementInsert.setString(2, lastName); // Set value of customer_last_name

            statementInsert.executeUpdate(); // request

            System.out.println("Complete method - insert()");

        }
        catch (SQLException e){
            System.out.println("Error - method insert(). Error: " + e);
        }
        finally {

            try {
                if (statementInsert != null)
                    connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }

            try {
                if (connection != null)
                    connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }

        }

    }

    public static void selectAll(){

        Statement statementSelect = null;
        connection = null;

        try {
            connection = DriverManager.getConnection(
                    ConnectJDBC.URL.getName(),
                    ConnectJDBC.USERNAME.getName(),
                    ConnectJDBC.PASSWORD.getName()
            );

            statementSelect = connection.createStatement();
            // create statement connection to database

            ResultSet resultSet = statementSelect.executeQuery("SELECT * FROM customers"); // getting result from the statement

            while (resultSet.next()){
                String id = resultSet.getString("customer_id");
                String firstName = resultSet.getString("customer_first_name");
                String lastName = resultSet.getString("customer_last_name");
                System.out.println(id + " " + firstName + " " + lastName);
            }

            resultSet.close();

            System.out.println("Complete method - selectAll()");

        }
        catch (SQLException e){
            System.out.println("Error - method selectAll(). Error: " + e);
        }
        finally {
            try {
                if (statementSelect != null)
                    connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }

            try {
                if (connection != null)
                    connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    public static void updateFirstName(String oldFirstName,String newFirstName) {

        PreparedStatement statementUpdate = null;
        connection = null;

        try {

            connection = DriverManager.getConnection(
                    ConnectJDBC.URL.getName(),
                    ConnectJDBC.USERNAME.getName(),
                    ConnectJDBC.PASSWORD.getName()
            );

            //UPDATE
            statementUpdate = connection.prepareCall("" +
                    "UPDATE customers " +
                    "SET customer_first_name = ?" +
                    "WHERE customer_first_name ?"
            );

            statementUpdate.setString(2, oldFirstName); // Set value of - WHERE customer_first_name ?
            statementUpdate.setString(1, newFirstName); // Set value of - SET customer_first_name = ?

            statementUpdate.executeUpdate(); // request

            System.out.println("Complete method - updateFirstName()");

        }
        catch (SQLException e){
            System.out.println("Error - method updateFirstName(). Error: " + e);
        }
        finally {

            try {
                if (statementUpdate != null)
                    connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }

            try {
                if (connection != null)
                    connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }

        }

    }

    public static void updateLastName(String oldLastName,String newLastName) {

        PreparedStatement statementUpdate = null;
        connection = null;

        try {

            connection = DriverManager.getConnection(
                    ConnectJDBC.URL.getName(),
                    ConnectJDBC.USERNAME.getName(),
                    ConnectJDBC.PASSWORD.getName()
            );

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
        finally {

            try {
                if (statementUpdate != null)
                    connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }

            try {
                if (connection != null)
                    connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }

        }

    }

    public static void deleteById(int id) {

        PreparedStatement statementDelete = null;
        connection = null;

        try {

            connection = DriverManager.getConnection(
                    ConnectJDBC.URL.getName(),
                    ConnectJDBC.USERNAME.getName(),
                    ConnectJDBC.PASSWORD.getName()
            );

            //DELETE
            statementDelete = connection.prepareCall("" +
                    "DELETE FROM customers " +
                    "WHERE customer_id = ?"
            );

            statementDelete.setInt(1, id); // Set value of - WHERE customer_id = ?

            statementDelete.executeUpdate(); // request

            System.out.println("Complete method - deleteById(). Delete id = " + id);

        }
        catch (SQLException e){
            System.out.println("Error - method deleteById(). Error: " + e);
        }
        finally {

            try {
                if (statementDelete != null)
                    connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }

            try {
                if (connection != null)
                    connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }

        }

    }

/*    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    ConnectJDBC.URL.getName(),
                    ConnectJDBC.USERNAME.getName(),
                    ConnectJDBC.PASSWORD.getName()
            );
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }*/

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
