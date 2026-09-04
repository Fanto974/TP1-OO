package com.example.TP1_OO.repository;

import com.example.TP1_OO.models.Contrat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository extends CrudRepository<Contrat, Long> {

}