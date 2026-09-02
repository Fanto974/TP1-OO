package com.example.TP1_OO.repository;

import com.example.TP1_OO.models.Car;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface CarRepository extends CrudRepository<Car, String>{

}
