package org.FoodMngtSys.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;


public class FileInputOutput {
	
	
	public static void writeData(String fileName,UtilityCalendarClass wri){
		FileOutputStream fOut  = null;
		ObjectOutputStream oOut = null;
		
		//apples temp = null;
		try{
			fOut = new FileOutputStream(fileName);
			oOut = new ObjectOutputStream(fOut);
			
			oOut.writeObject(wri);
			
		
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
			if(oOut!=null)
				oOut.close();
			if(fOut!=null)
				fOut.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public static UtilityCalendarClass readData(String fileName){
		FileInputStream fIn  = null;
		ObjectInputStream oIn = null;
		
		UtilityCalendarClass temp = null;
		try{
			fIn = new FileInputStream(fileName);
			oIn = new ObjectInputStream(fIn);
			
			temp = (UtilityCalendarClass)oIn.readObject();
			
		
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
			if(oIn!=null)
				oIn.close();
			if(fIn!=null)
				fIn.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		//System.out.println(temp.toString());
		return temp;
	}
	
	public static String generateID(String val,String fileName){
		
		String s = "";
		
		Date date = new Date(); // your date
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    int yr = cal.get(Calendar.YEAR);
	    int mnt = cal.get(Calendar.MONTH)+1;
	    int dy = cal.get(Calendar.DAY_OF_MONTH);
	   File f = new File(fileName);
	   
	   UtilityCalendarClass readD = new UtilityCalendarClass();
	   
	   if(f.exists()){
		   readD =  readData(fileName);
	   }
	   	if(readD.getYear() != yr || readD.getMonth()!= mnt || readD.getDay()!= dy)
	    {
	    	//System.out.println(readD.year);
	    	//System.out.println(readD.month);
	    	//System.out.println(readD.days);
	    	readD.setYear(yr);
	    	readD.setMonth(mnt);;
	    	readD.setDay(dy);
	    	readD.setTotalSmallDonation(1);
	    	readD.setTotalLargeDonation(1);
	    	readD.setTotalDonorAcc(1);
	    	readD.setTotalReceiverAcc(1);
	    	readD.setTotalStalls(1);
	    	readD.setTotalFoodItems(1);
	    }
	    	
	    String m= (readD.getMonth()<10)?"0"+readD.getMonth():""+readD.getMonth();
	    String d = (readD.getDay()<10)?"0"+readD.getDay():""+readD.getDay();
	    
	    s+=val;
		s+="-";
		s+=readD.getYear();
		s+="-";
		s+=m;
		s+="-";
		s+=d;
		s+="-";
		
		if(val.equals("D"))
		{
			s+=readD.getTotalDonorAcc();
			readD.setTotalDonorAcc(readD.getTotalDonorAcc()+1);		
		}
		else if(val.equals("R"))
		{
			s+=readD.getTotalReceiverAcc();
			readD.setTotalReceiverAcc(readD.getTotalReceiverAcc()+1);;
		}
		else if(val.equals("S"))
		{
			s+=readD.getTotalStalls();
			readD.setTotalStalls(readD.getTotalStalls()+1);
		}
		else if(val.equals("L"))
		{
			s+=readD.getTotalLargeDonation();
			readD.setTotalLargeDonation(readD.getTotalLargeDonation()+1);
			
		}
		else if(val.equals("SM"))
		{
			s+=readD.getTotalSmallDonation();
			readD.setTotalSmallDonation(readD.getTotalSmallDonation()+1);
		}
		
		else if(val.equals("F"))
		{
			s+=readD.getTotalFoodItems();
			readD.setTotalFoodItems(readD.getTotalFoodItems()+1);
		}

		writeData(fileName, readD);
		return s;

	}
}
