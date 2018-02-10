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

public class DonorScreen {

	private JFrame frame;
	private JLabel lblAccHolderFName;
	private JButton btnSignOut;
	private JButton btnProfileSettings;
	private JButton btnMakeDonation;
	private JButton btnViewDonations;
	private JButton btnShowReceiverProfile;
	private JButton btnConfirmRequest;
	private JPanel pnlBottom;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonorScreen window = new DonorScreen();
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
	public void setBehaviours(ActionListener listen) {
		btnMakeDonation.addActionListener(listen);
		btnViewDonations.addActionListener(listen);
		btnProfileSettings.addActionListener(listen);
		btnSignOut.addActionListener(listen);
		btnShowReceiverProfile.addActionListener(listen);
	}
	
	public DonorScreen() {
		initialize();
		//donationConfirmed();
	}
	
	public void setPnlBottom(boolean val){
		pnlBottom.setVisible(val);
	}
	public String getLblAccHolderFName() {
		return lblAccHolderFName.getText();
	}
	public void setLblAccHolderFName(String str) {
		lblAccHolderFName.setText(str);
	}
	public JButton getBtnSignOut() {
		return btnSignOut;
	}
	public void setBtnSignOut(JButton btnSignOut) {
		this.btnSignOut = btnSignOut;
	}
	public JButton getBtnProfileSettings() {
		return btnProfileSettings;
	}
	public void setBtnProfileSettings(JButton btnProfileSettings) {
		this.btnProfileSettings = btnProfileSettings;
	}
	public JButton getBtnMakeDonation() {
		return btnMakeDonation;
	}
	public void setBtnMakeDonation(JButton btnMakeDonation) {
		this.btnMakeDonation = btnMakeDonation;
	}
	public JButton getBtnViewDonations() {
		return btnViewDonations;
	}
	public void setBtnViewDonations(JButton btnViewDonations) {
		this.btnViewDonations = btnViewDonations;
	}
	public JButton getBtnConfirmRequest() {
		return btnConfirmRequest;
	}
	public void setBtnConfirmRequest(JButton btnConfirmRequest) {
		this.btnConfirmRequest = btnConfirmRequest;
	}
	public void setVisibility(boolean val){
		frame.setVisible(val);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 350);
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
		
		btnMakeDonation = new JButton("Make Donation");
		btnMakeDonation.setBounds(94, 40, 152, 62);
		pnlCenter.add(btnMakeDonation);
		
		btnViewDonations = new JButton("View your Donations");
		btnViewDonations.setBounds(94, 113, 152, 62);
		pnlCenter.add(btnViewDonations);
		
		//setPnlBottomVisible(false);
		
	}
	
	public void setPnlBottomVisible(boolean val){
		pnlBottom = new JPanel(new BorderLayout());
		frame.getContentPane().add(pnlBottom,BorderLayout.SOUTH);
		
		JLabel lblYourDonationIs = new JLabel("Your Donation is requested");
		lblYourDonationIs.setHorizontalAlignment(SwingConstants.CENTER);
		pnlBottom.add(lblYourDonationIs, BorderLayout.CENTER);
		
		JPanel panelSouth = new JPanel();
		pnlBottom.add(panelSouth, BorderLayout.SOUTH);
		
		btnShowReceiverProfile = new JButton("Show Receiver profile");
		panelSouth.add(btnShowReceiverProfile);
		pnlBottom.setVisible(val);
	}
	
}
