package personnelManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Paycheck extends JFrame implements ActionListener{
	JButton print, close;
	JLabel lbId, lbmonth, lbyear;
	Choice cId, cm, cy;
	JTextArea ta;
	JPanel p1;
	Font f;
	
	Paycheck(){
		super("Paycheck");
		setBounds(0, 0, 500, 500);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		f = new Font("Arial", Font.BOLD, 18);
		
		lbId = new JLabel("ID:");
		lbId.setFont(f);
		
		lbmonth = new JLabel("Month:");
		lbmonth.setFont(f);
		
		lbyear = new JLabel("Year:");
		lbyear.setFont(f);
		
		cId = new Choice();
		cId.setFont(f);
		
		try
		{
			Conn conn1 = new Conn();
            ResultSet rs = conn1.s.executeQuery("select * from Personnel");
            while(rs.next()) {
            	cId.add(rs.getString("id"));
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cm = new Choice();
		cm.setFont(f);
		cm.add("January");
		cm.add("February");
		cm.add("March");
		cm.add("April");
		cm.add("May");
		cm.add("June");
		cm.add("July");
		cm.add("August");
		cm.add("September");
		cm.add("October");
		cm.add("November");
		cm.add("December");
		
		cy = new Choice();
		cy.setFont(f);
		cy.add("2018");
		cy.add("2019");
		cy.add("2020");
		cy.add("2021");
		cy.add("2022");
		cy.add("2023");
		
		print = new JButton("Print");
		print.setBackground(Color.BLACK);
		print.setForeground(Color.WHITE);
		print.setFocusPainted(false);
		print.addActionListener(this);
		
		close = new JButton("Close");
		close.setBackground(Color.BLACK);
		close.setForeground(Color.WHITE);
		close.setFocusPainted(false);
		close.addActionListener(this);
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 2, 10, 10));
		p1.add(lbId);
		p1.add(cId);
		p1.add(lbmonth);
		p1.add(cm);
		p1.add(lbyear);
		p1.add(cy);
		p1.add(print);
		p1.add(close);
		
		ta = new JTextArea();
		JScrollPane sp = new JScrollPane(ta);
		ta.setEditable(false);
		ta.setFont(new Font ("Arial", Font.PLAIN, 20));
		
		setLayout(new BorderLayout());
		add(sp, "Center");
		add(p1, "South");
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == print) {
			ta.setText("*********************** PAYCHECK ********************");
			try {
				Conn conn2 = new Conn();
				String eid = cId.getSelectedItem();
				String month_year = cm.getSelectedItem() + " " + cy.getSelectedItem();
				ResultSet rs = conn2.s.executeQuery("select * from Personnel where id = '"+eid+"'");
				while(rs.next()) {
					ta.append("\n\nID: " + rs.getString("id"));
					ta.append("\nName: " + rs.getString("name"));
					ta.append("\nPhone: " + rs.getString("phone"));
					ta.append("\nEmail: " + rs.getString("email"));
					ta.append("\n\n------------------------------------------------------------------\n\n");
				}
				
				String query = "select * from Salary where month_year = '"+month_year+"' and id = '"+eid+"'";
				ResultSet rs2 = conn2.s.executeQuery(query);
				
				if(rs2.next() == false) {
					ta.append("Record Not Found");
					ta.append("\n\nPlease add salary of this month and year for this record.");
					ta.append("\n\n-----------------------------------------------------------------");
				}
				
				else {
					ta.append("Basic Salary: " + Float.parseFloat(rs2.getString("basic")));
					ta.append("\nBonus: " + Float.parseFloat(rs2.getString("bonus")));
					
					ta.append("\n\n-------------------------------------------------------------------");
					float gross = Float.parseFloat(rs2.getString("basic")) + Float.parseFloat(rs2.getString("bonus"));
					double tax = (gross * 2.5)/100;
					double net = gross - tax;
					ta.append("\n\nGross Salary: " + gross);
					ta.append("\nTax 2.5% of salary: " + tax);
					ta.append("\nNet Salary: " + net);
				}
				
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
		if(e.getSource() == close) {
			JOptionPane.showMessageDialog(null, "Are you sure?");
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new Paycheck();
	}
}
