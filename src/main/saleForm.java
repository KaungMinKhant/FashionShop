package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class saleForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					saleForm frame = new saleForm();
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
	public saleForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSaleId = new JLabel("Sale ID");
		lblSaleId.setBounds(10, 11, 46, 14);
		contentPane.add(lblSaleId);
		
		textField = new JTextField();
		textField.setBounds(67, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDateOfSale = new JLabel("Date of Sale");
		lblDateOfSale.setBounds(250, 11, 96, 14);
		contentPane.add(lblDateOfSale);
		
		textField_1 = new JTextField();
		textField_1.setBounds(326, 8, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblItemId = new JLabel("Item ID");
		lblItemId.setBounds(107, 58, 46, 14);
		contentPane.add(lblItemId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(209, 55, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(107, 96, 61, 14);
		contentPane.add(lblQuantity);
		
		textField_3 = new JTextField();
		textField_3.setBounds(209, 93, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(107, 141, 46, 14);
		contentPane.add(lblAmount);
		
		textField_4 = new JTextField();
		textField_4.setBounds(209, 138, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(307, 208, 89, 23);
		contentPane.add(btnSubmit);
	}
}
