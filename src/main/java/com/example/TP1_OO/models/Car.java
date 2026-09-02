package com.example.TP1_OO.models;

public class Car {
	private final String plateNumber;
	private final String brand;
	private final int price;

	private boolean isRented;
	private String begin;
	private String end;

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
	public String getBegin() {
		return begin;
	}
	public String getEnd() {
		return end;
	}

	public void rent(Dates dates) {
		this.isRented = true;
		this.begin = dates.getBegin();
		this.end = dates.getEnd();
	}

	public void returnCar() {
		this.isRented = false;
		this.begin = null;
		this.end = null;
	}
}
