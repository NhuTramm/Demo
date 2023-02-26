package personnelManagement;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomePage extends JFrame implements ActionListener{
	HomePage() {
		super("Personnel Home Page");
		
		setBounds(0, 0, 1380, 733);
		setLayout(null);
		setLocationRelativeTo(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\dashboard.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1380, 733, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1380, 733);
		add(image);
		
		JLabel text = new JLabel("WELCOME");
		text.setBounds(450, 550, 1000, 75);
		text.setFont(new Font("Serif", Font.PLAIN, 85));
		text.setForeground(Color.WHITE);
		image.add(text);
		
		JMenuBar mb = new JMenuBar();
		mb.setBounds(0, 0, 1380, 30);
		image.add(mb);
		
		JMenu personnel = new JMenu("PERSONNAL");
		personnel.setForeground(Color.DARK_GRAY);
		mb.add(personnel);
		
		JMenuItem add = new JMenuItem("Add personnel");
		add.addActionListener(this);
		personnel.add(add);
		
		JMenuItem find = new JMenuItem("View personnel");
		find.addActionListener(this);
		personnel.add(find);
		
		JMenuItem update = new JMenuItem("Update personnel");
		update.addActionListener(this);
		personnel.add(update);
		
		JMenuItem delete = new JMenuItem("Delete personnel");
		delete.addActionListener(this);
		personnel.add(delete);
				
		JMenu salary = new JMenu("SALARY");
		salary.setForeground(Color.DARK_GRAY);
		mb.add(salary);
		
		JMenuItem addSalary = new JMenuItem("Add salary");
		addSalary.addActionListener(this);
		salary.add(addSalary);
		
		JMenuItem paycheck = new JMenuItem("Paycheck");
		paycheck.addActionListener(this);
		salary.add(paycheck);
		
		JMenu exit = new JMenu("EXIT");
		exit.setForeground(Color.RED);
		mb.add(exit);
		
		JMenuItem logout = new JMenuItem("Logout");
		logout.addActionListener(this);
		exit.add(logout);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Add personnel")) {
			new AddPersonnel();
		} else if (e.getActionCommand().equals("View personnel")) {
			new View();
		} else if (e.getActionCommand().equals("Update personnel")) {
			new Update();
		} else if (e.getActionCommand().equals("Delete personnel")) {
			new Delete();
		} else if (e.getActionCommand().equals("Add salary")) {
			new Salary();
		} else if (e.getActionCommand().equals("Paycheck")) {
			new Paycheck();
		} else if (e.getActionCommand().equals("Logout")) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new HomePage();
	}
}

