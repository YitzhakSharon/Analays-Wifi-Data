package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import object.Database;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class folderpath extends JPanel{
	private JTextField textField;
	
	Connect c;
	
	public Connect getC() {
		return c;
	}

	/**
	 * Create the panel.
	 */
	public folderpath(Connect con) {
		Connect c=new Connect();
		c.setData(con.data);
		setBackground(new Color(250, 235, 215));
		setLayout(null);
		
		JLabel lblReadDatabaseFrom = new JLabel("Read Database from folder");
		lblReadDatabaseFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReadDatabaseFrom.setBounds(48, 54, 249, 27);
		add(lblReadDatabaseFrom);
		
		JLabel lblPath = new JLabel("Path:");
		lblPath.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPath.setBounds(55, 119, 37, 27);
		add(lblPath);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(102, 123, 207, 20);
		add(textField);
		
		JLabel lblScans = new JLabel("Number of Scan: " + c.data.getDatabase().size());
		lblScans.setBounds(48, 207, 295, 27);
		add(lblScans);
		
		JLabel lblNumberOfMacs = new JLabel("Number of Macs: " + c.data.getHash_map().size());
		lblNumberOfMacs.setBounds(48, 244, 295, 27);
		add(lblNumberOfMacs);
		
		JButton btnInsert = new JButton("Insert Database");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path =textField.getText();
				Database data = c.enterdatabase(path);
				lblScans.setText("Number of Scan: " + data.getDatabase().size());
				lblNumberOfMacs.setText("Number of Macs: " + data.getHash_map().size());
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInsert.setBackground(UIManager.getColor("Button.background"));
		btnInsert.setBounds(234, 173, 158, 23);
		add(btnInsert);
		
	
		
		

	}

}
