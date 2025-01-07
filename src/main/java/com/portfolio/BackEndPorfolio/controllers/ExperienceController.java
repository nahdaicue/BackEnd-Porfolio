package com.portfolio.BackEndPorfolio.controllers;

import com.portfolio.BackEndPorfolio.dto.ExperienceDTO;
import com.portfolio.BackEndPorfolio.entities.Experience;
import com.portfolio.BackEndPorfolio.services.ExperienceService;
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
@RequestMapping("/experience")
@CrossOrigin(origins = "https://frontent-porfolio.web.app")
public class ExperienceController {

    private final ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> detail(@PathVariable("id") int id) {
        if (!experienceService.existById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Experience experience = experienceService.getOne(id).get();
        return new ResponseEntity<>(experience, HttpStatus.OK);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Experience>> list() {
        List<Experience> list = experienceService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> create(@Valid @RequestBody ExperienceDTO dtoExp) {
        // Crear la experiencia y guardarla en el repositorio
        Experience experience = new Experience(dtoExp.getNameExp(), dtoExp.getDescriptionExp());
        experienceService.save(experience);

        // Devolver una respuesta JSON con un mensaje de éxito
        Map<String, String> response = new HashMap<>();
        response.put("message", "Experiencia agregada");

        return new ResponseEntity<>(response, HttpStatus.CREATED); // Usamos CREATED para indicar que se creó un nuevo recurso
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @Valid @RequestBody ExperienceDTO dtoExp) {
        // Verificar si existe el ID
        if (!experienceService.existById(id)) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "El ID no existe");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        // Obtener la experiencia y actualizarla
        Experience experience = experienceService.getOne(id).get();
        experience.setNameExp(dtoExp.getNameExp());
        experience.setDescriptionExp(dtoExp.getDescriptionExp());
        experienceService.save(experience);

        // Respuesta de éxito
        Map<String, String> response = new HashMap<>();
        response.put("message", "La experiencia fue modificada");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
        // Verificar si existe el ID
        if (!experienceService.existById(id)) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "El ID no existe");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        // Eliminar la experiencia
        experienceService.delete(id);

        // Respuesta de éxito
        Map<String, String> response = new HashMap<>();
        response.put("message", "La experiencia fue eliminada");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
