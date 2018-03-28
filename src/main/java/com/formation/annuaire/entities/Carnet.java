package com.formation.annuaire.entities;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="personne")
public class Carnet {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)//pour la base donnee pour generer l'auto-incrementation
    private Long id;
    //@Pattern(regexp="(?i)[a-z] {2,50}", message="{com.formation.annuaire.hello.civilite}")
	@Enumerated(EnumType.STRING) // pour la base de donne pour rendre l'enumeraion ne string
	@Column(length= 8) // pour la base de donnee la taille sera definie
    private Civilite civilite;
	@NotBlank(message="{com.formation.annuaire.hello.nom}")
	//@Pattern(regexp="(?i)[a-z] {2,50}", message="{com.formation.annuaire.hello.nom}")
	@Column(length=100)
    private String nom;
	@NotBlank(message="{com.formation.annuaire.hello.prenom}")
	//@Pattern(regexp="(?i)[a-z\\- ] {2,100}", message="{com.formation.annuaire.hello.prenom}")
	@Column(length=100)
    private String prenom;
	@NotBlank(message="Bonjour Tout le monde// message personnalisé avec notblank")
	@Column(columnDefinition="date",name="dateDeNaissance")
    private String dateDeNaissance;
	//@NotBlank
	// @Pattern(regexp="(?i)[0-9] {2,50}", message="{com.formation.annuaire.hello.tel}")
	@Column(name="tel", length=10)
    private String tel;
	@NotBlank
	// @Pattern(regexp="(?i)[a-z] {}", message="{com.formation.annuaire.hello.email}") 
	@Column(length=100)
    private String email;
	
	
    public Carnet() {
    }
   
    public Carnet(Long id, Civilite civilite, String nom, String prenom, String dateDeNaissance, String tel, String email, String cp, String ville) {
        this.id = id;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.tel = tel;
        this.email = email;
        this.cp = cp;
        this.ville = ville;
    }

    public Long getId() {
    
        return id;
    }
    public void setId(Long id) {
    
        this.id = id;
    }

    public Civilite getCivilite() {
    
        return civilite;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    private String cp;
    private String ville;

}
