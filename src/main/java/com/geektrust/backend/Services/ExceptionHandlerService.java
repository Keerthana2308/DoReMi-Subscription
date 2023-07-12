package com.geektrust.backend.Services;

import java.util.List;

import com.geektrust.backend.Exception.SubscriptionAlreadyExist;
import com.geektrust.backend.Exception.SubscriptionNotFountException;
import com.geektrust.backend.Exception.TopUpFailedAndSubscriptionNotFoundException;

import com.geektrust.backend.Exception.TopUpAlreayExistException;
import com.geektrust.backend.entities.SetTopUpStatus;
import com.geektrust.backend.entities.SubscriptionPlans;
import com.geektrust.backend.entities.TopUpDetails;
import com.geektrust.backend.enums.TopUpStatus;

public class ExceptionHandlerService{
    
DateCheckExceptionhandler dateCheckExceptionhandler=new DateCheckExceptionhandler();

    
     public void subscriptionNotFound(List<SubscriptionPlans> subscriptionPlans)
    {
        if(subscriptionPlans.size()==0)
        {
            throw new SubscriptionNotFountException("SUBSCRIPTIONS_NOT_FOUND");
        }
    }
    public void subscriptionNotFoundAndTopUpFailed(List<SubscriptionPlans> subscriptionPlans,TopUpDetails topUpDetails)
    {
        if(subscriptionPlans.size()==0 && topUpDetails!=null)
        {
            throw new TopUpFailedAndSubscriptionNotFoundException("ADD_TOPUP_FAILED_SUBSCRIPTIONS_NOT_FOUND");
        }
    }


    public SubscriptionPlans subscriptionAlreadyExists(List<SubscriptionPlans> listofSubscriptionPlans, SubscriptionPlans subscriptionPlans)

{    

   
        for(SubscriptionPlans sub:listofSubscriptionPlans)
        {
            if(sub.getsubscriptionType() ==subscriptionPlans.getsubscriptionType())
            {
                throw new SubscriptionAlreadyExist("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
            }
        }
    return subscriptionPlans;
    }
     
    

    public void validateTopUpAlreadyExists()
     {


        if(SetTopUpStatus.gettopUpStatus()==TopUpStatus.NOTSTARTED)
        {
            SetTopUpStatus.settopUpStatus(TopUpStatus.STARTED);              
        }
     else if(SetTopUpStatus.gettopUpStatus()==(TopUpStatus.STARTED))
         {
             throw new TopUpAlreayExistException("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
         }
     }


     public void checkSubscriptionPresentForTopUp(TopUpDetails topUpDetails,List<SubscriptionPlans> subscriptionPlans)
     {
        if(topUpDetails!=null && subscriptionPlans.size()==0){
{
  throw new TopUpFailedAndSubscriptionNotFoundException("ADD_TOPUP_FAILED SUBSCRIPTIONS_NOT_FOUND");
}
        }
     }
    



}


