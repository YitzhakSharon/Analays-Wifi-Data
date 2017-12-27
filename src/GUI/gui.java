package GUI;

import java.awt.EventQueue;
import com.toedter.calendar.JCalendar;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Time;
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
import de.micromata.opengis.kml.v_2_2_0.Placemark;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;

import org.omg.PortableServer.ServantRetentionPolicyValue;

import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gui {

	protected static final String Connect = null;
	private JFrame frame;
	private JTextField txtEnterPathTo;
	private JTextField txtEnterSignal_2;
	private JTextField txtEnterSignal_1;
	private JTextField txtEnterMac_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField enterfile;
	private JTextField enterpath_csv;
	private JTextField txtEnterName;
	private JTextField namekml;

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
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.getContentPane().setBackground(new Color(240, 255, 255));
		frame.setFont(new Font("Engravers MT", Font.BOLD, 16));
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

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

		txtEnterPathTo = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, txtEnterPathTo, -319, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtEnterPathTo, -13, SpringLayout.EAST, frame.getContentPane());
		txtEnterPathTo.setText("Format of CSV File");
		txtEnterPathTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnterPathTo.setColumns(10);
		frame.getContentPane().add(txtEnterPathTo);


		txtEnterMac_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtEnterMac_3, 4, SpringLayout.SOUTH, txtpnAlgo);
		springLayout.putConstraint(SpringLayout.WEST, txtEnterMac_3, 62, SpringLayout.WEST, txtpnAlgo);
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


		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 141, SpringLayout.NORTH, frame.getContentPane());
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setColumns(10);
		frame.getContentPane().add(textField);

		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField, 314, SpringLayout.EAST, textField_1);
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 141, SpringLayout.NORTH, frame.getContentPane());
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setColumns(10);
		frame.getContentPane().add(textField_1);

		JTextPane txtpnMac = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, txtpnMac, 3, SpringLayout.SOUTH, txtpnAlgo);
		springLayout.putConstraint(SpringLayout.EAST, txtpnMac, -6, SpringLayout.WEST, txtEnterMac_3);
		txtpnMac.setText("Mac:");
		txtpnMac.setForeground(Color.BLACK);
		txtpnMac.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnMac.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(txtpnMac);

		JTextPane txtpnPath = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, txtEnterPathTo, 16, SpringLayout.EAST, txtpnPath);
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnAlgo_1, -5, SpringLayout.NORTH, txtpnPath);
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
		springLayout.putConstraint(SpringLayout.NORTH, txtpnMac_1, 296, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, txtpnOr, -6, SpringLayout.NORTH, txtpnMac_1);
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

		JLabel lblCord = new JLabel("cord:");
		springLayout.putConstraint(SpringLayout.NORTH, lblCord, 9, SpringLayout.SOUTH, txtEnterMac_3);
		springLayout.putConstraint(SpringLayout.SOUTH, lblCord, -22, SpringLayout.NORTH, txtpnAlgo_1);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, -296, SpringLayout.WEST, lblCord);
		springLayout.putConstraint(SpringLayout.EAST, textField, -18, SpringLayout.WEST, lblCord);
		springLayout.putConstraint(SpringLayout.WEST, lblCord, 844, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblCord, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblCord);	

		JButton button_1 = new JButton("Start algo 1");
		springLayout.putConstraint(SpringLayout.WEST, button_1, 13, SpringLayout.EAST, txtEnterMac_3);
		springLayout.putConstraint(SpringLayout.SOUTH, button_1, -9, SpringLayout.NORTH, lblCord);
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

		JLabel num_of_Scan = new JLabel("number of Scan");
		springLayout.putConstraint(SpringLayout.WEST, num_of_Scan, 51, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, num_of_Scan, -622, SpringLayout.WEST, label);
		num_of_Scan.setFont(new Font("Tahoma", Font.BOLD, 13));
		springLayout.putConstraint(SpringLayout.SOUTH, num_of_Scan, -62, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(num_of_Scan);

		JLabel num_of_mac = new JLabel("number of macs ");
		springLayout.putConstraint(SpringLayout.NORTH, num_of_mac, 4, SpringLayout.NORTH, btnCancelFilters);
		springLayout.putConstraint(SpringLayout.WEST, num_of_mac, 51, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, num_of_mac, 0, SpringLayout.EAST, txtpnDatabase);
		num_of_mac.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(num_of_mac);

		enterfile = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, enterfile, 0, SpringLayout.WEST, txtpnDatabase);
		springLayout.putConstraint(SpringLayout.EAST, enterfile, 299, SpringLayout.WEST, frame.getContentPane());
		enterfile.setText("path to folder");
		frame.getContentPane().add(enterfile);
		enterfile.setColumns(10);

		enterpath_csv = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, enterpath_csv, -896, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, enterpath_csv, 0, SpringLayout.NORTH, txtpnAlgo_1);
		enterpath_csv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connect c =new  Connect ();
				String path = txtEnterPathTo.getText();
				Database data =c.readCSv(path);
				num_of_Scan.setText("number of Scan: "+data.getDatabase().size());
				num_of_mac.setText("number of macs: "+data.getHash_map().size());
				
			}
		});
		enterpath_csv.setText("Format of CSV File");
		frame.getContentPane().add(enterpath_csv);
		enterpath_csv.setColumns(10);

		JButton btninsertDatabase = new JButton("insert database");
		springLayout.putConstraint(SpringLayout.NORTH, enterfile, 5, SpringLayout.SOUTH, btninsertDatabase);
		springLayout.putConstraint(SpringLayout.WEST, btninsertDatabase, 68, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btninsertDatabase, 0, SpringLayout.SOUTH, txtpnAlgo);
		btninsertDatabase.setBackground(UIManager.getColor("Button.background"));
		btninsertDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String path =enterfile.getText();
				Connect c= new Connect();
				Database data=c.enterdatabase(path);
				num_of_Scan.setText("number of Scan: "+data.getDatabase().size());
				num_of_mac.setText("number of macs: "+data.getHash_map().size());
				

			}
		});
		frame.getContentPane().add(btninsertDatabase);
		JButton btnNewButton = new JButton("insert CSV");
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 607, SpringLayout.EAST, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btninsertDatabase, 33, SpringLayout.EAST, btnNewButton);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -9, SpringLayout.NORTH, enterpath_csv);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -58, SpringLayout.EAST, num_of_Scan);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path=enterpath_csv.getText();
				Connect c= new Connect();
				Database data=c.readCSv(path);
				num_of_Scan.setText("number of Scan: "+data.getDatabase().size());
				num_of_mac.setText("number of macs: "+data.getHash_map().size());
			
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		
		
		JButton btnClearDatabase = new JButton("clear database");
		springLayout.putConstraint(SpringLayout.WEST, txtpnPath, 699, SpringLayout.EAST, btnClearDatabase);
		springLayout.putConstraint(SpringLayout.WEST, btnClearDatabase, 72, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, btnClearDatabase);
		springLayout.putConstraint(SpringLayout.NORTH, btnClearDatabase, 0, SpringLayout.NORTH, txtEnterPathTo);
		btnClearDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect c= new Connect();
				Database data=c.clear();
				num_of_Scan.setText("number of Scan: "+data.getDatabase().size());
				num_of_mac.setText("number of macs: "+data.getHash_map().size());
			}
		});
		frame.getContentPane().add(btnClearDatabase);
		
		JButton btnCsvDataIn = new JButton("save data in CSV");
		springLayout.putConstraint(SpringLayout.NORTH, btnCsvDataIn, 39, SpringLayout.SOUTH, btnClearDatabase);
		springLayout.putConstraint(SpringLayout.WEST, btnCsvDataIn, 0, SpringLayout.WEST, btnNewButton);
		btnCsvDataIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name =enterpath_csv.getText();
				Connect c = new Connect();
			c.writeCSV(name);
			}
		});
		frame.getContentPane().add(btnCsvDataIn);
		
		txtEnterName = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txtEnterName, 0, SpringLayout.WEST, txtpnDatabase);
		springLayout.putConstraint(SpringLayout.SOUTH, txtEnterName, 0, SpringLayout.SOUTH, txtpnMac_2);
		springLayout.putConstraint(SpringLayout.EAST, txtEnterName, 0, SpringLayout.EAST, enterfile);
		txtEnterName.setText("enter name");
		frame.getContentPane().add(txtEnterName);
		txtEnterName.setColumns(10);
		
		JButton btnSaveInKml = new JButton("save in kml");
		springLayout.putConstraint(SpringLayout.NORTH, btnSaveInKml, 0, SpringLayout.NORTH, textField_9);
		springLayout.putConstraint(SpringLayout.WEST, btnSaveInKml, 0, SpringLayout.WEST, btninsertDatabase);
		btnSaveInKml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=namekml.getText(); 
				Connect c = new Connect();
				c.saveinkml(name);
			}
		});
		frame.getContentPane().add(btnSaveInKml);
		
		namekml = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, namekml, 50, SpringLayout.SOUTH, txtEnterName);
		springLayout.putConstraint(SpringLayout.WEST, namekml, 131, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, namekml, 288, SpringLayout.WEST, frame.getContentPane());
		namekml.setText("enter name ");
		frame.getContentPane().add(namekml);
		namekml.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, txtpnAlgo);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 31, SpringLayout.SOUTH, label);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, txtEnterPathTo);
		frame.getContentPane().add(lblNewLabel);
		
		JButton button_2 = new JButton("Start algo 2");
		springLayout.putConstraint(SpringLayout.NORTH, button_2, 6, SpringLayout.SOUTH, txtEnterPathTo);
		springLayout.putConstraint(SpringLayout.EAST, button_2, 0, SpringLayout.EAST, txtEnterPathTo);
		button_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Connect con=new Connect();
						String path=txtEnterPathTo.getText();
						con.algoritem2a(path);
						lblNewLabel.setText("resutlt_algo2.csv was created check workspace");
					}
				});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_2.setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().add(button_2);
		
		JTextPane textPane_3 = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, textPane_3, 0, SpringLayout.SOUTH, btninsertDatabase);
		springLayout.putConstraint(SpringLayout.WEST, textPane_3, 82, SpringLayout.WEST, frame.getContentPane());
		textPane_3.setText("Path:");
		textPane_3.setForeground(Color.BLACK);
		textPane_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPane_3.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(textPane_3);
		
		JTextPane textPane_4 = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, enterpath_csv, 6, SpringLayout.EAST, textPane_4);
		springLayout.putConstraint(SpringLayout.NORTH, textPane_4, 0, SpringLayout.NORTH, txtpnAlgo_1);
		springLayout.putConstraint(SpringLayout.WEST, textPane_4, 0, SpringLayout.WEST, btnClearDatabase);
		textPane_4.setText("Path:");
		textPane_4.setForeground(Color.BLACK);
		textPane_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPane_4.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, textPane_5, 0, SpringLayout.NORTH, txtpnMac_2);
		springLayout.putConstraint(SpringLayout.WEST, textPane_5, 0, SpringLayout.WEST, btnNewButton);
		textPane_5.setText("Path:");
		textPane_5.setForeground(Color.BLACK);
		textPane_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPane_5.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(textPane_5);
		
		JTextPane textPane_6 = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, textPane_6, 12, SpringLayout.SOUTH, btnSaveInKml);
		springLayout.putConstraint(SpringLayout.WEST, textPane_6, 0, SpringLayout.WEST, btninsertDatabase);
		textPane_6.setText("Path:");
		textPane_6.setForeground(Color.BLACK);
		textPane_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPane_6.setBackground(new Color(255, 250, 250));
		frame.getContentPane().add(textPane_6);
		
		JButton time = new JButton("Time");
		time.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui_filter_time window = new gui_filter_time();
				window.time_filer_Screen();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, time, 0, SpringLayout.NORTH, textField);
		frame.getContentPane().add(time);
		
		JButton Place = new JButton("place");
		springLayout.putConstraint(SpringLayout.EAST, time, 0, SpringLayout.EAST, Place);
		Place.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui_filter_byPlace window = new gui_filter_byPlace();
				window.GUI_BY_PLACE();
			}
		});
		frame.getContentPane().add(Place);
		
		JButton Id = new JButton("id");
		springLayout.putConstraint(SpringLayout.NORTH, Id, 0, SpringLayout.NORTH, txtpnAlgo_1);
		Id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui_filter_byID window = new gui_filter_byID();
				window.GUI_ID();
			}
		});
		frame.getContentPane().add(Id);
		
		JButton NotPlace = new JButton("not place");
		springLayout.putConstraint(SpringLayout.NORTH, Place, 0, SpringLayout.NORTH, NotPlace);
		springLayout.putConstraint(SpringLayout.WEST, Place, 46, SpringLayout.EAST, NotPlace);
		springLayout.putConstraint(SpringLayout.NORTH, NotPlace, 26, SpringLayout.SOUTH, txtpnFilters);
		springLayout.putConstraint(SpringLayout.WEST, NotPlace, 182, SpringLayout.EAST, enterfile);
		NotPlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui_not_Place window = new gui_not_Place();
				window.GUI_NotBY_PLACE();
			}
		});
		frame.getContentPane().add(NotPlace);
		
		JButton NotTime = new JButton("not time");
		springLayout.putConstraint(SpringLayout.NORTH, NotTime, 0, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, NotTime, 0, SpringLayout.EAST, NotPlace);
		NotTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui_filter_NOttime window = new gui_filter_NOttime();
				window.NOTtime_filer_Screen();
				NotTime.setEnabled(true);
			}
		});
		frame.getContentPane().add(NotTime);
		
		JButton NotId = new JButton("not id");
		springLayout.putConstraint(SpringLayout.WEST, Id, 61, SpringLayout.EAST, NotId);
		springLayout.putConstraint(SpringLayout.NORTH, NotId, 0, SpringLayout.NORTH, txtpnAlgo_1);
		springLayout.putConstraint(SpringLayout.EAST, NotId, 0, SpringLayout.EAST, NotPlace);
		NotId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_not_id window = new  GUI_not_id();
				window.GUI_not_ID();
			}
		});
		frame.getContentPane().add(NotId);
		JButton btnStartFilter = new JButton("Start filter");
		btnStartFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnStartFilter, -640, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnCancelFilters, 54, SpringLayout.EAST, btnStartFilter);
		springLayout.putConstraint(SpringLayout.NORTH, btnStartFilter, 0, SpringLayout.NORTH, btnCancelFilters);
		btnStartFilter.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStartFilter.setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().add(btnStartFilter);

		

	}
}