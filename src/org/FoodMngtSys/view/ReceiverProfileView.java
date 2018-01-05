package org.FoodMngtSys.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;

public class ReceiverProfileView {

	private JFrame frame;
	private JLabel lblrecID;
	private JLabel lblAccholdername;
	private JLabel lblAccholderadd;
	private JLabel lblAccholdercon;
	private JLabel lblAccholderemail;

	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceiverProfileView window = new ReceiverProfileView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/


	public void setLblrecID(String lblrecID) {
		this.lblrecID.setText(lblrecID);
	}

	public void setLblAccholdername(String lblAccholdername) {
		this.lblAccholdername.setText(lblAccholdername);
	}

	public void setLblAccholderadd(String lblAccholderadd) {
		this.lblAccholderadd.setText(lblAccholderadd);
	}

	public void setLblAccholdercon(String lblAccholdercon) {
		this.lblAccholdercon.setText(lblAccholdercon);
	}

	public void setLblAccholderemail(String lblAccholderemail) {
		this.lblAccholderemail.setText(lblAccholderemail);
	}
	
	public void setVisiblity(boolean val){
		this.frame.setVisible(val);
	}

	/**
	 * Create the application.
	 */
	public ReceiverProfileView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 200);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		lblrecID = new JLabel("recID");
		lblrecID.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblrecID.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblrecID, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblReceiverName = new JLabel("Receiver Name:");
		lblReceiverName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReceiverName.setBounds(34, 37, 140, 14);
		panel.add(lblReceiverName);
		
		lblAccholdername = new JLabel("accHolderName");
		lblAccholdername.setBounds(199, 37, 170, 14);
		panel.add(lblAccholdername);
		
		JLabel lblReceiverAddress = new JLabel("Receiver Address:");
		lblReceiverAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReceiverAddress.setBounds(34, 62, 140, 14);
		panel.add(lblReceiverAddress);
		
		lblAccholderadd = new JLabel("accHolderAdd");
		lblAccholderadd.setBounds(199, 62, 170, 14);
		panel.add(lblAccholderadd);
		
		JLabel lblNewLabel = new JLabel("Receiver Contact No:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(34, 87, 140, 14);
		panel.add(lblNewLabel);
		
		lblAccholdercon = new JLabel("accHolderCon");
		lblAccholdercon.setBounds(199, 87, 170, 14);
		panel.add(lblAccholdercon);
		
		JLabel lblReceiverEmailId = new JLabel("Receiver Email ID:");
		lblReceiverEmailId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReceiverEmailId.setBounds(34, 112, 140, 14);
		panel.add(lblReceiverEmailId);
		
		lblAccholderemail = new JLabel("accHolderEmail");
		lblAccholderemail.setBounds(199, 112, 170, 14);
		panel.add(lblAccholderemail);
	}
}
