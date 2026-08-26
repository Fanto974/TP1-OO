package com.example.TP1_OO.services;

import com.example.TP1_OO.exeptions.CarAlreadyRentedExeption;
import com.example.TP1_OO.exeptions.MissingRentalDatesExeption;
import com.example.TP1_OO.models.Car;
import com.example.TP1_OO.models.Dates;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService implements RentalService{
	private final List<Car> cars = new ArrayList<>();

	public CarService() {
		cars.add(new Car("11AA22", "Ferrari", 100, false));
		cars.add(new Car("22AA33", "Porsche", 90, false));
	}

	public Car findCar(String plateNumber){
		for(Car car : cars){
			if(car.getPlateNumber().equals(plateNumber)){
				return car;
			}
		}
		throw new CarAlreadyRentedExeption(plateNumber);
	}

	@Override
	public List<Car> listOfCars(){
		return cars.stream().filter(car -> !car.isRent()).toList();
	}

	@Override
	public Car aCar(String plateNumber){
		return findCar(plateNumber);
	}

	@Override
	public void rentOrGetBack(String plateNumber, boolean rent, Dates dates){

		Car car = findCar(plateNumber);

		if(rent){
			if (car.isRent()) {
				throw new CarAlreadyRentedExeption(plateNumber);
			}
			else if (dates == null) {
				throw new MissingRentalDatesExeption(plateNumber);
			}
			else {
				car.setRent(true);
				car.setBegin(dates.getBegin());
				car.setEnd(dates.getEnd());
			}
		}
		else {
			car.setRent(false);
			car.setBegin(null);
			car.setEnd(null);
		}
	}
}
