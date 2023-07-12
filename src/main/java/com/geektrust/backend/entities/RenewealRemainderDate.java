package com.geektrust.backend.entities;

import java.time.LocalDate;
import com.geektrust.backend.Constants.Constants;
import com.geektrust.backend.enums.Plans;
import com.geektrust.backend.enums.SubscriptionType;

public class RenewealRemainderDate {
    public static RenewealRemainder getRenewealDetailss(SubscriptionType typeOfSubscription,
    Plans planType,LocalDate localDate)
     {
       Integer value=getMonthsForRenewealReminder.getMonths(planType);
       LocalDate  localDateTime =localDate.plusMonths(value);
       LocalDate resultDate=localDateTime.minusDays(Constants.MINUS_DAYS);
       return new RenewealRemainder(typeOfSubscription,resultDate);
     }
}
