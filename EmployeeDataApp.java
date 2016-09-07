package com.employeedata.employeedata;

import java.util.Scanner;

public class EmployeeDataApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String userInput = null;
		String idToDelete = null;

		System.out.println(
				"What would you like to do?\n1: View employees\n2: Add employee\n3: Update employee\n4: Delete employee");
		userInput = sc.nextLine();

		switch (userInput) {
		case "1":
			View.viewEmployeeData();
			break;
		case "2":
			System.out.println("Enter Employee's First Name:");

			break;
		case "3":

			break;
		case "4":
			View.viewEmployeeData();
			System.out.println("What Employee ID would you like to delete");
			idToDelete = sc.nextLine();
			Delete.DeleteFromAPI(idToDelete);
			View.viewEmployeeData();
			break;

		default:
			break;
		}

	}
}
