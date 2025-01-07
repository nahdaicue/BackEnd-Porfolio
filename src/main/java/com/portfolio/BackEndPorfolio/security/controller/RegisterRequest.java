
package com.portfolio.BackEndPorfolio.security.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {
    
    @NotBlank(message = "El nombre de usuario es obligatorio")
    String username;
    //@Email(message = "El correo debe ser válido")
    private String email;
    @NotBlank(message = "La contraseña es obligatoria")
    String password;
    @NotBlank(message = "El nombre es obligatorio")
    String firstname;
    @NotBlank(message = "El apellido es obligatorio")
    String lastname;
    @NotBlank(message = "El pais es obligatorio")
    String country;
}
