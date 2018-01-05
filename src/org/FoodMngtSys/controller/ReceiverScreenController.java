package org.FoodMngtSys.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.Date;

import org.FoodMngtSys.controller.DonorScreenController.DonorButtonListners;
import org.FoodMngtSys.model.Account;
import org.FoodMngtSys.model.DBStorage;
import org.FoodMngtSys.model.Donation;
import org.FoodMngtSys.model.Donor;
import org.FoodMngtSys.model.Receiver;
import org.FoodMngtSys.model.Stall;
import org.FoodMngtSys.model.UtilityCalendarClass;
import org.FoodMngtSys.view.DonationDetailScreen;
import org.FoodMngtSys.view.DonationEntryView;
import org.FoodMngtSys.view.DonationForm;
import org.FoodMngtSys.view.DonationListScreen;
import org.FoodMngtSys.view.DonorScreen;
import org.FoodMngtSys.view.LoginScreen;
import org.FoodMngtSys.view.ProfileView;
import org.FoodMngtSys.view.ReceiverScreen;
import org.FoodMngtSys.view.StallEntryView;

public class ReceiverScreenController {
private ReceiverScreen recScreen;
private Account acc;
private ArrayList<Donation> donList = new ArrayList<>();
private ArrayList<Stall> stlList = new ArrayList<>();
private ArrayList<DonationEntryView> donEntList = new ArrayList<>();
private ArrayList<StallEntryView> stlEntList = new ArrayList<>();
	
	public ReceiverScreenController(Account acc, ReceiverScreen screen){
		this.recScreen = screen;
		this.acc = acc;
		screen.setBehaviours(new ReceiverButtonListners());
	}
	
	class ReceiverButtonListners implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Sign Out")){
				LoginScreen logScreen = new LoginScreen();
				recScreen.setVisibility(false);
				logScreen.setVisibility(true);
				LoginScreenController loginControl = new LoginScreenController(logScreen);
			}else if(e.getActionCommand().equals("Profile Settings")){
				/*ArrayList<Account> acc = new ArrayList<>();
				acc.add(new Receiver("bet","hh", "hh", "hh", "hh", "hh", "hh", "hetj", "hetj", new Date(2017,11,10)));
				Account account = null;
				for(Account a:acc){
					//System.out.println(a.getAccountID());
					if(recScreen.getLblAccHolderFName().equals(a.getAccountID())){
						//System.out.println(recScreen.getLblAccHolderFName());
						account = a;
						break;
					}
				}*/
				ProfileView proScreen = new ProfileView(acc.getAccHolderFName(),acc.getAccHolderMName(),acc.getAccHolderLName(),acc.getAccHolderAdd(),acc.getAccHolderAreaPincode(),acc.getAccHolderContactNo(),acc.getAccHolderEmailID(),UtilityCalendarClass.getString(acc.getAccHolderDateOfBirth()));
				//ProfileView proScreen = new ProfileView();
				proScreen.setVisiblity(true);
				proScreen.setLblProfile(acc.getAccountID());
				ProfileViewController proControl = new ProfileViewController(acc, proScreen);
			}else if(e.getActionCommand().equals("Receive Donation")){
				DonationListScreen donationScreen = new DonationListScreen();
				donationScreen.setVisiblity(true);
				DonationListScreenController controlDonList = new DonationListScreenController(acc, donationScreen);
			}else if(e.getActionCommand().equals("View Received Donations")){
				donList = DBStorage.getDonationsForReceiver(acc.getAccountID());
				ArrayList<DonationEntryController> donEntCon = new ArrayList<>();
				
				stlList = DBStorage.getStallsForReceiver(acc.getAccountID());
				ArrayList<StallEntryViewController> stlEntCon = new ArrayList<>();
				
				for(Donation d : donList){
					donEntList.add(new DonationEntryView(d.getDonationID(), d.getPinCode(), UtilityCalendarClass.getString(d.getDonationDate())));
				}
				for(int i=0; i<donEntList.size(); i++){
					donEntCon.add(new DonationEntryController(donEntList.get(i),donList.get(i).getDonationList()));
				}
				
				for(Stall s : stlList){
					stlEntList.add(new StallEntryView(s.getStallID()));
				}
				for(StallEntryView sv:stlEntList){
					stlEntCon.add(new StallEntryViewController(sv));
				}
				DonationDetailScreen donDetScreen = new DonationDetailScreen();
				
				for(DonationEntryView d:donEntList){
					donDetScreen.addEntryToPanel(d);
				}
				for(StallEntryView s:stlEntList){
					donDetScreen.addEntryToPanel(s);
				}
				donDetScreen.setVisiblity(true);
			}
		}
		
	}

}
