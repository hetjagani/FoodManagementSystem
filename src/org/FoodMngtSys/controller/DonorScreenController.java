package org.FoodMngtSys.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.Date;

import javax.swing.JLabel;

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
import org.FoodMngtSys.view.DonorScreen;
import org.FoodMngtSys.view.LoginScreen;
import org.FoodMngtSys.view.ProfileView;
import org.FoodMngtSys.view.ReceiverProfileView;

public class DonorScreenController {
	private DonorScreen donScreen;
	private Account acc;
	private ArrayList<Stall> stl;
	private ArrayList<Donation> donList = new ArrayList<>();
	private ArrayList<DonationEntryView> donEntList = new ArrayList<>();
	private Receiver rec;
	
	public DonorScreenController(Account a, DonorScreen screen, ArrayList<Stall> stl){
		this.donScreen = screen;
		this.acc = a;
		this.stl = stl;
		screen.setBehaviours(new DonorButtonListners());
	}
	public DonorScreenController(Account a, DonorScreen screen, ArrayList<Stall> stl, Receiver rec){
		this.donScreen = screen;
		this.rec = rec;
		this.acc = a;
		this.stl = stl;
		screen.setBehaviours(new DonorButtonListners());
	}
	
	class DonorButtonListners implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Sign Out")){
				LoginScreen logScreen = new LoginScreen();
				donScreen.setVisibility(false);
				logScreen.setVisibility(true);
				LoginScreenController loginControl = new LoginScreenController(logScreen);
			}else if(e.getActionCommand().equals("Profile Settings")){
				/*ArrayList<Account> acc = new ArrayList<>();
				acc.add(new Donor("het","hh", "hh", "hh", "hh", "hh", "hh", "hetj", "hetj", UtilityCalendarClass.getDate("10/11/2017")));
				Account account = null;
				for(Account a:acc){
					//System.out.println(a.getAccountID());
					if(donScreen.getLblAccHolderFName().equals(a.getAccountID())){
						//System.out.println(donScreen.getLblAccHolderFName());
						account = a;
						break;
					}
				}*/
				ProfileView proScreen = new ProfileView(acc.getAccHolderFName(),acc.getAccHolderMName(),acc.getAccHolderLName(),acc.getAccHolderAdd(),acc.getAccHolderAreaPincode(),acc.getAccHolderContactNo(),acc.getAccHolderEmailID(),UtilityCalendarClass.getString(acc.getAccHolderDateOfBirth()));
				//ProfileView proScreen = new ProfileView();
				proScreen.setVisiblity(true);
				proScreen.setLblProfile(acc.getAccountID());
				ProfileViewController proControl = new ProfileViewController(acc, proScreen);
			}else if(e.getActionCommand().equals("Make Donation")){
				DonationForm form = new DonationForm();
				form.setVisiblity(true);
				DonationFormController controlForm = new DonationFormController(acc,form,stl);
			}else if(e.getActionCommand().equals("View your Donations")){
				donList = DBStorage.getDonationsForDonor(acc.getAccountID());
				ArrayList<DonationEntryController> donEntCon = new ArrayList<>();
				
				for(Donation d : donList){
					donEntList.add(new DonationEntryView(d.getDonationID(), d.getPinCode(), UtilityCalendarClass.getString(d.getDonationDate())));
				}
				for(int i=0; i<donEntList.size(); i++){
					donEntCon.add(new DonationEntryController(donEntList.get(i),donList.get(i).getDonationList()));
				}
				DonationDetailScreen donDetScreen = new DonationDetailScreen();
				
				for(DonationEntryView d:donEntList){
					donDetScreen.addEntryToPanel(d);
				}
				donDetScreen.setVisiblity(true);
			}else if(e.getActionCommand().equals("Show Receiver profile")){
				ReceiverProfileView recPro = new ReceiverProfileView();
				recPro.setLblAccholdername(rec.getAccHolderFName()+" "+rec.getAccHolderLName());
				recPro.setLblrecID(rec.getAccountID());
				recPro.setLblAccholderadd(rec.getAccHolderAdd());
				recPro.setLblAccholdercon(rec.getAccHolderContactNo());
				recPro.setLblAccholderemail(rec.getAccHolderEmailID());
				recPro.setVisiblity(true);
			}
		}
		
	}
}

