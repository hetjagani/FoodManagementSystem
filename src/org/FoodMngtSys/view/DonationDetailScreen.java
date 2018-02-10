package org.FoodMngtSys.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JPanel;

public class DonationDetailScreen {

	private JFrame frame;
	private JPanel pnlDisplay;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonationDetailScreen window = new DonationDetailScreen();
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
	public DonationDetailScreen() {
		initialize();
	}

	
	
	public void addEntryToPanel(JPanel pnl){
		pnlDisplay.add(pnl);
	}
	
	
	public void setVisiblity(boolean val){
		frame.setVisible(val);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 335);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblDonationDetails = new JLabel("Donation Details");
		lblDonationDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDonationDetails.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblDonationDetails, BorderLayout.NORTH);
		
		pnlDisplay = new JPanel();
		pnlDisplay.setLayout(new GridLayout(0, 1));
		frame.getContentPane().add(pnlDisplay, BorderLayout.CENTER);
		
		
	}

}
