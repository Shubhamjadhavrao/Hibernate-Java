package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String Name;
    @Column
    private String Department;;
    @Column
    private double Salary;

    public Employee() {
	super();
	// TODO Auto-generated constructor stub
    }

    public Employee(String name, String department, double salary) {
	super();

	Name = name;
	Department = department;
	Salary = salary;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return Name;
    }

    public void setName(String name) {
	Name = name;
    }

    public String getDepartment() {
	return Department;
    }

    public void setDepartment(String department) {
	Department = department;
    }

    public double getSalary() {
	return Salary;
    }

    public void setSalary(double salary) {
	Salary = salary;
    }

    @Override
    public String toString() {
	return "Employee [id=" + id + ","
		          + " Name=" + Name + ","
			+ " Department=" + Department + ", "
			+ "Salary=" + Salary + "]";
    }

}
