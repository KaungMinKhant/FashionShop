package main;

import java.awt.BorderLayout;

import java.sql.*;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import dbConnection.brandDB;
import dbConnection.category;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class categoryTable extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					categoryTable frame = new categoryTable();
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
	public categoryTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		category showResult = new category();
		
		try {
			ResultSet rs;
			rs = showResult.showData();
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
			JTable table = new JTable(data, column);
			table.setBounds(1, 1, 498, 0);
			contentPane.add(table);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(2, 5, 500, 400);
			getContentPane().add(scrollPane);
			
			JButton btnNewButton = new JButton("Edit");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int current = table.getSelectedRow();
					int y = JOptionPane.showConfirmDialog(null, "Are you srue you want to edit???");
					if(y == 0) {
						String id = String.valueOf(table.getModel().getValueAt(current, 0));
						String category_name = String.valueOf(table.getModel().getValueAt(current, 1));
						try {
							showResult.editData(id, category_name);
							rtable();
						}
						catch(Exception ex) {
							System.out.println(ex);
						}
					}
					else {
						System.out.println("Error");
					}
				}
			});
			
			btnNewButton.setBounds(29, 421, 89, 23);
			contentPane.add(btnNewButton);
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int current = table.getSelectedRow();
					int y = JOptionPane.showConfirmDialog(null, "Are you sure do you want to delete?");
					if(y == 0) {
						String id = String.valueOf(table.getModel().getValueAt(current, 0));
						try {
							showResult.deleteData(id);
							rtable();
						}
						catch(Exception ex) {
							System.out.println(ex);
						}
					}
					else {
						System.out.println("Error");
					}
				}
			});
			btnDelete.setBounds(135, 421, 89, 23);
			contentPane.add(btnDelete);
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		
		
	}
	
	public void rtable() {
		
		try {
			category showResult = new category();
			ResultSet rs;
			rs = showResult.showData();
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
			JTable table = new JTable(data, column);
			table.setBounds(1, 1, 498, 0);
			contentPane.add(table);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(5, 5, 500, 400);
			getContentPane().add(scrollPane);
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
}
