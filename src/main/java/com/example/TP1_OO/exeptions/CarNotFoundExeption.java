package com.example.TP1_OO.exeptions;

public class CarNotFoundExeption extends RuntimeException {

	private final String plateNumber;

	public CarNotFoundExeption(String plateNumber) {
		super("No car was found with plate number " + plateNumber);
		this.plateNumber = plateNumber;
	}

	public String getPlateNumber() {
		return plateNumber;
	}
}
