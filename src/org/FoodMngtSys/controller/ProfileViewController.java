package org.FoodMngtSys.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.Date;

import org.FoodMngtSys.model.Account;
import org.FoodMngtSys.model.DBStorage;
import org.FoodMngtSys.model.Donor;
import org.FoodMngtSys.model.Receiver;
import org.FoodMngtSys.model.UtilityCalendarClass;
import org.FoodMngtSys.view.ProfileView;

public class ProfileViewController {
	private ProfileView proScreen;
	private Account acc;
	
	public ProfileViewController(Account acc, ProfileView screen){
		proScreen = screen;
		this.acc = acc;
		
		proScreen.setUpdateBehaviour(new UpdateListner());
	}
	
	class UpdateListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
				acc.setAccHolderFName(proScreen.getTxtAccHolderFName());
				acc.setAccHolderMName(proScreen.getTxtAccHolderMName());
				acc.setAccHolderLName(proScreen.getTxtAccHolderLName());
				acc.setAccHolderEmailID(proScreen.getTxtAccHolderEmailID());
				acc.setAccHolderAdd(proScreen.getTxtAccHolderAdd());
				acc.setAccHolderAreaPincode(proScreen.getTxtAccHolderAreaPincode());
				acc.setAccHolderDateOfBirth(UtilityCalendarClass.getDate(proScreen.getTxtaccHolderDateOfBirth()));
				acc.setAccHolderContactNo(proScreen.getTxtAccHolderContactNo());
				DBStorage.updateAccount(acc);
				//System.out.println(a.getAccHolderFName());
			}
		}
		
}

