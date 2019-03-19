package devlab.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlanetExceptionController {

    @ExceptionHandler(value = PlanetNotfoundException.class)
    public ResponseEntity<ErrorMessage> exception(PlanetNotfoundException exception) {
        return new ResponseEntity<>(new ErrorMessage("Planet not found", HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = PlanetAlreadyExistException.class)
    public ResponseEntity<ErrorMessage> exception(PlanetAlreadyExistException exception) {
        return new ResponseEntity<>(new ErrorMessage("Planet already exist", HttpStatus.CONFLICT.value()), HttpStatus.CONFLICT);
    }
}
