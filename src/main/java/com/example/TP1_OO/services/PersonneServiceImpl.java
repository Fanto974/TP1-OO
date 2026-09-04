package com.example.TP1_OO.services;

import com.example.TP1_OO.exeptions.PersonneNotFoundExeption;
import com.example.TP1_OO.models.Personne;
import com.example.TP1_OO.repository.PersonneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneServiceImpl implements PersonneService{

	private static final Logger log = LoggerFactory.getLogger(PersonneServiceImpl.class);

	private final PersonneRepository personneRepository;

	public PersonneServiceImpl(PersonneRepository personneRepository) {   // injection par constructeur
		this.personneRepository = personneRepository;
	}

	private Personne findPersonneById(String tel) {
		return personneRepository.findById(tel)
				.orElseThrow(() -> new PersonneNotFoundExeption(tel));
	}

	@Override
	public Personne getPersonneById(String tel){
		return findPersonneById(tel);
	}

	@Override
	public List<Personne> getPersonnes(){
		return (List<Personne>) personneRepository.findAll();
	}
}
