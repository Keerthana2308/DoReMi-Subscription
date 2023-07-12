package com.geektrust.backend.FactoryClass;

import com.geektrust.backend.Constants.Constants;
import com.geektrust.backend.enums.SubscriptionType;

public class getPriceAsPerSubscription {

    public static Integer getSubscriptionPriceValueForFree(SubscriptionType subscriptionType) {
      switch(subscriptionType)
      {
        case MUSIC:
        return Constants.FREE_SUBSCRIPTION_PRICE_MUSIC;
        case VIDEO:
        return Constants.FREE_SUBSCRIPTION_PRICE_VIDEO;
        case PODCAST:
        return Constants.FREE_SUBSCRIPTION_PRICE_PODCAST;
      }

        return -1;
    }

    public static Integer getPriceAsPerSubscriptionForPersonal(
            SubscriptionType subscriptionType) 
            {
                switch(subscriptionType){
                case MUSIC:
                return Constants.PERSONAL_SUBSCRIPTION_PRICE_MUSIC;
                case VIDEO:
                return Constants.PERSONAL_SUBSCRIPTION_PRICE_VIDEO;
                case PODCAST:
                return Constants.PERSONAL_SUBSCRIPTION_PRICE_PODCAST;
                }
                return -1;
    }
  


    public static Integer getPriceAsPerSubscriptionForPremiun(
            SubscriptionType subscriptionType) {
                switch(subscriptionType){
                    case MUSIC:
                    return Constants.PREMIUM_SUBSCRIPTION_PRICE_MUSIC;
                    case VIDEO:
                    return Constants.PREMIUM_SUBSCRIPTION_PRICE_VIDEO;
                    case PODCAST:
                    return Constants.PREMIUM_SUBSCRIPTION_PRICE_PODCAST;
                    }
                    return -1;    }
    
}
