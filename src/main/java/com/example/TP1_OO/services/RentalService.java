package com.example.TP1_OO.services;

import com.example.TP1_OO.models.Car;
import com.example.TP1_OO.models.Dates;

import java.util.List;

public interface RentalService {

	public void addCar(Car car);

	public List<Car> listOfCars();

	public Car aCar(String plateNumber);

	public void rentOrGetBack(String plateNumber, boolean rent, Dates dates);

}
