package com.formation.annuaire.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.formation.annuaire.entities.Carnet;
@Repository
public interface CarnetRepositories  extends JpaRepository<Carnet, Long>{

}
