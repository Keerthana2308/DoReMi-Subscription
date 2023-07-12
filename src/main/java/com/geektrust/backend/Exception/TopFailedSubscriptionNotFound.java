package com.geektrust.backend.Exception;

public class TopFailedSubscriptionNotFound extends RuntimeException {
    public TopFailedSubscriptionNotFound()
    {
        super();
    }
    public TopFailedSubscriptionNotFound(String msg)
    {
        super(msg);
    }
}
