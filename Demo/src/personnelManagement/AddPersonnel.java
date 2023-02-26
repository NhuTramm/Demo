package personnelManagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddPersonnel extends JFrame implements ActionListener{
	JTextField tfid, tfname, tfage, tfphone, tfemail, tfedu, tfaddress;
	JRadioButton rbmale, rbfemale, rb3gender;
	JButton submit, cancel;
	JComboBox cbposition, cbedu, cbmaritalstatus;
	
	AddPersonnel() {
		super("Add personnel");
		
		setBounds(0, 0, 900, 700);
		setLayout(null);
		setLocationRelativeTo(null);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\add.png"));
		Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 700);
		add(image);
		
		JLabel text = new JLabel("New Personnel Details");
		text.setBounds(250, 30, 1000, 50);
		text.setFont(new Font("Serif", Font.PLAIN, 45));
		text.setForeground(Color.LIGHT_GRAY);
		image.add(text);
		
		JLabel lbname = new JLabel("Name:");
		lbname.setBounds(50, 150, 120, 30);
		lbname.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbname.setForeground(Color.BLACK);
		image.add(lbname);
		
		tfname = new JTextField();
		tfname.setBounds(170, 150, 208, 30);
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
		
		rbmale = new JRadioButton("Male");
		rbmale.setBounds(160, 310, 70, 30);
		rbmale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rbmale.setContentAreaFilled (false);
		rbmale.setBackground(Color.WHITE);
		image.add(rbmale);
		
		rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(225, 310, 90, 30);
		rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rbfemale.setBackground(Color.WHITE);
		rbfemale.setContentAreaFilled (false);
		image.add(rbfemale);
		
		rb3gender = new JRadioButton("Other");
		rb3gender.setBounds(315, 310, 70, 30);
		rb3gender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rb3gender.setContentAreaFilled (false);
		rb3gender.setBackground(Color.WHITE);
		image.add(rb3gender);
		
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);
		bg.add(rb3gender);
		
		JLabel lbjob = new JLabel("Position:");
		lbjob.setBounds(50, 390, 120, 30);
		lbjob.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbjob);
		
		String str[] = { "CEO", "Manager", "Accountant", "Audit", "Marketer", "Secretary", "HR staff", "Sale staff" };
		cbposition = new JComboBox(str);
		cbposition.setBounds(170, 390, 208, 30);
		cbposition.setBackground(Color.WHITE);
		image.add(cbposition);
			
		JLabel lbphone = new JLabel("Phone:");
		lbphone.setBounds(50, 470, 120, 30);
		lbphone.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(170, 470, 208, 30);
		image.add(tfphone);
		
		JLabel lbid = new JLabel("ID:");
		lbid.setBounds(500, 150, 120, 30);
		lbid.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbid);
		
		tfid = new JTextField();
		tfid.setBounds(615, 150, 208, 30);
		image.add(tfid);
		
		JLabel lbedu = new JLabel("Education:");
		lbedu.setBounds(500, 230, 120, 30);
		lbedu.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbedu);
		
		String edu[] = { "9/12", "12/12", "College", "Masters", "PhD"};
		cbedu = new JComboBox(edu);
		cbedu.setBounds(615, 230, 208, 30);
		cbedu.setBackground(Color.WHITE);
		image.add(cbedu);
		
		JLabel lbaddress = new JLabel("Address:");
		lbaddress.setBounds(500, 310, 120, 30);
		lbaddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbaddress);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(615, 310, 208, 30);
		image.add(tfaddress);
		
		JLabel lbmaritalstatus = new JLabel("Status");
		lbmaritalstatus.setBounds(500, 390, 120, 30);
		lbmaritalstatus.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbmaritalstatus);
		
		String maritalstatus[] = { "Single", "Married", "Divorced"};
		cbmaritalstatus = new JComboBox(maritalstatus);
		cbmaritalstatus.setBounds(615, 390, 208, 30);
		cbmaritalstatus.setBackground(Color.WHITE);
		image.add(cbmaritalstatus);
		
		JLabel lbemail = new JLabel("Email:");
		lbemail.setBounds(500, 470, 120, 30);
		lbemail.setFont(new Font("Tahoma", Font.BOLD, 20));
		image.add(lbemail);
		
		tfemail = new JTextField();
		tfemail.setBounds(615, 470, 208, 30);
		image.add(tfemail);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFocusPainted(false);
		submit.setBounds(200, 550, 208, 30);
		submit.addActionListener(this);
		image.add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFocusPainted(false);
		cancel.setBounds(480, 550, 208, 30);
		cancel.addActionListener(this);
		image.add(cancel);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = tfname.getText();
		String age = tfage.getText();
		String phone = tfphone.getText();
		String email = tfemail.getText();
		String address = tfaddress.getText();
		String id = tfid.getText();
		
		String gender = null;
		if(rbmale.isSelected()) {
			gender = "Male";
		} else if (rbfemale.isSelected()) {
			gender = "Female";
		} else if (rb3gender.isSelected()) {
			gender = "Other";
		}
		
		String position = (String) cbposition.getSelectedItem();
		String education = (String) cbedu.getSelectedItem();
		String maritalstatus = (String) cbmaritalstatus.getSelectedItem();
		
		if(e.getSource() == submit) {
			try {
				Conn conn = new Conn();
				
				String query = "insert into Personnel values ('"+ name+ "', '"+ id+ "', '"+ age+ "', '"+ education+ "', '"+ gender+ "', '"+ address+ "', '"+ position+ "', '"+ maritalstatus+ "', '"+ phone+ "', '"+ email+ "')";
				
				conn.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Personnel added successfully");
				setVisible(false);
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(e.getSource() == cancel) {
			JOptionPane.showMessageDialog(null, "Are you sure?");
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new AddPersonnel();
	}	
}

