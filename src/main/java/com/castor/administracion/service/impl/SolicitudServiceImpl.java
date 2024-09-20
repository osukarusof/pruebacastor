package com.castor.administracion.service.impl;

import com.castor.administracion.dto.SolicitudDto;
import com.castor.administracion.entity.EmpleadoEntity;
import com.castor.administracion.entity.EstadoSolicitudEntity;
import com.castor.administracion.entity.ServicioEntity;
import com.castor.administracion.entity.SolicitudEntity;
import com.castor.administracion.exception.NotFoundException;
import com.castor.administracion.repository.*;
import com.castor.administracion.service.SolicitudService;
import com.castor.administracion.utils.ApiResponseUtil;
import com.castor.administracion.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService {

    private final EmpleadoRepository empleadoRepository;
    private final SolicitudRepository solicitudRepository;
    private final SolicitudServicioRepository solicitudServicioRepository;
    private final EstadoSolicitudRepository estadoSolicitudRepository;
    private final ServicioRepository servicioRepository;

    private final Util util;

    @Override
    public ApiResponseUtil<Object> registrarSolicitudes(SolicitudDto solicitud) {

        Optional<EmpleadoEntity> empleadoOpt = empleadoRepository.findById(solicitud.getEmpleadoId());
        if (empleadoOpt.isEmpty()){
            throw new NotFoundException("El empleado no existe o se encuentra inativo");
        }

        Optional<EstadoSolicitudEntity> estadoSolicitudOpt = estadoSolicitudRepository.findById(solicitud.getEstadoServicioId());
        if(estadoSolicitudOpt.isEmpty()) {
            throw new NotFoundException("El esado de servicio no existe");
        }

       Optional<ServicioEntity> servicioOpt = servicioRepository.findById(solicitud.getServicioId());
        if(servicioOpt.isEmpty()){
            throw new NotFoundException("El servicio no existe");
        }

        ServicioEntity servicioEntity = servicioOpt.get();
        SolicitudEntity solicitudEntity = util.convertTo(solicitud, SolicitudEntity.class);
        solicitudEntity.getServicios().add(servicioEntity);
        solicitudRepository.save(solicitudEntity);

        return util.mapaRespuesta(new ArrayList<>());
    }
}
