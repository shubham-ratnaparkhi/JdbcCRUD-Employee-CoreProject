package com.jdbc.shubham;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeImpl implements EmployeeDAO {
	String username = "root";
	String password = "shubham";
	String url = "jdbc:mysql://localhost:3306/jdbcproject";
	Employee e = new Employee();

	@Override
	public void getAllEmployees() {
		try {
			String query = "select * from Employee";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				// getting values of employees from database
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String sirname = rs.getString(3);
				long salary = rs.getInt(4);
				String destination = rs.getString(5);
				String gender = rs.getString(6);
				// setting value to employee class
				e.setId(id);
				e.setName(name);
				e.setSirname(sirname);
				e.setSalary(salary);
				e.setDestination(destination);
				e.setGender(gender);
//				System.out.println("................All Employees Data..............");
				System.out.printf("|%5s|%-10s|%-10s|%-20s|%-25s|%-30s\n", id, name, sirname, salary, destination,
						gender);
			}
			// closing all connection
			rs.close();
			st.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employee getEmployeeById(int ID) {
		try {
			String query = "select * from Employee where ID=" + ID;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String sirname = rs.getString(3);
				long salary = rs.getInt(4);
				String destination = rs.getString(5);
				String gender = rs.getString(6);
				// setting value to employee class
				e.setId(id);
				e.setName(name);
				e.setSirname(sirname);
				e.setSalary(salary);
				e.setDestination(destination);
				e.setGender(gender);
				// System.out.println("Employee ID: "+i+"\tEmployee name: "+name+"\tSalary:
				// "+salary);
				System.out.println("         Employee Data          ");
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.printf("|%5s|%-10s|%-10s|%-20s|%-25s|%-30s\n", "ID", "Name", "Sirname", "Salary",
						"Destination", "Gender");
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.printf("|%5s|%-10s|%-10s|%-20s|%-25s|%-30s\n", id, name, sirname, salary, destination,
						gender);
				System.out.println("-------------------------------------------------------------------------------------");
			}
			rs.close();
			st.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return e;
	}

	@Override
	public Employee addEmployee(Employee e) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Employee VALUES (?, ?, ?, ?, ?, ?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3,e.getSirname() );
			ps.setLong(4, e.getSalary());
			ps.setString(5,e.getDestination());
			ps.setString(6, e.getGender());
			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Employee added successfully...!");
			} else
				System.out.println("Failed to add a record........!");
			ps.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee delEmployee(int ID) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "DELETE FROM Employee WHERE ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ID);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Data deleted successfully!");
			} else
				System.out.println("Failed to delete data..!");

			ps.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		return null;

	}

	@Override
	public Employee updateEmployee(int ID, String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = "UPDATE Employee SET Name= ? WHERE ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, ID);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("An existing user was updated successfully!");
			} else
				System.out.println("Failed to update data..!");

			ps.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		return null;

	}
}
