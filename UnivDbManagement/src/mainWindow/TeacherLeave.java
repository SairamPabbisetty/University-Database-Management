package mainWindow;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class TeacherLeave extends JFrame implements ActionListener {

	Conn c;
	ResultSet rs1;
	Choice cempid, ctime;
	JDateChooser dcdate;
	JButton submit, cancel;
	
	TeacherLeave() {
		
		setSize(500, 500);
		setLocation(550, 100);
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		
		JLabel heading = new JLabel("Apply Leave (Teacher)");
		heading.setBounds(40, 50, 300, 30);
		heading.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(heading);
		
		JLabel lblrollno = new JLabel("Search by Employee Id");
		lblrollno.setBounds(60, 100, 240, 20);
		lblrollno.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblrollno);
		
		cempid = new Choice();
		cempid.setBounds(60, 130, 200, 20);
		add(cempid);
		
		try {
			
			c = new Conn();
			rs1 = c.s.executeQuery("select * from Teacher");
			while(rs1.next()) {
				cempid.add(rs1.getString("empId"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel lbldb = new JLabel("Date");
		lbldb.setBounds(60, 180, 200, 20);
		lbldb.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lbldb);
		
		dcdate = new JDateChooser();
		dcdate.setBounds(60, 210, 200, 30);
		add(dcdate);
		
		JLabel lbltime = new JLabel("Time Duration");
		lbltime.setBounds(60, 260, 200, 20);
		lbltime.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lbltime);
		
		ctime = new Choice();
		ctime.setBounds(60, 290, 200, 20);
		ctime.add("Full Day");
		ctime.add("Half Day");
		add(ctime);
		
		submit = new JButton("Submit");
		submit.setBounds(60, 350, 100, 30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		submit.setFont(new Font("serif", Font.BOLD, 15));
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(200, 350, 100, 30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		cancel.setFont(new Font("serif", Font.BOLD, 15));
		add(cancel);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {
			
			String empid = cempid.getSelectedItem();
			String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
			String duration = ctime.getSelectedItem();
			
			String query = "insert into teacherleave values('"+empid+"', '"+date+"', '"+duration+"')";
			
			try {
				
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Leave Confirmed");
				setVisible(false);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new TeacherLeave();
	}

}
