package mainWindow;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
	
	JButton login, cancel;
	JTextField usertf, pswdtf;

	Login() {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel userlbl = new JLabel("Username");
		userlbl.setBounds(40, 20, 100, 20);
		add(userlbl);
		
		usertf = new JTextField();
		usertf.setBounds(150, 20, 150, 20);
		add(usertf);
		
		JLabel pswdlbl = new JLabel("Password");
		pswdlbl.setBounds(40, 70, 100, 20);
		add(pswdlbl);
		
		pswdtf = new JPasswordField();
		pswdtf.setBounds(150, 70, 150, 20);
		add(pswdtf);
		
		login = new JButton("Login");
		login.setBounds(40, 140, 120, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		login.setFont(new Font("serif", Font.BOLD, 15));
		add(login);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(180, 140, 120, 30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		cancel.setFont(new Font("serif", Font.BOLD, 15));
		add(cancel); 
		
		setSize(600, 300);
		setLocation(500, 250);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == login) {
			String username = usertf.getText();
			String password = pswdtf.getText();
			
			String query = "select * from login where username='"+username+"' and password='"+password+"'";
			
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				
				if(rs.next()) {
					setVisible(false);
					new Project();
				} else {
					JOptionPane.showMessageDialog(null, "Invalid username or password");
					setVisible(false);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(ae.getSource() == cancel) {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new Login();
	}

}
