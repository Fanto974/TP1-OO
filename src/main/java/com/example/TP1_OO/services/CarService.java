package com.example.TP1_OO.services;

import com.example.TP1_OO.models.Car;

import java.util.Date;
import java.util.List;

public interface CarService {

	public void addCar(Car car);

	public List<Car> getCars();

	public Car getCarById(String plateNumber);

	public void rentOrGetBack(String plateNumber, boolean rent, String personneTel, Date begin, Date end);

}
