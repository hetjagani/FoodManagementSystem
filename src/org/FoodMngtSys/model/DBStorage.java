package org.FoodMngtSys.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.FoodMngtSys.connectivity.DBConnection;

import java.sql.ResultSet;

public class DBStorage {
	private static Connection conn= DBConnection.getConnection(); 
	
	/*public DBStorage() {
		try{
			conn = DBConnection.getConnection(); 
		}catch(Exception e){
			System.out.println(e);
		}
	}*/
	
	
	public static void addAccount(Account acc) {
		Statement stmt=null;
		try{
			stmt = conn.createStatement();
			String sql = null;
			
			sql = "INSERT INTO `foodmngtsys`.`accounts` (`AccID`, `accHolderFName`, `accHolderMName`, `accHolderLName`, `accHolderAdd`, `accHolderPincode`, `accHolderContactNo`, `accHolderEmailID`, `accDateOfCreation`, `accPassword`, `accHolderDateOfBirth`) VALUES (";
			sql += "'" +acc.getAccountID()+ "',";
			sql += "'" +acc.getAccHolderFName()+ "',";
			sql += "'" +acc.getAccHolderMName()+ "',";
			sql += "'" +acc.getAccHolderLName()+ "',";
			sql += "'" +acc.getAccHolderAdd()+ "',";
			sql += "'" +acc.getAccHolderAreaPincode()+ "',";
			sql += "'" +acc.getAccHolderContactNo()+ "',";
			sql += "'" +acc.getAccHolderEmailID()+ "',";
			sql += "'" +acc.getAccDateOfCreation()+ "',";
			sql += "'" +acc.getAccPassword()+ "',";
			sql += "'" +acc.getAccHolderDateOfBirth()+ "'";
			sql += ");";
			
			stmt.execute(sql);

		}catch(Exception e){
			System.out.println(e);
		}
		finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public static void updateAccount(Account acc){
		Statement stmt = null;
		
		
		try {
			stmt = conn.createStatement();
			
			//sql = "SET SQL_SAFE_UPDATES = 0;";
			String sql = "UPDATE foodmngtsys.accounts";
			sql += " SET accHolderFName = '"+acc.getAccHolderFName()+"', accHolderMName = '"+acc.getAccHolderMName()+"', accHolderLName = '"+acc.getAccHolderLName()+"', accHolderAdd = '"+acc.getAccHolderAdd()+"', accHolderPincode = '"+acc.getAccHolderAreaPincode()+"', accHolderContactNo = '"+acc.getAccHolderContactNo()+"', accHolderEmailID = '"+acc.getAccHolderEmailID()+"', accHolderDateOfBirth = '"+acc.getAccHolderDateOfBirth()+"'";
			sql += " WHERE AccID = '"+acc.getAccountID()+"';";
			
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*public static Account getAccount(String password, String emailID){
		Statement stmt = null;
		Account acc = null;
		try {
			stmt = conn.createStatement();
			String sql = null;
		
			sql = "SELECT * FROM foodmngtsys.accounts";
			sql += "WHERE accounts.accPassword = '"+ password +"' AND accounts.accHolderEmailID = '"+ emailID +"';";
			
			
			
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				String ID = rs.getString(0);
				String[] compID = ID.split("-");
				
				if(compID[0].equals("D"))
					acc = new Donor(rs.getString(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getDate(10));
				else if(compID[0].equals("R"))
					acc = new Receiver(rs.getString(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getDate(10));
			}else
				System.out.println("......");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return acc;
	}
	*/
	
	public static ArrayList<Account> getAllAccounts(){
		Statement stmt = null;
		ArrayList<Account> list = new ArrayList<>();

		try {
			stmt = conn.createStatement();
			String sql = null;
			sql = "SELECT * FROM foodmngtsys.accounts";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String id = rs.getString("AccID");
				String[] comp = id.split("-");
				
				if(comp[0].equals("D")){
					list.add(new Donor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10), rs.getDate(11)));
				}else if(comp[0].equals("R")){
					list.add(new Receiver(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10), rs.getDate(11)));
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}
	
	public static void storeDonation(Donation donation , String donorID){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = null;
			
			sql = "INSERT INTO `foodmngtsys`.`donation` (`donationID`, `donorID`, `recieverID`, `pincode`, `donationDate`) VALUES (";
			sql += "'"+ donation.getDonationID() +"',"; 
			sql += "'"+ donorID +"',"; 
			sql += "'"+ null +"',"; 
			sql += "'"+ donation.getPinCode() +"',"; 
			sql += "'"+ donation.getDonationDate() +"')";
			
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} 
	}
	
	public static void storeFoodItems(ArrayList<FoodItem> list, String donationID){
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			String sql = null;
			
			for(FoodItem f:list){
				sql = "INSERT INTO `foodmngtsys`.`fooditems` (`donationID`, `foodName`, `mfgDate`, `expDate`, `quantity`, `foodItemID`) VALUES (";
				sql += "'"+ donationID +"',"; 
				sql += "'"+ f.getFoodName() +"',";
				sql += "'"+ f.getMfgDate() +"',";
				sql += "'"+ f.getExpDate() +"',";
				sql += "'"+ f.getFoodQuantity() +"',"; 
				sql += "'"+ f.getFoodItemID() +"')";
				
				stmt.execute(sql);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	public static ArrayList<String> getDonationIDFromStall(String stallID){
		Statement stmt = null;
		ArrayList<String> list = new ArrayList<>();
		
		try{
			stmt = conn.createStatement();
			String sql = null;
						
			sql = "SELECT *";
			sql += " FROM foodmngtsys.stalls";
			sql += " WHERE stalls.stallID = '" + stallID + "' AND stalls.recieverID = 'null';";			
			
			ResultSet rs = stmt.executeQuery(sql);
			//System.out.println(rs.getFetchSize());
			while(rs.next()){
				list.add(rs.getString("donationID"));
				//break;
				//System.out.println(rs.getString("donationID"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
		
	}
	
	public static ArrayList<FoodItem> getFoodItemsFromStall(String stlID){
		ArrayList<FoodItem> list = new ArrayList<>();
		ArrayList<String> donIDs = getDonationIDFromStall(stlID);
		for(String s : donIDs){
			ArrayList<FoodItem> tempFI = getFoodItems(s);
			list.addAll(tempFI);
		}
		return list;
	}
	
	public static ArrayList<FoodItem> getFoodItems(String donID){
		Statement stmt = null;
		ArrayList<FoodItem> list = new ArrayList<>();
		
		try {
			stmt = conn.createStatement();
			
			
			String sql = "SELECT *";
			sql +=" FROM fooditems";
			sql +=" WHERE fooditems.donationID = '"+ donID +"';";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while(rs.next()){
				//FoodItem(String ID, String name, int qty, Date mfgDate, Date expDate)
				list.add(new FoodItem(rs.getString(6), rs.getString(2), rs.getInt(5), rs.getDate(3), rs.getDate(4)));
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}
	
	
	public static ArrayList<Stall> getStalls(String pincode){
		Statement stmt = null;
		ArrayList<Stall> list = new ArrayList<>();
		
		try {
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM foodmngtsys.stalls ";
			sql +="WHERE pincode = " +Integer.parseInt(pincode)+ " AND recieverID = 'null';";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				list.add(new Stall(rs.getString(1), Integer.toString(rs.getInt(4))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return list;
		
	}
	
	
	public static ArrayList<LargeScaleDonation> getLSDonations(String pincode){
		Statement stmt = null;
		ArrayList<LargeScaleDonation> list = new ArrayList<>();
		
		try {
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM foodmngtsys.donation ";
			sql += "WHERE donation.pincode = "+ Integer.parseInt(pincode) +" AND recieverID = 'null';";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String donID = rs.getString(1);
				String[] comp = donID.split("-");
				
				if(comp[0].equals("L")){
					list.add(new LargeScaleDonation(rs.getString(1),getFoodItems(rs.getString(1)), rs.getString(4), rs.getDate(5), rs.getString(2), rs.getString(3)));
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return list;
		
	}
	
	public static void addSSDonations(Donation don,Stall stl){
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			String sql1 = null;
			String sql2 = null;
			
			sql1 = "INSERT INTO `foodmngtsys`.`donation` (`donationID`, `donorID`, `recieverID`, `pincode`, `donationDate`) VALUES (";
			sql1 += "'"+ don.getDonationID() +"',";
			sql1 += "'" +don.getDonorID() +"',";
			sql1 +="'" + stl.getStallID() +"',";
			sql1 +="'"+don.getPinCode()+"',";
			sql1 +="'"+don.getDonationDate()+"')";

			sql2 = "INSERT INTO `foodmngtsys`.`stalls` (`stallID`, `donationID`, `recieverID`, `pincode`) VALUES (";
			sql2 += "'" +stl.getStallID() + "',";
			sql2 += "'" +don.getDonationID()+"',";
			sql2 += "'" +null +"',";
			sql2 += "'"+don.getPinCode()+"')";

			
			stmt.execute(sql1);
			stmt.execute(sql2);
			storeFoodItems(don.getDonationList(), don.getDonationID());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}
	
	public static void addLSDonations(Donation don){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = null;
			sql = "INSERT INTO `foodmngtsys`.`donation` (`donationID`, `donorID`, `recieverID`, `pincode`, `donationDate`) VALUES (";
			sql += "'"+don.getDonationID()+"',";
			sql += "'"+don.getDonorID()+"',";
			sql += "'"+don.getReceiverID()+"',";
			sql += "'"+don.getPinCode()+"',";
			sql += "'"+don.getDonationDate()+"')";
			
			stmt.execute(sql);
			storeFoodItems(don.getDonationList(), don.getDonationID());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}
	
	public static void addFoodItems(Donation don){
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			ArrayList<FoodItem> list = don.getDonationList();
			
			for (FoodItem fi : list){
				String sql = null;
				sql = "INSERT INTO `foodmngtsys`.`fooditems` (`donationID`, `foodName`, `mfgDate`, `expDate`, `quantity`, `foodItemID`) VALUES (";
				sql += "'" +don.getDonationID()+ "',";
				sql += "'" +fi.getFoodName() + "',";
				sql += "'" +fi.getMfgDate() + "',";
				sql += "'" +fi.getExpDate() + "',";
				sql += "'" +fi.getFoodQuantity() + "',";
				sql += "'" +fi.getFoodItemID() + "')";
 
				stmt.execute(sql);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		
	}
	
	public static void setReceiverToStall(String stallID, String recID){
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			
			String sql = " UPDATE foodmngtsys.stalls"; 
			sql += " SET recieverID = '"+ recID +"'"; 
			sql += " WHERE stallID = '"+ stallID +"';";
			
			stmt.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public static void setReceiverToLSDonation(String donID, String recID){
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			
			
			String sql = " UPDATE foodmngtsys.donation"; 
			sql += " SET recieverID = '"+ recID +"'"; 
			sql += " WHERE donationID = '"+ donID +"';";
			
			stmt.execute(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	
	public static ArrayList<Donation> getDonationsForDonor(String accID){
		Statement stmt = null;
		ArrayList<Donation> donList = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			
			String sql = "SELECT *";
			sql +=" FROM foodmngtsys.donation";
			sql +=" WHERE donation.donorID = '"+ accID +"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String str = rs.getString(1);
				String[] s = str.split("-");
				if(s[0].equals("L"))
					donList.add(new LargeScaleDonation(rs.getString(1),DBStorage.getFoodItems(rs.getString(1)), Integer.toString(rs.getInt(4)), rs.getDate(5), rs.getString(2), rs.getString(3)));
				else if(s[0].equals("SM"))
					donList.add(new SmallScaleDonation(rs.getString(1),DBStorage.getFoodItems(rs.getString(1)), Integer.toString(rs.getInt(4)), rs.getDate(5), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return donList;
	}
	
	
	public static ArrayList<Donation> getDonationsForReceiver(String accID){
		Statement stmt = null;
		ArrayList<Donation> donList = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			
			String sql = "SELECT *";
			sql +=" FROM foodmngtsys.donation";
			sql +=" WHERE donation.recieverID = '"+ accID +"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String str = rs.getString(1);
				String[] s = str.split("-");
				if(s[0].equals("L"))
					donList.add(new LargeScaleDonation(rs.getString(1),DBStorage.getFoodItems(rs.getString(1)), Integer.toString(rs.getInt(4)), rs.getDate(5), rs.getString(2), rs.getString(3)));
				else if(s[0].equals("SM"))
					donList.add(new SmallScaleDonation(rs.getString(1),DBStorage.getFoodItems(rs.getString(1)), Integer.toString(rs.getInt(4)), rs.getDate(5), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return donList;
	}
	
	public static ArrayList<Stall> getStallsForReceiver(String accID){
		Statement stmt = null;
		ArrayList<Stall> stlList = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			
			String sql = "SELECT *";
			sql += " FROM foodmngtsys.stalls";
			sql += " WHERE recieverID = '"+ accID +"';";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				stlList.add(new Stall(rs.getString(1), rs.getString(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return stlList;
	}
	
	public static Receiver getReceiverForDonor(String donID){
		Statement stmt = null;
		Receiver r = null;
		try {
			stmt = conn.createStatement();
			
			String sql = "SELECT donation.recieverID";
			sql += " FROM foodmngtsys.donation";
			sql += " WHERE donorID = '"+ donID +"';";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String s = rs.getString(1);
				String str[] = s.split("-");
				if(str[0].equals("R")){
					r = getRecAccount(s);
					//System.out.println(r.toString());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return r;
	}
	
	public static Receiver getRecAccount(String accID){
		Statement stmt = null;
		Receiver acc = null;
		try {
			stmt = conn.createStatement();
			
			String sql1 = "SELECT *"; 
			sql1 +=" FROM foodmngtsys.accounts";
			sql1 +=" WHERE accounts.AccID = '"+accID+"';";
			//System.out.println(accID);
			ResultSet rs2 = stmt.executeQuery(sql1);
			
			while(rs2.next())
				acc = new Receiver(rs2.getString(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getString(5), Integer.toString(rs2.getInt(6)), rs2.getString(7), rs2.getString(8), rs2.getDate(9), rs2.getString(10), rs2.getDate(11));
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return acc;
	}
	
	
	/*public static UtilityCalendarClass readData(String fileName){
		FileInputStream fIn = null;
		ObjectInputStream oIn = null;
		UtilityCalendarClass temp = null;
		try{
			fIn = new FileInputStream(fileName);
			oIn = new ObjectInputStream(fIn);
			
			temp = (UtilityCalendarClass)oIn.readObject();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
			if(fIn!=null)
				fIn.close();
			if(oIn!=null)
				oIn.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			
		}
		System.out.println(temp.month);
		return temp;
	}
	
	public static void writeData(String fileName,UtilityCalendarClass cal){
		FileOutputStream fOut = null;
		ObjectOutputStream oOut= null;

		try{
			fOut= new FileOutputStream(fileName);
			oOut = new ObjectOutputStream(fOut);
			
			oOut.writeObject(cal);
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
			if(fOut!=null)
				fOut.close();
			if(oOut!=null)
				oOut.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			
		}
	}*/
	
	/*public static ArrayList<String> getAccID(){
		ArrayList<String> accID = new ArrayList<>();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			
			String sql = "SELECT accounts.AccID FROM accounts";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				accID.add(rs.getString(1));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return accID;
	}
	
	public static ArrayList<String> getDonorID(){
		ArrayList<String> accID = getAccID();
		ArrayList<String> donID = new ArrayList<>();
		for(String s:accID){
			String[] str = s.split("-");
			if(str[0].equals("D")){
				donID.add(s);
			}
		}
		return donID;
	}
	
	public static ArrayList<String> getReceiverID(){
		ArrayList<String> accID = getAccID();
		ArrayList<String> recID = new ArrayList<>();
		for(String s:accID){
			String[] str = s.split("-");
			if(str[0].equals("R")){
				recID.add(s);
			}
		}
		return recID;
	}
	
	public static ArrayList<String> getDonationID(){
		ArrayList<String> donID = new ArrayList<>();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			
			String sql = "SELECT donation.donationID FROM donation";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				donID.add(rs.getString(1));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return donID;
	}
	
	public static ArrayList<String> getFoodID(){
		ArrayList<String> foodID = new ArrayList<>();
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			
			String sql = "SELECT fooditems.foodItemID FROM donation";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				foodID.add(rs.getString(1));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return foodID;
	}*/

		
	
	public void close() throws SQLException, Exception{
		if(conn != null)
			conn.close();
	}
}
