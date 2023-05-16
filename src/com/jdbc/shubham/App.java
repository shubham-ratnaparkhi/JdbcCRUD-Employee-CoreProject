package com.jdbc.shubham;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int choice, num;

		EmployeeDAO dao = new EmployeeImpl();
		@SuppressWarnings("unused") //Just to Suppress Warnings...You can ignored it :)
		Employee e;

		 
		do {
			System.out.println("<-------Menu------>");
			System.out.println("1.Get Employee by ID");
			System.out.println("2.Add Employee");
			System.out.println("3.Update Employee");
			System.out.println("4.Delete Employee");
			System.out.println("5.Get all Employees");
			@SuppressWarnings("resource") //Just to Suppress Warnings...You can ignored it :)
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter the ID of Employee: ");
				int id = sc.nextInt();
				e = dao.getEmployeeById(id);
				break;

			case 2:
				System.out.println("Enter Employee Details: ");
				System.out.println("Enter Employee ID: ");
				int id2 = sc.nextInt();
				System.out.println("Enter Employee Name: ");
				String name = sc.next();
				System.out.println("Enter Employee SirName: ");
				String sirname = sc.next();
				System.out.println("Enter Salary: ");
				int salary = sc.nextInt();
				System.out.println("Enter Employee  Destination: ");
				String destination = sc.next();
				System.out.println("Enter Employee gender (Male/Female):  ");
				String gender = sc.next();

				Employee e1 = new Employee(id2, name, sirname, salary, destination, gender);
				e = dao.addEmployee(e1);
				break;

			case 3:
				System.out.println("Enter the ID to change record: ");
				int id5 = sc.nextInt();
				System.out.println("Enter the new Name: ");
				String name1 = sc.next();
				e = dao.updateEmployee(id5, name1);
				break;

			case 4:
				System.out.println("Enter the ID to delete record");
				int id31 = sc.nextInt();
				e = dao.delEmployee(id31);
				break;

			case 5:
				System.out.println("Employee Data");
				System.out.println(
						"-------------------------------------------------------------------------------------");
				System.out.printf("|%5s|%-10s|%-10s|%-20s|%-25s|%-30s\n", "ID", "Name", "Sirname", "Salary",
						"Destination", "Gender");
				System.out.println(
						"-------------------------------------------------------------------------------------");
				dao.getAllEmployees();
				System.out.println(						"-------------------------------------------------------------------------------------");
				break;
			default:
				System.out.println("Wrong input..!");
				break;
			}
			
			System.out.println("Enter 9  for Main menu....!");
			num = sc.nextInt();
		} while (num == 9);
	}

}
