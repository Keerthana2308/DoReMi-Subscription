package com.geektrust.backend.Exception;

public class SubscriptionAlreadyExist extends RuntimeException {
    public SubscriptionAlreadyExist()
    {
        super();
    }
    public SubscriptionAlreadyExist(String msg)
    {
        super(msg);
    }
    
}
