package org.FoodMngtSys.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;

import org.FoodMngtSys.model.Account;
import org.FoodMngtSys.model.DBStorage;
import org.FoodMngtSys.model.Donor;
import org.FoodMngtSys.model.Receiver;
import org.FoodMngtSys.model.Stall;
import org.FoodMngtSys.model.UtilityCalendarClass;
import org.FoodMngtSys.view.DonorScreen;
import org.FoodMngtSys.view.ReceiverScreen;
import org.FoodMngtSys.view.SignUpScreen;

public class SignUpScreenController {
	private SignUpScreen screen;
	private Account acc;
	private ArrayList<Stall> stl;
	
	public SignUpScreenController(SignUpScreen screen, ArrayList<Stall> stl){
		this.screen = screen;
		this.stl = stl;
		this.screen.setSignUpBehaviour(new SignUpListner());
	}
	
	class SignUpListner implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(screen.getRdbtnDonor().isSelected() && screen.getTxtPassword().getText().equals(screen.getTxtConfirmPassword().getText())){
				String pass = screen.getTxtPassword().getText();
				acc = new Donor(screen.getTxtFirstName().getText(),screen.getTxtMiddleName().getText(),screen.getTxtLastName().getText(),screen.getTxtAddress().getText(),screen.getTxtPincode().getText(),screen.getTxtContactNo().getText(),screen.getTxtEmailID().getText(),pass,UtilityCalendarClass.getDate(screen.getTxtDOB().getText()));
				
				DBStorage.addAccount(acc);
				
				//System.out.println("donor");
				DonorScreen donScreen = new DonorScreen();
				screen.setVisiblity(false);
				donScreen.setVisibility(true);
				donScreen.setLblAccHolderFName(acc.getAccountID());
				DonorScreenController controlDonScreen = new DonorScreenController(acc, donScreen,stl);
			}else if(screen.getRdbtnReceiver().isSelected() && screen.getTxtPassword().getText().equals(screen.getTxtConfirmPassword().getText())){
				String pass = screen.getTxtPassword().getText();
				acc = new Receiver(screen.getTxtFirstName().getText(),screen.getTxtMiddleName().getText(),screen.getTxtLastName().getText(),screen.getTxtAddress().getText(),screen.getTxtPincode().getText(),screen.getTxtContactNo().getText(),screen.getTxtEmailID().getText(),pass,UtilityCalendarClass.getDate(screen.getTxtDOB().getText()));
				
				DBStorage.addAccount(acc);
				
				//System.out.println("receiver");
				ReceiverScreen recScreen = new ReceiverScreen();
				screen.setVisiblity(false);
				recScreen.setVisibility(true);
				recScreen.setLblAccHolderFName(acc.getAccountID());
				ReceiverScreenController controlRecScreen = new ReceiverScreenController(acc, recScreen);
			}else{
				screen.setMainLbl("Error in form...");
			}
		}
		
	}
}
