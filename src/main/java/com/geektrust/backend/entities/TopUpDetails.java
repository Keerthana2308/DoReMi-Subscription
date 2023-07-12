package com.geektrust.backend.entities;

import com.geektrust.backend.enums.TopUpCategories;

public class TopUpDetails {

   private TopUpCategories topUpCategory;
  private Integer Devices=0;

  public TopUpDetails(TopUpCategories topUpCategory,  Integer Devices) {
   this.topUpCategory=topUpCategory;
   this.Devices=Devices;
  }
public TopUpCategories getTopUpCategories()
  {
     return topUpCategory;
  }
  public Integer getDevices()
  {
     return Devices;
  }


}
