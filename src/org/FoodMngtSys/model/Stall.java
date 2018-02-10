package org.FoodMngtSys.model;

public class Stall{
	private final String stallID;
	private final String pinCode;
	
	public Stall(String pin, String donID, String recID){
		this.stallID = FileInputOutput.generateID("S","ID.txt");
		this.pinCode = pin;
	}
	
	public Stall(String pin){
		this.stallID = FileInputOutput.generateID("S", "ID.txt");
		this.pinCode = pin;
	}
	
	public Stall(String stallID, String pin){
		this.stallID = stallID;
		this.pinCode = pin;
	}
	
	public Stall(Stall temp){
		this.stallID = temp.stallID;
		this.pinCode = temp.pinCode;
		
	}
	
	

	public String getStallID() {
		return stallID;
	}

	public String getPinCode() {
		return pinCode;
	}
}