package org.FoodMngtSys.view;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import org.FoodMngtSys.model.FoodItem;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.JRadioButton;

public class DonationForm {

	private JFrame frame;
	private JTextField txtDateOfDonation;
	private JTextField txtPincode;
	private JTextField txtFoodName;
	private JTextField txtFoodQuantity;
	private JTextField txtExpDate;
	private JTextField txtMfgDate;
	private JButton btnAddItem;
	private JButton btnRemoveItem;
	private JButton btnConfirmDonation;
	private JPanel pnlList;
	private JPanel pnlItems;
	private JRadioButton rdbtnSmallScale;
	private JRadioButton rdbtnLargeScale ;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonationForm window = new DonationForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public JRadioButton getRdbtnSmallScale() {
		return rdbtnSmallScale;
	}

	public JRadioButton getRdbtnLargeScale() {
		return rdbtnLargeScale;
	}

	/**
	 * Create the application.
	 */
	public DonationForm() {
		initialize();
	}

	public void setVisiblity(boolean val){
		frame.setVisible(val);
	}
	
	public void setBehaviours(ActionListener listen){
		btnAddItem.addActionListener(listen);
		btnConfirmDonation.addActionListener(listen);
		btnRemoveItem.addActionListener(listen);
	}
	
	public void addItemInList(JPanel Item){
		pnlItems.add(Item);
	}
	
	public void removeItemFromList(JPanel Item){
		pnlItems.remove(Item);
	}
	
	public void setPnlItemsVisible(boolean val){
		pnlItems.setVisible(val);
	}
	
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblDonationForm = new JLabel("Donation Form");
		lblDonationForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonationForm.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(lblDonationForm, BorderLayout.NORTH);
		
		JPanel pnlDetails = new JPanel();
		frame.getContentPane().add(pnlDetails, BorderLayout.CENTER);
		pnlDetails.setLayout(null);
		
		JLabel lblDateOfDonation = new JLabel("Date of Donation:");
		lblDateOfDonation.setBounds(56, 24, 130, 14);
		pnlDetails.add(lblDateOfDonation);
		
		txtDateOfDonation = new JTextField();
		txtDateOfDonation.setText("DD/MM/YYYY");
		txtDateOfDonation.setBounds(238, 21, 86, 20);
		pnlDetails.add(txtDateOfDonation);
		txtDateOfDonation.setColumns(10);
		
		JLabel lblPincodeOfArea = new JLabel("PinCode of Area:");
		lblPincodeOfArea.setBounds(56, 49, 130, 14);
		pnlDetails.add(lblPincodeOfArea);
		
		txtPincode = new JTextField();
		txtPincode.setBounds(238, 46, 86, 20);
		pnlDetails.add(txtPincode);
		txtPincode.setColumns(10);
		
		JLabel lblEnterFoodItems = new JLabel("Enter food items you want to add to your donation");
		lblEnterFoodItems.setBounds(10, 74, 414, 20);
		pnlDetails.add(lblEnterFoodItems);
		
		JLabel lblFoodItemName = new JLabel("Food Item Name:");
		lblFoodItemName.setBounds(56, 105, 130, 14);
		pnlDetails.add(lblFoodItemName);
		
		txtFoodName = new JTextField();
		txtFoodName.setBounds(238, 102, 130, 20);
		pnlDetails.add(txtFoodName);
		txtFoodName.setColumns(10);
		
		JLabel lblQuantitynoOfPersons = new JLabel("Quantity(no of persons):");
		lblQuantitynoOfPersons.setBounds(56, 136, 130, 14);
		pnlDetails.add(lblQuantitynoOfPersons);
		
		txtFoodQuantity = new JTextField();
		txtFoodQuantity.setBounds(238, 133, 86, 20);
		pnlDetails.add(txtFoodQuantity);
		txtFoodQuantity.setColumns(10);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date:");
		lblExpiryDate.setBounds(56, 161, 130, 14);
		pnlDetails.add(lblExpiryDate);
		
		txtExpDate = new JTextField();
		txtExpDate.setText("DD/MM/YYYY");
		txtExpDate.setBounds(238, 158, 86, 20);
		pnlDetails.add(txtExpDate);
		txtExpDate.setColumns(10);
		
		JLabel lblManufractureDate = new JLabel("Manufracture Date:");
		lblManufractureDate.setBounds(56, 186, 130, 14);
		pnlDetails.add(lblManufractureDate);
		
		txtMfgDate = new JTextField();
		txtMfgDate.setText("DD/MM/YYYY");
		txtMfgDate.setBounds(238, 183, 86, 20);
		pnlDetails.add(txtMfgDate);
		txtMfgDate.setColumns(10);
		
		btnAddItem = new JButton("Add Item");
		
		btnAddItem.setBounds(97, 235, 107, 23);
		pnlDetails.add(btnAddItem);
		
		btnRemoveItem = new JButton("Remove Item");
		
		btnRemoveItem.setBounds(238, 235, 107, 23);
		pnlDetails.add(btnRemoveItem);
		
		btnConfirmDonation = new JButton("Confirm Donation");
		btnConfirmDonation.setBounds(136, 301, 154, 23);
		pnlDetails.add(btnConfirmDonation);
		
		JLabel lblTypeOfDonation = new JLabel("Type of donation:");
		lblTypeOfDonation.setBounds(56, 211, 130, 14);
		pnlDetails.add(lblTypeOfDonation);
		
		rdbtnSmallScale = new JRadioButton("Small Scale ");
		rdbtnSmallScale.setBounds(173, 207, 100, 23);
		pnlDetails.add(rdbtnSmallScale);
		
		rdbtnLargeScale = new JRadioButton("Large Scale");
		rdbtnLargeScale.setBounds(275, 207, 109, 23);
		pnlDetails.add(rdbtnLargeScale);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnLargeScale);
		group.add(rdbtnSmallScale);
		
		pnlList = new JPanel();
		frame.getContentPane().add(pnlList, BorderLayout.SOUTH);
		pnlList.setLayout(new BorderLayout(0, 0));
		
		JLabel lblListOfItems = new JLabel("List of Items of your Donation");
		pnlList.add(lblListOfItems, BorderLayout.NORTH);
		
		pnlItems = new JPanel();
		pnlList.add(pnlItems, BorderLayout.CENTER);
		pnlItems.setLayout(new GridLayout(0, 1));
		pnlItems.setVisible(true);
		
	}

	public String getTxtDateOfDonation() {
		return txtDateOfDonation.getText();
	}

	public void setTxtDateOfDonation(String txtDateOfDonation) {
		this.txtDateOfDonation.setText(txtDateOfDonation);
	}

	public String getTxtPincode() {
		return txtPincode.getText();
	}

	public void setTxtPincode(String txtPincode) {
		this.txtPincode.setText(txtPincode);
	}

	public String getTxtFoodName() {
		return txtFoodName.getText();
	}

	public void setTxtFoodName(String txtFoodName) {
		this.txtFoodName.setText(txtFoodName);
	}

	public String getTxtFoodQuantity() {
		return txtFoodQuantity.getText();
	}

	public void setTxtFoodQuantity(String txtFoodQuantity) {
		this.txtFoodQuantity.setText(txtFoodQuantity);
	}

	public String getTxtExpDate() {
		return txtExpDate.getText();
	}

	public void setTxtExpDate(String txtExpDate) {
		this.txtExpDate.setText(txtExpDate);
	}

	public String getTxtMfgDate() {
		return txtMfgDate.getText();
	}

	public void setTxtMfgDate(String txtMfgDate) {
		this.txtMfgDate.setText(txtMfgDate);
	}
}
