package com.geektrust.backend.Exception;

public class InvalidDateException extends RuntimeException {
    public InvalidDateException()
    {
        super();
    }
    public InvalidDateException(String msg)
    {
        super(msg);
    }
    
}
