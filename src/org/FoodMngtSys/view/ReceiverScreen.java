package org.FoodMngtSys.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class ReceiverScreen {

	private JFrame frame;
	private JButton btnProfileSettings;
	private JButton btnSignOut;
	private JButton btnReceiveDonation;
	private JLabel lblAccHolderFName;
	private JButton btnViewDonations;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceiverScreen window = new ReceiverScreen();
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
	public void setBehaviours(ActionListener listen){
		btnProfileSettings.addActionListener(listen);
		btnReceiveDonation.addActionListener(listen);
		btnSignOut.addActionListener(listen);
		btnViewDonations.addActionListener(listen);
	}
	
	public  ReceiverScreen() {
		initialize();
	}
	
	public void setBtnProfileSettings(JButton btnProfileSettings) {
		this.btnProfileSettings = btnProfileSettings;
	}

	public void setBtnSignOut(JButton btnSignOut) {
		this.btnSignOut = btnSignOut;
	}

	public void setBtnReceiveDonation(JButton btnReceiveDonation) {
		this.btnReceiveDonation = btnReceiveDonation;
	}

	public void setLblAccHolderFName(String str) {
		lblAccHolderFName.setText(str);
	}

	public void setBtnViewDonations(JButton btnViewDonations) {
		this.btnViewDonations = btnViewDonations;
	}

	public JButton getBtnProfileSettings() {
		return btnProfileSettings;
	}

	public JButton getBtnSignOut() {
		return btnSignOut;
	}

	public JButton getBtnReceiveDonation() {
		return btnReceiveDonation;
	}

	public String getLblAccHolderFName() {
		return lblAccHolderFName.getText();
	}

	public JButton getBtnViewDonations() {
		return btnViewDonations;
	}

	public void setVisibility(boolean val){
		frame.setVisible(val);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlLeft = new JPanel();
		frame.getContentPane().add(pnlLeft, BorderLayout.WEST);
		pnlLeft.setLayout(new GridLayout(4, 1));
		
		JLabel lblSettings = new JLabel("Settings:");
		lblSettings.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		pnlLeft.add(lblSettings);
		
		btnProfileSettings = new JButton("Profile Settings");
		pnlLeft.add(btnProfileSettings);
		
		btnSignOut = new JButton("Sign Out");
		pnlLeft.add(btnSignOut);
		
		JPanel pnlTop = new JPanel();
		frame.getContentPane().add(pnlTop, BorderLayout.NORTH);
		pnlTop.setLayout(new BorderLayout(0, 0));
		
		lblAccHolderFName = new JLabel("accHolderFName");
		lblAccHolderFName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAccHolderFName.setHorizontalAlignment(SwingConstants.CENTER);
		pnlTop.add(lblAccHolderFName, BorderLayout.NORTH);
		
		JPanel pnlCenter = new JPanel();
		frame.getContentPane().add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(null);
		
		btnReceiveDonation = new JButton("Receive Donation");
		btnReceiveDonation.setBounds(94, 40, 152, 62);
		pnlCenter.add(btnReceiveDonation);
		
		btnViewDonations = new JButton("View Received Donations");
		btnViewDonations.setBounds(94, 113, 152, 62);
		pnlCenter.add(btnViewDonations);
	}

}
