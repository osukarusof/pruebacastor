package com.castor.administracion.repository;

import com.castor.administracion.entity.ServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServicioRepository extends JpaRepository<ServicioEntity, Long> {

    @Query(value = "select s from ServicioEntity s where s.id = :servicioId")
    Optional<ServicioEntity> findById(@Param("servicioId") Long servicioId);
}
