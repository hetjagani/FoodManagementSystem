package org.FoodMngtSys.model;

import java.sql.Date;

public class Receiver extends Account{
	
	public Receiver(Receiver tempDonor){
		super(tempDonor.getAccountID(),tempDonor.getAccHolderFName(),tempDonor.getAccHolderMName(),tempDonor.getAccHolderLName(),tempDonor.getAccHolderAdd(),tempDonor.getaccHolderAreaPincode() ,tempDonor.getAccHolderContactNo(),tempDonor.getAccHolderEmailID(),tempDonor.getAccPassword(),tempDonor.getAccHolderDateOfBirth());
	}
	
	public Receiver(String accHolderFName, String accHolderMName, String accHolderLName,String accHolderAdd, String accHolderAreaPincode, String accHolderContactNo, String accHolderEmailID,String accPassword, Date accHolderDateOfBirth){
		super(FileInputOutput.generateID("R","ID.txt"),accHolderFName,accHolderMName,accHolderLName,accHolderAdd,accHolderAreaPincode,accHolderContactNo,accHolderEmailID,accPassword,accHolderDateOfBirth);
	}
	
	public Receiver(String accID, String accHolderFName, String accHolderMName, String accHolderLName,String accHolderAdd, String accHolderAreaPincode, String accHolderContactNo, String accHolderEmailID,Date accDateOfCreation,String accPassword, Date accHolderDateOfBirth){
		super(accID,accHolderFName,accHolderMName,accHolderLName,accHolderAdd,accHolderAreaPincode,accHolderContactNo,accHolderEmailID,accDateOfCreation,accPassword,accHolderDateOfBirth);
	}

		
}
