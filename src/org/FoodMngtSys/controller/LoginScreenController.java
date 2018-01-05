package org.FoodMngtSys.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import org.FoodMngtSys.model.Receiver;
import org.FoodMngtSys.model.Stall;
import org.FoodMngtSys.model.UtilityCalendarClass;

import javax.swing.JLabel;

import org.FoodMngtSys.model.Account;
import org.FoodMngtSys.model.DBStorage;
import org.FoodMngtSys.model.Donation;
import org.FoodMngtSys.model.Donor;
import org.FoodMngtSys.view.DonorScreen;
import org.FoodMngtSys.view.LoginScreen;
import org.FoodMngtSys.view.ReceiverScreen;
import org.FoodMngtSys.view.SignUpScreen;

public class LoginScreenController {
	private LoginScreen login ;
	private ArrayList<Account> acc;
	private ArrayList<Stall> stl;
	
	public LoginScreenController(ArrayList<Account> acc, LoginScreen screen, ArrayList<Stall> stl){
		this.login = screen;
		this.stl = stl;
		this.acc = acc;
		
		login.setBehaviour(new BtnListner());
	}
	public LoginScreenController(LoginScreen screen){
		this.login = screen;
		
		login.setBehaviour(new BtnListner());
	}
	
	
	
	
	class BtnListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("Login")){
				for(Account a:acc){
					if(login.getPassword().equals(a.getAccPassword()) && login.getLoginID().equals(a.getAccHolderEmailID())){
						//System.out.println(a.getAccountID());
					//Account acc = DBStorage.getAccount(login.getLoginID(), login.getPassword());
						if(a instanceof Donor){
							login.setVisibility(false);
							DonorScreen donScreen = new DonorScreen();
							Receiver rec = DBStorage.getReceiverForDonor(a.getAccountID());
							DonorScreenController donControl;
							
							if(rec != null){
								donScreen.setPnlBottomVisible(true);
								donScreen.setVisibility(true);
								donScreen.setLblAccHolderFName(a.getAccountID());
								donControl = new DonorScreenController(a, donScreen, stl,rec);
							}else{
								donScreen.setPnlBottomVisible(false);
								donScreen.setVisibility(true);
								donScreen.setLblAccHolderFName(a.getAccountID());
								donControl = new DonorScreenController(a, donScreen, stl);
							}
						}
						else if(a instanceof Receiver){
							login.setVisibility(false);
							ReceiverScreen recScreen = new ReceiverScreen();
							recScreen.setVisibility(true);
							recScreen.setLblAccHolderFName(a.getAccountID());
							ReceiverScreenController recControl = new ReceiverScreenController(a, recScreen);
						}
					}
					else{
						login.getLblEnterYourId().setText("Invalid ID or Password...");
					}
				}
			}
			else if(e.getActionCommand().equals("Sign up")){
				login.setVisibility(false);
				SignUpScreen signUp = new SignUpScreen();
				signUp.setVisiblity(true);
				SignUpScreenController controlSignUp = new SignUpScreenController(signUp,stl);
			}
		}
		
	}
}
