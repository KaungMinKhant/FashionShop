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

public class searchResult extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchResult frame = new searchResult(null);
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
	public searchResult(String search) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		item item = new item();
		try {
			ResultSet rs;
			rs = item.search(search);
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
			scrollPane.setBounds(2, 5, 500, 400);
			getContentPane().add(scrollPane);

		}
		catch(Exception ex){
			
		}
	}

}
