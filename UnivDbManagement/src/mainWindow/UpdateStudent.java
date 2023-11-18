package mainWindow;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener {
	
	JTextField tfaddress, tfphone, tfemail, tfcourse, tfbranch;
	JLabel labelrollno, tfname, tffname, dcdob, tfx, tfxii, tfaadhar;
	JButton submit, cancel;
	Choice crollno;
	Conn c;
	ResultSet rs1, rs2;
	
	UpdateStudent() {
		setSize(900, 650);
		setLocation(350, 50);
		
		setLayout(null);
		
		JLabel heading = new JLabel("Update Student Details");
		heading.setBounds(50, 10, 500, 50);
		heading.setFont(new Font("serif", Font.BOLD, 30));
		add(heading);
		
		JLabel lblrollnum = new JLabel("Search by Roll Number");
		lblrollnum.setBounds(50, 100, 200, 20);
		lblrollnum.setFont(new Font("serif", Font.ITALIC, 20));
		add(lblrollnum);
		
		crollno = new Choice();
		crollno.setBounds(250, 100, 200, 20);
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
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(50, 150, 100, 30);
		lblname.setFont(new Font("serif", Font.BOLD, 20));
		add(lblname);
		
		tfname = new JLabel();
		tfname.setBounds(200, 150, 150, 30);
		tfname.setFont(new Font("serif", Font.BOLD, 20));
		add(tfname);
		
		JLabel lblfname = new JLabel("Father's Name");
		lblfname.setBounds(400, 150, 200, 30);
		lblfname.setFont(new Font("serif", Font.BOLD, 20));
		add(lblfname);
		
		tffname = new JLabel();
		tffname.setBounds(600, 150, 150, 30);
		tffname.setFont(new Font("serif", Font.BOLD, 20));
		add(tffname);
		
		JLabel lblrollno = new JLabel("Roll Number");
		lblrollno.setBounds(50, 200, 200, 30);
		lblrollno.setFont(new Font("serif", Font.BOLD, 20));
		add(lblrollno);
		
		labelrollno = new JLabel();
		labelrollno.setBounds(200, 200, 200, 30);
		labelrollno.setFont(new Font("serif", Font.BOLD, 20));
		add(labelrollno);
		
		JLabel lbldb = new JLabel("Date of Birth");
		lbldb.setBounds(400, 200, 200, 30);
		lbldb.setFont(new Font("serif", Font.BOLD, 20));
		add(lbldb);
		
		dcdob = new JLabel();
		dcdob.setBounds(600, 200, 150, 30);
		dcdob.setFont(new Font("serif", Font.BOLD, 20));
		add(dcdob);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(50, 250, 200, 30);
		lbladdress.setFont(new Font("serif", Font.BOLD, 20));
		add(lbladdress);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(200, 250, 150, 30);
		tfaddress.setFont(new Font("serif", Font.BOLD, 20));
		add(tfaddress);
		
		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(400, 250, 200, 30);
		lblphone.setFont(new Font("serif", Font.BOLD, 20));
		add(lblphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(600, 250, 150, 30);
		tfphone.setFont(new Font("serif", Font.BOLD, 20));
		add(tfphone); 
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(50, 300, 200, 30);
		lblemail.setFont(new Font("serif", Font.BOLD, 20));
		add(lblemail);
		
		tfemail = new JTextField();
		tfemail.setBounds(200, 300, 150, 30);
		tfemail.setFont(new Font("serif", Font.BOLD, 20));
		add(tfemail);
		
		JLabel lblx = new JLabel("Class X (%)");
		lblx.setBounds(400, 300, 200, 30);
		lblx.setFont(new Font("serif", Font.BOLD, 20));
		add(lblx);
		
		tfx = new JLabel();
		tfx.setBounds(600, 300, 150, 30);
		tfx.setFont(new Font("serif", Font.BOLD, 20));
		add(tfx);
		
		JLabel lblxii = new JLabel("Class XII (%)");
		lblxii.setBounds(50, 350, 200, 30);
		lblxii.setFont(new Font("serif", Font.BOLD, 20));
		add(lblxii);
		
		tfxii = new JLabel();
		tfxii.setBounds(200, 350, 150, 30);
		tfxii.setFont(new Font("serif", Font.BOLD, 20));
		add(tfxii);
		
		JLabel lblaadhar = new JLabel("Aadhar Number");
		lblaadhar.setBounds(400, 350, 200, 30);
		lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
		add(lblaadhar);
		
		tfaadhar = new JLabel();
		tfaadhar.setBounds(600, 350, 150, 30);
		tfaadhar.setFont(new Font("serif", Font.BOLD, 20));
		add(tfaadhar);
		
		JLabel lblcourse = new JLabel("Course");
		lblcourse.setBounds(50, 400, 200, 30);
		lblcourse.setFont(new Font("serif", Font.BOLD, 20));
		add(lblcourse);
		
		tfcourse = new JTextField();
		tfcourse.setBounds(200, 400, 150, 30);
		tfcourse.setFont(new Font("serif", Font.BOLD, 20));
		add(tfcourse);
		
		JLabel lblbranch = new JLabel("Branch");
		lblbranch.setBounds(400, 400, 200, 30);
		lblbranch.setFont(new Font("serif", Font.BOLD, 20));
		add(lblbranch);
		
		tfbranch = new JTextField();
		tfbranch.setBounds(600, 400, 150, 30);
		tfbranch.setFont(new Font("serif", Font.BOLD, 20));
		add(tfbranch);
		
		try {
			
			String query = "select * from Student where rollno='"+crollno.getSelectedItem()+"'";
			rs2 = c.s.executeQuery(query);
			while(rs2.next()) {
				tfname.setText(rs2.getString("name"));
				tffname.setText(rs2.getString("fname"));
				dcdob.setText(rs2.getString("dob"));
				tfaddress.setText(rs2.getString("address"));
				tfphone.setText(rs2.getString("phone"));
				tfemail.setText(rs2.getString("email"));
				tfx.setText(rs2.getString("class_x"));
				tfxii.setText(rs2.getString("class_xii"));
				tfaadhar.setText(rs2.getString("aadhar"));
				labelrollno.setText(rs2.getString("rollno"));
				tfcourse.setText(rs2.getString("course"));
				tfbranch.setText(rs2.getString("branch"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		crollno.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie) {
				try {
					
					String query = "select * from Student where rollno='"+crollno.getSelectedItem()+"'";
					rs2 = c.s.executeQuery(query);
					while(rs2.next()) {
						tfname.setText(rs2.getString("name"));
						tffname.setText(rs2.getString("fname"));
						dcdob.setText(rs2.getString("dob"));
						tfaddress.setText(rs2.getString("address"));
						tfphone.setText(rs2.getString("phone"));
						tfemail.setText(rs2.getString("email"));
						tfx.setText(rs2.getString("class_x"));
						tfxii.setText(rs2.getString("class_xii"));
						tfaadhar.setText(rs2.getString("aadhar"));
						labelrollno.setText(rs2.getString("rollno"));
						tfcourse.setText(rs2.getString("course"));
						tfbranch.setText(rs2.getString("branch"));
					}
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		submit = new JButton("Update");
		submit.setBounds(250, 550, 120, 30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		submit.setFont(new Font("serif", Font.BOLD, 15));
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(450, 550, 120, 30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		cancel.setFont(new Font("serif", Font.BOLD, 15));
		add(cancel);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {
			
			String rollno = labelrollno.getText();
			String address = tfaddress.getText();
			String phone = tfphone.getText();
			String email = tfemail.getText();
			String course = tfcourse.getText();
			String branch = tfbranch.getText();
			
			try {
				
				String query = "update Student set address='"+address+"', phone='"+phone+"', email='"+email+"', course='"+course+"', branch='"+branch+"' where rollno='"+rollno+"'";
				
				c.s.executeUpdate(query); 
				
				JOptionPane.showMessageDialog(null, "Student details updated successfully");
				setVisible(false);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new UpdateStudent();
	}
	
}
