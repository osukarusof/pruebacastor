package com.castor.administracion.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseUtil<T> {

    private String message;

    private int status;

    private T data;

    private T fieldErrors;
}
