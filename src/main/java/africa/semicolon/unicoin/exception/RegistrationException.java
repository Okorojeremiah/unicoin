package africa.semicolon.unicoin.exception;

import africa.semicolon.unicoin.utiils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


public class RegistrationException extends RuntimeException {
    public RegistrationException(String message) {
        super(message);
    }
}
