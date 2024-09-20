package com.castor.administracion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "empleados")
public class EmpleadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cedula", nullable = false)
    private Long cedula;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "foto", nullable = false)
    private String foto;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fecha;

    @Column(name = "activo", nullable = false)
    @Builder.Default
    private Boolean activo = true;

    @ManyToOne
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private CargoEntity cargo;

    @OneToMany(mappedBy = "empleado")
    private Set<SolicitudEntity> solicitudEntities;
}
