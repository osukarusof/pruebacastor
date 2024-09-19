package com.castor.administracion.repository;

import com.castor.administracion.entity.EstadoSolicitudEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoSolicitudRepository extends JpaRepository<EstadoSolicitudEntity, Long> {
}
