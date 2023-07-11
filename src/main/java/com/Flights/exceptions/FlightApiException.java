package com.Flights.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FlightApiException extends RuntimeException{

    public FlightApiException(HttpStatus badRequest, String msg){

        super(msg);
    }
}
