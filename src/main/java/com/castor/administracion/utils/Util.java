package com.castor.administracion.utils;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class Util {

    private final ModelMapper modelMapper;


    public <T> ApiResponseUtil<Object> mapaRespuesta (T data) {

        return ApiResponseUtil.builder()
                .status(HttpStatus.OK.value())
                .message("This sequence is a mutant")
                .data(data)
                .fieldErrors(new ArrayList<>())
                .build();
    }

    public <T> T convertTo(Object origen, Class<T> destino) {
        return modelMapper.map(origen, destino);
    }
}
