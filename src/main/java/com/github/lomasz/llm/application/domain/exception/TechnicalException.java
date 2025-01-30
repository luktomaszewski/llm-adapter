package com.github.lomasz.llm.application.domain.exception;

import java.io.Serial;

public class TechnicalException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -649385970025987816L;

    public TechnicalException(String message) {
        super(message);
    }
}
