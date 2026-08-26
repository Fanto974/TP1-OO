package com.example.TP1_OO.exeptions;

public class CarAlreadyRentedExeption extends RuntimeException {

	private final String plateNumber;

	public CarAlreadyRentedExeption(String plateNumber) {
		super("Car " + plateNumber + " is already rented");
		this.plateNumber = plateNumber;
	}

	public String getPlateNumber() {
		return plateNumber;
	}
}