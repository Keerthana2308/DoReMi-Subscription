package com.geektrust.backend.Services;

import java.util.List;
import com.geektrust.backend.entities.SubscriptionPlans;
import com.geektrust.backend.entities.TopUpDetails;

public interface IExceptionHandlerService {
    public void subscriptionNotFound(List<SubscriptionPlans> subscriptionPlans);
    public void subscriptionNotFoundAndTopUpFailed(List<SubscriptionPlans> subscriptionPlans,TopUpDetails topUpDetails);
    public SubscriptionPlans subscriptionAlreadyExists(List<SubscriptionPlans> listofSubscriptionPlans, SubscriptionPlans subscriptionPlans,String date);
    public void validateTopUpAlreadyExists();
    public void checkSubscriptionPresentForTopUp(TopUpDetails topUpDetails,List<SubscriptionPlans> subscriptionPlans);

}
