package mainWindow;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class StudentFeeForm extends JFrame implements ActionListener {
	
	Conn c = new Conn();
	ResultSet rs2, rs3;
	JComboBox cbsemester;
	JButton update, payfee, back;
	JLabel nameValue, fnameValue, courseValue, branchValue, paymentValue;
	JTextField rollValue;

	public StudentFeeForm() {
		setSize(600, 500);
		setLocation(300, 100);
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		
		JLabel heading = new JLabel("Student Payment Form");
		heading.setBounds(170, 10, 200, 20);
		heading.setFont(new Font("serif", Font.BOLD, 20));
		add(heading);
		
		JLabel lblrollnum = new JLabel("Enter Roll Number");
		lblrollnum.setBounds(40, 60, 200, 20);
		lblrollnum.setFont(new Font("serif", Font.BOLD, 20));
		add(lblrollnum); 
		
		rollValue = new JTextField();
		rollValue.setBounds(240, 60, 150, 20);
		rollValue.setFont(new Font("serif", Font.PLAIN, 20));
		add(rollValue);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(40, 100, 150, 20);
		lblname.setFont(new Font("serif", Font.BOLD, 20));
		add(lblname);
		
		nameValue = new JLabel();
		nameValue.setBounds(200, 100, 150, 20);
		nameValue.setFont(new Font("serif", Font.PLAIN, 20));
		add(nameValue);
		
		JLabel lblfname = new JLabel("Father's Name");
		lblfname.setBounds(40, 140, 150, 20);
		lblfname.setFont(new Font("serif", Font.BOLD, 20));
		add(lblfname);
		
		fnameValue = new JLabel();
		fnameValue.setBounds(200, 140, 150, 20);
		fnameValue.setFont(new Font("serif", Font.PLAIN, 20));
		add(fnameValue);
		
		JLabel course = new JLabel("Course");
		course.setBounds(40, 180, 150, 20);
		course.setFont(new Font("serif", Font.BOLD, 20));
		add(course);
		
		courseValue = new JLabel();
		courseValue.setBounds(200, 180, 150, 20);
		courseValue.setFont(new Font("serif", Font.PLAIN, 20));
		add(courseValue);
		
		JLabel branch = new JLabel("Branch");
		branch.setBounds(40, 220, 150, 20);
		branch.setFont(new Font("serif", Font.BOLD, 20));
		add(branch);
		
		branchValue = new JLabel();
		branchValue.setBounds(200, 220, 150, 20);
		branchValue.setFont(new Font("serif", Font.PLAIN, 20));
		add(branchValue);
		
		JLabel semester = new JLabel("Semester");
		semester.setBounds(40, 260, 150, 20);
		semester.setFont(new Font("serif", Font.BOLD, 20));
		add(semester);
		
		String semesters[] = {"semester1", "semester2", "semester3", "semester4", "semester5", "semester6", "semester7", "semester8"};
		cbsemester = new JComboBox(semesters);
		cbsemester.setBounds(200, 260, 150, 20);
		cbsemester.setBackground(Color.WHITE);
		add(cbsemester);
		
		JLabel payment = new JLabel("Total Payable");
		payment.setBounds(40, 300, 150, 20);
		payment.setFont(new Font("serif", Font.BOLD, 20));
		add(payment);
		
		paymentValue = new JLabel();
		paymentValue.setBounds(200, 300, 150, 20);
		paymentValue.setFont(new Font("serif", Font.PLAIN, 20));
		add(paymentValue);
		
		update = new JButton("Update");
		update.setBounds(20, 350, 100, 30);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.addActionListener(this);
		update.setFont(new Font("serif", Font.BOLD, 15));
		add(update);
		
		payfee = new JButton("Pay Fee");
		payfee.setBounds(140, 350, 100, 30);
		payfee.setBackground(Color.BLACK);
		payfee.setForeground(Color.WHITE);
		payfee.addActionListener(this);
		payfee.setFont(new Font("serif", Font.BOLD, 15));
		add(payfee);
		
		back = new JButton("Back");
		back.setBounds(260, 350, 100, 30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setFont(new Font("serif", Font.BOLD, 15));
		add(back);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==update) {
			try {
				rs2 = c.s.executeQuery("select * from Student where rollno='"+rollValue.getText()+"'");
				if(rs2.next()) {
					nameValue.setText(rs2.getString("name"));
					fnameValue.setText(rs2.getString("fname"));
					courseValue.setText(rs2.getString("course"));
					branchValue.setText(rs2.getString("branch"));
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				String sem = (String) cbsemester.getSelectedItem();
				String course = courseValue.getText();
				
				rs3 = c.s.executeQuery("select * from fee where course='"+course+"'");
				if(rs3.next()) {
					paymentValue.setText(rs3.getString(sem)); 
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(ae.getSource()==payfee) {
			
		}
	}

	public static void main(String[] args) {
		new StudentFeeForm();
	}

}
