package com.geektrust.backend.entities;

import com.geektrust.backend.Constants.Constants;
import com.geektrust.backend.enums.Plans;

public class getMonthsForRenewealReminder {
    
    public static Integer getMonths(Plans planType)
    {
        if(Plans.FREE==planType) return Constants.FREE_SUBSCRIPTION;        
        else if(Plans.PERSONAL==planType)return Constants.PERSONAL_SUBSCRIPTION;
        return Constants.PREMIUM_SUBSCRIPTION;
    }   

}
