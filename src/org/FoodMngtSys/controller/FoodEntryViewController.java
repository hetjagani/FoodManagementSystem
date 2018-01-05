package org.FoodMngtSys.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.FoodMngtSys.model.FoodItem;
import org.FoodMngtSys.model.UtilityCalendarClass;
import org.FoodMngtSys.view.DonationForm;
import org.FoodMngtSys.view.FoodEntryView;

public class FoodEntryViewController {
	private FoodEntryView view;
	private DonationForm donFormView;
	
	
	public FoodEntryViewController(FoodEntryView panel, DonationForm don){
		view = panel;
		donFormView = don;
		
		panel.setMouseBehaviour(new ClickListner());
	}
	class ClickListner implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			FoodItem item = new FoodItem(view.getFoodName(), Integer.parseInt(view.getFoodQuantity()), UtilityCalendarClass.getDate(view.getFoodMfgDate()), UtilityCalendarClass.getDate(view.getFoodExpDate()));
			donFormView.setTxtFoodName(view.getFoodName());
			donFormView.setTxtFoodQuantity(view.getFoodQuantity());
			donFormView.setTxtMfgDate(view.getFoodMfgDate());
			donFormView.setTxtExpDate(view.getFoodExpDate());
			
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
