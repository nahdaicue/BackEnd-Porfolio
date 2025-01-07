package com.portfolio.BackEndPorfolio.controllers;

import com.portfolio.BackEndPorfolio.dto.EducationDTO;
import com.portfolio.BackEndPorfolio.entities.Education;
import com.portfolio.BackEndPorfolio.services.EducationService;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/education")
@CrossOrigin(origins = "https://frontent-porfolio.web.app")
public class EducationController {

    private final EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    //LISTA
    @GetMapping("/list")
    public ResponseEntity<List<Education>> list() {
        List<Education> list = educationService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //BUSCAR POR ID
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        if (educationService.existsById(id)) {
            Education education = educationService.getOne(id).get();
            return new ResponseEntity<>(education, HttpStatus.OK);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "No se encontró la educación con el ID: " + id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    //BORRAR
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Map<String, String> response = new HashMap<>();

        if (educationService.existsById(id)) {
            educationService.delete(id);
            response.put("message", "La educación con ID: " + id + " fue eliminada exitosamente.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "La educación con ID: " + id + " no fue encontrada.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    //CREAR
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody EducationDTO educationDTO) {
        Map<String, String> response = new HashMap<>();
        Education education = new Education(educationDTO.getNameEducation(), educationDTO.getDescriptionEducation());

        educationService.save(education);

        response.put("message", "La educación fue creada exitosamente.");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //MODIFICAR
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EducationDTO educationDTO) {
        Map<String, String> response = new HashMap<>();

        if (educationService.existsById(id)) {
            // Obtener la educación existente
            Education education = educationService.getOne(id).get();

            // Actualizar los campos
            education.setNameEducation(educationDTO.getNameEducation());
            education.setDescriptionEducation(educationDTO.getDescriptionEducation());

            // Guardar la educación actualizada
            educationService.save(education);

            // Respuesta exitosa
            response.put("message", "Se modificó con éxito");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            // Si no se encuentra la educación con el ID proporcionado
            response.put("message", "No se encontró el ID");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

}
//38:50
