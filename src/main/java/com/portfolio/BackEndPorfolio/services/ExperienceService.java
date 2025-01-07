package com.portfolio.BackEndPorfolio.services;

import com.portfolio.BackEndPorfolio.entities.Experience;
import com.portfolio.BackEndPorfolio.repositories.ExperienceRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional 
public class ExperienceService {
    
    private final ExperienceRepository experienceRepository;
    
    @Autowired // Inyección de la dependencia a través del constructor
    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }
    
    public List<Experience> list(){
        return experienceRepository.findAll();
    }
    
    public Optional<Experience> getOne(int id){
        return experienceRepository.findById(id);
    }
    
    public Optional<Experience> getByNameExp(String nameExp){
        return experienceRepository.findByNameExp(nameExp);
    }
    
    public void save(Experience exp){
        experienceRepository.save(exp);
    }
    
    public void delete(int id){
        experienceRepository.deleteById(id);
    }
    
    public boolean existById(int id){
        return experienceRepository.existsById(id);
    }
    
    public boolean existByNameExp(String nameExp){
        return experienceRepository.existsByNameExp(nameExp);
    }
}
