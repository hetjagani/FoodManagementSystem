package org.FoodMngtSys.model;

import java.sql.Date;

public class Donor extends Account{
	
	public Donor(Donor tempDonor){
		super(tempDonor.getAccountID(),tempDonor.getAccHolderFName(),tempDonor.getAccHolderMName(),tempDonor.getAccHolderLName(),tempDonor.getAccHolderAdd(),tempDonor.getaccHolderAreaPincode() ,tempDonor.getAccHolderContactNo(),tempDonor.getAccHolderEmailID(),tempDonor.getAccPassword(),tempDonor.getAccHolderDateOfBirth());
	}
	
	public Donor(String accHolderFName, String accHolderMName, String accHolderLName,String accHolderAdd, String accHolderAreaPincode, String accHolderContactNo, String accHolderEmailID,String accPassword, Date  date){
		super(FileInputOutput.generateID("D","ID.txt"),accHolderFName,accHolderMName,accHolderLName,accHolderAdd,accHolderAreaPincode,accHolderContactNo,accHolderEmailID,accPassword,date);
	}
	
	public Donor(String accID,String accHolderFName, String accHolderMName, String accHolderLName,String accHolderAdd, String accHolderAreaPincode, String accHolderContactNo, String accHolderEmailID,Date accDateOfCreation,String accPassword, Date  date){
		super(accID,accHolderFName,accHolderMName,accHolderLName,accHolderAdd,accHolderAreaPincode,accHolderContactNo,accHolderEmailID,accDateOfCreation,accPassword,date);
	}
	
	
	
		
	
	
}
