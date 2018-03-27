package com.formation.annuaire.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.formation.annuaire.carnets.Civilite;
import com.formation.annuaire.entities.Carnet;
import com.formation.annuaire.services.CarnetService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController
public class CarnetController {
	@Autowired
	private CarnetService sap;

	@RequestMapping("/carnets")
	public List<Carnet> getAllCarnet() {
		return sap.getAll();
	}

}
