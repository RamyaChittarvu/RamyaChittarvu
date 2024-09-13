package guru.spring_web.SpringRest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//@ControllerAdvice
public class ExceptionController {

   // @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotfoundException()
    {

        System.out.println("in not found exception");
        return ResponseEntity.notFound().build();
    }
}
