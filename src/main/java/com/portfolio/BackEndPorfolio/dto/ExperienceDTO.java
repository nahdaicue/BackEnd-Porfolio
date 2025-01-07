
package com.portfolio.BackEndPorfolio.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceDTO {
    
    //Se usan con @Valid
    @NotBlank(message = "El nombre de la experiencia no puede estar vacío")
    private String nameExp;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descriptionExp;

}
