package com.jdbc.shubham;

public class Employee {

	private int id;
	private String name;
	private String sirname;
	private long salary;
	private String destination;
	private String gender;

	public int getId() {
		return id;
	}
    
	public Employee(int id, String name, String sirname, long salary, String destination, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.sirname = sirname;
		this.salary = salary;
		this.destination = destination;
		this.gender = gender;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSirname() {
		return sirname;
	}

	public void setSirname(String sirname) {
		this.sirname = sirname;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
