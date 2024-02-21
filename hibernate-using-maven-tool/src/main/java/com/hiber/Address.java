package com.hiber;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType .IDENTITY)
	@Column (name ="address_id")
	private int addressId;
	@Column
	private String Name;
	@Column
	private String City;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int addressId, String name, String city) {
		super();
		this.addressId = addressId;
		Name = name;
		City = city;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", Name=" + Name + ", City=" + City + "]";
	}
	
	

}
