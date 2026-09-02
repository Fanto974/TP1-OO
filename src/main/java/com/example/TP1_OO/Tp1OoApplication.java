package com.example.TP1_OO;

import com.example.TP1_OO.models.Car;
import com.example.TP1_OO.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tp1OoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp1OoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CarRepository carRentalService) {
		return (args) -> {
			carRentalService.save( new Car("11AA22", "Ferrari", 1000, false));
			carRentalService.save( new Car("22BB44", "Porshe", 2000, false));
		};
	}

}
