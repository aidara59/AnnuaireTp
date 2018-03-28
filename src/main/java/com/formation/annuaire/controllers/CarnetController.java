package com.formation.annuaire.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.formation.annuaire.entities.Carnet;
import com.formation.annuaire.entities.Civilite;
import com.formation.annuaire.services.CarnetService;

@RestController
public class CarnetController {
	@Autowired
	private CarnetService sap;
	private List<Carnet> listeCarnets = new ArrayList<>(Arrays.asList( 
            new Carnet(1L, Civilite.MONSIEUR, "Pouye", "Johny", "1960-10-18","0123458970", "pouye@yahoo.fr", "75015", "Paris"), 
            new Carnet(2L, Civilite.MADAME, "Baraka", "Wafa", "1999-11-16","0627895413", "baraka@yahoo.fr","59000", "Lille"), 
            new Carnet(3L, Civilite.MONSIEUR,"Niang","Aidara", "2000-08-10","0612131415", "niang@gmail.com","59100", "Lille"),
            new Carnet(4L, Civilite.MONSIEUR,"Martin","Michel", "1999-08-10","0125789632", "michel@hotmail.fr","75012", "Paris"),
            new Carnet(5L, Civilite.MADAME,"Sara","SARA", "1998-08-10","0723541089", "sara@yahoo.fr","59300" ,"Villeneuve d'asq")));
	
	/* @GetMapping("/carnetsrest") 
	    public List<Carnet> getAllRest() { 
	        return listeCarnets; 
	    } 
	*/
	@RequestMapping("/carnetsrest")
	public List<Carnet> getAllCarnet() {
		return sap.getAll();
			
	}
	 @GetMapping("/carnetshtml") 
	    public ModelAndView getAll(){ 
	        ModelAndView mav = new ModelAndView("pages/carnets"); 
	        mav.addObject("carnets", listeCarnets); 
	        return mav; 
	    } 
	 @RequestMapping(value = "/carnet", method = RequestMethod.GET) 
	    public ModelAndView form(){ 
	        return new ModelAndView("pages/formulaire") 
	            .addObject("carnet", new Carnet()); 
	         
	    } 
	 @GetMapping("/carnets") 
	    public ModelAndView setAll(){ 
	        ModelAndView mav = new ModelAndView("pages/carnets"); 
	        sap.saveAll(listeCarnets);
	        mav.addObject("carnets", sap.getAll()); 
	        return mav; 
	    }
	 @GetMapping("/carnet/{id}") 
	    public ModelAndView getById(@PathVariable Long id){ 
	        ModelAndView mav = new ModelAndView("pages/carnet"); 
	        sap.saveAll(listeCarnets);
	        mav.addObject("carnet", sap.findById(id).get()); 
	        return mav; 
	    }
	 @RequestMapping(method = RequestMethod.PUT, value = "/carnet")
	    public ModelAndView update(@Validated Carnet carnet, BindingResult bindingResult){
	        if (bindingResult.hasErrors()){
	            return new ModelAndView("pages/carnet.html").addObject("carnet", carnet);
	        }
	        sap.update(carnet);
	        return new ModelAndView("redirect:/carnet/" + carnet.getId());
	    }
	 @RequestMapping(method = RequestMethod.DELETE, value = "/carnet/{id}")
	    public ModelAndView update(@PathVariable Long id){
		 
	        sap.delete(sap.findById(id).get());
	        return new ModelAndView("redirect:/carnetshtml/");
	    }
	 @RequestMapping(value = "/carnet", method = RequestMethod.POST)
	    public ModelAndView add(@Validated Carnet carnet, BindingResult bindingResult){
	        if (bindingResult.hasErrors()){
	            return new ModelAndView("pages/carnetForm.html").addObject("carnet", carnet);
	        }
	        sap.create(carnet);
	        return new ModelAndView("pages/carnetForm.html").addObject("carnet", carnet);
	    }
	}
