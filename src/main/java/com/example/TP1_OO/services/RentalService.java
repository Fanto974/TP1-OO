package com.example.TP1_OO.services;

import com.example.TP1_OO.models.Car;
import com.example.TP1_OO.models.Dates;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RentalService {

	@GetMapping("/cars")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Car> listOfCars();

	@GetMapping("/cars/{plateNumber}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception;

	@PutMapping(value = "/cars/{plateNumber}")
	@ResponseStatus(HttpStatus.OK)
	public void rentOrGetBack(
			@PathVariable("plateNumber") String plateNumber,
			@RequestParam(value="rent", required = true)boolean rent,
			@RequestBody Dates dates);

}
