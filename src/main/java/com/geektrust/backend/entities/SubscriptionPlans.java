package com.geektrust.backend.entities;

import com.geektrust.backend.enums.Plans;
import com.geektrust.backend.enums.SubscriptionType;

public class SubscriptionPlans 
{
private SubscriptionType subscriptionType;
private Plans plans;
     public SubscriptionPlans(SubscriptionType subscriptionType, Plans plans) 
     {
        this.subscriptionType=subscriptionType;
        this.plans=plans;
     }

     public SubscriptionPlans(SubscriptionPlans subplans) {}

    public void setsubscriptionType(SubscriptionType subscriptionType)
     {
        this.subscriptionType=subscriptionType;
     }
     public SubscriptionType getsubscriptionType()
     {
        return subscriptionType;
     }
  
     public Plans getPlans()
     {
        return plans;
     }
}
