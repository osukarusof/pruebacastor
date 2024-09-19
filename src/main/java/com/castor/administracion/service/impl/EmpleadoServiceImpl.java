package com.castor.administracion.service.impl;

import com.castor.administracion.entity.EmpleadoEntity;
import com.castor.administracion.repository.EmpleadoRepository;
import com.castor.administracion.service.EmpleadoService;
import com.castor.administracion.utils.ApiResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Override
    public ApiResponseUtil<Object> obtnerTodaEmpleados() {

        List<EmpleadoEntity> listaEmpleados = empleadoRepository.findAll();
        if (listaEmpleados.isEmpty()) {
            return null;
        }

        return null;
    }
}
