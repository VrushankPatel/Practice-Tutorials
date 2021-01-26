package com.flurken.webservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// @ControllerAdvice is an annotation provided by Spring allowing you to write global code that can be applied to a wide range of controllers
// here, we'll create global exception handler for our project.
// this will create instance of our exceptionResponse class to return an exception.
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    // below method is for all generic exceptions : return 500 internal server error
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    // below method is for user not found exception : return 404 not found
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(PostsNotFoundException.class)
    public final ResponseEntity<Object> handlePostsNotFoundException(PostsNotFoundException ex, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(PostDoesNotExistsException.class)
    public final ResponseEntity<Object> handlePostDoesNotExistsException(PostDoesNotExistsException ex, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);

    }
}
