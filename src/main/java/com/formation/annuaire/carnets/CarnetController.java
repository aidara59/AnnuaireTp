package com.formation.annuaire.carnets;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CarnetController {

    private List<Carnet> listeCarnets = new ArrayList<>(Arrays.asList(
            new Carnet(1, Civilite.MONSIEUR, "Besson", "Luc", "1959-13-18","0000000000", "5 avenue de l'Element", "75015", "Paris"),
            new Carnet(2, Civilite.MADAME, "Ullmann", "Liv", "1938-12-16","0101010101", "1-16-5", "22", "Tokyo"),
            new Carnet(3, Civilite.MONSIEUR, "Lynch", "David", "1946-01-20","0202020202", "423 Fire Terrace", "59801", "Missoula")
    ));

    /**
     * Récupère tous les Clients enregistrés dans la liste
     * @return la liste des carnets en JSON car on utilise un RESTController
     */
    @GetMapping("/carnets")
    public List<Carnet> getAllRest() {
        return listeCarnets;
    }

    /**
     * Récupère tous les Clients enregistrés dans la liste
     * @return Retourne un ModelAndView, donc une vue avec comme attribut la liste des carnets afin de l'afficher dans la vue pages/carnets contenu dans le dossier templates
     */
    @GetMapping("/carnetshtml")
    public ModelAndView getAll(){
        ModelAndView mav = new ModelAndView("pages/carnets");
        mav.addObject("carnets", listeCarnets);
        return mav;
    }

    /**
     * Méthode qui nous renvoie vers un formlaire HTML
     * @return Retourne ModelAndView afin d'afficher le formulaire avec pour url /carnet, en méthode GET
     */
    @RequestMapping(value = "/carnet", method = RequestMethod.GET)
    public ModelAndView form(){
        return new ModelAndView("pages/formulaire")
        		.addObject("carnet", new Carnet());
        
       
    }

    /**
     * Méthode qui permet de récupérer les informations envoyées par le formulaire puis est ajouté dans la liste des carnets
     * @param carnet Carnet entity
     * @return 
     */
    @RequestMapping(value = "/carnet", method = RequestMethod.POST)
    
    public ModelAndView add(@Validated Carnet carnet, BindingResult bindingResult){
    	if (bindingResult.hasErrors()) {
    		
    		return new ModelAndView("pages/formulaire")
    				.addObject("carnet", carnet);
    	}
        carnet.setId(listeCarnets.size() + 1);
        listeCarnets.add(carnet);
		return new ModelAndView("pages/carnet")
				.addObject("carnet",  carnet);
    }

    /**
     * Méthode qui permet d'afficher un seul carnet (utilisateur)
     * @param id Integer récupérer de l'url /carnet/{id}
     * @return Retourne un ModelAndView avec un carnet dans une vue qui a pour chemin pages/carnet, se trouvant dans le dossier template
     */
    @RequestMapping(method = RequestMethod.GET, value = "/carnet/{id}")
    public ModelAndView getById(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("pages/carnet");
        for ( Carnet carnet : listeCarnets){
            if (id.equals(carnet.getId())){
                mav.addObject("carnet", carnet);
                return mav;
            }
        }
        return null;
    }
}
