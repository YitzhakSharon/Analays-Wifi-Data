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

public class tokml extends JPanel {
	private JTextField textField;
	
	Connect c;
	
	public Connect getC() {
		return c;
	}

	/**
	 * Create the panel.
	 */
	public tokml(Connect con) {
		Connect c=new Connect();
		c.setData(con.data);
		setBackground(new Color(250, 235, 215));
		setLayout(null);
		
		JLabel lblExportKmlFile = new JLabel("Export KML file");
		lblExportKmlFile.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExportKmlFile.setBounds(32, 41, 249, 27);
		add(lblExportKmlFile);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(105, 121, 207, 20);
		add(textField);
		
		JLabel label = new JLabel("Path:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(58, 117, 37, 27);
		add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(58, 227, 295, 27);
		add(label_1);
		
		JButton button = new JButton("Export");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				c.saveinkml(name);
				label_1.setText("The KML file wab created");
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(UIManager.getColor("Button.background"));
		button.setBounds(279, 183, 100, 23);
		add(button);
		
	

	}

}
