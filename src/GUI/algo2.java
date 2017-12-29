package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class algo2 extends JPanel {
	private JTextField txtCsvFormat;
	
	Connect c;
	
	public Connect getC() {
		return c;
	}

	/**
	 * Create the panel.
	 */
	public algo2(Connect con) {
		Connect c=new Connect();
		c.setData(con.data);
		setBackground(new Color(250, 235, 215));
		setLayout(null);
		
		JLabel lblAlgorithem = new JLabel("Algorithem 2 - Path of csv");
		lblAlgorithem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlgorithem.setBounds(38, 56, 336, 27);
		add(lblAlgorithem);
		
		JLabel lblPath = new JLabel("Path:");
		lblPath.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPath.setBounds(58, 123, 37, 27);
		add(lblPath);
		
		txtCsvFormat = new JTextField();
		txtCsvFormat.setText("csv format");
		txtCsvFormat.setColumns(10);
		txtCsvFormat.setBounds(105, 127, 187, 20);
		add(txtCsvFormat);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(38, 231, 356, 27);
		add(lblNewLabel);
		
		JButton button = new JButton("Srart");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String path = txtCsvFormat.getText();
				c.algoritem2a(path);
				lblNewLabel.setText("resutlt_algo2.csv was created check workspace");
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(UIManager.getColor("Button.highlight"));
		button.setBounds(262, 185, 89, 23);
		add(button);
		


	}

}
