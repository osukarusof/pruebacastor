package com.castor.administracion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "solucitudes")
public class SolicitudEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "empleado_id", referencedColumnName = "id")
    private EmpleadoEntity empleado;

    @ManyToOne
    @JoinColumn(name = "estado_solicitud_id", referencedColumnName = "id")
    private EstadoSolicitudEntity estadoSolicitud;

    @OneToMany(mappedBy = "solicitud")
    private Set<SolicitudServicioEntity> solicitudServicios;
}
