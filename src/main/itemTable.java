package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import dbConnection.item;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class itemTable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					itemTable frame = new itemTable();
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
	public itemTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		item item = new item();
		try {
			ResultSet rs;
			rs = item.showData();
			java.sql.ResultSetMetaData rsmt = rs.getMetaData();
			int c = rsmt.getColumnCount();
			Vector column = new Vector(c);
			for(int i = 1; i <= c; i++) {
				column.add(rsmt.getColumnName(i));
			}
			Vector data = new Vector();
			Vector row = new Vector();
			while(rs.next()) {
				row = new Vector(c);
				for(int i = 1; i <= c; i++) {
					row.add(rs.getString(i));
				}
				data.add(row);
			}
			contentPane.setLayout(null);
			contentPane.setLayout(null);
			JTable table = new JTable(data, column);
			table.setBounds(1, 1, 498, 0);
			contentPane.add(table);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(2 , 5, 500, 400);
			getContentPane().add(scrollPane);
			
			textField = new JTextField();
			textField.setBounds(41, 423, 86, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String result_key = textField.getText();
					
					searchResult result_form = new searchResult(result_key);
					result_form.setVisible(true);
				}
			});
			btnSearch.setBounds(141, 422, 89, 23);
			contentPane.add(btnSearch);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
