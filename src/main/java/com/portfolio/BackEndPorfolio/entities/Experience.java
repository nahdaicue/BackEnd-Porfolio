package com.portfolio.BackEndPorfolio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data  // Lombok genera getters, setters, toString, etc.
@NoArgsConstructor  // Lombok genera el constructor vacío
@AllArgsConstructor // Lombok genera el constructor con parámetros
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_exp")
    private String nameExp;

    @Column(name = "description_exp")
    private String descriptionExp;

    public Experience(String nombreE, String descripcionE) {
        this.nameExp = nombreE;
        this.descriptionExp = descripcionE;
    }
}
