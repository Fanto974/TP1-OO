package com.example.TP1_OO.services;

import com.example.TP1_OO.models.Car;
import com.example.TP1_OO.models.Dates;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No car with plate number " + plateNumber);
	}

	@Override
	public List<Car> listOfCars(){
		return cars.stream().filter(car -> !car.isRent()).toList();
	}

	@Override
	public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception{
		return findCar(plateNumber);
	}

	@Override
	public void rentOrGetBack(
			@PathVariable("plateNumber") String plateNumber,
			@RequestParam(value="rent", required = true)boolean rent,
			@RequestBody Dates dates){

		Car car = findCar(plateNumber);

		if(rent){
			if (car.isRent()) {
				throw new ResponseStatusException(HttpStatus.CONFLICT, "Car " + plateNumber + " is already rented");
			}
			else if (dates == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"Rental dates are required to rent a car");
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
