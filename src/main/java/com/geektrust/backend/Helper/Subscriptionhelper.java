package com.geektrust.backend.Helper;

import java.util.ArrayList;
import java.util.List;
import com.geektrust.backend.Exception.SubscriptionAlreadyExist;
import com.geektrust.backend.Exception.SubscriptionFailedInvalidDate;
import com.geektrust.backend.Exception.SubscriptionNotFountException;
import com.geektrust.backend.Services.DateCheckExceptionhandler;
import com.geektrust.backend.Services.ExceptionHandlerService;
import com.geektrust.backend.entities.SubscriptionPlans;
import com.geektrust.backend.enums.Plans;
import com.geektrust.backend.enums.SubscriptionType;

public class Subscriptionhelper {
    private static ExceptionHandlerService subscriptionService=new ExceptionHandlerService();
    private static List<SubscriptionPlans> listofSubscriptionPlans=new ArrayList<>();
    private LocalDateHelper metaHelper =new LocalDateHelper();
    private DateCheckExceptionhandler dateCheckExceptionhandler=new DateCheckExceptionhandler();

    private static SubscriptionType subscriptionType;
    private static Plans plans;
public   void subHelper(String subscriptionTypes ,String PlanTyp)
{
         subscriptionType = SubscriptionType.valueOf(subscriptionTypes);
         plans = Plans.valueOf(PlanTyp);
         addsubscriptionToList(subscriptionType, plans);

}
public List<SubscriptionPlans> addsubscriptionToList(SubscriptionType subscriptionType,Plans plans)
{
    try {
      
       SubscriptionPlans subplans=new SubscriptionPlans(subscriptionType, plans);
      subplans=subscriptionService.subscriptionAlreadyExists(listofSubscriptionPlans,subplans);
      dateCheckExceptionhandler.checkdateforSubscription(metaHelper.getstrdate());
      listofSubscriptionPlans.add(subplans);
    }
    catch (SubscriptionNotFountException e)
    {
        System.out.println(e.getMessage());

    }
    catch(SubscriptionAlreadyExist e)
    {
    System.out.println(e.getMessage());
    }
    catch (SubscriptionFailedInvalidDate e) {
       System.out.println(e.getMessage());
   }
 return listofSubscriptionPlans;
}

public List<SubscriptionPlans> getSubscriptionPlans()
{
   return listofSubscriptionPlans;
}
}
