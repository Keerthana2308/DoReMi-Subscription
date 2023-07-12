package com.geektrust.backend.Exception;

public class SubscriptionFailedInvalidDate extends RuntimeException{
    public SubscriptionFailedInvalidDate()
    {
        super();
    }
    public SubscriptionFailedInvalidDate(String msg)
    {
      super(msg);
    }
}
