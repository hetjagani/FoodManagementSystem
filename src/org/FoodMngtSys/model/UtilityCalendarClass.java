package org.FoodMngtSys.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilityCalendarClass implements Serializable{
	
	private int year;
	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public int getMonth() {
		return month;
	}



	public void setMonth(int month) {
		this.month = month;
	}



	public int getDay() {
		return day;
	}



	public void setDay(int day) {
		this.day = day;
	}



	public int getTotalDonorAcc() {
		return totalDonorAcc;
	}



	public void setTotalDonorAcc(int totalDonorAcc) {
		this.totalDonorAcc = totalDonorAcc;
	}



	public int getTotalReceiverAcc() {
		return totalReceiverAcc;
	}



	public void setTotalReceiverAcc(int totalReceiverAcc) {
		this.totalReceiverAcc = totalReceiverAcc;
	}



	public int getTotalLargeDonation() {
		return totalLargeDonation;
	}



	public void setTotalLargeDonation(int totalLargeDonation) {
		this.totalLargeDonation = totalLargeDonation;
	}



	public int getTotalStalls() {
		return totalStalls;
	}



	public void setTotalStalls(int totalStalls) {
		this.totalStalls = totalStalls;
	}



	public int getTotalSmallDonation() {
		return totalSmallDonation;
	}



	public void setTotalSmallDonation(int totalSmallDonation) {
		this.totalSmallDonation = totalSmallDonation;
	}



	public int getTotalFoodItems() {
		return totalFoodItems;
	}



	public void setTotalFoodItems(int totalFoodItems) {
		this.totalFoodItems = totalFoodItems;
	}



	private int month;
	private int day;
	private int totalDonorAcc;
	private int totalReceiverAcc;
	private int totalLargeDonation;
	private int totalStalls;
	private int totalSmallDonation;
	private int totalFoodItems;
	
	public static java.sql.Date getDate(String str){
		//String[] ddmmyyyy = str.split("/");
		//return new java.sql.Date(Integer.parseInt(ddmmyyyy[2]), Integer.parseInt(ddmmyyyy[1]), Integer.parseInt(ddmmyyyy[0]));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date = null;
		java.sql.Date sqlDate = null;
		try {
			date = sdf.parse(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlDate = new java.sql.Date(date.getTime());
	
		}
		return sqlDate;
	}
	

	
	public static String getString(java.sql.Date date){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String d = df.format(date);
		return d;
	}
	
	
	/*public static String generateID(String val){
		String s = "";
		Date date = new Date(); // your date
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    int yr = cal.get(Calendar.YEAR);
	    int mnt = cal.get(Calendar.MONTH)+1;
	    int dy = cal.get(Calendar.DAY_OF_MONTH);
	    //System.out.println(yr);
	    //System.out.println(mnt);
	    //System.out.println(dy);
	    
	    if(year != yr || month != mnt || day != dy)
	    {
	    	year = yr;
	    	month = mnt;
	    	day = dy;
	    	totalSmallDonation = 0;
	    	totalLargeDonation = 0;
	    	totalDonorAcc = 0;
	    	totalReceiverAcc = 0;
	    	totalStalls = 0;
	    }
	    
	    
	    String m= (month<10)?"0"+month:""+month;
	    String d = (day<10)?"0"+day:""+day;
	    
	    s+=val;
		s+="-";
		s+=year;
		s+="-";
		s+=m;
		s+="-";
		s+=d;
		s+="-";
		
		if(val.equals("D"))
		{
			totalDonorAcc++;
			s+=totalDonorAcc;
		}
		else if(val.equals("R"))
		{
			totalReceiverAcc++;
			s+=totalReceiverAcc;
		}
		else if(val.equals("S"))
		{
			totalStalls++;
			s+=totalStalls;
		}
		else if(val.equals("L"))
		{
			totalLargeDonation++;
			s+=totalLargeDonation;
		}
		else if(val.equals("SM"))
		{
			totalSmallDonation++;
			s+=totalSmallDonation;
		}
		
		else if(val.equals("F"))
		{
			totalFoodItems++;
			s+=totalFoodItems;
		}
		System.out.println(s);
		
		return s;
		
	}
*/
	
}
