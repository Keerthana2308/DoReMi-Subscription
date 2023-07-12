package com.geektrust.backend.entity;
import com.geektrust.backend.Services.RenewealRemainderService;
import com.geektrust.backend.entities.FreeSubscription;
import com.geektrust.backend.entities.PersonalSubscription;
import com.geektrust.backend.entities.PremiumSubscription;
import com.geektrust.backend.entities.RenewealDetails;
import com.geektrust.backend.entities.Subscription;
import com.geektrust.backend.entities.getMonthsForRenewealReminder;
import com.geektrust.backend.enums.Plans;
import com.geektrust.backend.enums.SubscriptionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateTheValues {

     Subscription subscription = new Subscription();
     RenewealDetails r=new RenewealDetails();
     RenewealRemainderService subscriptionLogic=new RenewealRemainderService();

   
    @Test
    void getPriceofFreePlanTest()
    {
    Integer actual=FreeSubscription.getPriceBaseOnSubscriptionPlanAndCategoryFree(SubscriptionType.MUSIC, Plans.FREE);
    Assertions.assertEquals(0,actual);
        
    }
    
    @Test
    void getPriceofPersonalPlanTest()
    {
    Integer actual=PersonalSubscription.getPriceBaseOnSubscriptionPlanAndCategoryPersonal(SubscriptionType.MUSIC, Plans.PERSONAL);
    Assertions.assertEquals(100,actual);
        
    }

    @Test
    void getPriceofPremiumPlanTest()
    {
    Integer actual=PremiumSubscription.getPriceBaseOnSubscriptionPlanAndCategoryPremiun(SubscriptionType.VIDEO, Plans.PREMIUM);
    Assertions.assertEquals(500,actual);      
    }
     @Test
    void  CalucalteMonthsForSubscriptionPlans()
    {
   Assertions.assertEquals(1, getMonthsForRenewealReminder.getMonths(Plans.FREE));
   Assertions.assertEquals(1, getMonthsForRenewealReminder.getMonths(Plans.PERSONAL));
   Assertions.assertEquals(3, getMonthsForRenewealReminder.getMonths(Plans.PREMIUM));
    }
}
