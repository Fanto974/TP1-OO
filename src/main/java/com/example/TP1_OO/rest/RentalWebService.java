package com.example.TP1_OO.rest;

import com.example.TP1_OO.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentalWebService {
	@Autowired
	RentalService rentalService;
}
