package org.FoodMngtSys.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.FoodMngtSys.controller.LoginScreenController;
import org.FoodMngtSys.controller.SignUpScreenController;
import org.FoodMngtSys.model.Account;
import org.FoodMngtSys.model.DBStorage;
import org.FoodMngtSys.model.Donor;
import org.FoodMngtSys.model.Receiver;
import org.FoodMngtSys.model.Stall;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;

public class LoginScreen {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblEnterYourId;
	private JButton btnLogin;
	private JButton btnSignUp;

	public JButton getBtnLogin() {
		return btnLogin;
	}
	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}
	
	public void setBehaviour(ActionListener listen){
		btnLogin.addActionListener(listen);
		btnSignUp.addActionListener(listen);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LoginScreen window;
		ArrayList<Account> acc =DBStorage.getAllAccounts();
		//acc.add(new Donor("het","hh", "hh", "hh", "hh", "hh", "hh", "hetj", "hetj", new Date()));
		//acc.add(new Receiver("bet","hh", "hh", "hh", "hh", "hh", "hh", "hetk", "hetk", new Date()));
		ArrayList<Stall> stl = new ArrayList<>();
		stl.add(new Stall("359007"));
		stl.add(new Stall("360001"));
		
		window = new LoginScreen();
		window.frame.setVisible(true);
		LoginScreenController controlLogin = new LoginScreenController(acc,window,stl);
			
	}
	
	public JLabel getLblEnterYourId() {
		return lblEnterYourId;
	}

	public void setLblEnterYourId(JLabel lblEnterYourId) {
		this.lblEnterYourId = lblEnterYourId;
	}

	/**
	 * Create the application.
	 */
	
	public String getLoginID(){
		return this.textField.getText();
	}
	
	public String getPassword(){
		return this.passwordField.getText();
	}
	
	public LoginScreen() {
		initialize();
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
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(102, 87, 46, 20);
		panel.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(171, 87, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(102, 118, 59, 26);
		panel.add(lblPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(168, 177, 89, 23);
		panel.add(btnLogin);
		
		btnSignUp = new JButton("Sign up");
		btnSignUp.setBounds(168, 206, 89, 23);
		panel.add(btnSignUp);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 121, 86, 20);
		panel.add(passwordField);
		
		lblEnterYourId = new JLabel("Enter your ID and Password");
		lblEnterYourId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterYourId.setBounds(102, 43, 235, 33);
		panel.add(lblEnterYourId);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblLoginScreen = new JLabel("Login Screen");
		lblLoginScreen.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLoginScreen.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_1.add(lblLoginScreen);
	}
}
