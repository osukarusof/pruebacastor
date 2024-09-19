package com.castor.administracion.service.impl;

import com.castor.administracion.dto.EmpleadoDto;
import com.castor.administracion.entity.CargoEntity;
import com.castor.administracion.entity.EmpleadoEntity;
import com.castor.administracion.exception.NotFoundException;
import com.castor.administracion.repository.CargoRepository;
import com.castor.administracion.repository.EmpleadoRepository;
import com.castor.administracion.service.EmpleadoService;
import com.castor.administracion.utils.ApiResponseUtil;
import com.castor.administracion.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final CargoRepository cargoRepository;

    private final Util util;

    @Override
    public ApiResponseUtil<Object> obtnerTodaEmpleados() {

        List<EmpleadoEntity> listaEmpleados = empleadoRepository.findAll();
        if (listaEmpleados.isEmpty()) {
            return null;
        }

        return null;
    }

    @Override
    public ApiResponseUtil<Object> registrarEmpleado(EmpleadoDto empleado) {

        Optional<CargoEntity> cargoOpt = cargoRepository.findById(empleado.getCargoId());
        if(cargoOpt.isEmpty()) {
            throw new NotFoundException("El cargo no existe o se encuentra inactivo.");
        }

        EmpleadoEntity empleadoEntity = util.convertTo(empleado, EmpleadoEntity.class);
        empleadoEntity.setCargo(cargoOpt.get());

        EmpleadoEntity empleadoSave = empleadoRepository.save(empleadoEntity);
        EmpleadoDto empleadoDto = util.convertTo(empleadoSave, EmpleadoDto.class);

        return util.mapaRespuesta(empleadoDto);
    }
}
