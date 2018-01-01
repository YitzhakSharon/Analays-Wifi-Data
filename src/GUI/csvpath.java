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

public class csvpath extends JPanel {
	private JTextField textField;
	
	Connect c;
	
	public Connect getC() {
		return c;
	}







	/**
	 * Create the panel.
	 */
	public csvpath(Connect con) {
		Connect c=new Connect();
		c.setData(con.data);
		setBackground(new Color(250, 235, 215));
		setLayout(null);
		
		JLabel lblReadDatabaseFrom = new JLabel("Read Database from Csv file");
		lblReadDatabaseFrom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReadDatabaseFrom.setBounds(34, 54, 249, 27);
		add(lblReadDatabaseFrom);
		
		JLabel label = new JLabel("Path:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(47, 125, 37, 27);
		add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(104, 129, 207, 20);
		add(textField);
		
		JLabel label_1 = new JLabel("Number of Scan: " + c.data.getDatabase().size());
		label_1.setBounds(58, 216, 295, 27);
		add(label_1);
		
		JLabel label_2 = new JLabel("Number of Macs: " + c.data.getHash_map().size());
		label_2.setBounds(58, 254, 295, 27);
		add(label_2);
		
		JButton btnInsert = new JButton("Insert Database");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = textField.getText();
				Database data = c.readCSv(path);
				label_1 .setText("Number of Scan: " + data.getDatabase().size());
				label_2.setText("Number of Macs: " + data.getHash_map().size());
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInsert.setBackground(UIManager.getColor("Button.background"));
		btnInsert.setBounds(213, 182, 158, 23);
		add(btnInsert);
		
	

	}

}
