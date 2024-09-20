package com.castor.administracion.controller;

import com.castor.administracion.dto.SolicitudDto;
import com.castor.administracion.service.SolicitudService;
import com.castor.administracion.utils.ApiResponseUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/solicitud")
public class SolicitudController {

    private final SolicitudService solicitudService;

    @GetMapping("/")
    public ResponseEntity<ApiResponseUtil<Object>> obtnerTodaSolicitudes () {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponseUtil<Object>> registrarSolicitudes (@Valid @RequestBody SolicitudDto solicitud) {
        return  new ResponseEntity<>(solicitudService.registrarSolicitudes(solicitud), HttpStatus.CREATED);
    }
}
