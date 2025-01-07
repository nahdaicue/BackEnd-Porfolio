package com.portfolio.BackEndPorfolio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // Lombok genera getters, setters, toString, etc.
@NoArgsConstructor  // Lombok genera el constructor vacío
@AllArgsConstructor // Lombok genera el constructor con parámetros
public class EducationDTO {
    
    @NotBlank(message = "El nombre de la educación no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    private String nameEducation;
    
    @Size(max = 500, message = "La descripción no puede exceder los 500 caracteres")
    private String descriptionEducation;
    
}
