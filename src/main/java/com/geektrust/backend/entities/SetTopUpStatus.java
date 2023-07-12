package com.geektrust.backend.entities;

import com.geektrust.backend.enums.TopUpStatus;

public class SetTopUpStatus {
    private static TopUpStatus topUpStatusDetail=TopUpStatus.NOTSTARTED;
    public static void settopUpStatus(TopUpStatus topUpStatus)
    {  
       topUpStatusDetail=topUpStatus;
    }
    public static TopUpStatus gettopUpStatus()
    {
       return topUpStatusDetail;
    }
}
