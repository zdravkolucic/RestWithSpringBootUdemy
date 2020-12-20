package de.zlucic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.NOT_FOUND)
public class UnknownRessourceException extends RuntimeException {

    private static final long SerialVersionUID = 1L;

    public UnknownRessourceException( String message) {
        super(message);
    }
}

