package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbConnection.brandDB;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class brandForm extends JFrame {

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
					brandForm frame = new brandForm();
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
	public brandForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBrandId = new JLabel("Brand ID");
		lblBrandId.setBounds(82, 49, 46, 14);
		contentPane.add(lblBrandId);
		
		textField = new JTextField();
		textField.setBounds(185, 46, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBrandName = new JLabel("Brand Name");
		lblBrandName.setBounds(82, 86, 74, 14);
		contentPane.add(lblBrandName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(185, 83, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = textField_1.getText();
				brandDB brand = new brandDB();
				brand.insertData(name);
			}
		});
		btnSubmit.setBounds(304, 211, 89, 23);
		contentPane.add(btnSubmit);
	}

}
