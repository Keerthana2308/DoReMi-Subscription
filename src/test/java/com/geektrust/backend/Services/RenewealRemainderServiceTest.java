package com.geektrust.backend.Services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.geektrust.backend.entities.RenewealAmount;
import com.geektrust.backend.entities.RenewealRemainder;
import com.geektrust.backend.entities.SubscriptionPlans;
import com.geektrust.backend.entities.TopUpDetails;
import com.geektrust.backend.enums.Plans;
import com.geektrust.backend.enums.SubscriptionType;
import com.geektrust.backend.enums.TopUpCategories;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RenewealRemainderServiceTest {
    
SubscriptionPlans subscriptionPlans;
RenewealRemainderService remainderService=new RenewealRemainderService();
@Test
    void RenewealRemainderTest()
    {

       DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/uuuu");
       LocalDate parsedDate = LocalDate.parse("20/02/2022", formatters);
           parsedDate.format(formatters);
        List<SubscriptionPlans> planslist=new ArrayList<SubscriptionPlans>()
        {
         {
         add(new SubscriptionPlans(SubscriptionType.MUSIC,Plans.FREE));  
         add(new SubscriptionPlans(SubscriptionType.VIDEO,Plans.PERSONAL));          
         add(new SubscriptionPlans(SubscriptionType.PODCAST,Plans.PREMIUM));          
       
         } };
         TopUpDetails topUpDetails=new TopUpDetails(TopUpCategories.FOUR_DEVICE, 4);
      List<RenewealRemainder> remainders=remainderService.getSubscriptionRemainderDetails(parsedDate, planslist, topUpDetails);     
     Assertions.assertEquals(3, remainders.size());
    }
    @Test
    void RenewealAmountTest()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse("20-02-2022", formatter);
        List<SubscriptionPlans> planslist=new ArrayList<SubscriptionPlans>()
        {
         {
         add(new SubscriptionPlans(SubscriptionType.MUSIC,Plans.PERSONAL));  
         add(new SubscriptionPlans(SubscriptionType.VIDEO,Plans.PREMIUM));          
         add(new SubscriptionPlans(SubscriptionType.PODCAST,Plans.FREE));                 
         } };
         TopUpDetails topUpDetails=new TopUpDetails(TopUpCategories.FOUR_DEVICE, 3);
      remainderService.getSubscriptionRemainderDetails(date, planslist, topUpDetails);
      remainderService.getSubscriptionRenewalAmountDetail(topUpDetails, planslist);
      Assertions.assertEquals(750,RenewealAmount.getAmount());
    }
     

}
