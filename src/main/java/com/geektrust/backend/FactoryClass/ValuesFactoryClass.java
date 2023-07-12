package com.geektrust.backend.FactoryClass;

import com.geektrust.backend.enums.Plans;
import com.geektrust.backend.enums.SubscriptionType;

public class ValuesFactoryClass 
{

public static Integer getCategoryPriceAsPerSubscription(Plans plans,SubscriptionType subscriptionType) 
{
  Integer amount=0;
switch(plans)
{
  case FREE:
  amount= getPriceAsPerSubscription.getSubscriptionPriceValueForFree(subscriptionType);
    return amount;
  case PERSONAL:
 amount= getPriceAsPerSubscription.getPriceAsPerSubscriptionForPersonal(subscriptionType);
  return amount;
  case PREMIUM:
  amount= getPriceAsPerSubscription.getPriceAsPerSubscriptionForPremiun(subscriptionType);
return amount;
  
}

return -1;
    }

   
  



}
