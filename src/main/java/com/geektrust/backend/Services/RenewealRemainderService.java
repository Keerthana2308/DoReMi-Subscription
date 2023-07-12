package com.geektrust.backend.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.geektrust.backend.entities.RenewealAmount;
import com.geektrust.backend.entities.RenewealDetails;
import com.geektrust.backend.entities.RenewealRemainder;
import com.geektrust.backend.entities.RenewealRemainderDate;
import com.geektrust.backend.entities.Subscription;
import com.geektrust.backend.entities.SubscriptionPlans;
import com.geektrust.backend.entities.TopUpDetails;

public class RenewealRemainderService implements IRenewealRemainderService {
    
    Subscription subscription;
    ExceptionHandlerService exceptionHandler;
    SubscriptionService subscriptionService;
      


public List<RenewealRemainder> getSubscriptionRemainderDetails(LocalDate date,List<SubscriptionPlans> subscriptionPlans,
TopUpDetails topUpDetails)
{ 
    subscriptionService=new SubscriptionService();
    subscription=new Subscription();
 //   exceptionHandler=new ExceptionHandlerService();
 subscription=subscriptionService.addSubscription(date, subscriptionPlans, topUpDetails);
    LocalDate localdate=subscription.getsubscriptionStartDate();
    List<RenewealRemainder> result=new ArrayList<>();
    List<SubscriptionPlans> subscriptionPlanTypes=new ArrayList<>();
    subscriptionPlanTypes=subscription.getsubscriptionPlans().stream().collect(Collectors.toList());
   subscriptionPlans.forEach(plans ->
   {
    RenewealRemainder renewealRemainder=RenewealRemainderDate.getRenewealDetailss(plans.getsubscriptionType(),
    plans.getPlans(),localdate);
    result.add(renewealRemainder);
   });
    return result;
}

public RenewealAmount getSubscriptionRenewalAmountDetail(TopUpDetails topUpDetails,List<SubscriptionPlans> subscriptionplans)
{
    RenewealAmount renewealAmount=null;
   
     if(topUpDetails!=null && subscriptionplans!=null)
    {
         renewealAmount=RenewealDetails.GetRenewalAmount(topUpDetails,subscriptionplans);
    }
  if(topUpDetails==null && subscriptionplans!=null){
     renewealAmount=RenewealDetails.GetRenewalAmountOnlyForSubscription(subscriptionplans);

 }
    return renewealAmount;   
}



}
