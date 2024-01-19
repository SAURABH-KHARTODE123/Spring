package com.demo.model;

public class Employee {
	private int id;
	private String name;
	private String gender;
	private double price;
	public Employee() {
		super();
	}
	public Employee(int id, String name, String gender, double price) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.price = price;
	}
	public int getId() {
		return id;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", gender=" + gender + ", price=" + price + "]";
	}
	
	
}
