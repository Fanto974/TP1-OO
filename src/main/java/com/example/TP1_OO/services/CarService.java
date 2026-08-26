package com.example.TP1_OO.services;

import com.example.TP1_OO.models.Car;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CarService {
	private List<Car> cars;

	public Car findCar(String plateNumber){
		for(Car car : cars){
			if(car.getPlateNumber().equals(plateNumber)){
				return car;
			}
		}
		return null;
	}

	@GetMapping("/cars")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Car> listOfCars(){
		return cars;
	}

	@GetMapping("/cars/{plateNumber}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception{
		return findCar(plateNumber);
	}

	@PutMapping(value = "/cars/{plateNumber}")
	@ResponseStatus(HttpStatus.OK)
	public void rentOrGetBack(
			@PathVariable("plateNumber") String plateNumber,
			@RequestParam(value="rent", required = true)boolean rent,
			@RequestBody Dates dates){

		Car car = findCar(plateNumber);

		if(rent){
			if (car.isRent()) {
				System.out.println(car.getPlateNumber() + " is already rented");
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
