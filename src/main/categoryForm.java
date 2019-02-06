package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbConnection.category;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class categoryForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					categoryForm frame = new categoryForm();
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
	public categoryForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCategoryId = new JLabel("Category ID");
		lblCategoryId.setBounds(107, 72, 125, 14);
		contentPane.add(lblCategoryId);
		
		textField = new JTextField();
		textField.setBounds(214, 69, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCategoryName = new JLabel("Category Name");
		lblCategoryName.setBounds(107, 108, 107, 14);
		contentPane.add(lblCategoryName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(214, 105, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = textField_1.getText();
				category categoryName = new category();
				categoryName.insertData(name);
			}
		});
		btnSubmit.setBounds(310, 169, 89, 23);
		contentPane.add(btnSubmit);
	}
}
