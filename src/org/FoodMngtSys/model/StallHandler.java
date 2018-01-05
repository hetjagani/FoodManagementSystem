package org.FoodMngtSys.model;

import java.sql.Date;

public class StallHandler extends Account{
	private String StallHandlerID;
	private int totalStallAcc = 0;
	public StallHandler(StallHandler tempStallHandler){
		super(tempStallHandler.getAccHolderFName(),tempStallHandler.getAccHolderMName(),tempStallHandler.getAccHolderLName(),tempStallHandler.getAccHolderAdd(),tempStallHandler.getaccHolderAreaPincode() ,tempStallHandler.getAccHolderContactNo(),tempStallHandler.getAccHolderEmailID(),tempStallHandler.getAccPassword(),tempStallHandler.getAccHolderDateOfBirth());
		this.StallHandlerID = tempStallHandler.StallHandlerID;
		totalStallAcc++;
	}
	
	public StallHandler(String StallHandlerID, String accHolderFName, String accHolderMName, String accHolderLName,String accHolderAdd, String accHolderAreaPincode, String accHolderContactNo, String accHolderEmailID,String accPassword, Date accHolderDateOfBirth){
		super(accHolderFName,accHolderMName,accHolderLName,accHolderAdd,accHolderAreaPincode,accHolderContactNo,accHolderEmailID,accPassword,accHolderDateOfBirth);
		this.StallHandlerID = StallHandlerID;
		totalStallAcc++;
	}

	public String getStallHandlerID() {
		return StallHandlerID;
	}
	
	public int getTotalStallAcc(){
		return totalStallAcc;
	}
	
}
