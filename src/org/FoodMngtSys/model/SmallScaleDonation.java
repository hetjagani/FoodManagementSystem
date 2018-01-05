package org.FoodMngtSys.model;

import java.util.ArrayList;
import java.sql.Date;

public class SmallScaleDonation extends Donation{
	
	
	
	public SmallScaleDonation(ArrayList<FoodItem> list, String pin, Date d,String donrID,String recID){
		super(FileInputOutput.generateID("SM","ID.txt"),list, pin,d, donrID,recID);
	}
	
	public SmallScaleDonation(String id,ArrayList<FoodItem> list, String pin, Date d,String donrID,String recID){
		super(id,list, pin,d, donrID,recID);
	}
	
}