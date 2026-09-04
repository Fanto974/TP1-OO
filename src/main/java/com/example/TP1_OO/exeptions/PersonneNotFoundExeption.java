package com.example.TP1_OO.exeptions;

public class PersonneNotFoundExeption extends RuntimeException {

	private final String telephone;

	public PersonneNotFoundExeption(String telephone) {
		super("No personne was found with phone number " + telephone);
		this.telephone = telephone;
	}

	public String getTelephone() {
		return telephone;
	}
}