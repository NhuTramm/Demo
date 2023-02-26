package personnelManagement;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	JTextField username;
	JPasswordField password;
	JButton login, cancel;
	
	Login(){
		super("Login");
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel user = new JLabel("Username");
		user.setBounds(40, 40, 100, 30);
		add(user);
		
		username = new JTextField();
		username.setBounds(150, 40, 150, 30);
		add(username);
		
		JLabel pass = new JLabel("Password");
		pass.setBounds(40, 97, 100, 30);
		add(pass);
		
		password = new JPasswordField();
		password.setBounds(150, 97, 150, 30);
		add(password);
		
		login = new JButton("Login");
		login.setBounds(40, 170, 120, 30);
		login.setFocusPainted (false);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(180, 170, 120, 30);
		cancel.setFocusPainted (false);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\manager.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 15, 200, 200);
		add(image);
		
		setBounds(500, 200, 600, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login) {
			String user = username.getText();
			String pass = password.getText();
			
			try {
				Conn c = new Conn();
				String query = "select * from Login where username = '" + user + "' and password = '" + pass + "'";
				ResultSet rs = c.s.executeQuery(query);
				
				if(rs.next()) {
					setVisible(false);
					new HomePage();
				} else {
					JOptionPane.showMessageDialog(null, "Invalid username or password");
					setVisible(false);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if(e.getSource() == cancel) {
			setVisible(false);
		}
	}
	public static void main(String[] args) {
		new Login();
	}
}

