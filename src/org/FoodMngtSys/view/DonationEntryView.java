package org.FoodMngtSys.view;

import java.awt.FlowLayout;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DonationEntryView extends JPanel{
	
	private JLabel donationID;	
	private JLabel pincode;
	private JLabel donationDate;

	public DonationEntryView(String donationID,String pincode,String donationDate){
		this.setLayout(new FlowLayout());
		
		this.donationID = new JLabel(donationID);
		this.pincode = new JLabel(pincode);
		this.donationDate = new JLabel(donationDate);
		
		this.add(this.donationID);
		this.add(this.pincode);
		this.add(this.donationDate);
		
		this.setVisible(true);
		
	}
	
	public void setBehaviour(MouseListener listen){
		this.addMouseListener(listen);
	}
	
	public String getDonationID(){
		return donationID.getText();
	}
}
