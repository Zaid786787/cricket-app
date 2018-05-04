package io.cricket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CricketNotFoundException extends RuntimeException {

    public CricketNotFoundException() {
        super();
    }

    public CricketNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CricketNotFoundException(String message) {
        super(message);
    }

    public CricketNotFoundException(Throwable cause) {
        super(cause);
    }
}
