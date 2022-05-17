//This is
package com.project.springrestfulmicroservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

//Custom Handling Exception with correct status code
//Implementing Unchecked Exception
@ResponseStatus(HttpStatus.NOT_FOUND)

public class UserNotFound extends RuntimeException {

    private String message;

    public UserNotFound(String message){
        super(message);
    }

}
