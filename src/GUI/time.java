package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.toedter.calendar.JDateChooser;

import Filter.AndFilter;
import Filter.FilterByTime;
import Filter.Filters;
import Filter.Makefilter;
import Filter.NotFilter;
import Filter.Operator;
import Filter.OrFilter;
import object.Database;
import java.awt.Font;
import java.awt.Color;

public class time extends JPanel {
	private String min;
	private String max;
	private JTextField txt_max_hour;
	private JTextField txt_min_hour;

	/**
	 * Create the panel.
	 */
	public time(Filters [] filter,Connect c) {
		setBackground(new Color(250, 235, 215));
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		JDateChooser txt_max_year = new JDateChooser();
		springLayout.putConstraint(SpringLayout.NORTH, txt_max_year, 89, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, txt_max_year, 120, SpringLayout.WEST, this);
		add(txt_max_year);

		txt_max_hour = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, txt_max_hour, 0, SpringLayout.WEST, txt_max_year);
		txt_max_hour.setText("hh:mm:ss");
		springLayout.putConstraint(SpringLayout.NORTH, txt_max_hour, 6, SpringLayout.SOUTH, txt_max_year);
		springLayout.putConstraint(SpringLayout.EAST, txt_max_hour, 0, SpringLayout.EAST, txt_max_year);
		add(txt_max_hour);
		txt_max_hour.setColumns(10);

		JDateChooser txt_min_year = new JDateChooser();
		springLayout.putConstraint(SpringLayout.WEST, txt_min_year, 0, SpringLayout.WEST, txt_max_year);
		add(txt_min_year);

		txt_min_hour = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txt_min_hour, 6, SpringLayout.SOUTH, txt_min_year);
		springLayout.putConstraint(SpringLayout.EAST, txt_min_hour, 0, SpringLayout.EAST, txt_max_year);
		txt_min_hour.setText("hh:mm:ss");
		add(txt_min_hour);
		txt_min_hour.setColumns(10);

		JButton btnApply = new JButton("apply");
		springLayout.putConstraint(SpringLayout.NORTH, btnApply, 6, SpringLayout.SOUTH, txt_min_hour);
		springLayout.putConstraint(SpringLayout.WEST, btnApply, 91, SpringLayout.WEST, this);
		btnApply.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String date_mintest=txt_max_year.getDate().toLocaleString();
				String date_min=date_mintest.substring(9, date_mintest.length());
				String date_maxt =txt_min_year.getDate().toLocaleString();
				String date_max=date_maxt.substring(9, date_maxt.length());
				String min_time=txt_min_hour.getText();
				String max_time=txt_max_hour.getText();
				min = date_min +" "+min_time;
				max = date_max+ " "+max_time;
				min=FilterByTime.CheckTime(min);
				max=FilterByTime.CheckTime(max);
				Date mindate = FilterByTime.stringToDate(min);
				Date maxdate = FilterByTime.stringToDate(max);

				if(!mindate.before(maxdate)) {
					JOptionPane.showMessageDialog(new JFrame(), "Please enter correct time");
				}
				Filters ft= new FilterByTime(mindate, maxdate);
				if(filter[1]!=null)
					filter[2]= ft;
				else 
					filter[0]= ft;
				JOptionPane.showMessageDialog(new JFrame(), "The Filter by Time is Apply");


			}

		});
		add(btnApply);

		JButton btnApply_1 = new JButton("! apply");
		springLayout.putConstraint(SpringLayout.SOUTH, btnApply_1, -44, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnApply_1, -130, SpringLayout.EAST, this);
		btnApply_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnApply_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date_mintest=txt_max_year.getDate().toLocaleString();
				String date_min=date_mintest.substring(9, date_mintest.length());
				String date_maxt =txt_min_year.getDate().toLocaleString();
				String date_max=date_maxt.substring(9, date_maxt.length());
				String min_time=txt_min_hour.getText();
				String max_time=txt_max_hour.getText();
				min = date_min +" "+min_time;
				max = date_max+ " "+max_time;
				min=FilterByTime.CheckTime(min);
				max=FilterByTime.CheckTime(max);
				Date mindate = FilterByTime.stringToDate(min);
				Date maxdate = FilterByTime.stringToDate(max);

				if(!mindate.before(maxdate)) {
					JOptionPane.showMessageDialog(new JFrame(), "Please enter correct time");
				}
				Filters s=new FilterByTime(min,max);
				Filters ft=new NotFilter(s);
				if(filter[1]!=null)
					filter[2]= ft;
				else 
					filter[0]= ft;

				JOptionPane.showMessageDialog(new JFrame(), "The Filter not by Time is Apply ");
			}

		});
		add(btnApply_1);

		JLabel lblFilterByTime = new JLabel("Filter by Time");
		springLayout.putConstraint(SpringLayout.WEST, lblFilterByTime, 180, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblFilterByTime, -31, SpringLayout.NORTH, txt_max_year);
		lblFilterByTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblFilterByTime);

		JLabel lblStart = new JLabel("Start:");
		springLayout.putConstraint(SpringLayout.NORTH, lblStart, 0, SpringLayout.NORTH, txt_max_year);
		lblStart.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblStart);

		JLabel lblEnd_1 = new JLabel("End:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblEnd_1, -107, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, txt_min_year, 0, SpringLayout.NORTH, lblEnd_1);
		springLayout.putConstraint(SpringLayout.WEST, lblStart, 0, SpringLayout.WEST, lblEnd_1);
		springLayout.putConstraint(SpringLayout.WEST, lblEnd_1, 66, SpringLayout.WEST, this);
		lblEnd_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblEnd_1);

	}
}

