package com.geektrust.backend.Helper;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import com.geektrust.backend.Constants.Constants;
import com.geektrust.backend.entities.SubscriptionPlans;
import com.geektrust.backend.enums.Plans;
import com.geektrust.backend.enums.SubscriptionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class HelperTestCases {
    LocalDateHelper localDateHelper=new LocalDateHelper();
Subscriptionhelper subscriptionhelper=new Subscriptionhelper();
    @Test
    void validateDate()
{
     localDateHelper.DateHelper("23-05-2020");
     Assertions.assertEquals("23-05-2020",  DateTimeFormatter.ofPattern(Constants.DateFormat).format(localDateHelper.DateHelper("23-05-2020"))
     );
}
@Test
void validateSubscriptionPlans()
{
    localDateHelper.DateHelper("23-05-2020");

List<SubscriptionPlans> subscriptionPlans=new ArrayList<>();
subscriptionPlans=subscriptionhelper.addsubscriptionToList(SubscriptionType.MUSIC, Plans.FREE);


   Assertions.assertEquals(1, subscriptionPlans.size());
   
}
}