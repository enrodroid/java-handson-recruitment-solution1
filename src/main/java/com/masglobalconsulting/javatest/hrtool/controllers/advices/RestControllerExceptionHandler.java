package com.masglobalconsulting.javatest.hrtool.controllers.advices;

import com.masglobalconsulting.javatest.hrtool.exceptions.HRException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {
  
  @ExceptionHandler(value = {HRException.class})
  protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
    return handleExceptionInternal(ex, ex.getMessage(),
        new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
  }
}
