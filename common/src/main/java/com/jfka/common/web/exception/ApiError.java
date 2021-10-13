package com.jfka.common.web.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class ApiError {

    private int status;
    private String message;
    private String developerMessage;

    public ApiError(final int status, final String message, final String developerMessage) {
        super();
        this.status = status;
        this.message = message;
        this.developerMessage = developerMessage;
    }


}
