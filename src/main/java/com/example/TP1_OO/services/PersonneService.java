package com.example.TP1_OO.services;

import com.example.TP1_OO.models.Personne;

import java.util.List;

public interface PersonneService {

	public Personne getPersonneById(String tel);

	public List<Personne> getPersonnes();
}
