package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class tocsv extends JPanel {
	private JTextField textField;
	
	Connect c;
	
	public Connect getC() {
		return c;
	}
	/**
	 * Create the panel.
	 */
	public tocsv(Connect con) {
		Connect c=new Connect();
		c.setData(con.data);
		setBackground(new Color(250, 235, 215));
		setLayout(null);
		
		JLabel lblExportCsvFile = new JLabel("Export CSV file");
		lblExportCsvFile.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExportCsvFile.setBounds(50, 54, 249, 27);
		add(lblExportCsvFile);
		
		JLabel label = new JLabel("Path:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(50, 118, 37, 27);
		add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(92, 122, 207, 20);
		add(textField);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(68, 231, 295, 27);
		add(label_1);
		
		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				c.writeCSV(name);
				label_1.setText("The CSV file wab created");
			}
		});
		btnExport.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExport.setBackground(UIManager.getColor("Button.background"));
		btnExport.setBounds(304, 186, 100, 23);
		add(btnExport);
		
	

	}

}
