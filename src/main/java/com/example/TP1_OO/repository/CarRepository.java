package com.example.TP1_OO.repository;

import com.example.TP1_OO.models.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {

	private final List<Car> cars = new ArrayList<>();

	public CarRepository() {
		cars.add(new Car("11AA22", "Ferrari", 100, false));
		cars.add(new Car("22AA33", "Porsche", 90, false));
	}

	public List<Car> findAll() {
		return cars;
	}

	public Optional<Car> findByPlateNumber(String plateNumber) {
		return cars.stream()
				.filter(car -> car.getPlateNumber().equals(plateNumber))
				.findFirst();
	}
}