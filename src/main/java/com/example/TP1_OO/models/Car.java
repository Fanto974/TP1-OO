package com.example.TP1_OO.models;

import jakarta.persistence.*;

@Entity
public class Car {
	@Id
	private String plateNumber;

	private String brand;

	private int price;

	private boolean isRented;

	public Car() {
	}

	public Car(String plateNumber, String brand, int price, boolean isRented) {
		this.plateNumber = plateNumber;
		this.brand = brand;
		this.price = price;
		this.isRented = isRented;
	}

	public String getPlateNumber() {
		return plateNumber;
	}
	public String getBrand() {
		return brand;
	}
	public int getPrice() {
		return price;
	}
	public boolean isRent() {
		return isRented;
	}
}
