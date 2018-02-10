package org.FoodMngtSys.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.FoodMngtSys.controller.SignUpScreenController;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpScreen {

	private JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtMiddleName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtPincode;
	private JTextField txtContactNo;
	private JTextField txtEmailID;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private JTextField txtDOB;
	private JRadioButton rdbtnDonor;
	private JRadioButton rdbtnReceiver;
	private JLabel lblEnterPersonalDetails;
	private JButton btnCreateAccount; 
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		SignUpScreen screen = new SignUpScreen();
		screen.setVisiblity(true);
		SignUpScreenController control = new SignUpScreenController(screen);
		
	}*/
	
	
	public void setSignUpBehaviour(ActionListener listen){
		btnCreateAccount.addActionListener(listen);
	}
	
	public void setMainLbl(String str){
		lblEnterPersonalDetails.setText(str);
	}
	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTxtFirstName() {
		return txtFirstName;
	}

	public JTextField getTxtMiddleName() {
		return txtMiddleName;
	}

	public JTextField getTxtLastName() {
		return txtLastName;
	}

	public JTextField getTxtAddress() {
		return txtAddress;
	}

	public JTextField getTxtPincode() {
		return txtPincode;
	}

	public JTextField getTxtContactNo() {
		return txtContactNo;
	}

	public JTextField getTxtEmailID() {
		return txtEmailID;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public JPasswordField getTxtConfirmPassword() {
		return txtConfirmPassword;
	}

	public JTextField getTxtDOB() {
		return txtDOB;
	}

	public JRadioButton getRdbtnDonor() {
		return rdbtnDonor;
	}

	public JRadioButton getRdbtnReceiver() {
		return rdbtnReceiver;
	}

	/**
	 * Create the application.
	 * @return 
	 */
	public void setVisiblity(boolean val){
		frame.setVisible(val);
	}
	
	public SignUpScreen() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		lblEnterPersonalDetails = new JLabel("Enter Personal Details");
		lblEnterPersonalDetails.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterPersonalDetails.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblEnterPersonalDetails, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(46, 11, 90, 14);
		panel.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(175, 8, 180, 20);
		panel.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblMiddleName = new JLabel("Middle Name:");
		lblMiddleName.setBounds(46, 36, 90, 14);
		panel.add(lblMiddleName);
		
		txtMiddleName = new JTextField();
		txtMiddleName.setBounds(175, 33, 180, 20);
		panel.add(txtMiddleName);
		txtMiddleName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(46, 61, 90, 14);
		panel.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(175, 58, 180, 20);
		panel.add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(46, 86, 90, 14);
		panel.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(175, 83, 249, 20);
		panel.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblPincode = new JLabel("Pincode:");
		lblPincode.setBounds(46, 111, 90, 14);
		panel.add(lblPincode);
		
		txtPincode = new JTextField();
		txtPincode.setBounds(175, 108, 180, 20);
		panel.add(txtPincode);
		txtPincode.setColumns(10);
		
		JLabel lblContactNo = new JLabel("Contact no:");
		lblContactNo.setBounds(46, 136, 90, 14);
		panel.add(lblContactNo);
		
		txtContactNo = new JTextField();
		txtContactNo.setBounds(175, 133, 180, 20);
		panel.add(txtContactNo);
		txtContactNo.setColumns(10);
		
		JLabel lblEmailId = new JLabel("E-mail ID:");
		lblEmailId.setBounds(46, 161, 90, 14);
		panel.add(lblEmailId);
		
		txtEmailID = new JTextField();
		txtEmailID.setBounds(175, 158, 180, 20);
		panel.add(txtEmailID);
		txtEmailID.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(46, 186, 90, 14);
		panel.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(175, 183, 180, 20);
		panel.add(txtPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(46, 211, 90, 14);
		panel.add(lblConfirmPassword);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(175, 208, 180, 20);
		panel.add(txtConfirmPassword);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth:");
		lblDateOfBirth.setBounds(46, 236, 90, 14);
		panel.add(lblDateOfBirth);
		
		txtDOB = new JTextField();
		txtDOB.setText("DD/MM/YYYY");
		txtDOB.setToolTipText("");
		txtDOB.setBounds(175, 233, 90, 20);
		panel.add(txtDOB);
		txtDOB.setColumns(10);
		
		JLabel lblAccountType = new JLabel("Account Type:");
		lblAccountType.setBounds(46, 288, 90, 14);
		panel.add(lblAccountType);
		
		rdbtnDonor = new JRadioButton("Donor");
		rdbtnDonor.setBounds(175, 284, 67, 23);
		panel.add(rdbtnDonor);
		
		rdbtnReceiver = new JRadioButton("Receiver");
		rdbtnReceiver.setBounds(259, 284, 96, 23);
		panel.add(rdbtnReceiver);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnReceiver);
		group.add(rdbtnDonor);
		
		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCreateAccount.setBounds(150, 348, 146, 23);
		panel.add(btnCreateAccount);
	}
}
