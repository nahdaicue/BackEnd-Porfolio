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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_education", nullable = false, length = 100)
    private String nameEducation;

    @Column(name = "description_education", length = 500)
    private String descriptionEducation;

    // Constructor adicional (sin ID)
    public Education(String nameEducation, String descriptionEducation) {
        this.nameEducation = nameEducation;
        this.descriptionEducation = descriptionEducation;
    }
}
