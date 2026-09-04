package com.example.TP1_OO.controllers;

import com.example.TP1_OO.models.Car;
import com.example.TP1_OO.models.RentalRequest;
import com.example.TP1_OO.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class RentalWebService {
	@Autowired
	CarService rentalService;

	@GetMapping("/cars")
	public List<Car> listOfCars() {
		return rentalService.getCars();
	}

	@GetMapping("/cars/{plateNumber}")
	@ResponseStatus(HttpStatus.OK)
	public Car aCar(@PathVariable("plateNumber") String plateNumber){
		return rentalService.getCarById(plateNumber);
	}

	@PutMapping("/cars/{plateNumber}")
	@ResponseStatus(HttpStatus.OK)
	public void rentOrGetBack(
			@PathVariable("plateNumber") String plateNumber,
			@RequestParam("rent") boolean rent,
			@RequestBody(required = false) RentalRequest request) {
		String personneTel = request != null ? request.getPersonneTel() : null;
		Date begin = request != null ? request.getBegin() : null;
		Date end = request != null ? request.getEnd() : null;
		rentalService.rentOrGetBack(plateNumber, rent, personneTel, begin, end);
	}
}
