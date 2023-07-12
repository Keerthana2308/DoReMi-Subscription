package com.geektrust.backend.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.geektrust.backend.Constants.Constants;
import com.geektrust.backend.enums.SubscriptionType;

public class RenewealRemainder {
    private LocalDate localDate;
    private SubscriptionType subscriptionType;
    private Integer renewalAmount;

    public RenewealRemainder(SubscriptionType subscriptionType,LocalDate localDate)
    {
        this.subscriptionType=subscriptionType;
        this.localDate=localDate;
    }

    public RenewealRemainder() {}


    public SubscriptionType getsubscriptionType()
    {
        return subscriptionType;
    }


   public LocalDate getLocalDate()
   {
    return localDate;
   }

   public RenewealRemainder(Integer renewalAmount)
   {
       this.renewalAmount=renewalAmount;
   }

public Integer getrenewalAmount()
   {
    return renewalAmount;
   }

   @Override
   public String toString() {
    return "RENEWAL_REMINDER " + subscriptionType +" " +  DateTimeFormatter.ofPattern(Constants.DateFormat).format(localDate);
  
}
}
