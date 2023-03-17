package by.shylau.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SensorGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<SensorIncorrectData> handlerException(NoSuchSensorException exception) {
        SensorIncorrectData data = new SensorIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<SensorIncorrectData> handlerException(Exception exception) {
        SensorIncorrectData data = new SensorIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}