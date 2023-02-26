package personnelManagement;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Delete extends JFrame implements ActionListener {

	Choice cId;
    JButton delete, cancel;
    
    Delete() {
    	super("Delete Personnel");
    	
        setLayout(null);
        
        JLabel lbId = new JLabel("Personnel ID:");
        lbId.setBounds(40, 35, 100, 30);
        lbId.setFont(new Font("Serif", Font.PLAIN, 17));
        add(lbId);
        
        cId = new Choice();
        cId.setBounds(175, 40, 150, 30);
        add(cId);
        
        try {
            Conn c = new Conn();
            String query = "select * from Personnel";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cId.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name:");
        labelname.setBounds(40, 85, 100, 30);
        labelname.setFont(new Font("Serif", Font.PLAIN, 17));
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(175, 85, 300, 30);
        lblname.setFont(new Font("Serif", Font.PLAIN, 19));
        add(lblname);
        
        JLabel labelpos = new JLabel("Position:");
        labelpos.setBounds(40, 135, 100, 30);
        labelpos.setFont(new Font("Serif", Font.PLAIN, 17));
        add(labelpos);
        
        JLabel lblpos = new JLabel();
        lblpos.setBounds(175, 135, 300, 30);
        lblpos.setFont(new Font("Serif", Font.PLAIN, 19));
        add(lblpos);
        
        JLabel labelphone = new JLabel("Phone:");
        labelphone.setBounds(40, 185, 100, 30);
        labelphone.setFont(new Font("Serif", Font.PLAIN, 17));
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setBounds(175, 185, 300, 30);
        lblphone.setFont(new Font("Serif", Font.PLAIN, 19));
        add(lblphone);
        
        JLabel labelemail = new JLabel("Email:");
        labelemail.setBounds(40, 235, 100, 30);
        labelemail.setFont(new Font("Serif", Font.PLAIN, 17));
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setBounds(175, 235, 300, 30);
        lblemail.setFont(new Font("Serif", Font.PLAIN, 17));
        add(lblemail);
        
        cId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from Personnel where id = '"+cId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblpos.setText(rs.getString("position"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80, 305, 100,30);
        delete.setFocusPainted (false);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(250, 305, 100,30);
        cancel.setFocusPainted (false);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 0, 600, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from Personnel where id = '"+cId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Personnel Information Deleted Sucessfully!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
        	JOptionPane.showMessageDialog(null, "Are you sure?");
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Delete();
    }
}

