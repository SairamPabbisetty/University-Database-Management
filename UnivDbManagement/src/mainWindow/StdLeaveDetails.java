package mainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StdLeaveDetails extends JFrame implements ActionListener {
	
	Choice crollno;
	Conn c;
	ResultSet rs1, rs2;
	JButton search, save, insert, update, close;
	JLabel lblrollno, lblrollnoValue, lbldate, lbldateValue, lblduration, lbldurationValue;
	
	StdLeaveDetails() {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Search by Roll Number");
		heading.setBounds(20, 20, 150, 20);
		add(heading);
		
		crollno = new Choice();
		crollno.setBounds(180, 20, 150, 20);
		add(crollno);
		
		try {
			
			c = new Conn();
			rs1 = c.s.executeQuery("select * from Student");
			while(rs1.next()) {
				crollno.add(rs1.getString("rollno"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		search = new JButton("Search");
		search.setBounds(20, 70, 80, 20);
		search.addActionListener(this);
		add(search);
		
		save = new JButton("Save(pdf)");
		save.setBounds(120, 70, 100, 20);
		save.addActionListener(this);
		add(save);
		
		insert = new JButton("Add");
		insert.setBounds(250, 70, 80, 20);
		insert.addActionListener(this);
		add(insert);
		
		update = new JButton("Update");
		update.setBounds(350, 70, 80, 20);
		update.addActionListener(this);
		add(update);
		
		close = new JButton("Close");
		close.setBounds(450, 70, 80, 20);
		close.addActionListener(this);
		add(close);
		
		setSize(900, 700);
		setLocation(300, 100);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==search) {
			try {
				rs2 = c.s.executeQuery("select * from studentleave where rollno='"+crollno.getSelectedItem()+"'");
			
				if(rs2.next()) {
				
					lblrollno = new JLabel("Roll Number");
					lblrollno.setBounds(50, 150, 150, 30);
					lblrollno.setFont(new Font("serif", Font.BOLD, 20));
					add(lblrollno);
					
					lblrollnoValue = new JLabel(rs2.getString("rollno"));
					lblrollnoValue.setBounds(200, 150, 150, 30);
					lblrollnoValue.setFont(new Font("serif", Font.BOLD, 20));
					add(lblrollnoValue);
					
					lbldate = new JLabel("Date");
					lbldate.setBounds(50, 200, 200, 30);
					lbldate.setFont(new Font("serif", Font.BOLD, 20));
					add(lbldate);
					
					lbldateValue = new JLabel(rs2.getString("date"));
					lbldateValue.setBounds(200, 200, 200, 30);
					lbldateValue.setFont(new Font("serif", Font.BOLD, 20));
					add(lbldateValue);
					
					lblduration = new JLabel("Duration");
					lblduration.setBounds(50, 250, 200, 30);
					lblduration.setFont(new Font("serif", Font.BOLD, 20));
					add(lblduration);
					
					lbldurationValue = new JLabel(rs2.getString("duration"));
					lbldurationValue.setBounds(200, 250, 200, 30);
					lbldurationValue.setFont(new Font("serif", Font.BOLD, 20));
					add(lbldurationValue);
				
				} 
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(ae.getSource()==save) {
			
		} else if(ae.getSource()==insert) {
			new StudentLeave();
		} else if(ae.getSource()==update) {
			
		} else {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new StdLeaveDetails();
	}

}
