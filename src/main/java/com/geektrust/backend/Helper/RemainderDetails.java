package com.geektrust.backend.Helper;

import java.util.ArrayList;
import java.util.List;
import com.geektrust.backend.Exception.SubscriptionNotFountException;
import com.geektrust.backend.Exception.TopUpFailedAndSubscriptionNotFoundException;
import com.geektrust.backend.Services.ExceptionHandlerService;
import com.geektrust.backend.Services.RenewealRemainderService;
import com.geektrust.backend.entities.RenewealAmount;
import com.geektrust.backend.entities.RenewealRemainder;
import com.geektrust.backend.entities.SubscriptionPlans;
import com.geektrust.backend.entities.TopUpDetails;



public class RemainderDetails {
    LocalDateHelper metaHelper=new LocalDateHelper();
  Subscriptionhelper subscriptionhelper=new Subscriptionhelper();
 RenewealRemainderService remainderService=new RenewealRemainderService();
ExceptionHandlerService exceptionHandlerService=new ExceptionHandlerService();
TopUpHelper topUpHelper=new TopUpHelper();
 List<RenewealRemainder> remainders =new ArrayList<>();
 
  public void remainderdetails()    
  {  
try{
  
  exceptionHandlerService.subscriptionNotFound(subscriptionhelper.getSubscriptionPlans());

remainders=  remainderService.getSubscriptionRemainderDetails(metaHelper.getstartofSubscriptiondate(), subscriptionhelper.getSubscriptionPlans(),
topUpHelper.getDetailsOfTopUp());
printdetails(remainders);

renewealAmount(topUpHelper.getDetailsOfTopUp(),subscriptionhelper.getSubscriptionPlans());
}
catch(TopUpFailedAndSubscriptionNotFoundException e)
{
System.out.println(e.getMessage());
}
catch(SubscriptionNotFountException e)
{
  System.out.println(e.getMessage());

}

}


public void printdetails( List<RenewealRemainder> Remainders)
{
  for(RenewealRemainder remainder:Remainders)
  {
   System.out.println(remainder);
   }
}

public void renewealAmount(TopUpDetails topUpDetails,List<SubscriptionPlans> listSubscriptionPlans)
{
  RenewealAmount renewealAmount=remainderService.getSubscriptionRenewalAmountDetail(topUpHelper.getDetailsOfTopUp(),subscriptionhelper.getSubscriptionPlans());
  System.out.print(renewealAmount);}

}

 


