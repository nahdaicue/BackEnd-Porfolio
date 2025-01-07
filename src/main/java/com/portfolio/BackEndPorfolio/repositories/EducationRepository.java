package com.portfolio.BackEndPorfolio.repositories;

import com.portfolio.BackEndPorfolio.entities.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {

    public Optional<Education> findByNameEducation(String nameEducation);

    public boolean existsByNameEducation(String nameEducation);
}
