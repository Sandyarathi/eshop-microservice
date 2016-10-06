package com.sjsu.cmpe282.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
	
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleAutoDBConflicts(DataIntegrityViolationException ex) {
    	return buildErrorResponse(ex, HttpStatus.CONFLICT);
    }
    
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<?> handleCustomDBConflicts(DuplicateKeyException ex) {
        return buildErrorResponse(ex, HttpStatus.CONFLICT);
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> handleRecordNotFoundException(RecordNotFoundException ex) {
    	return buildErrorResponse(ex, HttpStatus.NOT_FOUND);
    }
 
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<?> handleServiceException(ServiceException ex) {
    	return buildErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(Exception ex) {
    	return buildErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    /**
     * @param t
     * @param status
     * @return
     * 		Build and return the error response
     */
    private ResponseEntity<?> buildErrorResponse(Throwable t, HttpStatus status) {
    	Map<String,String> responseBody = new HashMap<>();
    	responseBody.put("HTTP Status", status.toString() + " - " + status.name());
        responseBody.put("message", t.getLocalizedMessage());
        return new ResponseEntity<Object>(responseBody, status);
    }
}
