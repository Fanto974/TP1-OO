package com.example.TP1_OO.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.TP1_OO.exeptions.CarAlreadyRentedExeption;
import com.example.TP1_OO.exeptions.MissingRentalDatesExeption;
import com.example.TP1_OO.exeptions.CarNotFoundExeption;
import com.example.TP1_OO.models.Car;
import com.example.TP1_OO.models.Dates;
import com.example.TP1_OO.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService implements RentalService{

	private static final Logger log = LoggerFactory.getLogger(CarService.class);
	private final CarRepository carRepository;

	public CarService(CarRepository carRepository) {   // injection par constructeur
		this.carRepository = carRepository;
	}

	public Car findCar(String plateNumber){
		return carRepository.findByPlateNumber(plateNumber)
				.orElseThrow(() -> new CarNotFoundExeption(plateNumber));
	}

	@Override
	public List<Car> listOfCars(){
		return carRepository.findAll().stream().filter(car -> !car.isRent()).toList();
	}

	@Override
	public Car aCar(String plateNumber){
		return findCar(plateNumber);
	}

	@Override
	public void rentOrGetBack(String plateNumber, boolean rent, Dates dates){
		log.info("Rental request: plateNumber={}, rent={}", plateNumber, rent);

		Car car = findCar(plateNumber);

		if(rent){
			if (car.isRent()) {
				throw new CarAlreadyRentedExeption(plateNumber);
			}
			else if (dates == null) {
				throw new MissingRentalDatesExeption(plateNumber);
			}
			else {
				car.rent(dates);
			}
		}
		else {
			car.returnCar();
		}
	}
}
