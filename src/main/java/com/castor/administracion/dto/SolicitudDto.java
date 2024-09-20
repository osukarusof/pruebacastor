package com.castor.administracion.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudDto {

    @Positive(message = "El campo Id debe ser un número positivo.")
    private Long id;

    @Positive(message = "El campo empleadoId debe ser un número positivo.")
    private Long empleadoId;

    @Positive(message = "El campo empleadoId debe ser un número positivo.")
    private Long servicioId;

    @Positive(message = "El campo estadoServicioId debe ser un número positivo.")
    private Long estadoServicioId;

    @NotNull(message = "Este campo es requerido.")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaSolicitud;
}
