package com.portfolio.BackEndPorfolio.interfaces;

import com.portfolio.BackEndPorfolio.entities.Persona;
import java.util.List;

public interface IPersonaService {

    //Get_Traer lista de personas
    public List<Persona> getPersona();
    
    //Guarda un objeto de tipo persona
    public void savePersona(Persona persona);
    
    //Eliminar objeto por Id
    public void deletePersona (Long id);
    
    //Buscar persona
    public Persona findPersona(Long id);
}
