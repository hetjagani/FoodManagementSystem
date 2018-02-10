package org.FoodMngtSys.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfileView {

	private JFrame frame;
	private JTextField txtAccHolderFName;
	private JTextField txtAccHolderMName;
	private JTextField txtAccHolderLName;
	private JTextField txtAccHolderAdd;
	private JTextField txtAccHolderAreaPincode;
	private JTextField txtAccHolderContactNo;
	private JTextField txtAccHolderEmailID;
	private JTextField txtaccHolderDateOfBirth;
	private JLabel lblProfile;
	private JButton btnUpdateAccountDetails;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileView window = new ProfileView();
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
	public void setVisiblity(boolean val){
		frame.setVisible(val);
	}
	
	
	/*public ProfileView() {
		initialize();
	}*/
	
	public String getLblProfile() {
		String str = lblProfile.getText();
		String[] s = str.split(":");
		return s[1];
	}


	public void setLblProfile(String lblProfile) {
		this.lblProfile.setText("Profile:"+lblProfile);;
	}
	
	public void setUpdateBehaviour(ActionListener listen){
		btnUpdateAccountDetails.addActionListener(listen);
	}

	public ProfileView(String fname, String mname, String lname, String add, String pin, String con, String emailID, String dob) {
		initialize();
		txtAccHolderFName.setText(fname);
		txtAccHolderMName.setText(mname);
		txtAccHolderLName.setText(lname);
		txtAccHolderAdd.setText(add);
		txtAccHolderAreaPincode.setText(pin);
		txtAccHolderContactNo.setText(con);
		txtAccHolderEmailID.setText(emailID);
		txtaccHolderDateOfBirth.setText(dob);
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public String getTxtAccHolderFName() {
		return txtAccHolderFName.getText();
	}

	public void setTxtAccHolderFName(JTextField txtAccHolderFName) {
		this.txtAccHolderFName = txtAccHolderFName;
	}

	public String getTxtAccHolderMName() {
		return txtAccHolderMName.getText();
	}

	public void setTxtAccHolderMName(JTextField txtAccHolderMName) {
		this.txtAccHolderMName = txtAccHolderMName;
	}

	public String getTxtAccHolderLName() {
		return txtAccHolderLName.getText();
	}

	public void setTxtAccHolderLName(JTextField txtAccHolderLName) {
		this.txtAccHolderLName = txtAccHolderLName;
	}

	public String getTxtAccHolderAdd() {
		return txtAccHolderAdd.getText();
	}

	public void setTxtAccHolderAdd(JTextField txtAccHolderAdd) {
		this.txtAccHolderAdd = txtAccHolderAdd;
	}

	public String getTxtAccHolderAreaPincode() {
		return txtAccHolderAreaPincode.getText();
	}

	public void setTxtAccHolderAreaPincode(JTextField txtAccHolderAreaPincode) {
		this.txtAccHolderAreaPincode = txtAccHolderAreaPincode;
	}

	public String getTxtAccHolderContactNo() {
		return txtAccHolderContactNo.getText();
	}

	public void setTxtAccHolderContactNo(JTextField txtAccHolderContactNo) {
		this.txtAccHolderContactNo = txtAccHolderContactNo;
	}

	public String getTxtAccHolderEmailID() {
		return txtAccHolderEmailID.getText();
	}

	public void setTxtAccHolderEmailID(JTextField txtAccHolderEmailID) {
		this.txtAccHolderEmailID = txtAccHolderEmailID;
	}

	public String getTxtaccHolderDateOfBirth() {
		return txtaccHolderDateOfBirth.getText();
	}

	public void setTxtaccHolderDateOfBirth(JTextField txtaccHolderDateOfBirth) {
		this.txtaccHolderDateOfBirth = txtaccHolderDateOfBirth;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 425, 335);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFirstName.setBounds(50, 11, 90, 14);
		panel.add(lblFirstName);
		
		JLabel lblMidleName = new JLabel("Middle Name:");
		lblMidleName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMidleName.setBounds(50, 36, 90, 14);
		panel.add(lblMidleName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastName.setBounds(50, 61, 90, 14);
		panel.add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setBounds(50, 86, 90, 14);
		panel.add(lblAddress);
		
		JLabel lblNewLabel = new JLabel("Area pincode:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(50, 111, 90, 14);
		panel.add(lblNewLabel);
		
		JLabel lblContactNo = new JLabel("Contact no:");
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContactNo.setBounds(50, 136, 90, 14);
		panel.add(lblContactNo);
		
		JLabel lblEmailId = new JLabel("E-mail ID:");
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailId.setBounds(50, 161, 90, 14);
		panel.add(lblEmailId);
		
		JLabel lblBirthDate = new JLabel("Birth Date:");
		lblBirthDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBirthDate.setBounds(50, 186, 90, 14);
		panel.add(lblBirthDate);
		
		txtAccHolderFName = new JTextField();
		txtAccHolderFName.setBounds(211, 8, 140, 20);
		panel.add(txtAccHolderFName);
		txtAccHolderFName.setColumns(10);
		
		txtAccHolderMName = new JTextField();
		txtAccHolderMName.setBounds(211, 33, 140, 20);
		panel.add(txtAccHolderMName);
		txtAccHolderMName.setColumns(10);
		
		txtAccHolderLName = new JTextField();
		txtAccHolderLName.setBounds(211, 58, 140, 20);
		panel.add(txtAccHolderLName);
		txtAccHolderLName.setColumns(10);
		
		txtAccHolderAdd = new JTextField();
		txtAccHolderAdd.setBounds(211, 83, 140, 20);
		panel.add(txtAccHolderAdd);
		txtAccHolderAdd.setColumns(10);
		
		txtAccHolderAreaPincode = new JTextField();
		txtAccHolderAreaPincode.setBounds(211, 108, 140, 20);
		panel.add(txtAccHolderAreaPincode);
		txtAccHolderAreaPincode.setColumns(10);
		
		txtAccHolderContactNo = new JTextField();
		txtAccHolderContactNo.setBounds(211, 133, 140, 20);
		panel.add(txtAccHolderContactNo);
		txtAccHolderContactNo.setColumns(10);
		
		txtAccHolderEmailID = new JTextField();
		txtAccHolderEmailID.setBounds(211, 158, 140, 20);
		panel.add(txtAccHolderEmailID);
		txtAccHolderEmailID.setColumns(10);
		
		txtaccHolderDateOfBirth = new JTextField();
		txtaccHolderDateOfBirth.setBounds(211, 183, 86, 20);
		panel.add(txtaccHolderDateOfBirth);
		txtaccHolderDateOfBirth.setColumns(10);
		
		btnUpdateAccountDetails = new JButton("Update Account Details");
		btnUpdateAccountDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("hello world..");
			}
		});
		btnUpdateAccountDetails.setBounds(116, 221, 181, 23);
		panel.add(btnUpdateAccountDetails);
		
		lblProfile = new JLabel("Profile:");
		lblProfile.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblProfile, BorderLayout.NORTH);
	}
}
