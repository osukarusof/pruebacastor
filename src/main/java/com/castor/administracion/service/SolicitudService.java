package com.castor.administracion.service;

import com.castor.administracion.dto.SolicitudDto;
import com.castor.administracion.utils.ApiResponseUtil;

public interface SolicitudService {
    ApiResponseUtil<Object> registrarSolicitudes(SolicitudDto solicitud);
}
