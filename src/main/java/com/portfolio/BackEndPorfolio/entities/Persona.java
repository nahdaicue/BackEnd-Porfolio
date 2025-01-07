package com.portfolio.BackEndPorfolio.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 40, message = "No cumple con la logitud")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 40, message = "No cumple con la logitud")
    private String Apellido;
     
    @Size(min = 1, max = 300, message = "No cumple con la logitud")
    private String img;

    public Persona() {
    }

    public Persona(Long id, String nombre, String Apellido, String img) {
        this.id = id;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.img = img;
    }
    
    
}
