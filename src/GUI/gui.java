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

public class gui {

	protected static final String Connect = null;
	private JFrame frame;
	private JTextField txtEnterRadius;
	private JTextField txtEnterMaxTime;
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
		frame.setBounds(100, 100, 1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JTextPane txtpnTime = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtpnTime, 387, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnTime, -363, SpringLayout.SOUTH, frame.getContentPane());
		txtpnTime.setForeground(new Color(128, 0, 0));
		txtpnTime.setBackground(new Color(255, 250, 250));
		txtpnTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnTime.setText("   Time");
		frame.getContentPane().add(txtpnTime);
		
		JTextPane txtpnId = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtpnId, 480, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtpnId, -433, SpringLayout.EAST, frame.getContentPane());
		txtpnId.setText("     ID");
		txtpnId.setForeground(new Color(128, 0, 0));
		txtpnId.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnId.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnId);
		
		JTextPane txtpnPlace = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtpnPlace, 549, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtpnTime, -91, SpringLayout.WEST, txtpnPlace);
		springLayout.putConstraint(SpringLayout.NORTH, txtpnPlace, 0, SpringLayout.NORTH, txtpnTime);
		springLayout.putConstraint(SpringLayout.EAST, txtpnPlace, -364, SpringLayout.EAST, frame.getContentPane());
		txtpnPlace.setText("  Place");
		txtpnPlace.setForeground(new Color(128, 0, 0));
		txtpnPlace.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnPlace.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnPlace);
		
		txtEnterRadius = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEnterRadius, 6, SpringLayout.SOUTH, txtpnPlace);
		springLayout.putConstraint(SpringLayout.WEST, txtEnterRadius, 593, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtEnterRadius, -350, SpringLayout.EAST, frame.getContentPane());
		txtEnterRadius.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterRadius.setColumns(10);
		frame.getContentPane().add(txtEnterRadius);
		
		txtEnterMaxTime = new JTextField();
		txtEnterMaxTime.setText(" hh:mm:ss");
		txtEnterMaxTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEnterMaxTime.setColumns(10);
		frame.getContentPane().add(txtEnterMaxTime);
		
		JButton btnCancelFilters = new JButton("Cancel filters");
		springLayout.putConstraint(SpringLayout.NORTH, btnCancelFilters, -56, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnCancelFilters, -31, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCancelFilters, -320, SpringLayout.EAST, frame.getContentPane());
		btnCancelFilters.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelFilters.setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().add(btnCancelFilters);
		
		JTextPane txtpnAlgo = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtpnAlgo, 95, SpringLayout.EAST, txtEnterRadius);
		springLayout.putConstraint(SpringLayout.EAST, txtpnAlgo, -166, SpringLayout.EAST, frame.getContentPane());
		txtpnAlgo.setText("     Algo 1");
		txtpnAlgo.setForeground(new Color(128, 0, 0));
		txtpnAlgo.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnAlgo.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnAlgo);
		
		JTextPane txtpnAlgo_1 = new JTextPane();
		springLayout.putConstraint(SpringLayout.EAST, txtpnAlgo_1, -156, SpringLayout.EAST, frame.getContentPane());
		txtpnAlgo_1.setText("     Algo 2");
		txtpnAlgo_1.setForeground(new Color(128, 0, 0));
		txtpnAlgo_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnAlgo_1.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnAlgo_1);
		
		JTextPane txtpnMin = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtEnterMaxTime, 6, SpringLayout.SOUTH, txtpnMin);
		springLayout.putConstraint(SpringLayout.NORTH, txtpnMin, 2, SpringLayout.SOUTH, txtpnTime);
		springLayout.putConstraint(SpringLayout.WEST, txtpnMin, 397, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnMin, 0, SpringLayout.SOUTH, txtEnterRadius);
		springLayout.putConstraint(SpringLayout.EAST, txtpnMin, -10, SpringLayout.EAST, txtpnTime);
		txtpnMin.setText("  Start");
		txtpnMin.setForeground(new Color(0, 0, 0));
		txtpnMin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnMin.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnMin);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		springLayout.putConstraint(SpringLayout.NORTH, dateChooser_1, 6, SpringLayout.SOUTH, txtEnterMaxTime);
		frame.getContentPane().add(dateChooser_1);
		
		txtEnterPathTo = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEnterPathTo, 6, SpringLayout.SOUTH, txtpnAlgo_1);
		springLayout.putConstraint(SpringLayout.EAST, txtEnterPathTo, -47, SpringLayout.EAST, frame.getContentPane());
		txtEnterPathTo.setText("Format of CSV File");
		txtEnterPathTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterPathTo.setColumns(10);
		frame.getContentPane().add(txtEnterPathTo);
	
		
		txtEnterMac_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, txtEnterMac_3, -59, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, txtpnAlgo_1, 38, SpringLayout.SOUTH, txtEnterMac_3);
		txtEnterMac_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterMac_3.setColumns(10);
		frame.getContentPane().add(txtEnterMac_3);
		
		JTextPane txtpnDatabase = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnDatabase, 29, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtpnDatabase, 90, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnDatabase, -400, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtpnDatabase, 205, SpringLayout.WEST, frame.getContentPane());
		txtpnDatabase.setText("   DataBase");
		txtpnDatabase.setForeground(new Color(0, 0, 0));
		txtpnDatabase.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtpnDatabase.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(txtpnDatabase);

		
		JTextPane txtpnAlgorithms = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtpnAlgorithms, 605, SpringLayout.EAST, txtpnDatabase);
		springLayout.putConstraint(SpringLayout.NORTH, txtpnAlgo, 26, SpringLayout.SOUTH, txtpnAlgorithms);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnAlgorithms, 0, SpringLayout.SOUTH, txtpnDatabase);
		txtpnAlgorithms.setText("Algorithms");
		txtpnAlgorithms.setForeground(Color.BLACK);
		txtpnAlgorithms.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtpnAlgorithms.setBackground(Color.WHITE);
		frame.getContentPane().add(txtpnAlgorithms);
		
		JButton btnStartFilter = new JButton("Start filter");
		springLayout.putConstraint(SpringLayout.EAST, btnStartFilter, -496, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnCancelFilters, 48, SpringLayout.EAST, btnStartFilter);
		springLayout.putConstraint(SpringLayout.NORTH, btnStartFilter, 0, SpringLayout.NORTH, btnCancelFilters);
		btnStartFilter.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStartFilter.setBackground(SystemColor.menu);
		frame.getContentPane().add(btnStartFilter);
		
		JTextPane txtpnEnd = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnEnd, 6, SpringLayout.SOUTH, dateChooser_1);
		springLayout.putConstraint(SpringLayout.WEST, txtpnEnd, 406, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtpnEnd, -537, SpringLayout.EAST, frame.getContentPane());
		txtpnEnd.setText(" End");
		txtpnEnd.setForeground(Color.BLACK);
		txtpnEnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnEnd.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnEnd);
		
		JButton btnStartAlgo = new JButton("Start algo 2");
		btnStartAlgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connect con=new Connect();
				String path=txtEnterPathTo.getText();
				con.algoritem2a(path);
			}
		});
		btnStartAlgo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStartAlgo.setBackground(SystemColor.menu);
		frame.getContentPane().add(btnStartAlgo);
		
		JButton btnStartAlgo_1 = new JButton("Start algo 1");
		springLayout.putConstraint(SpringLayout.WEST, btnStartAlgo, 0, SpringLayout.WEST, btnStartAlgo_1);
		springLayout.putConstraint(SpringLayout.NORTH, btnStartAlgo_1, 141, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtEnterMac_3, -6, SpringLayout.NORTH, btnStartAlgo_1);
		btnStartAlgo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connect con=new Connect();
			    String mac=txtEnterMac_3.getText();
			    Cordinate temp=con.algoritem1(mac);
				JOptionPane.showMessageDialog(null, temp.toString());
			}
		});
		btnStartAlgo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStartAlgo_1.setBackground(SystemColor.menu);
		frame.getContentPane().add(btnStartAlgo_1);
		
	
		
		JTextPane txtpnRadius = new JTextPane();
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnRadius, 0, SpringLayout.SOUTH, txtEnterRadius);
		springLayout.putConstraint(SpringLayout.EAST, txtpnRadius, -6, SpringLayout.WEST, txtEnterRadius);
		txtpnRadius.setText("Radius:");
		txtpnRadius.setForeground(new Color(0, 0, 0));
		txtpnRadius.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnRadius.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnRadius);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, btnStartAlgo_1, 228, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.NORTH, textField, 7, SpringLayout.SOUTH, txtEnterRadius);
		springLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, txtEnterRadius);
		springLayout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, txtEnterRadius);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setColumns(10);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtpnAlgo_1, 105, SpringLayout.EAST, textField_1);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, txtEnterRadius);
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 10, SpringLayout.SOUTH, textField);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setColumns(10);
		frame.getContentPane().add(textField_1);
		
		JTextPane txtpnLat = new JTextPane();
		springLayout.putConstraint(SpringLayout.EAST, txtEnterMaxTime, -46, SpringLayout.WEST, txtpnLat);
		springLayout.putConstraint(SpringLayout.WEST, txtpnLat, 0, SpringLayout.WEST, txtpnRadius);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnLat, 0, SpringLayout.SOUTH, textField);
		txtpnLat.setText("Lat:");
		txtpnLat.setForeground(Color.BLACK);
		txtpnLat.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnLat.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnLat);
		
		JTextPane txtpnLon = new JTextPane();
		springLayout.putConstraint(SpringLayout.EAST, dateChooser_1, -29, SpringLayout.WEST, txtpnLon);
		springLayout.putConstraint(SpringLayout.NORTH, txtpnLon, 9, SpringLayout.SOUTH, txtpnLat);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 26, SpringLayout.EAST, txtpnLon);
		springLayout.putConstraint(SpringLayout.WEST, txtpnLon, 0, SpringLayout.WEST, txtpnRadius);
		txtpnLon.setText("Lon:");
		txtpnLon.setForeground(Color.BLACK);
		txtpnLon.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnLon.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnLon);
		
		JTextPane txtpnTime_1 = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtEnterMaxTime, 8, SpringLayout.EAST, txtpnTime_1);
		springLayout.putConstraint(SpringLayout.WEST, txtpnTime_1, 358, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnTime_1, 0, SpringLayout.SOUTH, textField);
		txtpnTime_1.setText("Time:");
		txtpnTime_1.setForeground(Color.BLACK);
		txtpnTime_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTime_1.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnTime_1);
		
		JTextPane txtpnDate = new JTextPane();
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnDate, 0, SpringLayout.SOUTH, dateChooser_1);
		springLayout.putConstraint(SpringLayout.WEST, dateChooser_1, 6, SpringLayout.EAST, txtpnDate);
		springLayout.putConstraint(SpringLayout.WEST, txtpnDate, 358, SpringLayout.WEST, frame.getContentPane());
		txtpnDate.setText("Date:");
		txtpnDate.setForeground(Color.BLACK);
		txtpnDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnDate.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnDate);
		
		JTextPane textPane = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, textPane, 0, SpringLayout.WEST, txtpnTime_1);
		textPane.setText("Time:");
		textPane.setForeground(Color.BLACK);
		textPane.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPane.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		springLayout.putConstraint(SpringLayout.SOUTH, btnStartAlgo, 0, SpringLayout.SOUTH, textPane_1);
		springLayout.putConstraint(SpringLayout.NORTH, textPane_1, 239, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textPane, 0, SpringLayout.NORTH, textPane_1);
		springLayout.putConstraint(SpringLayout.EAST, textPane_1, 0, SpringLayout.EAST, txtpnTime_1);
		textPane_1.setText("Date:");
		textPane_1.setForeground(Color.BLACK);
		textPane_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPane_1.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(textPane_1);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, txtEnterMaxTime);
		springLayout.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, txtEnterMaxTime);
		textField_2.setText(" hh:mm:ss");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setColumns(10);
		frame.getContentPane().add(textField_2);
		
		JDateChooser dateChooser = new JDateChooser();
		springLayout.putConstraint(SpringLayout.EAST, dateChooser, 0, SpringLayout.EAST, dateChooser_1);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_2, -2, SpringLayout.NORTH, dateChooser);
		springLayout.putConstraint(SpringLayout.NORTH, txtpnId, 23, SpringLayout.SOUTH, dateChooser);
		springLayout.putConstraint(SpringLayout.WEST, dateChooser, 0, SpringLayout.WEST, txtEnterMaxTime);
		springLayout.putConstraint(SpringLayout.SOUTH, dateChooser, 0, SpringLayout.SOUTH, textPane_1);
		frame.getContentPane().add(dateChooser);
		
		JTextPane txtpnId_1 = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnId_1, 6, SpringLayout.SOUTH, txtpnId);
		springLayout.putConstraint(SpringLayout.EAST, txtpnId_1, 0, SpringLayout.EAST, txtEnterMaxTime);
		txtpnId_1.setText("ID:");
		txtpnId_1.setForeground(Color.BLACK);
		txtpnId_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnId_1.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnId_1);
		
		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_3, 6, SpringLayout.EAST, txtpnId_1);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_3, 0, SpringLayout.SOUTH, txtpnId_1);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_3.setColumns(10);
		frame.getContentPane().add(textField_3);
		
		JTextPane txtpnMac = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnMac, 1, SpringLayout.SOUTH, txtpnAlgo);
		springLayout.putConstraint(SpringLayout.EAST, txtpnMac, -191, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtEnterMac_3, 17, SpringLayout.EAST, txtpnMac);
		txtpnMac.setText("Mac:");
		txtpnMac.setForeground(Color.BLACK);
		txtpnMac.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnMac.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnMac);
		
		JTextPane txtpnPath = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtEnterPathTo, 6, SpringLayout.EAST, txtpnPath);
		springLayout.putConstraint(SpringLayout.NORTH, txtpnPath, 3, SpringLayout.SOUTH, txtpnAlgo_1);
		springLayout.putConstraint(SpringLayout.WEST, txtpnPath, 10, SpringLayout.WEST, txtpnAlgo_1);
		txtpnPath.setText("Path:");
		txtpnPath.setForeground(Color.BLACK);
		txtpnPath.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnPath.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnPath);
		
		JTextPane txtpnOr = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnOr, 6, SpringLayout.SOUTH, btnStartAlgo);
		springLayout.putConstraint(SpringLayout.EAST, txtpnOr, -112, SpringLayout.EAST, frame.getContentPane());
		txtpnOr.setText("OR");
		txtpnOr.setForeground(Color.BLACK);
		txtpnOr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnOr.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnOr);
		
		JTextPane txtpnMac_1 = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtpnMac_1, 0, SpringLayout.WEST, txtpnAlgo);
		txtpnMac_1.setText("Mac 1:");
		txtpnMac_1.setForeground(Color.BLACK);
		txtpnMac_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnMac_1.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnMac_1);
		
		JTextPane txtpnMac_2 = new JTextPane();
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnMac_1, -13, SpringLayout.NORTH, txtpnMac_2);
		springLayout.putConstraint(SpringLayout.WEST, txtpnMac_2, 130, SpringLayout.EAST, textField_3);
		txtpnMac_2.setText("Mac 2:");
		txtpnMac_2.setForeground(Color.BLACK);
		txtpnMac_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnMac_2.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnMac_2);
		
		JTextPane txtpnMac_3 = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnMac_3, 359, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnMac_2, -6, SpringLayout.NORTH, txtpnMac_3);
		springLayout.putConstraint(SpringLayout.WEST, txtpnMac_3, 0, SpringLayout.WEST, txtpnAlgo);
		txtpnMac_3.setText("Mac 3:");
		txtpnMac_3.setForeground(Color.BLACK);
		txtpnMac_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnMac_3.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnMac_3);
		
		textField_7 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_7, 0, SpringLayout.EAST, txtpnMac_1);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_7, 0, SpringLayout.SOUTH, txtpnMac_1);
		springLayout.putConstraint(SpringLayout.EAST, textField_7, 61, SpringLayout.EAST, txtpnMac_1);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_7.setColumns(10);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_8, 0, SpringLayout.NORTH, txtpnMac_2);
		springLayout.putConstraint(SpringLayout.WEST, textField_8, 0, SpringLayout.EAST, txtpnMac_2);
		springLayout.putConstraint(SpringLayout.EAST, textField_8, 0, SpringLayout.EAST, textField_7);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_8.setColumns(10);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_9, 6, SpringLayout.SOUTH, txtpnMac_2);
		springLayout.putConstraint(SpringLayout.WEST, textField_9, 0, SpringLayout.EAST, txtpnMac_3);
		springLayout.putConstraint(SpringLayout.EAST, textField_9, 0, SpringLayout.EAST, textField_7);
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_9.setColumns(10);
		frame.getContentPane().add(textField_9);
		
		JTextPane txtpnSig = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnSig, 6, SpringLayout.SOUTH, txtpnOr);
		springLayout.putConstraint(SpringLayout.WEST, txtpnSig, 0, SpringLayout.WEST, txtpnOr);
		txtpnSig.setText("Signal 1:");
		txtpnSig.setForeground(Color.BLACK);
		txtpnSig.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnSig.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnSig);
		
		JTextPane txtpnSignal = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtpnSignal, 0, SpringLayout.WEST, txtpnOr);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnSignal, 0, SpringLayout.SOUTH, txtpnMac_2);
		txtpnSignal.setText("Signal 2:");
		txtpnSignal.setForeground(Color.BLACK);
		txtpnSignal.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnSignal.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnSignal);
		
		JTextPane txtpnSignal_1 = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtpnSignal_1, 0, SpringLayout.WEST, txtpnOr);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnSignal_1, 0, SpringLayout.SOUTH, txtpnMac_3);
		txtpnSignal_1.setText("Signal 3:");
		txtpnSignal_1.setForeground(Color.BLACK);
		txtpnSignal_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnSignal_1.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnSignal_1);
		
		textField_10 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_10, 0, SpringLayout.NORTH, txtpnMac_1);
		springLayout.putConstraint(SpringLayout.WEST, textField_10, 6, SpringLayout.EAST, txtpnSig);
		springLayout.putConstraint(SpringLayout.EAST, textField_10, 0, SpringLayout.EAST, btnStartAlgo);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_10.setColumns(10);
		frame.getContentPane().add(textField_10);
		
		textField_12 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_12, 6, SpringLayout.EAST, txtpnSignal);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_12, 0, SpringLayout.SOUTH, txtpnMac_2);
		springLayout.putConstraint(SpringLayout.EAST, textField_12, 0, SpringLayout.EAST, btnStartAlgo);
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_12.setColumns(10);
		frame.getContentPane().add(textField_12);
		
		textField_13 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_13, 6, SpringLayout.EAST, txtpnSignal_1);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_13, 0, SpringLayout.SOUTH, txtpnMac_3);
		springLayout.putConstraint(SpringLayout.EAST, textField_13, 0, SpringLayout.EAST, btnStartAlgo);
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_13.setColumns(10);
		frame.getContentPane().add(textField_13);
		
		JButton button = new JButton("Start algo 2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				Connect con=new Connect();
				String path=txtEnterPathTo.getText();
				Cordinate temp=con.algoritem2b(mac1,mac2,mac3,sig1,sig2,sig2);
				JOptionPane.showMessageDialog(null, temp.toString());
				
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, txtEnterPathTo);
		springLayout.putConstraint(SpringLayout.SOUTH, button, 0, SpringLayout.SOUTH, btnCancelFilters);
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBackground(SystemColor.menu);
		frame.getContentPane().add(button);
		
		JTextPane txtpnFilters = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnFilters, 0, SpringLayout.NORTH, txtpnDatabase);
		springLayout.putConstraint(SpringLayout.WEST, txtpnFilters, -14, SpringLayout.WEST, txtpnId_1);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnFilters, 0, SpringLayout.SOUTH, txtpnDatabase);
		springLayout.putConstraint(SpringLayout.EAST, txtpnFilters, 0, SpringLayout.EAST, txtpnId);
		txtpnFilters.setText("   Filters");
		txtpnFilters.setForeground(Color.BLACK);
		txtpnFilters.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtpnFilters.setBackground(Color.WHITE);
		frame.getContentPane().add(txtpnFilters);
	}
}
