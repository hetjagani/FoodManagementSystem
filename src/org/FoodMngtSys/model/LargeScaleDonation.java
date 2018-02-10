package org.FoodMngtSys.model;

import java.util.ArrayList;
import java.sql.Date;

public class LargeScaleDonation extends Donation{
	
	
	public LargeScaleDonation(ArrayList<FoodItem> list, String pin, Date d,String donrID,String recID){
		super(FileInputOutput.generateID("L","ID.txt"),list, pin, d,donrID,recID);
	
	}
	public LargeScaleDonation(String id,ArrayList<FoodItem> list, String pin, Date d,String donrID,String recID){
		super(id,list, pin, d,donrID,recID);
	
	}
	
}