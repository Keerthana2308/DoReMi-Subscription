package com.geektrust.backend.Services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import com.geektrust.backend.Constants.Constants;
import com.geektrust.backend.Exception.InvalidDateException;
import com.geektrust.backend.Exception.SubscriptionFailedInvalidDate;
import com.geektrust.backend.Exception.TopUpFailedInvalidDate;

public class DateCheckExceptionhandler {
    public boolean validateDate(String localDate)
    {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DateFormat);
      LocalDate date = null;
        try {
           date= LocalDate.parse(localDate, formatter);
        }
        catch (DateTimeParseException e) {
            return  false;
        }
        catch (NullPointerException e) {
            return  false;
        }
        return true;
    }
    public  LocalDate convertStringToLocalDate(String Date)
{
    LocalDate date=null;
      if(validateDate(Date)==true)
      {
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DateFormat);
           date = LocalDate.parse(Date, formatter);
      }
      else {
        throw new InvalidDateException("INVALID_DATE");
    }

    return  date;
}
public void checkdateforTopUp(String date)
{  if(validateDate(date)==false)
    {
    throw new TopUpFailedInvalidDate("ADD_TOPUP_FAILED INVALID_DATE");

     }

}
public void checkdateforSubscription(String date)

{
    if(validateDate(date)==false)
    {
        throw new SubscriptionFailedInvalidDate("ADD_SUBSCRIPTION_FAILED INVALID_DATE");


     }
}

}
