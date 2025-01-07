package com.portfolio.BackEndPorfolio.services;

import com.portfolio.BackEndPorfolio.entities.Education;
import com.portfolio.BackEndPorfolio.repositories.EducationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EducationService {
    
    private final EducationRepository educationRepository;
    
    @Autowired
    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }
    
    public List<Education> list() {
        return educationRepository.findAll();
    }
    
    public Optional<Education> getOne(int id) {
        return educationRepository.findById(id);
    }
    
    public Optional<Education> getByNameEducation(String nameEducation) {
        return educationRepository.findByNameEducation(nameEducation);
    }
    
    public void save(Education education){
        educationRepository.save(education);
    }
    
    public void delete(int id){
        educationRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return educationRepository.existsById(id);
    }
    
    public boolean existsByName(String nameEducation){
        return educationRepository.existsByNameEducation(nameEducation);
    }
}
