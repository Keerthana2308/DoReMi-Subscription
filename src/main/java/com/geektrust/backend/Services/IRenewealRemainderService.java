package com.geektrust.backend.Services;

import java.time.LocalDate;
import java.util.List;
import com.geektrust.backend.entities.RenewealAmount;
import com.geektrust.backend.entities.RenewealRemainder;
import com.geektrust.backend.entities.SubscriptionPlans;
import com.geektrust.backend.entities.TopUpDetails;

public interface IRenewealRemainderService {
   public List<RenewealRemainder> getSubscriptionRemainderDetails(LocalDate date,List<SubscriptionPlans> subscriptionPlans,
   TopUpDetails topUpDetails);
   public RenewealAmount getSubscriptionRenewalAmountDetail(TopUpDetails topUpDetails,List<SubscriptionPlans> subscriptionplans);

}
