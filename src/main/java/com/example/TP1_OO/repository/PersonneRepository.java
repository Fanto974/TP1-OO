package com.example.TP1_OO.repository;

import com.example.TP1_OO.models.Personne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends CrudRepository<Personne, String> {

}
