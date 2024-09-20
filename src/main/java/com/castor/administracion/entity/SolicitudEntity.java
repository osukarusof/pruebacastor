package com.castor.administracion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "solicitudes")
public class SolicitudEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_solicitud")
    private LocalDate fechaSolicitud;

    @ManyToOne
    @JoinColumn(name = "empleado_id", referencedColumnName = "id")
    private EmpleadoEntity empleado;

    @ManyToOne
    @JoinColumn(name = "estado_solicitud_id", referencedColumnName = "id")
    private EstadoSolicitudEntity estadoSolicitud;

    @ManyToMany
    @JoinTable(
            name = "solicitud_servicios",
            joinColumns = @JoinColumn(name = "solicitud_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id")
    )
    private Set<ServicioEntity> servicios = new HashSet<>();
}
