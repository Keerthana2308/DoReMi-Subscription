package com.geektrust.backend.Helper;

import java.time.LocalDate;
import com.geektrust.backend.Exception.InvalidDateException;
import com.geektrust.backend.Services.DateCheckExceptionhandler;
import com.geektrust.backend.entities.Subscription;


public class LocalDateHelper {
private DateCheckExceptionhandler dateCheckExceptionhandler=new DateCheckExceptionhandler();

 private  static LocalDate startofSubscriptiondate;
 private Subscription subscription;
private static String strdate;
public  LocalDate  DateHelper(String localdate) 
{

   strdate= localdate;
    LocalDate date;
    try {
        date= dateCheckExceptionhandler.convertStringToLocalDate(localdate);
         subscription=new Subscription(date);
         startofSubscriptiondate=subscription.getsubscriptionStartDate();
      
    } catch (InvalidDateException e) {
        System.out.println(e.getMessage());
    }
    return startofSubscriptiondate;
}

public  LocalDate getstartofSubscriptiondate()
{
    return startofSubscriptiondate;
}

public String getstrdate()
{
    return strdate;
}


}
