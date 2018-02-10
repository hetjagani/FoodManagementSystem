package org.FoodMngtSys.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class FoodItemsView {

	private JFrame frame;
	private JPanel pnlList;
	private FoodEntryView foodEntry = new FoodEntryView("Food-ID","Food-Name", "Quantity(no of persons)", "Mfg-Date", "Exp-Date");
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodItemsView window = new FoodItemsView();
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
	
	public void addFoodEntry (JPanel pnl){
		pnlList.add(pnl);
	}
	
	public void setVisiblity(boolean val){
		frame.setVisible(val);
	}
	
	public FoodItemsView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		JLabel lblFoodItems = new JLabel("Food Items");
		lblFoodItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoodItems.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(lblFoodItems, BorderLayout.NORTH);
		
		pnlList = new JPanel();
		pnlList.setLayout(new GridLayout(0, 1));
		frame.getContentPane().add(pnlList, BorderLayout.CENTER);
		pnlList.add(foodEntry);
		foodEntry.setVisible(true);
	}

}
