package org.FoodMngtSys.view;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListDataListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class DonationListScreen {

	private JFrame frame;
	private JTextField txtDonationId;
	private JTextField txtPincode;
	private JButton btnRequestDonation;
	private JButton btnSearchForDonations;
	private JPanel pnlDonationList;
	private JLabel lblRequest;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonorListScreen window = new DonorListScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public DonationListScreen() {
		initialize();
	}
	
	public void setVisiblity(boolean val){
		frame.setVisible(val);
	}
	
	public void setButtonBehaviour(ActionListener listen){
		btnRequestDonation.addActionListener(listen);
		btnSearchForDonations.addActionListener(listen);
	}
	
	public String getPincode(){
		return txtPincode.getText();
	}
	
	public String getDonationID(){
		return txtDonationId.getText();
	}
	
	public void setDonationID(String donID){
		txtDonationId.setText(donID);
	}
	
	public void addEntryToList(JPanel pnl){
		pnlDonationList.add(pnl);
		pnl.setVisible(true);
	}
	
	public void setlblRequest(String value){
		lblRequest.setText(value);
	}
	
	
	
	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlFooter = new JPanel();
		frame.getContentPane().add(pnlFooter, BorderLayout.SOUTH);
		pnlFooter.setLayout(new BorderLayout(0, 0));
		
		lblRequest = new JLabel("Enter donation ID to request donation");
		lblRequest.setHorizontalAlignment(SwingConstants.CENTER);
		pnlFooter.add(lblRequest, BorderLayout.NORTH);
		
		btnRequestDonation = new JButton("Request Donation");
		pnlFooter.add(btnRequestDonation, BorderLayout.SOUTH);
		
		txtDonationId = new JTextField();
		txtDonationId.setToolTipText("Enter Donation ID");
		txtDonationId.setHorizontalAlignment(SwingConstants.CENTER);
		pnlFooter.add(txtDonationId, BorderLayout.CENTER);
		txtDonationId.setColumns(10);
		
		JPanel pnlHeader = new JPanel();
		frame.getContentPane().add(pnlHeader, BorderLayout.NORTH);
		pnlHeader.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDonorsInYour = new JLabel("Donations in your area");
		lblDonorsInYour.setFont(new Font("Tahoma", Font.BOLD, 13));
		pnlHeader.add(lblDonorsInYour, BorderLayout.NORTH);
		
		txtPincode = new JTextField();
		txtPincode.setText("Pincode");
		pnlHeader.add(txtPincode, BorderLayout.EAST);
		txtPincode.setColumns(10);
		
		btnSearchForDonations = new JButton("Search for donations");
		pnlHeader.add(btnSearchForDonations, BorderLayout.SOUTH);
		
		pnlDonationList = new JPanel();
		pnlDonationList.setLayout(new GridLayout(0, 1));
		frame.getContentPane().add(pnlDonationList, BorderLayout.CENTER);
		
	}

}
