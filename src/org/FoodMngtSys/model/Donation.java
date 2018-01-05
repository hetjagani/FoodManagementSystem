package org.FoodMngtSys.model;

import java.util.ArrayList;
import java.sql.Date;

public abstract class Donation{
	private String donationID;
	private ArrayList<FoodItem> donationList;
	private String pinCode;
	private Date donationDate;
	private String donorID;
	private String receiverID;
		
	public Donation(String donID, ArrayList<FoodItem> list, String pin, Date d,String donrID){
		this.donationID = donID;
		this.donationList = list;
		this.pinCode = pin;
		this.donationDate = d;
		this.donorID = donrID;
	}
	
	public Donation(String donID, ArrayList<FoodItem> list, String pin, Date d,String donrID,String recID){
		this.donationID = donID;
		this.donationList = list;
		this.pinCode = pin;
		this.donationDate = d;
		this.donorID = donrID;
	}
	
	public Donation(Donation d){
		this.donationID = d.donationID;
		this.donationList = d.donationList;
		this.pinCode = d.pinCode;
		this.donationDate = d.donationDate;
		this.donorID = d.donorID;
		//this.isRecieved = d.isRecieved;
	}
	
	public String getDonationID(){
		return this.donationID;
	}
	
	public void setDonationList(ArrayList<FoodItem> list){
		this.donationList = list;
	}	
	public ArrayList<FoodItem> getDonationList(){
		return this.donationList;
	}
	
	public String getPinCode(){
		return this.pinCode;
	}
	public void setPinCode(String pin){
		this.pinCode = pin;
	}
	
	public Date getDonationDate(){
		return this.donationDate;
	}
	public void setPinCode(Date d){
		this.donationDate = d;
	}

	public String getDonorID() {
		return donorID;
	}

	public void setDonorID(String donorID) {
		this.donorID = donorID;
	}

	public String getReceiverID() {
		return receiverID;
	}

	public void setReceiverID(String receiverID) {
		this.receiverID = receiverID;
	}
	
	
	/*public boolean getIsRecieved(){
		return this.isRecieved;
	}
	public void setIsRecieved(boolean val){
		this.isRecieved = val;
	}
	
	public boolean getIsDonated(){
		return this.isDonated;
	}
	public void setIsDonated(boolean val){
		this.isDonated = val;
	}*/
}