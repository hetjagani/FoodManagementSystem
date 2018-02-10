package org.FoodMngtSys.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;

import org.FoodMngtSys.model.Account;
import org.FoodMngtSys.model.DBStorage;
import org.FoodMngtSys.model.Donation;
import org.FoodMngtSys.model.FoodItem;
import org.FoodMngtSys.model.LargeScaleDonation;
import org.FoodMngtSys.model.SmallScaleDonation;
import org.FoodMngtSys.model.Stall;
import org.FoodMngtSys.model.UtilityCalendarClass;
import org.FoodMngtSys.view.DonationForm;
import org.FoodMngtSys.view.FoodEntryView;

public class DonationFormController {
	private DonationForm form;
	private Account acc; 
	private ArrayList<FoodEntryView> entries = new ArrayList<>();
	private ArrayList<FoodEntryViewController> conEntries = new ArrayList<>();
	private ArrayList<FoodItem> foodList = new ArrayList<>();
	private ArrayList<Stall> stl;
	
	public DonationFormController(Account acc,DonationForm screen,ArrayList<Stall> stl){
		this.form = screen;
		this.acc = acc;
		this.stl = stl;
		screen.setBehaviours(new DonationFormListner());
	}
	
	
	class DonationFormListner implements ActionListener{
/////////////////////////////THIS IS NOT WORKING/////////////////////
		@Override
		public void actionPerformed(ActionEvent e) {
			//String s = e.getActionCommand();
		
			if(e.getActionCommand().equals("Add Item"))
			{
				
				//System.out.println("add Item");
				FoodItem item = new FoodItem(form.getTxtFoodName(), Integer.parseInt(form.getTxtFoodQuantity()), UtilityCalendarClass.getDate(form.getTxtMfgDate()), UtilityCalendarClass.getDate(form.getTxtExpDate()));
				foodList.add(item);
				entries.add(new FoodEntryView(form.getTxtFoodName(), form.getTxtFoodQuantity(), form.getTxtMfgDate(), form.getTxtExpDate()));
				
				for(FoodEntryView fv:entries){
					form.addItemInList(fv);
					conEntries.add(new FoodEntryViewController(fv, form));
				}
				
			}else if(e.getActionCommand().equals("Remove Item"))
			{	//System.out.println("Hello");
				for(int i=0; i<entries.size(); i++){
					if(entries.get(i).getFoodName().equals(form.getTxtFoodName()) && entries.get(i).getFoodQuantity().equals(form.getTxtFoodQuantity()) && entries.get(i).getFoodMfgDate().equals(form.getTxtMfgDate()) && entries.get(i).getFoodExpDate().equals(form.getTxtExpDate())){
						form.removeItemFromList(entries.get(i));
						foodList.remove(i);
					}
				}
			}
			else if(e.getActionCommand().equals("Confirm Donation")){
				//System.out.println("Hello World..");
				if(form.getRdbtnLargeScale().isSelected()){
					//STORE OBJ OF LARGE SCALE DONATION TO DATABASE
					LargeScaleDonation lsDon = new LargeScaleDonation(foodList, form.getTxtPincode(), UtilityCalendarClass.getDate(form.getTxtDateOfDonation()), acc.getAccountID(),null);
					DBStorage.addLSDonations(lsDon);
				}else if(form.getRdbtnSmallScale().isSelected()){
					//STORE OBJ OF SMALL SCALE DONATION TO DATABASE
					//STORE THAT DONATION ID TO STALL
					SmallScaleDonation smDon = new SmallScaleDonation(foodList, form.getTxtPincode(), UtilityCalendarClass.getDate(form.getTxtDateOfDonation()), acc.getAccountID(),null);
					for(Stall s:stl){
						if(s.getPinCode().equals(form.getTxtPincode())){
							DBStorage.addSSDonations(smDon, s);
						}
					}
				}
			}
			
		}
		
	}
}
