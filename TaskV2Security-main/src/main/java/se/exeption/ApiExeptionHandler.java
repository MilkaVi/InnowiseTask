package se.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
@ControllerAdvice
public class ApiExeptionHandler {
    @ExceptionHandler(value = {ApiRequestExeption.class})
    public ResponseEntity<Object> hanlderApiRequestExeption(ApiRequestExeption e){
        ApiExeption apiExeption = new ApiExeption(
                e.getMessage(),
                e,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiExeption,HttpStatus.BAD_REQUEST);
    }
}
