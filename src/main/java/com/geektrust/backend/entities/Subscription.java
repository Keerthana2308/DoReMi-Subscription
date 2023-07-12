package com.geektrust.backend.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Subscription  {
   private LocalDate subscriptionStartDate;
  private List<SubscriptionPlans> subscriptionPlans;
  private TopUpDetails topUpDetails;

  public Subscription (){}

  public Subscription(TopUpDetails topUpDetails) {this.topUpDetails=topUpDetails;}
  public Subscription(LocalDate subscriptionStartDate,TopUpDetails topUpDetails)
  {
    this.subscriptionStartDate=subscriptionStartDate;
    this.topUpDetails=topUpDetails;
  }
  public Subscription(LocalDate subscriptionStartDate, List<SubscriptionPlans> subscriptionPlans,
      TopUpDetails topUpDetails) {
this.subscriptionStartDate=subscriptionStartDate;
this.subscriptionPlans=new ArrayList<SubscriptionPlans>();
this.topUpDetails=topUpDetails;
      }

  public Subscription(LocalDate subscriptionStartDate) 
  {
    this.subscriptionStartDate=subscriptionStartDate;
  }

  public Subscription(LocalDate subscriptionStartDate, List<SubscriptionPlans> subscriptionPlans) {
    this.subscriptionStartDate=subscriptionStartDate;
    this.subscriptionPlans=new ArrayList<SubscriptionPlans>();

  }


  public LocalDate getsubscriptionStartDate()
  {
    return subscriptionStartDate;
  }

  
  public List<SubscriptionPlans> getsubscriptionPlans()
  {
    return subscriptionPlans;
  }

  public TopUpDetails getTopUpDetails()
  {
    return topUpDetails;
  }

  

}
