package personnelManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Update extends JFrame implements ActionListener{
	JTextField tfname, tfage, tfedu, tfgender, tfaddress, tfposition, tfmaritalstatus, tfphone, tfemail;
	JButton update, cancel;
	Choice ch;
	
	Update() {
		super("Update Personnel");
		
		setBounds(0, 0, 900, 700);
		setLayout(null);
		setLocationRelativeTo(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\update.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 700);
		add(image);
		
		JLabel text = new JLabel("Update Personnel Details");
		text.setBounds(230, 30, 1000, 70);
		text.setFont(new Font("Serif", Font.PLAIN, 45));
		text.setForeground(Color.BLACK);
		image.add(text);
		
		ch = new Choice();
		ch.setBounds(170, 155, 208, 80);
	    image.add(ch);
		
		try
		{
			Conn conn1 = new Conn();
            ResultSet rs = conn1.s.executeQuery("select id from Personnel");
            while(rs.next()) {
            	ch.add(rs.getString("id"));
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel lbname = new JLabel("Name:");
		lbname.setBounds(500, 150, 120, 30);
		lbname.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbname.setForeground(Color.BLACK);
		image.add(lbname);
		
		tfname = new JTextField();
		tfname.setBounds(615, 150, 208, 30);
		image.add(tfname);
		
		JLabel lbage = new JLabel("Age:");
		lbage.setBounds(50, 230, 120, 30);
		lbage.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbage);
		
		tfage = new JTextField();
		tfage.setBounds(170, 230, 208, 30);
		image.add(tfage);
		
		JLabel lbgender = new JLabel("Gender:");
		lbgender.setBounds(50, 310, 120, 30);
		lbgender.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbgender);
		
		tfgender = new JTextField();
		tfgender.setBounds(170, 310, 208, 30);
		image.add(tfgender);
		
		JLabel lbjob = new JLabel("Position:");
		lbjob.setBounds(50, 390, 120, 30);
		lbjob.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbjob);
		
		tfposition = new JTextField();
		tfposition.setBounds(170, 390, 208, 30);
		image.add(tfposition);
			
		JLabel lbphone = new JLabel("Phone:");
		lbphone.setBounds(50, 470, 120, 30);
		lbphone.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(170, 470, 208, 30);
		image.add(tfphone);
		
		JLabel lbid = new JLabel("ID:");
		lbid.setBounds(50, 150, 120, 30);
		lbid.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbid);
				
		JLabel lbedu = new JLabel("Education:");
		lbedu.setBounds(500, 230, 120, 30);
		lbedu.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbedu);
		
		tfedu = new JTextField();
		tfedu.setBounds(615, 230, 208, 30);
		image.add(tfedu);
		
		JLabel lbaddress = new JLabel("Address:");
		lbaddress.setBounds(500, 310, 120, 30);
		lbaddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbaddress);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(615, 310, 208, 30);
		image.add(tfaddress);
		
		JLabel lbmaritalstatus = new JLabel("Status:");
		lbmaritalstatus.setBounds(500, 390, 120, 30);
		lbmaritalstatus.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbmaritalstatus);
		
		tfmaritalstatus = new JTextField();
		tfmaritalstatus.setBounds(615, 390, 208, 30);
		image.add(tfmaritalstatus);
		
		JLabel lbemail = new JLabel("Email:");
		lbemail.setBounds(500, 470, 120, 30);
		lbemail.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbemail);
		
		tfemail = new JTextField();
		tfemail.setBounds(615, 470, 208, 30);
		image.add(tfemail);
		
		update = new JButton("Update");
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.setFocusPainted(false);
		update.setBounds(200, 550, 208, 30);
		update.addActionListener(this);
		image.add(update);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFocusPainted(false);
		cancel.setBounds(480, 550, 208, 30);
		cancel.addActionListener(this);
		image.add(cancel);
		
		ch.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from Personnel where id = '"+ch.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                    	tfname.setText(rs.getString("name"));
		            	tfage.setText(rs.getString("age"));
		            	tfedu.setText(rs.getString("education"));
		            	tfaddress.setText(rs.getString("address"));
		            	tfphone.setText(rs.getString("phone"));
		            	tfemail.setText(rs.getString("email"));
		            	tfmaritalstatus.setText(rs.getString("maritalstatus"));
		            	tfposition.setText(rs.getString("position"));
		            	tfgender.setText(rs.getString("gender"));  
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
		String id = ch.getSelectedItem();
		String name = tfname.getText();
		String age = tfage.getText();
		String status = tfmaritalstatus.getText();
		String phone = tfphone.getText();
		String email = tfemail.getText();
		String address = tfaddress.getText();
		String edu = tfedu.getText();
		String position = tfposition.getText();
		String gender = tfgender.getText();
		
		if(e.getSource() == update) {
			try {
				Conn conn = new Conn();
				String q1 = "update Personnel set name = '"+name+"', age = '"+age+"', maritalstatus = '"+status+"', phone = '"+phone+"', email = '"+email+"', address = '"+address+"', education = '"+edu+"',  position = '"+position+"', gender = '"+gender+"' where id ='"+id+"'"; 
	            conn.s.executeUpdate(q1);
	            JOptionPane.showMessageDialog(null, "Your data successfully updated");
	            setVisible(false);
			} 
			catch (Exception e2) {
				e2.printStackTrace();
			}
		} 
		if(e.getSource() == cancel) {
			JOptionPane.showMessageDialog(null, "Are you sure?");
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new Update();
	}

}
