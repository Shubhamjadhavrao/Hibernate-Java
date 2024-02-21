package com.hiber;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Student {

	private int id;
	private String Name;
	private String Address;

	public Student() {
		super();

	}

	public Student(int id, String name, String address) {
		super();
		this.id = id;
		Name = name;
		Address = address;

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

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + Name + ", Address=" + Address + "]";
	}

}
