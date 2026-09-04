package com.example.TP1_OO.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.TP1_OO.exeptions.CarAlreadyRentedExeption;
import com.example.TP1_OO.exeptions.MissingRentalDatesExeption;
import com.example.TP1_OO.exeptions.CarNotFoundExeption;
import com.example.TP1_OO.exeptions.PersonneNotFoundExeption;
import com.example.TP1_OO.models.Car;
import com.example.TP1_OO.models.Contrat;
import com.example.TP1_OO.models.Personne;
import com.example.TP1_OO.repository.CarRepository;
import com.example.TP1_OO.repository.ContratRepository;
import com.example.TP1_OO.repository.PersonneRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

	private static final Logger log = LoggerFactory.getLogger(CarServiceImpl.class);

	private final CarRepository carRepository;
	private final PersonneRepository personneRepository;
	private final ContratRepository contratRepository;

	public CarServiceImpl(CarRepository carRepository, PersonneRepository personneRepository, ContratRepository contratRepository) {   // injection par constructeur
		this.carRepository = carRepository;
		this.personneRepository = personneRepository;
		this.contratRepository = contratRepository;
	}

	private Car findCarById(String plateNumber){
		return carRepository.findById(plateNumber)
				.orElseThrow(() -> new CarNotFoundExeption(plateNumber));
	}

	@Override
	public void addCar(Car car) {
		carRepository.save(car);
	}

	@Override
	public List<Car> getCars(){
		return ((List<Car>) carRepository.findAll())
				.stream()
				.filter(car -> !car.isRent()).toList();
	}

	@Override
	public Car getCarById(String plateNumber){
		return findCarById(plateNumber);
	}

	@Transactional
	@Override
	public void rentOrGetBack(String plateNumber, boolean rent, String personneTel, Date begin, Date end){
		log.info("Rental request: plateNumber={}, rent={}", plateNumber, rent);

		Car car = findCarById(plateNumber);

		if(rent){
			if (car.isRent()) {
				throw new CarAlreadyRentedExeption(plateNumber);
			}
			else if (begin == null || end == null || personneTel == null) {
				throw new MissingRentalDatesExeption(plateNumber);
			}
			else {
				Personne personne = personneRepository.findById(personneTel)
						.orElseThrow(() -> new PersonneNotFoundExeption(personneTel));

				Contrat contrat = new Contrat();
				contrat.setPersonne(personne);
				contrat.setCar(car);
				contrat.setBeginning(begin);
				contrat.setEnding(end);
				contratRepository.save(contrat);

				car.setIsRented(true);
				carRepository.save(car);
			}
		}
		else {
			car.setIsRented(false);
			carRepository.save(car);
		}
	}
}
