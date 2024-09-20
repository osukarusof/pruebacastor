package com.castor.administracion.repository;

import com.castor.administracion.entity.EstadoSolicitudEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoSolicitudRepository extends JpaRepository<EstadoSolicitudEntity, Long> {

    @Query(value = "select es from EstadoSolicitudEntity es where es.id = :id")
    Optional<EstadoSolicitudEntity> findById(@Param("id") Long id);
}
