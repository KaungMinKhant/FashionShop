package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbConnection.item;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class itemForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					itemForm frame = new itemForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public itemForm() {
		item item = new item();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(101, 26, 67, 14);
		contentPane.add(lblItemName);
		
		textField = new JTextField();
		textField.setBounds(195, 23, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(101, 62, 46, 14);
		contentPane.add(lblPrice);
		
		textField_2 = new JTextField();
		textField_2.setBounds(195, 59, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(101, 87, 46, 14);
		contentPane.add(lblStock);
		
		textField_3 = new JTextField();
		textField_3.setBounds(195, 84, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblBrandId = new JLabel("Brand");
		lblBrandId.setBounds(101, 110, 67, 14);
		contentPane.add(lblBrandId);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(195, 107, 86, 20);
		contentPane.add(comboBox);
		comboBox.addItem(" ");
		ResultSet ans = item.getBrand();
		try {
			while(ans.next()) {
				comboBox.addItem(ans.getString("brand_name"));
			}
		}
		catch(Exception ex) {
			
		}
		comboBox.setSelectedIndex(-1);
		
		
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(101, 141, 84, 14);
		contentPane.add(lblCategory);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(195, 138, 86, 20);
		contentPane.add(comboBox_1);
		comboBox_1.addItem(" ");
		ResultSet ans1 = item.getCategory();
		try {
			while(ans1.next()) {
				comboBox_1.addItem(ans1.getString("category_name"));
			}
		}
		catch(Exception ex) {
			
		}
		comboBox_1.setSelectedIndex(-1);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(101, 171, 46, 14);
		contentPane.add(lblType);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(195, 169, 86, 20);
		contentPane.add(comboBox_2);
		comboBox_2.addItem(" ");
		ResultSet ans2 = item.getType();
		try {
			while(ans2.next()) {
				comboBox_2.addItem(ans2.getString("type_name"));
			}
		}
		catch(Exception ex) {
			
		}
		comboBox_2.setSelectedIndex(-1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = textField.getText();
				String price = textField_2.getText();
				String stock = textField_3.getText();
				String brand = (String) comboBox.getSelectedItem();
				String category = (String) comboBox_1.getSelectedItem();
				String type = (String) comboBox_2.getSelectedItem();
				item.insertData(name, price, stock, brand, category, type);
				
			}
		});
		btnSubmit.setBounds(319, 207, 89, 23);
		contentPane.add(btnSubmit);
	}
}
