package com.geektrust.backend.Services;

import java.time.LocalDate;
import java.util.List;
import com.geektrust.backend.entities.Subscription;
import com.geektrust.backend.entities.SubscriptionPlans;
import com.geektrust.backend.entities.TopUpDetails;


public interface ISubscriptionService {
 public Subscription addSubscription(LocalDate date,List<SubscriptionPlans> subscriptionPlans,
 TopUpDetails topUpDetails);

}
