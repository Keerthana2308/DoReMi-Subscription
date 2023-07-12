package com.geektrust.backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import com.geektrust.backend.Helper.RemainderDetails;
import com.geektrust.backend.Helper.LocalDateHelper;
import com.geektrust.backend.Helper.Subscriptionhelper;
import com.geektrust.backend.Helper.TopUpHelper;


public class App {


	static RemainderDetails fileConverter=new RemainderDetails();
static   LocalDateHelper dareHelper=new LocalDateHelper();
static Subscriptionhelper subscriptionhelper=new Subscriptionhelper();
static TopUpHelper topUpHelper=new TopUpHelper();

	public static void main(String[] args) throws IOException {
		//"sample_input/input1.txt"
		File file=new File(args[0]);
		
    	FileReader fr = new FileReader(file);
    	BufferedReader br=new BufferedReader(fr);
    	String line;
    	
    	while((line=br.readLine())!=null) {
    		helper(line);
    	}  
    	fr.close();
    	
	}
	private static void helper(String s) {
	 	String[] arr = s.split(" ");

 	 if(arr[0].equals("START_SUBSCRIPTION"))
		{
			
			
			dareHelper.DateHelper(arr[1]);
		}
else if(arr[0].equals("ADD_SUBSCRIPTION"))
{
	if(arr[1].equals("MUSIC"))
	{
		subscriptionhelper.subHelper(arr[1],arr[2]);
	}
else	if(arr[1].equals("VIDEO"))
	{
		subscriptionhelper.subHelper(arr[1],arr[2]);

	}
else	if(arr[1].equals("PODCAST"))
	{
		subscriptionhelper.subHelper(arr[1],arr[2]);
	}
}
else if(arr[0].equals("ADD_TOPUP"))
{
	topUpHelper.topHelper(arr[1],arr[2]);
}
else if(arr[0].equals("PRINT_RENEWAL_DETAILS"))
{
  fileConverter.remainderdetails();
}
	}
}
