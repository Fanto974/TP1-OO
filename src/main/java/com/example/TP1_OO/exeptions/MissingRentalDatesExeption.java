package com.example.TP1_OO.exeptions;

public class MissingRentalDatesExeption extends RuntimeException {

	public MissingRentalDatesExeption(String plateNumber) {
		super("Rental dates are required to rent car " + plateNumber);
	}
}
