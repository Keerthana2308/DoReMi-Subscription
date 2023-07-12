package com.geektrust.backend.entities;

import java.util.List;
import com.geektrust.backend.Constants.Constants;
import com.geektrust.backend.enums.TopUpCategories;

public class RenewealDetails {
    
 
    private Integer RenewalAmount;
     private TopUpDetails topUpDetails;


    public RenewealDetails(){}
    public RenewealDetails(TopUpDetails topUpDetails) { 
      this.topUpDetails=topUpDetails;
   }
   public RenewealDetails(Integer RenewalAmount) 
   {
      this.RenewalAmount=RenewalAmount;
   }

    public static RenewealAmount GetRenewalAmountOnlyForSubscription(List<SubscriptionPlans> subscriptionPlans)
    {
      Integer renewalAmountOfSubscriptions=RenewalAmountForSubscription.renewealSubscriptionAmount(subscriptionPlans);
      
         return  new RenewealAmount(renewalAmountOfSubscriptions);
    }
    
    public static RenewealAmount GetRenewalAmount(TopUpDetails topUpDetails,List<SubscriptionPlans> subscriptionPlans)
    {
      Integer renewalAmountOfSubscriptions=RenewalAmountForSubscription.renewealSubscriptionAmount(subscriptionPlans);
         if(topUpDetails.getTopUpCategories()==TopUpCategories.FOUR_DEVICE)
         {
        Integer amount=topUpDetails.getDevices() * Constants.ADD_TOP_UP_FOUR_DEVICE;
            return new RenewealAmount(amount+renewalAmountOfSubscriptions);
         }        
         Integer amount=topUpDetails.getDevices() * Constants.ADD_TOP_UP_TEN_DEVICE;
         
         return  new RenewealAmount(amount+renewalAmountOfSubscriptions);
    }
 
    }


