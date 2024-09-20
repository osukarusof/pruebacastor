package com.castor.administracion.service;

import com.castor.administracion.dto.EmpleadoDto;
import com.castor.administracion.utils.ApiResponseUtil;

public interface EmpleadoService {

    ApiResponseUtil<Object> obtnerTodaEmpleados();

    ApiResponseUtil<Object> registrarEmpleado (EmpleadoDto empleado);

    ApiResponseUtil<Object> actualizarEmpleado(Long id, EmpleadoDto empleado);

    ApiResponseUtil<Object> eliminarEmpleado(Long id);
}
