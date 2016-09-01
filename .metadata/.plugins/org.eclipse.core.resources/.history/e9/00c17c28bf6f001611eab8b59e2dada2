package com.airhacks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO {

	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "root";

	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;
	static String userInput = null;

	static Scanner sc = new Scanner(System.in);

	public static void connectToDatabase() {

		try {
			System.out.println("Trying to connect to the database...");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the database.");
		} catch (SQLException e) {
			System.out.println("Cannot connect to the database.");
			e.printStackTrace();
		}
	}// connectToDatabase

	public static void readFromDatabase() {

		connectToDatabase();

		ArrayList<Employee> companyEmployees = new ArrayList<>();

		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM company.employees;");

			while (RES_SET.next()) {

				Employee employeeInDatabase = new Employee();

				employeeInDatabase.setEmployeeID(RES_SET.getString("employee_id"));
				employeeInDatabase.setFirstName(RES_SET.getString("first_name"));
				employeeInDatabase.setLastName(RES_SET.getString("last_name"));
				employeeInDatabase.setPosition(RES_SET.getString("position"));
				employeeInDatabase.setSalary(RES_SET.getDouble("salary"));

				companyEmployees.add(employeeInDatabase);

			}

			for (Employee employee : companyEmployees) {

				System.out.println(employee.toString());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// readFromDatabase

	public static void writeToDatabase() {

		Employee employeeToAdd = new Employee();

		employeeToAdd = aboutTheEmployee();

		connectToDatabase();

		try {
			PREP_STMT = CONN.prepareStatement(insertToDatabase);

			PREP_STMT.setString(1, employeeToAdd.getFirstName());
			PREP_STMT.setString(2, employeeToAdd.getLastName());
			PREP_STMT.setString(3, employeeToAdd.getPosition());
			PREP_STMT.setDouble(4, employeeToAdd.getSalary());

			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// writeToDatabase

	private static String insertToDatabase = "INSERT INTO `company`.`employees`"
			+ "(first_name, last_name, position, salary)" + " VALUES " + "(?, ?, ?, ?)";

	private static Employee aboutTheEmployee() {

		Employee employeeToAdd = new Employee();

		System.out.println("What is the employee's first name?");
		employeeToAdd.setFirstName(sc.nextLine());

		System.out.println("What is the employee's last name?");
		employeeToAdd.setLastName(sc.nextLine());

		System.out.println("What is the employee's position?");
		employeeToAdd.setPosition(sc.nextLine());

		System.out.println("What is the employee's salary?");
		employeeToAdd.setSalary(Double.parseDouble(sc.nextLine()));

		return employeeToAdd;

	}// aboutTheEmployee

	public static void deleteFromDatabase() {
		
		connectToDatabase();
		
		ArrayList<Employee> companyEmployees = new ArrayList<>();
		
		String userInput = null;
		
		System.out.println("What is the last name of the employee you would like to delete?");
		userInput = sc.nextLine();
		
		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM company.employees"
					+ " WHERE last_name LIKE '%" + userInput + "'" );
			
			while (RES_SET.next()) {
				
				Employee employeeInDatabase = new Employee();
				
				employeeInDatabase.setEmployeeID(RES_SET.getString("employee_id"));
				employeeInDatabase.setFirstName(RES_SET.getString("first_name"));
				employeeInDatabase.setLastName(RES_SET.getString("last_name"));
				employeeInDatabase.setPosition(RES_SET.getString("position"));
				employeeInDatabase.setSalary(RES_SET.getDouble("salary"));
				
				companyEmployees.add(employeeInDatabase);
				
			}
			
			for (Employee employee : companyEmployees) {
				
				System.out.println(employee.toString());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("What is the employee ID of the employee to be deleted?");
		userInput = sc.nextLine();
		
		try {
		PREP_STMT = CONN.prepareStatement(deleteEmployee);
		
		PREP_STMT.setString(1, userInput);
		
		PREP_STMT.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}// deleteFromDatabase

	private static String deleteEmployee = "DELETE FROM `company`.`employees`"
			+ " WHERE employee_id = ?";
	
	public static void updateToDatabase() {
			
			connectToDatabase();
			
			ArrayList<Employee> companyEmployees = new ArrayList<>();
			
			String userInput = null;
			
			System.out.println("What is the last name of the employee you would like to update?");
			userInput = sc.nextLine();
			
			try {
				STMT = CONN.createStatement();
				RES_SET = STMT.executeQuery("SELECT * FROM company.employees"
						+ " WHERE last_name LIKE '%" + userInput + "'" );
				
				while (RES_SET.next()) {
					
					Employee employeeInDatabase = new Employee();
					
					employeeInDatabase.setEmployeeID(RES_SET.getString("employee_id"));
					employeeInDatabase.setFirstName(RES_SET.getString("first_name"));
					employeeInDatabase.setLastName(RES_SET.getString("last_name"));
					employeeInDatabase.setPosition(RES_SET.getString("position"));
					employeeInDatabase.setSalary(RES_SET.getDouble("salary"));
					
					companyEmployees.add(employeeInDatabase);
					
				}
				
				for (Employee employee : companyEmployees) {
					
					System.out.println(employee.toString());
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("What is the employee ID number of the employee to be updated?");
			userInput = sc.nextLine();
			
			Employee employeeToUpdate = new Employee();
	
			employeeToUpdate = aboutEmployeeUpdate();
			
			try {
				PREP_STMT = CONN.prepareStatement(updateEmployee);
	
				PREP_STMT.setString(1, employeeToUpdate.getEmployeeID());
				PREP_STMT.setString(2, employeeToUpdate.getFirstName());
				PREP_STMT.setString(3, employeeToUpdate.getLastName());
				PREP_STMT.setString(4, employeeToUpdate.getPosition());
				PREP_STMT.setDouble(5, employeeToUpdate.getSalary());
				PREP_STMT.setString(6, userInput);
	
				PREP_STMT.executeUpdate();
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}// deleteFromDatabase
	
	private static String updateEmployee = "UPDATE `company`.`employees`"
			+ " SET `employee_id` =  ?, `first_name` = ?, `last_name` = ?, `position` = ?, `salary` = ? "
			+ " WHERE  `employee_id` = ?";
	
	private static Employee aboutEmployeeUpdate() {
	
		Employee employeeToUpdate = new Employee();
		
		System.out.println("What would you like to update this employee's ID number to?");
		employeeToUpdate.setEmployeeID(sc.nextLine());
	
		System.out.println("What would you like to update this employee's first name to?");
		employeeToUpdate.setFirstName(sc.nextLine());
	
		System.out.println("What would you like to update this employee's last name to?");
		employeeToUpdate.setLastName(sc.nextLine());
	
		System.out.println("What would you like to update this employee's position to?");
		employeeToUpdate.setPosition(sc.nextLine());
	
		System.out.println("What would you like to update this employee's salary to?");
		employeeToUpdate.setSalary(Double.parseDouble(sc.nextLine()));
	
		return employeeToUpdate;
	
	}// aboutEmployeeUpdate

}// DAO class
