package com.formation.annuaire.services;

import java.util.List;
import java.util.Optional;

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
	public void saveAll(List<Carnet> listeCarnets) {
		ram.saveAll(listeCarnets);
		
	}
	public List<Carnet> getAllcarnets(){
		return ram.findAll();
	}
   public void setAllCarnets(List<Carnet> carnet) {
	   ram.saveAll(carnet);
   }
   public Long count() {
	   return ram.count();
   }
   public Optional<Carnet> findById(Long id){
	   return ram.findById(id);
   }
   public void delete(Carnet carnet) {
	    ram.delete(carnet);
	   
   }
   public  void create(Carnet carnet) {
	    ram.save(carnet);
   }
   public void update(Carnet carnet) {
	    ram.save(carnet);
   }
}
