package com.geektrust.backend.Helper;

import com.geektrust.backend.Exception.TopUpAlreayExistException;
import com.geektrust.backend.Exception.TopUpFailedAndSubscriptionNotFoundException;
import com.geektrust.backend.Exception.TopUpFailedInvalidDate;
import com.geektrust.backend.Services.DateCheckExceptionhandler;
import com.geektrust.backend.Services.ExceptionHandlerService;
import com.geektrust.backend.entities.TopUpDetails;
import com.geektrust.backend.enums.TopUpCategories;

public class TopUpHelper {
    private  static   TopUpCategories topUpDevice;
    private   static TopUpDetails DetailsOfTopUp;
    private static     Integer Device;
    private static ExceptionHandlerService exceptionHandlerService=new ExceptionHandlerService();
    private LocalDateHelper metaHelper =new LocalDateHelper();
    private DateCheckExceptionhandler dateCheckExceptionhandler=new DateCheckExceptionhandler();
private Subscriptionhelper subscriptionhelper=new Subscriptionhelper();
    public void topHelper(String TopUpDevice ,String NoOfDevice)
    {
        topUpDevice=TopUpCategories.valueOf(TopUpDevice);
        Device=Integer.valueOf(NoOfDevice);
        TopUpHelpers(topUpDevice,Device);
    }
    public  TopUpDetails TopUpHelpers(TopUpCategories TopUpDevice ,Integer NoOfDevice)
    {
        DetailsOfTopUp=new TopUpDetails(topUpDevice,Device);
      try{
        dateCheckExceptionhandler.checkdateforTopUp(metaHelper.getstrdate());
        exceptionHandlerService.validateTopUpAlreadyExists();
        exceptionHandlerService.checkSubscriptionPresentForTopUp(DetailsOfTopUp,subscriptionhelper.
        getSubscriptionPlans());
    
      }
      catch(TopUpAlreayExistException e)
     {
       System.out.println(e.getMessage());
      }
      catch(TopUpFailedInvalidDate e)
      {
       System.out.println(e.getMessage());
   
      }
      catch(TopUpFailedAndSubscriptionNotFoundException e)
      {
        System.out.println(e.getMessage());
      }
   
     return DetailsOfTopUp;
    }
   
   public TopUpDetails getDetailsOfTopUp()
   {
       return DetailsOfTopUp;
   }
}
