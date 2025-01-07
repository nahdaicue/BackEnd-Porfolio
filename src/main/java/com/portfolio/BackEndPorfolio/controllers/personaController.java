package com.portfolio.BackEndPorfolio.controllers;

import com.portfolio.BackEndPorfolio.entities.Persona;
import com.portfolio.BackEndPorfolio.interfaces.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://frontent-porfolio.web.app")
public class personaController {
    @Autowired IPersonaService iPersonaService;
    
    @GetMapping("/persona/traer")
    public List<Persona> getPersona(){
        return iPersonaService.getPersona();
    }
    
    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody Persona persona){
        iPersonaService.savePersona(persona);
        return "La persona se creo correctamente";
    }
    
    @DeleteMapping("/persona/borrar/{id}")
    public String detelePersona(@PathVariable Long id){
    iPersonaService.deletePersona(id);
    return "Se borro correctamente";
    }
    
    @PutMapping("/persona/editar/{id}")
    public String editPersona(@PathVariable Long id, @RequestBody Persona personaActualizada) {
    Persona persona = iPersonaService.findPersona(id);

    persona.setNombre(personaActualizada.getNombre());
    persona.setApellido(personaActualizada.getApellido());
    persona.setImg(personaActualizada.getImg());

    iPersonaService.savePersona(persona);
    return "Persona modificada correctamente";
}

}
