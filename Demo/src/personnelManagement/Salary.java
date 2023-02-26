package personnelManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Salary extends JFrame implements ActionListener{
	JLabel lbId, lbname, lbage, lbposition, lbphone, lbemail, lbbasic, lbbonus, lbmonth, lbyear;
	JTextField tfname, tfage, tfposition, tfphone, tfemail, tfbasic, tfbonus;
	Choice cId, cmonth, cyear;
	JButton bsubmit, bcancel;
	
	Salary(){
		super("Salary");
		
		setBounds(0, 0, 900, 700);
		setLayout(null);
		setLocationRelativeTo(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\salary1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 700);
		add(image);
		
		JLabel text = new JLabel("Personnel's Salary");
		text.setBounds(230, 30, 1000, 70);
		text.setFont(new Font("Serif", Font.PLAIN, 55));
		text.setForeground(Color.BLACK);
		image.add(text);
		
		lbId = new JLabel("Select ID:");
		lbId.setBounds(50, 150, 120, 30);
		lbId.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbId);
		
		cId = new Choice();
		cId.setBounds(200, 155, 208, 80);
	    image.add(cId);
	    
	    try
		{
			Conn conn1 = new Conn();
            ResultSet rs = conn1.s.executeQuery("select id from Personnel");
            while(rs.next()) {
            	cId.add(rs.getString("id"));
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    lbname = new JLabel("Name:");
		lbname.setBounds(500, 150, 120, 30);
		lbname.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbname.setForeground(Color.BLACK);
		image.add(lbname);
		
		tfname = new JTextField();
		tfname.setBounds(615, 150, 208, 30);
		tfname.setEditable(false);
		image.add(tfname);
		
		lbage = new JLabel("Age:");
		lbage.setBounds(50, 230, 120, 30);
		lbage.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbage);
		
		tfage = new JTextField();
		tfage.setBounds(200, 230, 208, 30);
		tfage.setEditable(false);
		image.add(tfage);
		
		lbposition = new JLabel("Position:");
		lbposition.setBounds(500, 230, 120, 30);
		lbposition.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbposition);
		
		tfposition = new JTextField();
		tfposition.setBounds(615, 230, 208, 30);
		tfposition.setEditable(false);
		image.add(tfposition);
		
		lbphone = new JLabel("Phone:");
		lbphone.setBounds(50, 310, 120, 30);
		lbphone.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(200, 310, 208, 30);
		tfphone.setEditable(false);
		image.add(tfphone);
		
		lbemail = new JLabel("Email:");
		lbemail.setBounds(500, 310, 120, 30);
		lbemail.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbemail);
		
		tfemail = new JTextField();
		tfemail.setBounds(615, 310, 208, 30);
		tfemail.setEditable(false);
		image.add(tfemail);
		
		lbbasic = new JLabel("Basic salary:");
		lbbasic.setBounds(50, 390, 200, 30);
		lbbasic.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbbasic);
		
		tfbasic = new JTextField();
		tfbasic.setBounds(200, 390, 208, 30);
		image.add(tfbasic);
		
		lbbonus = new JLabel("Bonus:");
		lbbonus.setBounds(500, 390, 120, 30);
		lbbonus.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbbonus);
		
		tfbonus = new JTextField();
		tfbonus.setBounds(615, 390, 208, 30);
		image.add(tfbonus);
		
		lbmonth = new JLabel("Select month:");
		lbmonth.setBounds(50, 470, 150, 30);
		lbmonth.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbmonth);
		
		cmonth = new Choice();
		cmonth.add("January");
		cmonth.add("February");
		cmonth.add("March");
		cmonth.add("April");
		cmonth.add("May");
		cmonth.add("June");
		cmonth.add("July");
		cmonth.add("August");
		cmonth.add("September");
		cmonth.add("October");
		cmonth.add("November");
		cmonth.add("December");
		cmonth.setBounds(200, 475, 208, 80);
		image.add(cmonth);
		
		lbyear = new JLabel("Select year:");
		lbyear.setBounds(498, 470, 120, 30);
		lbyear.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbyear);
		
		cyear = new Choice();
		cyear.add("2018");
		cyear.add("2019");
		cyear.add("2020");
		cyear.add("2021");
		cyear.add("2022");
		cyear.add("2023");
		cyear.setBounds(619, 475, 208, 80);
		image.add(cyear);
		
		bsubmit = new JButton("Submit");
		bsubmit.setBackground(Color.BLACK);
		bsubmit.setForeground(Color.WHITE);
		bsubmit.setFocusPainted(false);
		bsubmit.setBounds(220, 565, 208, 30);
		bsubmit.addActionListener(this);
		image.add(bsubmit);
		
		bcancel = new JButton("Cancel");
		bcancel.setBackground(Color.BLACK);
		bcancel.setForeground(Color.WHITE);
		bcancel.setFocusPainted(false);
		bcancel.setBounds(490, 565, 208, 30);
		bcancel.addActionListener(this);
		image.add(bcancel);
		
		try {
			Conn conn2 = new Conn();
			String rid = cId.getSelectedItem();
            ResultSet rs = conn2.s.executeQuery("select * from Personnel where id = '"+rid+"'");
            while(rs.next()) {
            	tfname.setText(rs.getString("name"));
            	tfage.setText(rs.getString("age"));
            	tfposition.setText(rs.getString("position"));
            	tfemail.setText(rs.getString("email"));
            	tfphone.setText(rs.getString("phone"));   	
            }
		} 
		catch(Exception e) {
			e.getStackTrace();
			
		}
		
		cId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from Personnel where id = '"+cId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                    	tfname.setText(rs.getString("name"));
		            	tfage.setText(rs.getString("age"));
		            	tfposition.setText(rs.getString("position"));
		            	tfemail.setText(rs.getString("email"));
		            	tfphone.setText(rs.getString("phone")); 
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bsubmit) {
			String id = cId.getSelectedItem();
			String name = tfname.getText();
			String age = tfage.getText();
			String position = tfposition.getText();
			String phone = tfphone.getText();
			String email = tfemail.getText();
			float basic = Float.parseFloat(tfbasic.getText());
			float bonus = Float.parseFloat(tfbonus.getText());
			String month = cmonth.getSelectedItem() + " " + cyear.getSelectedItem();
			
			try {
				Conn conn = new Conn();
				String query = "insert into Salary values ('"+ id+ "', '"+ name+ "', '"+ age+ "', '"+ position+ "', '"+ phone+ "', '"+ email+ "', '"+ basic+ "', '"+ bonus+ "', '"+ month+ "')";
	            conn.s.executeUpdate(query);
	            JOptionPane.showMessageDialog(null, "Your data successfully inserted");
	            setVisible(false);
			} 
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (e.getSource() == bcancel) {
			JOptionPane.showMessageDialog(null, "Are you sure?");
			setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		new Salary();
	}

}
