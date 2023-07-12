package com.geektrust.backend.entities;

public class RenewealAmount {
    
private static Integer Amount;

public RenewealAmount(Integer Amount) {RenewealAmount.Amount=Amount;}
public static Integer getAmount()
{
    return Amount;
}
@Override
public String toString() 
{
 return "RENEWAL_AMOUNT " + Amount ;
}
}
