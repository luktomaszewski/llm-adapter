package com.github.lomasz.llm.application.domain.exception;

import java.io.Serial;

public class BusinessException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -2582819800646135357L;

    public BusinessException(String message) {
        super(message);
    }
}
