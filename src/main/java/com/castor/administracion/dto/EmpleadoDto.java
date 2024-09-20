package com.castor.administracion.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDto {

    @Positive(message = "El campo Id debe ser un número positivo.")
    private Long id;

    @NotNull(message = "Este campo es requerido.")
    @Positive(message = "El campo cedula debe ser un número positivo.")
    private Long cedula;

    @NotNull(message = "Este campo es requerido.")
    @NotNull(message = "Este campo es requerido.")
    private String nombre;

    @NotNull(message = "Este campo es requerido.")
    @NotBlank(message = "Este campo no puede estar vacio.")
    private String foto;

    @NotNull(message = "Este campo es requerido.")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha;

    @Valid
    private CargoDto cargo;
}
