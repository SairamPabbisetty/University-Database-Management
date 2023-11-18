package mainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentDetails extends JFrame implements ActionListener {
	
	Choice crollno;
	Conn c;
	JLabel lblname, lblfname, lblrollno, lbldb, lbladdress, lblphone, lblemail, 
	lblx, lblxii, lblaadhar, lblcourse, lblbranch;
	JLabel nameValue, fnameValue, rollnoValue, dbValue, addressValue, phoneValue, emailValue, 
	xValue, xiiValue, aadharValue, courseValue, branchValue; 
	JButton search, save, insert, update,  close;
	ResultSet rs1, rs2;
	
	StudentDetails() {
		
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
				rs2 = c.s.executeQuery("select * from Student where rollno='"+crollno.getSelectedItem()+"'");
			
				if(rs2.next()) {
				
					lblname = new JLabel("Name");
					lblname.setBounds(50, 150, 100, 30);
					lblname.setFont(new Font("serif", Font.BOLD, 20));
					add(lblname);
					
					nameValue = new JLabel(rs2.getString("name"));
					nameValue.setBounds(200, 150, 150, 30);
					nameValue.setFont(new Font("serif", Font.BOLD, 20));
					add(nameValue);
					
					lblfname = new JLabel("Father's Name");
					lblfname.setBounds(400, 150, 200, 30);
					lblfname.setFont(new Font("serif", Font.BOLD, 20));
					add(lblfname);
					
					fnameValue = new JLabel(rs2.getString("fname"));
					fnameValue.setBounds(600, 150, 150, 30);
					fnameValue.setFont(new Font("serif", Font.BOLD, 20));
					add(fnameValue);
					
					lblrollno = new JLabel("Roll Number");
					lblrollno.setBounds(50, 200, 200, 30);
					lblrollno.setFont(new Font("serif", Font.BOLD, 20));
					add(lblrollno);
					
					rollnoValue = new JLabel(rs2.getString("rollno"));
					rollnoValue.setBounds(200, 200, 200, 30);
					rollnoValue.setFont(new Font("serif", Font.BOLD, 20));
					add(rollnoValue);
					
					lbldb = new JLabel("Date of Birth");
					lbldb.setBounds(400, 200, 200, 30);
					lbldb.setFont(new Font("serif", Font.BOLD, 20));
					add(lbldb);
					
					dbValue = new JLabel(rs2.getString("dob"));
					dbValue.setBounds(600, 200, 150, 30);
					dbValue.setFont(new Font("serif", Font.BOLD, 20));
					add(dbValue);
					
					lbladdress = new JLabel("Address");
					lbladdress.setBounds(50, 250, 200, 30);
					lbladdress.setFont(new Font("serif", Font.BOLD, 20));
					add(lbladdress);
					
					addressValue = new JLabel(rs2.getString("address"));
					addressValue.setBounds(200, 250, 150, 30);
					addressValue.setFont(new Font("serif", Font.BOLD, 20));
					add(addressValue);
					
					lblphone = new JLabel("Phone");
					lblphone.setBounds(400, 250, 200, 30);
					lblphone.setFont(new Font("serif", Font.BOLD, 20));
					add(lblphone);
					
					phoneValue = new JLabel(rs2.getString("phone"));
					phoneValue.setBounds(600, 250, 150, 30);
					phoneValue.setFont(new Font("serif", Font.BOLD, 20));
					add(phoneValue); 
					
					lblemail = new JLabel("Email");
					lblemail.setBounds(50, 300, 200, 30);
					lblemail.setFont(new Font("serif", Font.BOLD, 20));
					add(lblemail);
					
					emailValue = new JLabel(rs2.getString("email"));
					emailValue.setBounds(200, 300, 150, 30);
					emailValue.setFont(new Font("serif", Font.BOLD, 20));
					add(emailValue);
					
					lblx = new JLabel("Class X (%)");
					lblx.setBounds(400, 300, 200, 30);
					lblx.setFont(new Font("serif", Font.BOLD, 20));
					add(lblx);
					
					xValue = new JLabel(rs2.getString("class_x"));
					xValue.setBounds(600, 300, 150, 30);
					xValue.setFont(new Font("serif", Font.BOLD, 20));
					add(xValue);
					
					lblxii = new JLabel("Class XII (%)");
					lblxii.setBounds(50, 350, 200, 30);
					lblxii.setFont(new Font("serif", Font.BOLD, 20));
					add(lblxii);
					
					xiiValue = new JLabel(rs2.getString("class_xii"));
					xiiValue.setBounds(200, 350, 150, 30);
					xiiValue.setFont(new Font("serif", Font.BOLD, 20));
					add(xiiValue);
					
					lblaadhar = new JLabel("Aadhar Number");
					lblaadhar.setBounds(400, 350, 200, 30);
					lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
					add(lblaadhar);
					
					aadharValue = new JLabel(rs2.getString("aadhar"));
					aadharValue.setBounds(600, 350, 150, 30);
					aadharValue.setFont(new Font("serif", Font.BOLD, 20));
					add(aadharValue);
					
					lblcourse = new JLabel("Course");
					lblcourse.setBounds(50, 400, 200, 30);
					lblcourse.setFont(new Font("serif", Font.BOLD, 20));
					add(lblcourse);
					
					courseValue = new JLabel(rs2.getString("course"));
					courseValue.setBounds(200, 400, 150, 30);
					courseValue.setFont(new Font("serif", Font.BOLD, 20));
					add(courseValue);
					
					lblbranch = new JLabel("Branch");
					lblbranch.setBounds(400, 400, 200, 30);
					lblbranch.setFont(new Font("serif", Font.BOLD, 20));
					add(lblbranch);
					
					branchValue = new JLabel(rs2.getString("branch"));
					branchValue.setBounds(600, 400, 150, 30);
					branchValue.setFont(new Font("serif", Font.BOLD, 20));
					add(branchValue);
				
				} 
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(ae.getSource()==save) {
			
		} else if(ae.getSource()==insert) {
			new AddStud();
		} else if(ae.getSource()==update) {
			
		} else {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new StudentDetails();
	}

}
