package com.geektrust.backend.Exception;

public class TopUpAlreayExistException extends RuntimeException {
    
    public TopUpAlreayExistException()
    {
        super();
    }
    public TopUpAlreayExistException(String msg)
    {
        super(msg);
    }
}
