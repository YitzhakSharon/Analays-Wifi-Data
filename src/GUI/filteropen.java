package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;

import Filter.AndFilter;
import Filter.Filters;
import Filter.Makefilter;
import Filter.Operator;
import Filter.OrFilter;
import object.Database;
import object.Scan;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class filteropen extends JPanel {
	
	

	/**
	 * Create the panel.
	 */
	public filteropen(Filters[] filter, Connect c,Database prev) {
		setBackground(new Color(250, 235, 215));
		setLayout(null);
		
		JLabel label = new JLabel("Number of Scan: " + c.data.getDatabase().size());
		label.setBounds(42, 213, 295, 27);
		add(label);
		
		JLabel label_1 = new JLabel("Number of Macs: " + c.data.getHash_map().size());
		label_1.setBounds(42, 251, 295, 27);
		add(label_1);
		
		JLabel lblFilters = new JLabel("Filters");
		lblFilters.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFilters.setBounds(149, 46, 119, 23);
		add(lblFilters);
		
		JLabel lblChooseFiltersAnd = new JLabel("Choose Filters and operators and then play Start filtering");
		lblChooseFiltersAnd.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChooseFiltersAnd.setBounds(21, 88, 400, 55);
		add(lblChooseFiltersAnd);
		
		JButton btnStartFiltering = new JButton("Start filtering");
		btnStartFiltering.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblChooseFiltersAnd.setText("");
				
				if(filter[1]==null){
					Makefilter t = new Makefilter(filter[0]);
					ArrayList<Scan> temp =new ArrayList<Scan>();
					temp.addAll(t.filtering(c.data.getDatabase()));
					c.data.setDatabase(temp);
				
					filter[0]=null;
					filter[1]=null;
					filter[2]=null;

				}
				if(filter[filter.length-1]!=null) {
					
					Filters And = new AndFilter();
					Filters Or = new OrFilter();

	
					if(filter[1].toString().equals("AndFilter [filter_1=null, filter_2=null]"
) || filter[1].toString().equals("OrFilter [filter_1=null, filter_2=null]")) {


						Filters f1;
						if(filter[1].toString().equals("AndFilter [filter_1=null, filter_2=null]")) {
							f1=new AndFilter(filter[0],filter[2]);
							Makefilter t = new Makefilter(f1);
							ArrayList<Scan> temp =new ArrayList<Scan>();
							t.filtering(c.data.getDatabase());
							temp.addAll(t.filtering(c.data.getDatabase()));
							c.data.setDatabase(temp);
							filter[0]=null;
							filter[1]=null;
							filter[2]=null;


						}
						else if( filter[1].toString().equals("OrFilter [filter_1=null, filter_2=null]")) {
							f1=new OrFilter(filter[0],filter[2]);
							Makefilter t = new Makefilter(f1);
							ArrayList<Scan> temp =new ArrayList<Scan>();
							temp.addAll(t.filtering(c.data.getDatabase()));
							c.data.setDatabase(temp);
							filter[0]=null;
							filter[1]=null;
							filter[2]=null;

						}

					}
			
		}

				
				label.setText("Number of Scan: " + c.data.getDatabase().size());
				label_1.setText("Number of Macs: " + c.data.getHash_map().size());
				
			
		}}  );
		btnStartFiltering.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStartFiltering.setBackground(UIManager.getColor("Button.background"));
		btnStartFiltering.setBounds(249, 154, 119, 23);
		add(btnStartFiltering);
		
		JButton btnUndoFiltering = new JButton("Undo filtering");
		btnUndoFiltering.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(prev.getDatabase().size()>0){
				c.setData(prev);
				}
				label.setText("Number of Scan: " + c.data.getDatabase().size());
				label_1.setText("Number of Macs: " + c.data.getHash_map().size());
				
			}
		});
		btnUndoFiltering.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUndoFiltering.setBackground(UIManager.getColor("Button.background"));
		btnUndoFiltering.setBounds(69, 154, 119, 23);
		add(btnUndoFiltering);
		
	

	}
}
