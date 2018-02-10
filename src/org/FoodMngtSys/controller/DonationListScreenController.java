package org.FoodMngtSys.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.FoodMngtSys.model.Account;
import org.FoodMngtSys.model.DBStorage;
import org.FoodMngtSys.model.LargeScaleDonation;
import org.FoodMngtSys.model.Stall;
import org.FoodMngtSys.view.DonationEntryView;
import org.FoodMngtSys.view.DonationListScreen;
import org.FoodMngtSys.view.StallEntryView;

public class DonationListScreenController {
	
	private DonationListScreen screen;
	private Account acc;
	private ArrayList<DonationEntryView> listDonationEntries = new ArrayList<>();
 	private ArrayList<StallEntryView> listStallEntries = new ArrayList<>();
 	private ArrayList<DonationEntryController> controlDonEntry = new ArrayList<>();
 	private ArrayList<StallEntryViewController> controlStallEntry = new ArrayList<>();
	
	public DonationListScreenController(Account acc, DonationListScreen s){
		screen = s;
		this.acc = acc;
		screen.setButtonBehaviour(new DonationListListner());
	}
	
	
	
	class DonationListListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String pincode = screen.getPincode();
				if(e.getActionCommand().equals("Search for donations")){
					//System.out.println("Search");
					/*
					 * search for donations having given pincode
					 * search for stalls having given pincode
					 * add donations to listDonationEntries
					 * add each entry to panel of DonationListScreen
					 */
					ArrayList<LargeScaleDonation> lsList = new ArrayList<>();
					ArrayList<Stall> stlList = new ArrayList<>();
					lsList=  DBStorage.getLSDonations(pincode);
					//System.out.println(lsList.size());
					stlList = DBStorage.getStalls(pincode);
					//System.out.println(stlList.size());
	
					
					
					for(LargeScaleDonation ls : lsList){
						listDonationEntries.add(new DonationEntryView(ls.getDonationID(), ls.getPinCode(), ls.getDonationDate().toString()));
						//System.out.println("1");
					}
					for(int i=0; i<listDonationEntries.size(); i++){
						controlDonEntry.add(new DonationEntryController(listDonationEntries.get(i),lsList.get(i).getDonationList()));
						//System.out.println("2");
					}
					
					for(Stall stls : stlList){
						//System.out.println(stls.getStallID());
						listStallEntries.add(new StallEntryView(stls.getStallID()));
						
					}
					
					for(StallEntryView sv : listStallEntries){
						controlStallEntry.add(new StallEntryViewController(sv));
					}
					
					for(DonationEntryView d : listDonationEntries){
						screen.addEntryToList(d);
					}
					
					for(StallEntryView s : listStallEntries){
						screen.addEntryToList(s);
					}
				}else if(e.getActionCommand().equals("Request Donation")){
					System.out.println("request");
						String id = screen.getDonationID();
						String[] s = id.split("-");
						
						if(s[0].equals("S")){
							DBStorage.setReceiverToStall(id, acc.getAccountID());
							System.out.println(id);
							System.out.println(acc.getAccountID());
						}else if(s[0].equals("L")){
							DBStorage.setReceiverToLSDonation(id, acc.getAccountID());
							System.out.println(id);
							System.out.println(acc.getAccountID());
						}
					}
				
			
		}
		
	}
	
}
