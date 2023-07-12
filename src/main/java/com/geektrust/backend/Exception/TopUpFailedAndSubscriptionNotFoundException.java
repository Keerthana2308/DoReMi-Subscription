package com.geektrust.backend.Exception;

public class TopUpFailedAndSubscriptionNotFoundException extends RuntimeException{
    public TopUpFailedAndSubscriptionNotFoundException()
    {
        super();
    }
    public TopUpFailedAndSubscriptionNotFoundException(String msg)
    {
        super(msg);
    }
    
}
