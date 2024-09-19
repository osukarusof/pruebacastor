package com.castor.administracion.controller;

import com.castor.administracion.service.SolicitudService;
import com.castor.administracion.utils.ApiResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/solicitud")
public class SolicitudController {

    private final SolicitudService solicitudService;

    @GetMapping("/")
    public ResponseEntity<ApiResponseUtil<Object>> obtnerTodaSolicitudes () {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
