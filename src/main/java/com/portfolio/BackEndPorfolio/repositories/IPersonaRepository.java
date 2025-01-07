package com.portfolio.BackEndPorfolio.repositories;

import com.portfolio.BackEndPorfolio.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>{
    
}
