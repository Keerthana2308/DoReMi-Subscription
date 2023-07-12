package com.geektrust.backend.Exception;

public class SubscriptionNotFountException extends RuntimeException{

    public SubscriptionNotFountException()
    {
        super();
    }
    public SubscriptionNotFountException(String msg)
    {
        super(msg);
    }
    
}
