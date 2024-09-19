package com.castor.administracion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "solicitud_servicios")
public class SolicitudServicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "servicio_id", referencedColumnName = "id")
    private ServicioEntity servicio;

    @ManyToOne
    @JoinColumn(name = "solicitud_id", referencedColumnName = "id")
    private SolicitudEntity solicitud;

}
