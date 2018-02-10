package org.FoodMngtSys.view;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.spec.MGF1ParameterSpec;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.FoodMngtSys.model.FoodItem;
import org.FoodMngtSys.model.UtilityCalendarClass;

public class FoodEntryView extends JPanel{
	private JLabel foodName;
	private JLabel foodQuantity;
	private JLabel foodMfgDate;
	private JLabel foodExpDate;
	private JLabel foodID;
	
	
	public FoodEntryView(String ID, String Name, String qty, String mfgDate, String expDate){
		this.setLayout(new FlowLayout());
		
		foodName = new JLabel(Name);
		foodQuantity = new JLabel(qty);
		foodMfgDate = new JLabel(mfgDate);
		foodExpDate = new JLabel(expDate);
		foodID = new JLabel(ID);
		
		this.add(foodID);
		this.add(foodName);
		this.add(foodQuantity);
		this.add(foodMfgDate);
		this.add(foodExpDate);
		this.setVisible(true);
		
	}
	
	public FoodEntryView(String Name, String qty, String mfgDate, String expDate){
		this.setLayout(new FlowLayout());
		
		foodName = new JLabel(Name);
		foodQuantity = new JLabel(qty);
		foodMfgDate = new JLabel(mfgDate);
		foodExpDate = new JLabel(expDate);
	
		this.add(foodName);
		this.add(foodQuantity);
		this.add(foodMfgDate);
		this.add(foodExpDate);
		this.setVisible(true);
		
	}
	
	public void setMouseBehaviour(MouseListener listen){
		this.addMouseListener(listen);
	}


	public String getFoodName() {
		return foodName.getText();
	}



	public void setFoodName(JLabel foodName) {
		this.foodName = foodName;
	}



	public String getFoodQuantity() {
		return foodQuantity.getText();
	}



	public void setFoodQuantity(JLabel foodQuantity) {
		this.foodQuantity = foodQuantity;
	}



	public String getFoodMfgDate() {
		return foodMfgDate.getText();
	}



	public void setFoodMfgDate(JLabel foodMfgDate) {
		this.foodMfgDate = foodMfgDate;
	}



	public String getFoodExpDate() {
		return foodExpDate.getText();
	}



	public void setFoodExpDate(JLabel foodExpDate) {
		this.foodExpDate = foodExpDate;
	}
		
			
}
	

