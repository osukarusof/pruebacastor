package com.castor.administracion.repository;

import com.castor.administracion.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {


    @Query(name = "select e from EmpleadoEntity e where e.cedula = :cedula ")
    Optional<EmpleadoEntity> findByCedula(
            @Param("cedula") Long cedula
    );
}
