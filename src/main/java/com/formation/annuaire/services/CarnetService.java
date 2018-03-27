package com.formation.annuaire.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.annuaire.entities.Carnet;
import com.formation.annuaire.repositories.CarnetRepositories;

@Service
public class CarnetService {
	@Autowired
	CarnetRepositories ram;
	public List<Carnet> getAll() {
		return ram.findAll();
		
	}

}
