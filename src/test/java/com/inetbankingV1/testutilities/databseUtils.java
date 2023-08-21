package com.inetbankingV1.testutilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;

import com.inetbankingV1.pageObjects.RetrivingSuccesfullCust;

public class databseUtils {
	public static Connection con;
	private static final String jdbcUrl = "jdbc:mysql://localhost:3306/";
	private static final String usernamee = "root";
	private static final String passwordd = "root";
	private static final String dbName = "SucessfullCUSTDetails";
	public RetrivingSuccesfullCust retrivcust;
	WebDriver driver;

	public static Connection openConnection() throws SQLException {
		con = DriverManager.getConnection(jdbcUrl, usernamee, passwordd);

		return con;
	}
	


	public static void createTable() throws SQLException {
		try (Connection con = openConnection()) {
			String createDataBaseQuery = "CREATE DATABASE " + dbName;
			try (Statement createDbStatement = con.createStatement()) {
			    createDbStatement.executeUpdate(createDataBaseQuery);
			}

			String useDatabaseQuery = "USE " + dbName;
			try (Statement useDbStatement = con.createStatement()) {
			    useDbStatement.execute(useDatabaseQuery);
			}

			String createTableQuery = "CREATE TABLE IF NOT EXISTS CUSTOMERDETAILS (REQURIEDDETAILS VARCHAR(30), CUSTDETAILS VARCHAR(40))";
			try (Statement statement = con.createStatement()) {
				statement.execute(createTableQuery);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	



	public static void insertCustomerDetails(String reqDetails, String custDetails) throws SQLException {
	    try (Connection connection = openConnection()) {
	        // Select the database
	        String useDatabaseQuery = "USE " + dbName;
	        try (Statement useDbStatement = connection.createStatement()) {
	            useDbStatement.execute(useDatabaseQuery);
	        }
	        
	        // Insert data into the table
	        String insertQuery = "INSERT INTO CUSTOMERDETAILS (REQURIEDDETAILS, CUSTDETAILS) VALUES (?, ?)";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
	            preparedStatement.setString(1, reqDetails);
	            preparedStatement.setString(2, custDetails);
	            preparedStatement.executeUpdate();
	        }
	        
	        String selectQuery = "SELECT * FROM CUSTOMERDETAILS"; // Replace with your table name
            try (Statement statement = con.createStatement()) {
                ResultSet resultSet = statement.executeQuery(selectQuery);

                while (resultSet.next()) {
                    String requiredDetails = resultSet.getString("REQURIEDDETAILS");
                    String custsDetails = resultSet.getString("CUSTDETAILS");

                    System.out.println("Required Details: " + requiredDetails);
                    System.out.println("Customer Details: " + custsDetails);
                    System.out.println("-----------------------------");
                    }
            
	    } catch (SQLException e) {
	        e.printStackTrace();
	    
	}
	    }
	}

	public static void closeConnection(Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}
	    }



