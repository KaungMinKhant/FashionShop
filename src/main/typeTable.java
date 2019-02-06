package main;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import dbConnection.category;
import dbConnection.type;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class typeTable extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					typeTable frame = new typeTable();
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
	public typeTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		type type = new type();
		try {
			ResultSet rs;
			rs = type.showType();
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
			scrollPane.setBounds(94, 49, 390, 129);
			getContentPane().add(scrollPane);
			
			JButton btnEdit = new JButton("Edit");
			btnEdit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int current = table.getSelectedRow();
					int y = JOptionPane.showConfirmDialog(null, "Are you srue you want to edit???");
					if(y == 0) {
						String id = String.valueOf(table.getModel().getValueAt(current, 0));
						String category_name = String.valueOf(table.getModel().getValueAt(current, 1));
						try {
							type.updateData(id, category_name);
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
			btnEdit.setBounds(131, 206, 89, 23);
			contentPane.add(btnEdit);
		}
		catch(Exception ex) {
			
		}
	}
	public void rtable() {
		
		try {
			type type = new type();
			ResultSet rs;
			rs = type.showType();
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
			scrollPane.setBounds(94, 49, 390, 129);
			getContentPane().add(scrollPane);
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}

}
