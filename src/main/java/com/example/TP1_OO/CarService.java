package com.example.TP1_OO;

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
			@RequestParam(value="rent", required = true)boolean rent) throws Exception{

		Car car = findCar(plateNumber);

		if(rent){
			if ()
		}
	}

	@PutMapping(value = "/cars/{plateNumber}")
	public void rent(
			@PathVariable("plateNumber") String plateNumber,
			@RequestParam(value="rent", required = true)boolean rent,
			@RequestBody Dates dates){
	}
}
