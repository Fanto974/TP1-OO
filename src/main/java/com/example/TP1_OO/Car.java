package com.example.TP1_OO;

public class Car {
	private String plateNumber;
	private String brand;
	private int price;
	private boolean isRented = false;

	public Car(String plateNumber, String brand, int price, boolean isRented) {
		this.plateNumber = plateNumber;
		this.brand = brand;
		this.price = price;
		this.isRented = isRented;
	}

	public Car(){}

	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isRent() {
		return isRented;
	}
	public void setRent(boolean rent) {
		this.isRented = rent;
	}
}
