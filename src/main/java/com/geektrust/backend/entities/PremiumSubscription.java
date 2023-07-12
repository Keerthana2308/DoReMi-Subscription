package com.geektrust.backend.entities;

import com.geektrust.backend.FactoryClass.ValuesFactoryClass;
import com.geektrust.backend.enums.Plans;
import com.geektrust.backend.enums.SubscriptionType;

public class PremiumSubscription{



public static Integer getPriceBaseOnSubscriptionPlanAndCategoryPremiun(SubscriptionType subscriptionType,
Plans plans) {
    Integer value= ValuesFactoryClass.getCategoryPriceAsPerSubscription(plans,subscriptionType);

        return value;
}
}
