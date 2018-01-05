package org.FoodMngtSys.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import org.FoodMngtSys.model.DBStorage;
import org.FoodMngtSys.model.FoodItem;
import org.FoodMngtSys.model.UtilityCalendarClass;
import org.FoodMngtSys.view.DonationListScreen;
import org.FoodMngtSys.view.FoodEntryView;
import org.FoodMngtSys.view.FoodItemsView;
import org.FoodMngtSys.view.StallEntryView;

public class StallEntryViewController {
	private StallEntryView pnlStall;
	private ArrayList<FoodEntryView> listFoodEntries = new ArrayList<>();
	private FoodItemsView foodList = new FoodItemsView();
	
	public StallEntryViewController(StallEntryView view){
		this.pnlStall = view;
		
		pnlStall.setMouseBehaviour(new StallEntryListner());
	}
	
	class StallEntryListner implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
		String stlID = pnlStall.getStallID();	
		
		ArrayList<FoodItem> listFItem = DBStorage.getFoodItemsFromStall(stlID);
		//System.out.println(listFItem.size());
		for(FoodItem fi : listFItem){
			listFoodEntries.add(new FoodEntryView(fi.getFoodName(),fi.getFoodItemID(),Integer.toString(fi.getFoodQuantity()) , fi.getMfgDate().toString(), fi.getExpDate().toString()));
			//System.out.println("ccc");
		}
		
		for(FoodEntryView fv : listFoodEntries){
			foodList.addFoodEntry(fv);
			//System.out.println("ddd");
		}
		
		foodList.setVisiblity(true);
			/*	
			 * get arraylist of food items from database
			 * add those food items to FoodEntryList
			 * add those FoodEntryView panels to FoodItemsView
			 * 
			 */
		
		/*	ArrayList<FoodItem> fList = DBStorage.getFoodItemsFromStall(pnlStall.getStallID());
			
			for(FoodItem f:fList){
				listFoodEntries.add(new FoodEntryView(f.getFoodItemID(), f.getFoodName(), Integer.toString(f.getFoodQuantity()), UtilityCalendarClass.getString(f.getMfgDate()), UtilityCalendarClass.getString(f.getExpDate())));
			}
			for(FoodEntryView fev:listFoodEntries){
				foodList.addFoodEntry(fev);
			}
			
			foodList.setVisiblity(true);*/
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
