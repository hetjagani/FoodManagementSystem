package org.FoodMngtSys.model;

import java.sql.Date;


public abstract class Account {
	private String accHolderFName;
	private String accHolderMName;
	private String accHolderLName;
	private String accHolderAdd;
	private String accHolderAreaPincode;
	private String accHolderContactNo;
	private String accHolderEmailID;
	private Date accDateOfCreation;
	private String accPassword;
	private Date accHolderDateOfBirth;
	private String AccountID;
	
	public Account(String AccountID, String accHolderFName, String accHolderMName, String accHolderLName,String accHolderAdd, String accHolderAreaPincode, String accHolderContactNo, String accHolderEmailID,String accPassword, Date accHolderDateOfBirth) {
		
		java.util.Date date = new java.util.Date();
		String todayDate = Integer.toString(date.getDate())+"/"+Integer.toString(date.getMonth())+"/"+Integer.toString(date.getYear());
		//System.out.println(todayDate);
		this.accHolderFName = accHolderFName;
		this.accHolderMName = accHolderMName;
		this.accHolderLName = accHolderLName;
		this.accHolderAdd = accHolderAdd;
		this.accHolderAreaPincode = accHolderAreaPincode;
		this.accHolderContactNo = accHolderContactNo;
		this.accHolderEmailID = accHolderEmailID;
		this.accPassword = accPassword;
		this.accHolderDateOfBirth = accHolderDateOfBirth;
		this.accDateOfCreation = UtilityCalendarClass.getDate(todayDate);
		this.AccountID = AccountID;
	}
	public Account( String accHolderFName, String accHolderMName, String accHolderLName,String accHolderAdd, String accHolderAreaPincode, String accHolderContactNo, String accHolderEmailID,String accPassword, Date accHolderDateOfBirth) {
		java.util.Date date = new java.util.Date();
		String todayDate = Integer.toString(date.getDate())+"/"+Integer.toString(date.getMonth())+"/"+Integer.toString(date.getYear());
		
		this.accHolderFName = accHolderFName;
		this.accHolderMName = accHolderMName;
		this.accHolderLName = accHolderLName;
		this.accHolderAdd = accHolderAdd;
		this.accHolderAreaPincode = accHolderAreaPincode;
		this.accHolderContactNo = accHolderContactNo;
		this.accHolderEmailID = accHolderEmailID;
		this.accPassword = accPassword;
		this.accHolderDateOfBirth = accHolderDateOfBirth;
		this.accDateOfCreation = UtilityCalendarClass.getDate(todayDate);
	}
	
	public Account( String accID, String accHolderFName, String accHolderMName, String accHolderLName,String accHolderAdd, String accHolderAreaPincode, String accHolderContactNo, String accHolderEmailID,Date accDateOfCreation,String accPassword, Date accHolderDateOfBirth) {
		this.AccountID = accID;
		this.accHolderFName = accHolderFName;
		this.accHolderMName = accHolderMName;
		this.accHolderLName = accHolderLName;
		this.accHolderAdd = accHolderAdd;
		this.accHolderAreaPincode = accHolderAreaPincode;
		this.accHolderContactNo = accHolderContactNo;
		this.accHolderEmailID = accHolderEmailID;
		this.accPassword = accPassword;
		this.accHolderDateOfBirth = accHolderDateOfBirth;
		this.accDateOfCreation = accDateOfCreation;
	}
	
	public Account(Account tempAcc){
		this.accHolderFName= tempAcc.accHolderFName;
		this.accHolderMName= tempAcc.accHolderMName;
		this.accHolderLName= tempAcc.accHolderLName;
		this.accHolderAdd = tempAcc.accHolderAdd;
		this.accHolderAreaPincode= tempAcc.accHolderAreaPincode;
		this.accHolderContactNo = tempAcc.accHolderContactNo;
		this.accHolderEmailID= tempAcc.accHolderEmailID;
		this.accDateOfCreation = tempAcc.accDateOfCreation;
		this.accPassword = tempAcc.accPassword;
		this.accHolderDateOfBirth = tempAcc.accHolderDateOfBirth;
	}
		
	public String getAccHolderAreaPincode() {
		return accHolderAreaPincode;
	}

	public void setAccHolderAreaPincode(String accHolderAreaPincode) {
		this.accHolderAreaPincode = accHolderAreaPincode;
	}

	public String getAccountID() {
		return AccountID;
	}

	public void setAccountID(String accountID) {
		AccountID = accountID;
	}

	public String getAccHolderFName() {
		return accHolderFName;
	}
	
	public void setAccHolderFName(String accHolderFName) {
		this.accHolderFName = accHolderFName;
	}
	
	public String getAccHolderMName() {
		return accHolderMName;
	}
	
	public void setAccHolderMName(String accHolderMName) {
		this.accHolderMName = accHolderMName;
	}
	
	public String getAccHolderLName() {
		return accHolderLName;
	}
	
	public void setAccHolderLName(String accHolderLName) {
		this.accHolderLName = accHolderLName;
	}
	
	public String getAccHolderAdd() {
		return accHolderAdd;
	}
	
	public void setAccHolderAdd(String accHolderAdd) {
		this.accHolderAdd = accHolderAdd;
	}
	
	public String getaccHolderAreaPincode () {
		return accHolderAreaPincode ;
	}
	
	public void accHolderAreaPincode (String accHolderCity) {
		this.accHolderAreaPincode = accHolderCity;
	}
	
	public String getAccHolderContactNo() {
		return accHolderContactNo;
	}
	
	public void setAccHolderContactNo(String accHolderContactNo) {
		this.accHolderContactNo = accHolderContactNo;
	}
	
	public String getAccHolderEmailID() {
		return accHolderEmailID;
	}
	
	public void setAccHolderEmailID(String accHolderEmailID) {
		this.accHolderEmailID = accHolderEmailID;
	}
	
	public Date getAccDateOfCreation() {
		return accDateOfCreation;
	}
	
	public void setAccDateOfCreation(Date accDateOfCreation) {
		//this.accDateOfCreation = accDateOfCreation;
	}
	
	public String getAccPassword() {
		return accPassword;
	}
	
	public void setAccPassword(String accPassword) {
		this.accPassword = accPassword;
	}
	
	public Date getAccHolderDateOfBirth() {
		return accHolderDateOfBirth;
	}
	
	public void setAccHolderDateOfBirth(Date accHolderDateOfBirth) {
		this.accHolderDateOfBirth = accHolderDateOfBirth;
	}
		
}
