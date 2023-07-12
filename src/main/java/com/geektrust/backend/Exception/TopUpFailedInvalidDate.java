package com.geektrust.backend.Exception;

public class TopUpFailedInvalidDate extends RuntimeException{
    public TopUpFailedInvalidDate()
    {
        super();
    }
    public TopUpFailedInvalidDate(String msg)
    {
        super(msg);
    }
    
}
