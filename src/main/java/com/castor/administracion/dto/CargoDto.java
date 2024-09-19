package com.castor.administracion.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CargoDto {

    @Positive(message = "El campo Id debe ser un número positivo.")
    private Long id;

    @NotNull(message = "Este campo es requerido.")
    @NotNull(message = "Este campo es requerido.")
    private String nombre;
}
