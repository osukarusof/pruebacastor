package com.castor.administracion.repository;

import com.castor.administracion.entity.SolicitudServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudServicioRepository extends JpaRepository<SolicitudServicioEntity, Long> {
}
