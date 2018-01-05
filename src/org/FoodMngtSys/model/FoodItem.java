package org.FoodMngtSys.model;
import java.sql.Date;

public class FoodItem{
	
	private String foodItemID;
	private int foodQuantity;
	private String foodName;
	private Date mfgDate;
	private Date expDate;
	
	public FoodItem(String name, int qty, Date mfgDate, Date expDate){
		this.foodName = name;
		this.foodQuantity = qty;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
		this.foodItemID = FileInputOutput.generateID("F","ID.txt");
	}

	public FoodItem(String ID, String name, int qty, Date mfgDate, Date expDate){
		this.foodItemID = ID;
		this.foodName = name;
		this.foodQuantity = qty;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
	}

	public FoodItem(FoodItem item){
		this.foodName = item.foodName;
		this.foodQuantity = item.foodQuantity;
		this.mfgDate = item.mfgDate;
		this.expDate = item.expDate;
	}
	
	public String getFoodItemID() {
		return foodItemID;
	}

	public void setFoodQuantity(int qty){
		this.foodQuantity = qty;
	}
	public int getFoodQuantity(){
		return this.foodQuantity;
	}
	
	public void setFoodName(String name){
		this.foodName = name;
	}
	public String getFoodName(){
		return this.foodName;
	}
	
	public void setMfgDate(Date d){
		this.mfgDate = d;
	}
	public Date getMfgDate(){
		return this.mfgDate;
	}
	
	public void setExpDate(Date d){
		this.expDate = d;
	}
	public Date getExpDate(){
		return this.expDate;
	}
}
