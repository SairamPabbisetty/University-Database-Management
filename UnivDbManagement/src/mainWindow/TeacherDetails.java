package mainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TeacherDetails extends JFrame implements ActionListener {
	
	Choice empid;
	JLabel lblname, lblfname, lblempid, lbldb, lbladdress, lblphone, lblemail, 
	lblx, lblxii, lblaadhar, lblqualification, lbldept;
	JLabel nameValue, fnameValue, empidValue, dbValue, addressValue, phoneValue, emailValue, 
	xValue, xiiValue, aadharValue, qualificationValue, deptValue; 
	JButton search, save, insert, update,  close;
	ResultSet rs1, rs2;
	
	TeacherDetails() {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Search by Employee Id");
		heading.setBounds(20, 20, 150, 20);
		add(heading);
		
		empid = new Choice();
		empid.setBounds(180, 20, 150, 20);
		add(empid);
		
		try {
			
			Conn c = new Conn();
			rs1 = c.s.executeQuery("select * from Teacher");
			while(rs1.next()) {
				empid.add(rs1.getString("empid"));
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
				Conn c = new Conn();
				rs2 = c.s.executeQuery("select * from Teacher where empid='"+empid.getSelectedItem()+"'");
			
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
					
					lblempid = new JLabel("Employee Id");
					lblempid.setBounds(50, 200, 200, 30);
					lblempid.setFont(new Font("serif", Font.BOLD, 20));
					add(lblempid);
					
					empidValue = new JLabel(rs2.getString("empid"));
					empidValue.setBounds(200, 200, 200, 30);
					empidValue.setFont(new Font("serif", Font.BOLD, 20));
					add(empidValue);
					
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
					
					lblqualification = new JLabel("Qualification");
					lblqualification.setBounds(50, 400, 200, 30);
					lblqualification.setFont(new Font("serif", Font.BOLD, 20));
					add(lblqualification);
					
					qualificationValue = new JLabel(rs2.getString("qualification"));
					qualificationValue.setBounds(200, 400, 150, 30);
					qualificationValue.setFont(new Font("serif", Font.BOLD, 20));
					add(qualificationValue);
					
					lbldept = new JLabel("Department");
					lbldept.setBounds(400, 400, 200, 30);
					lbldept.setFont(new Font("serif", Font.BOLD, 20));
					add(lbldept);
					
					deptValue = new JLabel(rs2.getString("department"));
					deptValue.setBounds(600, 400, 150, 30);
					deptValue.setFont(new Font("serif", Font.BOLD, 20));
					add(deptValue);
				
				} 
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(ae.getSource()==save) {
			
		} else if(ae.getSource()==insert) {
			new AddTeacher();
		} else if(ae.getSource()==update) {
			
		} else {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new TeacherDetails();
	}

}
