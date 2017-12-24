package GUI;

import java.awt.EventQueue;
import com.toedter.calendar.JCalendar;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import com.toedter.calendar.JDateChooser;

import Algoritem.Algoritem;
import Files.FileCsv;
import Files.FileKml;
import Filter.Filter;
import object.Database;
import object.Scan;
import GUI.Connect;

import javax.swing.JTextArea;

public class gui {

	protected static final String Connect = null;
	private JFrame frame;
	private JTextField txtEnterId_1;
	private JTextField txtEnterRadius;
	private JTextField txtEnterLat;
	private JTextField txtEnterLon;
	private JTextField txtEnterMinTime;
	private JTextField txtEnterMaxTime;
	private JTextField txtEnterPathTo;
	private JTextField txtEnterMac;
	private JTextField txtEnterMac_2;
	private JTextField txtEnterMac_1;
	private JTextField txtEnterSignal;
	private JTextField txtEnterSignal_2;
	private JTextField txtEnterSignal_1;
	private JTextField txtEnterMac_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}
	/*
	 * 	btnAlgorithms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connect con=new Connect();
				String path=txtEnterPathTo.getText();
				String mac=txtEnterMac_3.getText();
				con.algoritem1(mac);
			    con.algoritem2path(path);

			}
		});
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 255, 255));
		frame.setFont(new Font("Engravers MT", Font.BOLD, 16));
		frame.setBounds(100, 100, 1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JButton btnFilters = new JButton("Filters");
		springLayout.putConstraint(SpringLayout.NORTH, btnFilters, 104, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnFilters, 440, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnFilters, -416, SpringLayout.EAST, frame.getContentPane());
		btnFilters.setBackground(UIManager.getColor("Button.background"));
		btnFilters.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(btnFilters);
		
		JTextPane txtpnTime = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnTime, 172, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnTime, -264, SpringLayout.SOUTH, frame.getContentPane());
		txtpnTime.setForeground(new Color(128, 0, 0));
		txtpnTime.setBackground(new Color(255, 250, 250));
		txtpnTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnTime.setText("   Time");
		frame.getContentPane().add(txtpnTime);
		
		JTextPane txtpnId = new JTextPane();
		springLayout.putConstraint(SpringLayout.SOUTH, btnFilters, -36, SpringLayout.NORTH, txtpnId);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnId, 0, SpringLayout.SOUTH, txtpnTime);
		springLayout.putConstraint(SpringLayout.EAST, txtpnId, -430, SpringLayout.EAST, frame.getContentPane());
		txtpnId.setText("     ID");
		txtpnId.setForeground(new Color(128, 0, 0));
		txtpnId.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnId.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnId);
		
		JTextPane txtpnPlace = new JTextPane();
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnPlace, 0, SpringLayout.SOUTH, txtpnTime);
		springLayout.putConstraint(SpringLayout.EAST, txtpnPlace, -306, SpringLayout.EAST, frame.getContentPane());
		txtpnPlace.setText("  Place");
		txtpnPlace.setForeground(new Color(128, 0, 0));
		txtpnPlace.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnPlace.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnPlace);
		
		JCheckBox checkBox = new JCheckBox("");
		springLayout.putConstraint(SpringLayout.WEST, txtpnTime, 6, SpringLayout.EAST, checkBox);
		springLayout.putConstraint(SpringLayout.NORTH, checkBox, 172, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, checkBox, -632, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		springLayout.putConstraint(SpringLayout.WEST, txtpnId, 6, SpringLayout.EAST, checkBox_1);
		springLayout.putConstraint(SpringLayout.EAST, checkBox_1, -507, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtpnTime, -27, SpringLayout.WEST, checkBox_1);
		springLayout.putConstraint(SpringLayout.NORTH, checkBox_1, 0, SpringLayout.NORTH, txtpnTime);
		frame.getContentPane().add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("");
		springLayout.putConstraint(SpringLayout.EAST, checkBox_2, -383, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtpnPlace, 6, SpringLayout.EAST, checkBox_2);
		springLayout.putConstraint(SpringLayout.NORTH, checkBox_2, 0, SpringLayout.NORTH, txtpnTime);
		frame.getContentPane().add(checkBox_2);
		
		txtEnterId_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEnterId_1, 17, SpringLayout.SOUTH, txtpnId);
		springLayout.putConstraint(SpringLayout.WEST, txtEnterId_1, 0, SpringLayout.WEST, checkBox_1);
		springLayout.putConstraint(SpringLayout.EAST, txtEnterId_1, -14, SpringLayout.EAST, btnFilters);
		txtEnterId_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterId_1.setText("     Enter ID");
		txtEnterId_1.setColumns(10);
		frame.getContentPane().add(txtEnterId_1);
		
		txtEnterRadius = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEnterRadius, 0, SpringLayout.NORTH, txtEnterId_1);
		springLayout.putConstraint(SpringLayout.WEST, txtEnterRadius, 0, SpringLayout.WEST, checkBox_2);
		springLayout.putConstraint(SpringLayout.EAST, txtEnterRadius, -306, SpringLayout.EAST, frame.getContentPane());
		txtEnterRadius.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterRadius.setText("  Enter Radius");
		txtEnterRadius.setColumns(10);
		frame.getContentPane().add(txtEnterRadius);
		
		txtEnterLat = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEnterLat, 6, SpringLayout.SOUTH, txtEnterRadius);
		springLayout.putConstraint(SpringLayout.WEST, txtEnterLat, 0, SpringLayout.WEST, checkBox_2);
		springLayout.putConstraint(SpringLayout.EAST, txtEnterLat, -306, SpringLayout.EAST, frame.getContentPane());
		txtEnterLat.setText("      Enter Lat");
		txtEnterLat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterLat.setColumns(10);
		frame.getContentPane().add(txtEnterLat);
		
		txtEnterLon = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEnterLon, 6, SpringLayout.SOUTH, txtEnterLat);
		springLayout.putConstraint(SpringLayout.WEST, txtEnterLon, 0, SpringLayout.WEST, checkBox_2);
		springLayout.putConstraint(SpringLayout.EAST, txtEnterLon, -306, SpringLayout.EAST, frame.getContentPane());
		txtEnterLon.setText("      Enter Lon");
		txtEnterLon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterLon.setColumns(10);
		frame.getContentPane().add(txtEnterLon);
		
		txtEnterMinTime = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEnterMinTime, -1, SpringLayout.NORTH, txtEnterLon);
		springLayout.putConstraint(SpringLayout.WEST, txtEnterMinTime, 0, SpringLayout.WEST, checkBox);
		springLayout.putConstraint(SpringLayout.EAST, txtEnterMinTime, -555, SpringLayout.EAST, frame.getContentPane());
		txtEnterMinTime.setText("   hh:mm:ss");
		txtEnterMinTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEnterMinTime.setColumns(10);
		frame.getContentPane().add(txtEnterMinTime);
		
		txtEnterMaxTime = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEnterMaxTime, 359, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtEnterMaxTime, 331, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtEnterMaxTime, 0, SpringLayout.EAST, txtpnTime);
		txtEnterMaxTime.setText("   hh:mm:ss");
		txtEnterMaxTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEnterMaxTime.setColumns(10);
		frame.getContentPane().add(txtEnterMaxTime);
		
		JButton btnCancelFilters = new JButton("Cancel filters");
		springLayout.putConstraint(SpringLayout.NORTH, btnCancelFilters, -73, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnCancelFilters, 440, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnCancelFilters, -48, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCancelFilters, 0, SpringLayout.EAST, btnFilters);
		btnCancelFilters.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelFilters.setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().add(btnCancelFilters);
		
		JTextPane txtpnAlgo = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnAlgo, 0, SpringLayout.NORTH, txtpnTime);
		txtpnAlgo.setText("     Algo 1");
		txtpnAlgo.setForeground(new Color(128, 0, 0));
		txtpnAlgo.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnAlgo.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnAlgo);
		

		JCheckBox checkBox_3 = new JCheckBox("");
		springLayout.putConstraint(SpringLayout.EAST, txtpnAlgo, 95, SpringLayout.EAST, checkBox_3);
		springLayout.putConstraint(SpringLayout.EAST, checkBox_3, -173, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtpnAlgo, 6, SpringLayout.EAST, checkBox_3);
		springLayout.putConstraint(SpringLayout.NORTH, checkBox_3, 0, SpringLayout.NORTH, txtpnTime);
		frame.getContentPane().add(checkBox_3);

		
		JButton btnAlgorithms = new JButton("Algorithms");
		springLayout.putConstraint(SpringLayout.NORTH, btnAlgorithms, 0, SpringLayout.NORTH, btnFilters);
		springLayout.putConstraint(SpringLayout.WEST, btnAlgorithms, -211, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnAlgorithms, 0, SpringLayout.SOUTH, btnFilters);
		springLayout.putConstraint(SpringLayout.EAST, btnAlgorithms, -89, SpringLayout.EAST, frame.getContentPane());
		btnAlgorithms.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAlgorithms.setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().add(btnAlgorithms);
		
		
		JCheckBox checkBox_4 = new JCheckBox("");
		springLayout.putConstraint(SpringLayout.SOUTH, checkBox_4, 0, SpringLayout.SOUTH, txtEnterLat);
		springLayout.putConstraint(SpringLayout.EAST, checkBox_4, 0, SpringLayout.EAST, checkBox_3);
		frame.getContentPane().add(checkBox_4);
		
		JTextPane txtpnAlgo_1 = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtpnAlgo_1, 0, SpringLayout.WEST, txtpnAlgo);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnAlgo_1, 0, SpringLayout.SOUTH, txtEnterLat);
		springLayout.putConstraint(SpringLayout.EAST, txtpnAlgo_1, 0, SpringLayout.EAST, txtpnAlgo);
		txtpnAlgo_1.setText("     Algo 2");
		txtpnAlgo_1.setForeground(new Color(128, 0, 0));
		txtpnAlgo_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnAlgo_1.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnAlgo_1);
		
		JButton btnDatabase = new JButton("DataBase");
		springLayout.putConstraint(SpringLayout.EAST, btnDatabase, 195, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnDatabase, 0, SpringLayout.NORTH, btnFilters);
		springLayout.putConstraint(SpringLayout.WEST, btnDatabase, 67, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnDatabase, 0, SpringLayout.SOUTH, btnFilters);
		btnDatabase.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDatabase.setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().add(btnDatabase);
		
		JDateChooser dateChooser = new JDateChooser();
		springLayout.putConstraint(SpringLayout.WEST, dateChooser, 0, SpringLayout.WEST, checkBox);
		springLayout.putConstraint(SpringLayout.SOUTH, dateChooser, 0, SpringLayout.SOUTH, txtEnterLat);
		springLayout.putConstraint(SpringLayout.EAST, dateChooser, 0, SpringLayout.EAST, txtpnTime);
		frame.getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		springLayout.putConstraint(SpringLayout.WEST, dateChooser_1, 0, SpringLayout.WEST, checkBox);
		springLayout.putConstraint(SpringLayout.SOUTH, dateChooser_1, -6, SpringLayout.NORTH, txtEnterMaxTime);
		springLayout.putConstraint(SpringLayout.EAST, dateChooser_1, 0, SpringLayout.EAST, txtpnTime);
		frame.getContentPane().add(dateChooser_1);
		
		JTextPane txtpnMin = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnMin, -25, SpringLayout.SOUTH, txtEnterId_1);
		springLayout.putConstraint(SpringLayout.WEST, txtpnMin, 0, SpringLayout.WEST, txtpnTime);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnMin, 0, SpringLayout.SOUTH, txtEnterId_1);
		springLayout.putConstraint(SpringLayout.EAST, txtpnMin, -70, SpringLayout.WEST, txtEnterId_1);
		txtpnMin.setText("Min");
		txtpnMin.setForeground(new Color(0, 0, 0));
		txtpnMin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnMin.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnMin);
		
		JTextPane txtpnMax = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtpnMax, 0, SpringLayout.WEST, txtpnTime);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnMax, -6, SpringLayout.NORTH, dateChooser_1);
		txtpnMax.setText("Max");
		txtpnMax.setForeground(Color.BLACK);
		txtpnMax.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnMax.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnMax);
		
		txtEnterPathTo = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEnterPathTo, 0, SpringLayout.NORTH, txtEnterLon);
		springLayout.putConstraint(SpringLayout.WEST, txtEnterPathTo, 0, SpringLayout.WEST, btnAlgorithms);
		springLayout.putConstraint(SpringLayout.EAST, txtEnterPathTo, -37, SpringLayout.EAST, frame.getContentPane());
		txtEnterPathTo.setText("      Enter Path to CSV File");
		txtEnterPathTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterPathTo.setColumns(10);
		frame.getContentPane().add(txtEnterPathTo);
		
		JTextPane txtpnOr = new JTextPane();
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnOr, 0, SpringLayout.SOUTH, txtpnMax);
		springLayout.putConstraint(SpringLayout.EAST, txtpnOr, -119, SpringLayout.EAST, frame.getContentPane());
		txtpnOr.setText("OR");
		txtpnOr.setForeground(Color.BLACK);
		txtpnOr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnOr.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnOr);
		
		txtEnterMac = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtEnterMac, -241, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtEnterMac, 0, SpringLayout.SOUTH, dateChooser_1);
		springLayout.putConstraint(SpringLayout.EAST, txtEnterMac, -152, SpringLayout.EAST, frame.getContentPane());
		txtEnterMac.setText("Enter MAC 1");
		txtEnterMac.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterMac.setColumns(10);
		frame.getContentPane().add(txtEnterMac);
		
		txtEnterMac_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEnterMac_2, 1, SpringLayout.NORTH, txtEnterMaxTime);
		springLayout.putConstraint(SpringLayout.WEST, txtEnterMac_2, 0, SpringLayout.WEST, txtEnterMac);
		springLayout.putConstraint(SpringLayout.EAST, txtEnterMac_2, 0, SpringLayout.EAST, txtEnterMac);
		txtEnterMac_2.setText("Enter MAC 2");
		txtEnterMac_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterMac_2.setColumns(10);
		frame.getContentPane().add(txtEnterMac_2);
		
		txtEnterMac_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEnterMac_1, 2, SpringLayout.NORTH, btnCancelFilters);
		springLayout.putConstraint(SpringLayout.WEST, txtEnterMac_1, 0, SpringLayout.WEST, txtEnterMac);
		springLayout.putConstraint(SpringLayout.EAST, txtEnterMac_1, 0, SpringLayout.EAST, txtEnterMac);
		txtEnterMac_1.setText("Enter MAC 3");
		txtEnterMac_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterMac_1.setColumns(10);
		frame.getContentPane().add(txtEnterMac_1);
		
		txtEnterSignal = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtEnterSignal, -85, SpringLayout.EAST, txtEnterPathTo);
		springLayout.putConstraint(SpringLayout.SOUTH, txtEnterSignal, 0, SpringLayout.SOUTH, dateChooser_1);
		springLayout.putConstraint(SpringLayout.EAST, txtEnterSignal, -24, SpringLayout.EAST, frame.getContentPane());
		txtEnterSignal.setText("Enter SIGNAL 1");
		txtEnterSignal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterSignal.setColumns(10);
		frame.getContentPane().add(txtEnterSignal);
		
		txtEnterSignal_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEnterSignal_2, 1, SpringLayout.NORTH, txtEnterMaxTime);
		springLayout.putConstraint(SpringLayout.WEST, txtEnterSignal_2, 0, SpringLayout.WEST, txtEnterSignal);
		springLayout.putConstraint(SpringLayout.EAST, txtEnterSignal_2, 98, SpringLayout.WEST, txtEnterSignal);
		txtEnterSignal_2.setText("Enter SIGNAL 2");
		txtEnterSignal_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterSignal_2.setColumns(10);
		frame.getContentPane().add(txtEnterSignal_2);
		
		txtEnterSignal_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEnterSignal_1, 0, SpringLayout.NORTH, btnCancelFilters);
		springLayout.putConstraint(SpringLayout.WEST, txtEnterSignal_1, 0, SpringLayout.WEST, txtEnterSignal);
		springLayout.putConstraint(SpringLayout.EAST, txtEnterSignal_1, 0, SpringLayout.EAST, txtEnterSignal);
		txtEnterSignal_1.setText("Enter SIGNAL 3");
		txtEnterSignal_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterSignal_1.setColumns(10);
		frame.getContentPane().add(txtEnterSignal_1);
		
		txtEnterMac_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEnterMac_3, 6, SpringLayout.SOUTH, txtpnAlgo);
		springLayout.putConstraint(SpringLayout.WEST, txtEnterMac_3, 0, SpringLayout.WEST, btnAlgorithms);
		springLayout.putConstraint(SpringLayout.EAST, txtEnterMac_3, -50, SpringLayout.EAST, frame.getContentPane());
		txtEnterMac_3.setText("            Enter MAC");
		txtEnterMac_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterMac_3.setColumns(10);
		frame.getContentPane().add(txtEnterMac_3);
	}
}
