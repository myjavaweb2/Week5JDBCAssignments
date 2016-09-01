package com.airhacks;

import java.util.Scanner;

public class EmployeeDatabase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String userInput = null;
		boolean userInputCorrect = false;
		
		System.out.println("Welcome to the Featured Employee Program");
		
		do {
			System.out.println("Press 1 to read from the database" + "\nPress 2 to write to the database"
					+ "\nPress 3 to delete data from the database" + "\nPress 4 to update the database");
			userInput = sc.nextLine();
			
			switch (userInput) {
			case "1":

				DAO.readFromDatabase();
				break;

			case "2":

				DAO.writeToDatabase();
				break;

			case "3":

				DAO.deleteFromDatabase();
				break;

			case "4":

				DAO.updateToDatabase();
				break;

			default:

				System.out.println("You have entered an invalid option.");
				userInputCorrect = true;
				break;
			}
		} while (userInputCorrect);
		
	}//main

}//class
