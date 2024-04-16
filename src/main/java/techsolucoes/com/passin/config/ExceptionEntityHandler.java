package techsolucoes.com.passin.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import techsolucoes.com.passin.domain.attendee.exceptions.AttendeeAlreadyExistException;
import techsolucoes.com.passin.domain.attendee.exceptions.AttendeeNotFoundException;
import techsolucoes.com.passin.domain.checkin.exceptions.CheckInAlreadyExistsException;
import techsolucoes.com.passin.domain.event.exceptions.EventFullException;
import techsolucoes.com.passin.domain.event.exceptions.EventNotFoundException;
import techsolucoes.com.passin.dto.general.ErrorResponseDTO;

@ControllerAdvice
public class ExceptionEntityHandler {
    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity handleEventNotFound(EventNotFoundException e) {
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(EventFullException.class)
    public ResponseEntity<ErrorResponseDTO> handleEventFullNotFound(EventFullException e) {
        return ResponseEntity.badRequest().body(new ErrorResponseDTO(e.getMessage()));
    }

    @ExceptionHandler(AttendeeNotFoundException.class)
    public ResponseEntity handleAttendeeNotFound(AttendeeNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(AttendeeAlreadyExistException.class)
    public ResponseEntity handleAttendeeAlreadyExistNotFound(AttendeeAlreadyExistException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler(CheckInAlreadyExistsException.class)
    public ResponseEntity handleCheckInAlreadyExistNotFound(CheckInAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

}
