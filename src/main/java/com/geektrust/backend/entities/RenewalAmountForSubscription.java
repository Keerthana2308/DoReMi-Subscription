package com.geektrust.backend.entities;

import java.util.List;
import com.geektrust.backend.enums.Plans;
import com.geektrust.backend.enums.SubscriptionType;

public class RenewalAmountForSubscription {
 
    public static Integer renewealSubscriptionAmount(List<SubscriptionPlans> subscriptionPlans)
    {
      Integer AmountOfReneweal=0;

      for(SubscriptionPlans typesOfSubscription:subscriptionPlans)
      {
        AmountOfReneweal=AmountOfReneweal + getrenewealAmount(typesOfSubscription.getsubscriptionType(), typesOfSubscription.getPlans());
      }
    return AmountOfReneweal;     
    }

    public static  Integer getrenewealAmount(SubscriptionType subscriptionType,Plans plans)
    {
      if(plans==Plans.FREE)
      {
    return  FreeSubscription.getPriceBaseOnSubscriptionPlanAndCategoryFree(subscriptionType,plans);
         
      }
      else if(plans.equals(Plans.PERSONAL))
      {
        return      PersonalSubscription.getPriceBaseOnSubscriptionPlanAndCategoryPersonal(subscriptionType,plans);
      }
      else if(plans==Plans.PREMIUM)
      {
        return   PremiumSubscription.getPriceBaseOnSubscriptionPlanAndCategoryPremiun(subscriptionType,plans);

     }      
     return 0;     

    }
}
