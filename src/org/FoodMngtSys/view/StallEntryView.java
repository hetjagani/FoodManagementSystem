package org.FoodMngtSys.view;

import java.awt.FlowLayout;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.FoodMngtSys.model.Stall;

public class StallEntryView extends JPanel{
	private JLabel stallID = new JLabel();
	
	public StallEntryView(String  stl){
		this.setLayout(new FlowLayout());
		this.stallID.setText(stl);
		this.add(stallID);
		this.setVisible(true);
	}
	
	public String getStallID(){
		return stallID.getText();
	}
	
	public void setMouseBehaviour(MouseListener listen){
		this.addMouseListener(listen);
	}
}
