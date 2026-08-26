package com.example.TP1_OO.rest;

import com.example.TP1_OO.models.Car;
import com.example.TP1_OO.models.Dates;
import com.example.TP1_OO.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentalWebService {
	@Autowired
	RentalService rentalService;

	@GetMapping("/cars")
	public List<Car> listOfCars() {
		return rentalService.listOfCars();
	}

	@PutMapping("/cars/{plateNumber}")
	@ResponseStatus(HttpStatus.OK)
	public void rentOrGetBack(
			@PathVariable("plateNumber") String plateNumber,
			@RequestParam("rent") boolean rent,
			@RequestBody(required = false) Dates dates) {
		rentalService.rentOrGetBack(plateNumber, rent, dates);
	}
}
