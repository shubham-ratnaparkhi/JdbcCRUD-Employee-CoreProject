package com.jdbc.shubham;

public interface EmployeeDAO {
	public void getAllEmployees();
	public Employee getEmployeeById(int ID);
	public Employee addEmployee(Employee e);
	public Employee delEmployee(int id);
	public Employee updateEmployee(int ID, String name);
}

