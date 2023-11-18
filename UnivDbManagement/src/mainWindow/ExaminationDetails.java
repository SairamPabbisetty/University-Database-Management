package mainWindow;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ExaminationDetails extends JFrame implements ActionListener {
	
	JTextField tfroll;
	JButton submit, cancel;
	JComboBox cbsemester;
	ResultSet rs1, rs2;
	Conn c;
	JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5, tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;

	ExaminationDetails() {
		setSize(600, 475);
		setLocation(300, 100);
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		
		JLabel heading = new JLabel("Check Result");
		heading.setBounds(80, 15, 400, 50);
		heading.setFont(new Font("Tahoma", Font.BOLD, 24));
		add(heading);
		
		JLabel roll = new JLabel("(Enter your roll number)");
		roll.setBounds(80, 70, 200, 20);
		add(roll);
		
		tfroll = new JTextField();
		tfroll.setBounds(80, 90, 200, 25);
		tfroll.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(tfroll);
		
		submit = new JButton("Result");
		submit.setBounds(300, 90, 120, 25);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		submit.setFont(new Font("serif", Font.BOLD, 15));
		add(submit);
		
		cancel = new JButton("Back");
		cancel.setBounds(440, 90, 120, 25);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		cancel.setFont(new Font("serif", Font.BOLD, 15));
		add(cancel);
		
		JLabel lblsemester = new JLabel("Select Semester");
		lblsemester.setBounds(80, 150, 120, 20);
		lblsemester.setFont(new Font("serif", Font.BOLD, 15));
		add(lblsemester);
		
		String semester[] = {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"};
		cbsemester = new JComboBox(semester);
		cbsemester.setBounds(200, 150, 150, 20);
		cbsemester.setBackground(Color.WHITE);
		add(cbsemester);
		
		tfsub1 = new JTextField();
		tfsub1.setBounds(50, 200, 200, 20);
		add(tfsub1);
		
		tfsub2 = new JTextField();
		tfsub2.setBounds(50, 230, 200, 20);
		add(tfsub2);
		
		tfsub3 = new JTextField();
		tfsub3.setBounds(50, 260, 200, 20);
		add(tfsub3);
		
		tfsub4 = new JTextField();
		tfsub4.setBounds(50, 290, 200, 20);
		add(tfsub4);
		
		tfsub5 = new JTextField();
		tfsub5.setBounds(50, 320, 200, 20);
		add(tfsub5);
		
		tfmarks1 = new JTextField();
		tfmarks1.setBounds(250, 200, 200, 20);
		add(tfmarks1);
		
		tfmarks2 = new JTextField();
		tfmarks2.setBounds(250, 230, 200, 20);
		add(tfmarks2);
		
		tfmarks3 = new JTextField();
		tfmarks3.setBounds(250, 260, 200, 20);
		add(tfmarks3);
		
		tfmarks4 = new JTextField();
		tfmarks4.setBounds(250, 290, 200, 20);
		add(tfmarks4);
		
		tfmarks5 = new JTextField();
		tfmarks5.setBounds(250, 320, 200, 20);
		add(tfmarks5);
		
		try {
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==submit) {
			
			try {
				
				c = new Conn();
				
				String query1 = "select * from subject where rollno='"+tfroll.getText()+"' and semester='"+cbsemester.getSelectedItem()+"'";
				rs1 = c.s.executeQuery(query1);
				
				if(rs1.next()) {
					tfsub1.setText(rs1.getString("subject1"));
					tfsub2.setText(rs1.getString("subject2"));
					tfsub3.setText(rs1.getString("subject3"));
					tfsub4.setText(rs1.getString("subject4"));
					tfsub5.setText(rs1.getString("subject5"));
				}
				
				String query2 = "select * from marks where rollno='"+tfroll.getText()+"' and semester='"+cbsemester.getSelectedItem()+"'";
				rs2 = c.s.executeQuery(query2);
				
				if(rs2.next()) {
					tfmarks1.setText(rs2.getString("marks1"));
					tfmarks2.setText(rs2.getString("marks2"));
					tfmarks3.setText(rs2.getString("marks3"));
					tfmarks4.setText(rs2.getString("marks4"));
					tfmarks5.setText(rs2.getString("marks5"));
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new ExaminationDetails();
	}

}
