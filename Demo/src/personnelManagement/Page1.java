package personnelManagement;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Page1 extends JFrame implements ActionListener{
	
	Page1() {
		setSize(1100, 580);
		setLocationRelativeTo(null);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\page1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1200, 565, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1200, 565);
		add(image);
		
		JLabel text = new JLabel("PERSONNEL MANAGEMENT SYSTEM");
		text.setBounds(20, 20, 1000, 150);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("serif", Font.PLAIN, 40));
		image.add(text);
		
		JButton next = new JButton("Next");
		next.setBounds(950, 78, 110, 40);
		next.setContentAreaFilled (false);
		next.setFocusPainted (false);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		next.setFont(new Font("serif", Font.PLAIN, 21));
		image.add(next);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Login();
	}

	public static void main(String[] args) {
		new Page1();
	}
}
