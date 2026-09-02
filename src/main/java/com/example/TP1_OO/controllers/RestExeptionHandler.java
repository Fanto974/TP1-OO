package com.example.TP1_OO.controllers;

import com.example.TP1_OO.exeptions.CarAlreadyRentedExeption;
import com.example.TP1_OO.exeptions.CarNotFoundExeption;
import com.example.TP1_OO.exeptions.MissingRentalDatesExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RestExeptionHandler {

	public record ApiError(LocalDateTime timestamp, int status, String error, String message) {
	}


	@ExceptionHandler(CarNotFoundExeption.class)
	public ResponseEntity<ApiError> handleCarNotFound(CarNotFoundExeption ex) {
		return build(HttpStatus.NOT_FOUND, ex.getMessage());
	}

	@ExceptionHandler(CarAlreadyRentedExeption.class)
	public ResponseEntity<ApiError> handleCarAlreadyRented(CarAlreadyRentedExeption ex) {
		return build(HttpStatus.CONFLICT, ex.getMessage());
	}

	@ExceptionHandler(MissingRentalDatesExeption.class)
	public ResponseEntity<ApiError> handleMissingDates(MissingRentalDatesExeption ex) {
		return build(HttpStatus.BAD_REQUEST, ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleUnexpected(Exception ex) {
		return build(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error: " + ex.getMessage());
	}

	private ResponseEntity<ApiError> build(HttpStatus status, String message) {
		ApiError body = new ApiError(
				LocalDateTime.now(),
				status.value(),
				status.getReasonPhrase(),
				message);
		return ResponseEntity.status(status).body(body);
	}
}