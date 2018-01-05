package org.FoodMngtSys.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.text.Utilities;

import org.FoodMngtSys.model.DBStorage;
import org.FoodMngtSys.model.FoodItem;
import org.FoodMngtSys.model.UtilityCalendarClass;
import org.FoodMngtSys.view.DonationDetailScreen;
import org.FoodMngtSys.view.DonationEntryView;
import org.FoodMngtSys.view.FoodEntryView;
import org.FoodMngtSys.view.FoodItemsView;

public class DonationEntryController {
	
	private DonationEntryView donEntView;
	private ArrayList<FoodEntryView> foodEntryList = new ArrayList<>();
	private ArrayList<FoodItem> foodList = new ArrayList<>();
	
	public DonationEntryController(DonationEntryView donEntView, ArrayList<FoodItem> food){
		this.donEntView = donEntView;
		this.foodList = food;
	
		donEntView.setBehaviour(new ClickListner());
	}
	
	public DonationEntryController(DonationEntryView donEntView){
		this.donEntView = donEntView;
	
		donEntView.setBehaviour(new ClickListner());
	}
	
	class ClickListner implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			FoodItemsView foodListScreen = new FoodItemsView();
			
			for(FoodItem fi : foodList){
				foodEntryList.add(new FoodEntryView(fi.getFoodItemID(),fi.getFoodName(), Integer.toString(fi.getFoodQuantity()), UtilityCalendarClass.getString(fi.getMfgDate()), UtilityCalendarClass.getString(fi.getExpDate())));
			}
			
			for(FoodEntryView fv : foodEntryList){
				foodListScreen.addFoodEntry(fv);
			}
			
			foodListScreen.setVisiblity(true);
			/*
			 * get arraylist of food items from database
			 * add those food items to FoodEntryList
			 * add those FoodEntryView panels to FoodItemsView
			 * 
			 */
			 
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
