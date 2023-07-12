package com.geektrust.backend.Services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import com.geektrust.backend.Exception.InvalidDateException;
import com.geektrust.backend.Exception.SubscriptionAlreadyExist;
import com.geektrust.backend.Exception.SubscriptionFailedInvalidDate;
import com.geektrust.backend.Exception.SubscriptionNotFountException;
import com.geektrust.backend.Exception.TopUpFailedAndSubscriptionNotFoundException;
import com.geektrust.backend.Exception.TopUpFailedInvalidDate;
import com.geektrust.backend.Exception.TopUpAlreayExistException;
import com.geektrust.backend.entities.Subscription;
import com.geektrust.backend.entities.SubscriptionPlans;
import com.geektrust.backend.entities.TopUpDetails;
import com.geektrust.backend.enums.Plans;
import com.geektrust.backend.enums.SubscriptionType;
import com.geektrust.backend.enums.TopUpCategories;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class ServicesTestExceptionsTest {
    
    Subscription subscription;
    
    SubscriptionPlans subscriptionPlans;
    RenewealRemainderService remainderService=new RenewealRemainderService();
    ExceptionHandlerService exceptionHandlerService =new ExceptionHandlerService();
DateCheckExceptionhandler dateCheckExceptionhandler=new DateCheckExceptionhandler();
SubscriptionService subscriptionService=new SubscriptionService();
      @Test
 public void dateValidation() throws ParseException
{


      Throwable Exception= Assertions.assertThrows(InvalidDateException.class,new Executable() {
        public void execute() throws Throwable{
            dateCheckExceptionhandler.convertStringToLocalDate(null);
                }
       });
    Assertions.assertEquals("INVALID_DATE", Exception.getMessage());
    }


    @Test
    public void invalidSubscriptionDateTestCase()
    {
        String strDate="22-22-2022";
    Throwable Exception=Assertions.assertThrows(SubscriptionFailedInvalidDate.class,new Executable() {
        public void execute() throws Throwable{
            dateCheckExceptionhandler.checkdateforSubscription(strDate);
                }
       });
    Assertions.assertEquals("ADD_SUBSCRIPTION_FAILED INVALID_DATE", Exception.getMessage());  
    }

    @Test
    public void invalidTopUpDateTestCase()
    {
        String strDate="22-22-2022";
    Throwable Exception=Assertions.assertThrows(TopUpFailedInvalidDate.class,new Executable() {
        public void execute() throws Throwable{
            dateCheckExceptionhandler.checkdateforTopUp(strDate);
                }
       });
    Assertions.assertEquals("ADD_TOPUP_FAILED INVALID_DATE", Exception.getMessage());  
    }
    @Test
    public void subscriptionNotFoundTest()
    {
      List<SubscriptionPlans> subscriptionPlans=new ArrayList<>();
      Throwable Exception=Assertions.assertThrows(SubscriptionNotFountException.class,new Executable()
     {
        public void execute() throws Throwable
        {
           exceptionHandlerService.subscriptionNotFound(subscriptionPlans);
                }
       });
    Assertions.assertEquals("SUBSCRIPTIONS_NOT_FOUND", Exception.getMessage());  
    }

    @Test
    public void subscriptionNotFoundAndTopUpFailedTest()
    {
     
List<SubscriptionPlans> subscriptionPlans=new ArrayList<>();
TopUpDetails topUpDetails=new TopUpDetails(TopUpCategories.FOUR_DEVICE, 4);;
    Throwable Exception=Assertions.assertThrows(TopUpFailedAndSubscriptionNotFoundException.class,new Executable() {
        public void execute() throws Throwable{
  exceptionHandlerService.subscriptionNotFoundAndTopUpFailed(subscriptionPlans, topUpDetails);
                }
       });
    Assertions.assertEquals("ADD_TOPUP_FAILED_SUBSCRIPTIONS_NOT_FOUND", Exception.getMessage());  
    }

     @Test
    public void subscriptionexistsTest1()
    {
        List<SubscriptionPlans> planslist=new ArrayList<SubscriptionPlans>()
        {
         {
         add(new SubscriptionPlans(SubscriptionType.MUSIC,Plans.FREE));  
         add(new SubscriptionPlans(SubscriptionType.MUSIC,Plans.PERSONAL));          
           
       
         } };

         SubscriptionPlans subplan=new SubscriptionPlans(SubscriptionType.MUSIC,Plans.PERSONAL);
         Throwable Exception=Assertions.assertThrows(
            SubscriptionAlreadyExist.class,new Executable() {
            public void execute() throws Throwable{
      exceptionHandlerService.subscriptionAlreadyExists(planslist,subplan);
                    }
           });
        Assertions.assertEquals("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY", Exception.getMessage());  
     
    }


 @Test
    void duplicateTopUpExistsTest1()
    {
       TopUpDetails topUpDetail1=new TopUpDetails(TopUpCategories.FOUR_DEVICE, 1);
       TopUpDetails topUpDetail2=new TopUpDetails(TopUpCategories.FOUR_DEVICE, 4);

        Throwable Exception=Assertions.assertThrows(
            TopUpAlreayExistException.class,new Executable() {
            public void execute() throws Throwable{

      exceptionHandlerService.validateTopUpAlreadyExists();
      exceptionHandlerService.validateTopUpAlreadyExists();


                    }
           });
           Assertions.assertEquals("ADD_TOPUP_FAILED DUPLICATE_TOPUP", Exception.getMessage());  
    }
    
  


}
