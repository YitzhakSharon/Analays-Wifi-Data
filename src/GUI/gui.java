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
import Filter.*;
import object.Cordinate;
import object.Database;
import object.Scan;
import GUI.Connect;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gui {

	protected static final String Connect = null;
	private JFrame frame;
	private JTextField txtEnterRadius;
	private JTextField txtEnterPathTo;
	private JTextField txtEnterSignal_2;
	private JTextField txtEnterSignal_1;
	private JTextField txtEnterMac_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_14;

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
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 255, 255));
		frame.setFont(new Font("Engravers MT", Font.BOLD, 16));
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JTextPane txtpnTime = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtpnTime, 445, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtpnTime, -668, SpringLayout.EAST, frame.getContentPane());
		txtpnTime.setForeground(new Color(128, 0, 0));
		txtpnTime.setBackground(new Color(255, 250, 250));
		txtpnTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnTime.setText("   Time");
		frame.getContentPane().add(txtpnTime);
		
		JTextPane txtpnId = new JTextPane();
		springLayout.putConstraint(SpringLayout.EAST, txtpnId, -604, SpringLayout.EAST, frame.getContentPane());
		txtpnId.setText("     ID");
		txtpnId.setForeground(new Color(128, 0, 0));
		txtpnId.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnId.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnId);
		
		JTextPane txtpnPlace = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnPlace, 0, SpringLayout.NORTH, txtpnTime);
		springLayout.putConstraint(SpringLayout.WEST, txtpnPlace, 89, SpringLayout.EAST, txtpnTime);
		springLayout.putConstraint(SpringLayout.EAST, txtpnPlace, -498, SpringLayout.EAST, frame.getContentPane());
		txtpnPlace.setText("  Place");
		txtpnPlace.setForeground(new Color(128, 0, 0));
		txtpnPlace.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnPlace.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnPlace);
		
		txtEnterRadius = new JTextField();
		txtEnterRadius.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterRadius.setColumns(10);
		frame.getContentPane().add(txtEnterRadius);
		
		JButton btnCancelFilters = new JButton("Cancel filters");
		springLayout.putConstraint(SpringLayout.SOUTH, btnCancelFilters, -31, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCancelFilters, -458, SpringLayout.EAST, frame.getContentPane());
		btnCancelFilters.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelFilters.setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().add(btnCancelFilters);
		
		JTextPane txtpnAlgo = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnAlgo, 85, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtpnAlgo, 855, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtpnAlgo, -248, SpringLayout.EAST, frame.getContentPane());
		txtpnAlgo.setText("     Algo 1");
		txtpnAlgo.setForeground(new Color(128, 0, 0));
		txtpnAlgo.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnAlgo.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnAlgo);
		
		JTextPane txtpnAlgo_1 = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtpnAlgo_1, 0, SpringLayout.WEST, txtpnAlgo);
		springLayout.putConstraint(SpringLayout.EAST, txtpnAlgo_1, -240, SpringLayout.EAST, frame.getContentPane());
		txtpnAlgo_1.setText("     Algo 2");
		txtpnAlgo_1.setForeground(new Color(128, 0, 0));
		txtpnAlgo_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnAlgo_1.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnAlgo_1);
		
		JTextPane txtpnMin = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnMin, 141, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtEnterRadius, 0, SpringLayout.SOUTH, txtpnMin);
		springLayout.putConstraint(SpringLayout.WEST, txtpnMin, 406, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnTime, -6, SpringLayout.NORTH, txtpnMin);
		txtpnMin.setText("  Start");
		txtpnMin.setForeground(new Color(0, 0, 0));
		txtpnMin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnMin.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnMin);
		
		txtEnterPathTo = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, txtEnterPathTo, -319, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtEnterPathTo, -13, SpringLayout.EAST, frame.getContentPane());
		txtEnterPathTo.setText("Format of CSV File");
		txtEnterPathTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterPathTo.setColumns(10);
		frame.getContentPane().add(txtEnterPathTo);
	
		
		txtEnterMac_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtEnterMac_3, 62, SpringLayout.WEST, txtpnAlgo);
		springLayout.putConstraint(SpringLayout.SOUTH, txtEnterMac_3, 0, SpringLayout.SOUTH, txtpnTime);
		springLayout.putConstraint(SpringLayout.EAST, txtEnterMac_3, -152, SpringLayout.EAST, frame.getContentPane());
		txtEnterMac_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterMac_3.setColumns(10);
		frame.getContentPane().add(txtEnterMac_3);
		
		JTextPane txtpnDatabase = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtpnDatabase, 130, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtpnDatabase, 245, SpringLayout.WEST, frame.getContentPane());
		txtpnDatabase.setText("   DataBase");
		txtpnDatabase.setForeground(new Color(0, 0, 0));
		txtpnDatabase.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtpnDatabase.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(txtpnDatabase);

		
		JTextPane txtpnAlgorithms = new JTextPane();
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnAlgorithms, -43, SpringLayout.NORTH, txtEnterMac_3);
		springLayout.putConstraint(SpringLayout.EAST, txtpnAlgorithms, -145, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, txtpnDatabase, 0, SpringLayout.NORTH, txtpnAlgorithms);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnDatabase, 0, SpringLayout.SOUTH, txtpnAlgorithms);
		txtpnAlgorithms.setText("Algorithms");
		txtpnAlgorithms.setForeground(Color.BLACK);
		txtpnAlgorithms.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtpnAlgorithms.setBackground(Color.WHITE);
		frame.getContentPane().add(txtpnAlgorithms);
		
		JButton btnStartFilter = new JButton("Start filter");
		springLayout.putConstraint(SpringLayout.WEST, btnCancelFilters, 54, SpringLayout.EAST, btnStartFilter);
		springLayout.putConstraint(SpringLayout.NORTH, btnStartFilter, 0, SpringLayout.NORTH, btnCancelFilters);
		btnStartFilter.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStartFilter.setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().add(btnStartFilter);
		
	
		
		JTextPane txtpnRadius = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtpnRadius, 605, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtEnterRadius, 6, SpringLayout.EAST, txtpnRadius);
		springLayout.putConstraint(SpringLayout.EAST, txtpnMin, -138, SpringLayout.WEST, txtpnRadius);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnRadius, 0, SpringLayout.SOUTH, txtpnMin);
		txtpnRadius.setText("Radius:");
		txtpnRadius.setForeground(new Color(0, 0, 0));
		txtpnRadius.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnRadius.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnRadius);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 141, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 136, SpringLayout.EAST, txtEnterRadius);
		springLayout.putConstraint(SpringLayout.EAST, textField, -197, SpringLayout.WEST, txtEnterRadius);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setColumns(10);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 141, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 56, SpringLayout.EAST, txtEnterRadius);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, -117, SpringLayout.WEST, txtEnterRadius);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setColumns(10);
		frame.getContentPane().add(textField_1);
		
		JTextPane txtpnLat = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtpnLat, 0, SpringLayout.WEST, txtpnPlace);
		txtpnLat.setText("Lat:");
		txtpnLat.setForeground(Color.BLACK);
		txtpnLat.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnLat.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnLat);
		
		JTextPane txtpnLon = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnLon, 8, SpringLayout.SOUTH, txtpnLat);
		springLayout.putConstraint(SpringLayout.WEST, txtpnLon, 0, SpringLayout.WEST, txtpnPlace);
		txtpnLon.setText("Lon:");
		txtpnLon.setForeground(Color.BLACK);
		txtpnLon.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnLon.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnLon);
		
		JTextPane txtpnTime_1 = new JTextPane();
		springLayout.putConstraint(SpringLayout.EAST, txtEnterRadius, 320, SpringLayout.WEST, txtpnTime_1);
		springLayout.putConstraint(SpringLayout.WEST, txtpnTime_1, 0, SpringLayout.WEST, txtpnMin);
		txtpnTime_1.setText("Time:");
		txtpnTime_1.setForeground(Color.BLACK);
		txtpnTime_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTime_1.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnTime_1);
		
		JTextPane textPane_1 = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, textPane_1, 203, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnTime_1, -5, SpringLayout.NORTH, textPane_1);
		springLayout.putConstraint(SpringLayout.WEST, textPane_1, 0, SpringLayout.WEST, txtpnMin);
		textPane_1.setText("Date:");
		textPane_1.setForeground(Color.BLACK);
		textPane_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPane_1.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(textPane_1);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, btnStartFilter, 0, SpringLayout.EAST, textField_2);
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 173, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnMin, -7, SpringLayout.NORTH, textField_2);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 17, SpringLayout.EAST, txtpnTime_1);
		springLayout.putConstraint(SpringLayout.EAST, textField_2, -61, SpringLayout.WEST, txtpnLat);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnLat, 0, SpringLayout.SOUTH, textField_2);
		textField_2.setText(" hh:mm:ss");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setColumns(10);
		frame.getContentPane().add(textField_2);
		
		JDateChooser dateChooser = new JDateChooser();
		springLayout.putConstraint(SpringLayout.NORTH, dateChooser, 9, SpringLayout.SOUTH, textField_2);
		springLayout.putConstraint(SpringLayout.WEST, dateChooser, 17, SpringLayout.EAST, textPane_1);
		springLayout.putConstraint(SpringLayout.EAST, dateChooser, -51, SpringLayout.WEST, txtpnLon);
		frame.getContentPane().add(dateChooser);
		
		JTextPane txtpnId_1 = new JTextPane();
		springLayout.putConstraint(SpringLayout.EAST, txtpnId_1, 0, SpringLayout.EAST, txtpnTime);
		txtpnId_1.setText("ID:");
		txtpnId_1.setForeground(Color.BLACK);
		txtpnId_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnId_1.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnId_1);
		
		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnId_1, 0, SpringLayout.NORTH, textField_3);
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, 387, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtpnId, 0, SpringLayout.WEST, textField_3);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnId, -14, SpringLayout.NORTH, textField_3);
		springLayout.putConstraint(SpringLayout.WEST, textField_3, 526, SpringLayout.WEST, frame.getContentPane());
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_3.setColumns(10);
		frame.getContentPane().add(textField_3);
		
		JTextPane txtpnMac = new JTextPane();
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnMac, 0, SpringLayout.SOUTH, txtpnTime);
		springLayout.putConstraint(SpringLayout.EAST, txtpnMac, -6, SpringLayout.WEST, txtEnterMac_3);
		txtpnMac.setText("Mac:");
		txtpnMac.setForeground(Color.BLACK);
		txtpnMac.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnMac.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnMac);
		
		JTextPane txtpnEnd = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtpnEnd, 406, SpringLayout.WEST, frame.getContentPane());
		txtpnEnd.setText(" End");
		txtpnEnd.setForeground(Color.BLACK);
		txtpnEnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnEnd.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnEnd);
		
		JTextPane txtpnPath = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtEnterPathTo, 16, SpringLayout.EAST, txtpnPath);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnAlgo_1, -5, SpringLayout.NORTH, txtpnPath);
		springLayout.putConstraint(SpringLayout.EAST, txtpnEnd, -417, SpringLayout.WEST, txtpnPath);
		txtpnPath.setText("Path:");
		txtpnPath.setForeground(Color.BLACK);
		txtpnPath.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnPath.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnPath);
		
		JTextPane txtpnOr = new JTextPane();
		springLayout.putConstraint(SpringLayout.EAST, txtpnOr, -259, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnPath, -25, SpringLayout.NORTH, txtpnOr);
		txtpnOr.setText("OR");
		txtpnOr.setForeground(Color.BLACK);
		txtpnOr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnOr.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnOr);
		
		JTextPane txtpnMac_1 = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnMac_1, 6, SpringLayout.SOUTH, txtpnOr);
		springLayout.putConstraint(SpringLayout.EAST, txtpnMac_1, 0, SpringLayout.EAST, txtpnAlgo);
		txtpnMac_1.setText("Mac 1:");
		txtpnMac_1.setForeground(Color.BLACK);
		txtpnMac_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnMac_1.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnMac_1);
		
		JTextPane txtpnMac_2 = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnMac_2, 6, SpringLayout.SOUTH, txtpnMac_1);
		springLayout.putConstraint(SpringLayout.EAST, txtpnMac_2, 0, SpringLayout.EAST, txtpnAlgo);
		txtpnMac_2.setText("Mac 2:");
		txtpnMac_2.setForeground(Color.BLACK);
		txtpnMac_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnMac_2.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnMac_2);
		
		JTextPane txtpnMac_3 = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnMac_3, 6, SpringLayout.SOUTH, txtpnMac_2);
		springLayout.putConstraint(SpringLayout.EAST, txtpnMac_3, 0, SpringLayout.EAST, txtpnAlgo);
		txtpnMac_3.setText("Mac 3:");
		txtpnMac_3.setForeground(Color.BLACK);
		txtpnMac_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnMac_3.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnMac_3);
		
		textField_7 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_7, 0, SpringLayout.WEST, txtpnAlgorithms);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_7.setColumns(10);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textField_7, -13, SpringLayout.NORTH, textField_8);
		springLayout.putConstraint(SpringLayout.WEST, textField_8, 3, SpringLayout.EAST, txtpnMac_2);
		springLayout.putConstraint(SpringLayout.EAST, textField_8, 0, SpringLayout.EAST, textField_7);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_8.setColumns(10);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textField_8, -7, SpringLayout.NORTH, textField_9);
		springLayout.putConstraint(SpringLayout.WEST, textField_9, 0, SpringLayout.WEST, txtpnAlgorithms);
		springLayout.putConstraint(SpringLayout.NORTH, textField_9, 359, SpringLayout.NORTH, frame.getContentPane());
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_9.setColumns(10);
		frame.getContentPane().add(textField_9);
		
		JTextPane txtpnSig = new JTextPane();
		springLayout.putConstraint(SpringLayout.EAST, textField_7, -37, SpringLayout.WEST, txtpnSig);
		txtpnSig.setText("Signal 1:");
		txtpnSig.setForeground(Color.BLACK);
		txtpnSig.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnSig.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnSig);
		
		JTextPane txtpnSignal = new JTextPane();
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnSig, -13, SpringLayout.NORTH, txtpnSignal);
		txtpnSignal.setText("Signal 2:");
		txtpnSignal.setForeground(Color.BLACK);
		txtpnSignal.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnSignal.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnSignal);
		
		JTextPane txtpnSignal_1 = new JTextPane();
		springLayout.putConstraint(SpringLayout.EAST, textField_9, -37, SpringLayout.WEST, txtpnSignal_1);
		springLayout.putConstraint(SpringLayout.NORTH, txtpnSignal_1, 359, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnSignal, -6, SpringLayout.NORTH, txtpnSignal_1);
		txtpnSignal_1.setText("Signal 3:");
		txtpnSignal_1.setForeground(Color.BLACK);
		txtpnSignal_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnSignal_1.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnSignal_1);
		
		textField_10 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_10, 1114, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtpnSig, -6, SpringLayout.WEST, textField_10);
		springLayout.putConstraint(SpringLayout.EAST, textField_10, -13, SpringLayout.EAST, frame.getContentPane());
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_10.setColumns(10);
		frame.getContentPane().add(textField_10);
		
		textField_12 = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textField_10, -15, SpringLayout.NORTH, textField_12);
		springLayout.putConstraint(SpringLayout.WEST, textField_12, 1114, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtpnSignal, -6, SpringLayout.WEST, textField_12);
		springLayout.putConstraint(SpringLayout.EAST, textField_12, -13, SpringLayout.EAST, frame.getContentPane());
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_12.setColumns(10);
		frame.getContentPane().add(textField_12);
		
		textField_13 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_13, 360, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField_12, -7, SpringLayout.NORTH, textField_13);
		springLayout.putConstraint(SpringLayout.WEST, textField_13, 1114, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtpnSignal_1, -6, SpringLayout.WEST, textField_13);
		springLayout.putConstraint(SpringLayout.EAST, textField_13, -13, SpringLayout.EAST, frame.getContentPane());
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_13.setColumns(10);
		frame.getContentPane().add(textField_13);
		
		JTextPane txtpnFilters = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnFilters, 0, SpringLayout.NORTH, txtpnAlgorithms);
		springLayout.putConstraint(SpringLayout.WEST, txtpnFilters, 293, SpringLayout.EAST, txtpnDatabase);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnFilters, 0, SpringLayout.SOUTH, txtpnDatabase);
		springLayout.putConstraint(SpringLayout.EAST, txtpnFilters, -292, SpringLayout.WEST, txtpnAlgorithms);
		txtpnFilters.setText("   Filters");
		txtpnFilters.setForeground(Color.BLACK);
		txtpnFilters.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtpnFilters.setBackground(Color.WHITE);
		frame.getContentPane().add(txtpnFilters);
		
		JTextPane textPane = new JTextPane();
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnOr, 0, SpringLayout.SOUTH, textPane);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnEnd, -9, SpringLayout.NORTH, textPane);
		springLayout.putConstraint(SpringLayout.EAST, textPane, 0, SpringLayout.EAST, txtpnTime_1);
		textPane.setText("Time:");
		textPane.setForeground(Color.BLACK);
		textPane.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPane.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_2 = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, textPane_2, 296, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textPane, -6, SpringLayout.NORTH, textPane_2);
		springLayout.putConstraint(SpringLayout.WEST, textPane_2, 0, SpringLayout.WEST, txtpnMin);
		textPane_2.setText("Date:");
		textPane_2.setForeground(Color.BLACK);
		textPane_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPane_2.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(textPane_2);
		
		textField_5 = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, dateChooser, -43, SpringLayout.NORTH, textField_5);
		springLayout.putConstraint(SpringLayout.WEST, textField_5, 17, SpringLayout.EAST, textPane);
		springLayout.putConstraint(SpringLayout.EAST, textField_5, 0, SpringLayout.EAST, textField_2);
		textField_5.setText(" hh:mm:ss");
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_5.setColumns(10);
		frame.getContentPane().add(textField_5);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		springLayout.putConstraint(SpringLayout.NORTH, dateChooser_1, 298, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField_5, -8, SpringLayout.NORTH, dateChooser_1);
		springLayout.putConstraint(SpringLayout.WEST, dateChooser_1, 0, SpringLayout.WEST, textField_2);
		springLayout.putConstraint(SpringLayout.EAST, dateChooser_1, 0, SpringLayout.EAST, dateChooser);
		frame.getContentPane().add(dateChooser_1);
		
		textField_6 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_6, -61, SpringLayout.EAST, txtEnterRadius);
		springLayout.putConstraint(SpringLayout.EAST, textField_6, 0, SpringLayout.EAST, txtEnterRadius);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_6.setColumns(10);
		frame.getContentPane().add(textField_6);
		
		textField_14 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtpnPath, 148, SpringLayout.EAST, textField_14);
		springLayout.putConstraint(SpringLayout.NORTH, textField_14, 204, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField_6, -6, SpringLayout.NORTH, textField_14);
		springLayout.putConstraint(SpringLayout.WEST, textField_14, 0, SpringLayout.WEST, txtEnterRadius);
		springLayout.putConstraint(SpringLayout.EAST, textField_14, 61, SpringLayout.WEST, txtEnterRadius);
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_14.setColumns(10);
		frame.getContentPane().add(textField_14);
		
		JLabel lblCord = new JLabel("cord:");
		springLayout.putConstraint(SpringLayout.NORTH, lblCord, -1, SpringLayout.NORTH, txtEnterRadius);
		springLayout.putConstraint(SpringLayout.WEST, lblCord, 118, SpringLayout.EAST, txtEnterRadius);
		springLayout.putConstraint(SpringLayout.SOUTH, lblCord, -22, SpringLayout.NORTH, txtpnAlgo_1);
		springLayout.putConstraint(SpringLayout.EAST, lblCord, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblCord);	
		
		JButton button_1 = new JButton("Start algo 1");
		springLayout.putConstraint(SpringLayout.WEST, button_1, 13, SpringLayout.EAST, txtEnterMac_3);
		springLayout.putConstraint(SpringLayout.SOUTH, button_1, 0, SpringLayout.SOUTH, txtpnTime);
		button_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Connect con=new Connect();
		    String mac=txtEnterMac_3.getText();
		    Cordinate temp=con.algoritem1(mac);
		    lblCord.setText("core: Lat:"+temp.getLat()+" Lon:"+temp.getLon()+" Alt:"+temp.getAlt());
			
		    }
		
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_1.setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().add(button_1);
		
		JLabel label = new JLabel("cord:");
		springLayout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, txtpnAlgo);
		springLayout.putConstraint(SpringLayout.SOUTH, label, -76, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label, 0, SpringLayout.EAST, txtEnterPathTo);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("Start algo 2");
		springLayout.putConstraint(SpringLayout.NORTH, label, 27, SpringLayout.SOUTH, button);
		springLayout.putConstraint(SpringLayout.NORTH, button, 28, SpringLayout.SOUTH, textField_9);
		springLayout.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, txtpnOr);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect con=new Connect();
				String mac1=null;
				String mac2=null;
				String mac3=null;
				String sig1=null;
				String sig2=null;
				String sig3=null;
			    mac1=textField_7.getText();
				mac2=textField_8.getText();
				mac3=textField_9.getText();
			    sig1=textField_10.getText();
                sig2=textField_12.getText();
                sig3=textField_13.getText(); 
				String path=txtEnterPathTo.getText();
				Cordinate temp=con.algoritem2b(mac1,mac2,mac3,sig1,sig2,sig2);
				label.setText("core: Lat:"+temp.getLat()+" Lon:"+temp.getLon()+" Alt:"+temp.getAlt());
				
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, txtpnAlgo);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 31, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, txtEnterPathTo);
		frame.getContentPane().add(lblNewLabel);
		
		JButton button_2 = new JButton("Start algo 2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					Connect con=new Connect();
					String path=txtEnterPathTo.getText();
					con.algoritem2a(path);
					lblNewLabel.setText("result_for_algo_2.csv was created check Workspace");
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, button_2, 10, SpringLayout.SOUTH, txtEnterPathTo);
		springLayout.putConstraint(SpringLayout.EAST, button_2, 0, SpringLayout.EAST, txtEnterPathTo);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_2.setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().add(button_2);

	}
}