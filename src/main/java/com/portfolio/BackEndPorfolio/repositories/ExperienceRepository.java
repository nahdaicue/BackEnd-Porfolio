package com.portfolio.BackEndPorfolio.repositories;

import com.portfolio.BackEndPorfolio.entities.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

    public Optional<Experience> findByNameExp(String nameExp);
    
    public boolean existsByNameExp(String nameExp);
}
