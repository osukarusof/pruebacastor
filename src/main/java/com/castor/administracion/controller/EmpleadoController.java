package com.castor.administracion.controller;

import com.castor.administracion.dto.EmpleadoDto;
import com.castor.administracion.service.EmpleadoService;
import com.castor.administracion.utils.ApiResponseUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping("/")
    public ResponseEntity<ApiResponseUtil<Object>> obtnerTodaEmpleados () {
        return new ResponseEntity<>(empleadoService.obtnerTodaEmpleados(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponseUtil<Object>> registrarEmpleado(@Valid @RequestBody EmpleadoDto empleado) {
        return  new ResponseEntity<>(empleadoService.registrarEmpleado(empleado), HttpStatus.CREATED);
    }

    @PutMapping("/{empleadoId}")
    public ResponseEntity<ApiResponseUtil<Object>> actualizarEmpleado(@PathVariable Long  empleadoId, @Valid @RequestBody EmpleadoDto empleado) {
        return  new ResponseEntity<>(empleadoService.actualizarEmpleado(empleadoId,empleado), HttpStatus.OK);
    }

    @DeleteMapping("/{empleadoId}")
    public  ResponseEntity<Object> eliminarEmpleado( @PathVariable Long  empleadoId) {
        return  new ResponseEntity<>(empleadoService.eliminarEmpleado(empleadoId), HttpStatus.OK);
    }
}
