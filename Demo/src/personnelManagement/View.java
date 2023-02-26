package personnelManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class View extends JFrame implements ActionListener{
	JTable table;
	Choice cId;
    JButton search, back;
	
	View(){
		super("View personnel");
		
		setBounds(0, 0, 900, 700);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lbsearch = new JLabel("Search by Personnel ID:");
		lbsearch.setBounds(20, 20, 200, 30);
		lbsearch.setFont(new Font("Serif", Font.PLAIN, 20));
		lbsearch.setForeground(Color.BLACK);
	    add(lbsearch);
	        
	    cId = new Choice();
	    cId.setBounds(250, 25, 200, 70);
	    add(cId);
	    
	    try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from Personnel");
            while(rs.next()) {
            cId.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		table = new JTable();
		
		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select * from Personnel");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0, 150, 900, 600);
		add(sp);
		
		search = new JButton("Search");
		search.setBackground(Color.BLACK);
		search.setForeground(Color.WHITE);
		search.setFocusPainted(false);
        search.setBounds(70, 80, 100, 35);
        search.addActionListener(this);
        add(search);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFocusPainted(false);
        back.setBounds(255, 80, 100, 35);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
	@Override
    public void actionPerformed(ActionEvent e2) {
        if (e2.getSource() == search) {
            String query = "select * from Personnel where id = '" + cId.getSelectedItem()+"'";
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
        	JOptionPane.showMessageDialog(null, "Are you sure?");
            setVisible(false);
        }
	}

	
	public static void main(String[] args) {
		new View();
	}

}
