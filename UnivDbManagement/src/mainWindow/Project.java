package mainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

	Project() {
		
		setSize(1000,350);
		
		JMenuBar mb = new JMenuBar();
		
		// Information
		JMenu newInfo = new JMenu("New Info");
		newInfo.setForeground(Color.BLUE);
		mb.add(newInfo);
		
		JMenuItem facInfo = new JMenuItem("New Faculty Info");
		facInfo.setBackground(Color.WHITE);
		facInfo.addActionListener(this);
		newInfo.add(facInfo);
		
		JMenuItem stdInfo = new JMenuItem("New Student Info");
		stdInfo.setBackground(Color.WHITE);
		stdInfo.addActionListener(this);
		newInfo.add(stdInfo);
		
		// Details
		JMenu details = new JMenu("View Details");
		details.setForeground(Color.RED);
		mb.add(details);
		
		JMenuItem facDetails = new JMenuItem("Faculty Details");
		facDetails.setBackground(Color.WHITE);
		facDetails.addActionListener(this);
		details.add(facDetails);
		
		JMenuItem stdDetails = new JMenuItem("Student Details");
		stdDetails.setBackground(Color.WHITE);
		stdDetails.addActionListener(this);
		details.add(stdDetails); 
		
		// Leave
		JMenu leave = new JMenu("Apply Leave");
		leave.setForeground(Color.BLUE);
		mb.add(leave);
		
		JMenuItem facLeave = new JMenuItem("Faculty Leave");
		facLeave.setBackground(Color.WHITE);
		facLeave.addActionListener(this);
		leave.add(facLeave);
		
		JMenuItem stdLeave = new JMenuItem("Student Leave");
		stdLeave.setBackground(Color.WHITE);
		stdLeave.addActionListener(this);
		leave.add(stdLeave);
		
		// Leave Details
		JMenu leaveDetails = new JMenu("Leave Details");
		leaveDetails.setForeground(Color.RED);
		mb.add(leaveDetails);
				
		JMenuItem facLeaveDet = new JMenuItem("Faculty Leave Details");
		facLeaveDet.setBackground(Color.WHITE);
		facLeaveDet.addActionListener(this);
		leaveDetails.add(facLeaveDet);
				
		JMenuItem stdLeaveDet = new JMenuItem("Student Leave Details");
		stdLeaveDet.setBackground(Color.WHITE);
		stdLeaveDet.addActionListener(this);
		leaveDetails.add(stdLeaveDet);
		
		// Examinations
		JMenu exams = new JMenu("Examinations");
		exams.setForeground(Color.BLUE);
		mb.add(exams);
						
		JMenuItem examShed = new JMenuItem("Examination Schedule");
		examShed.setBackground(Color.WHITE);
		exams.add(examShed);
						
		JMenuItem examResult = new JMenuItem("Examination Reuslts");
		exams.setBackground(Color.WHITE);
		exams.add(examResult);
		
		// Update Info
		JMenu updateInfo = new JMenu("Update Details");
		updateInfo.setForeground(Color.RED);
		mb.add(updateInfo);
				
		JMenuItem updFacDet = new JMenuItem("Update Faculty Details");
		updFacDet.setBackground(Color.WHITE);
		updFacDet.addActionListener(this);
		updateInfo.add(updFacDet);
				
		JMenuItem updStdDet = new JMenuItem("Update Student Details");
		updStdDet.setBackground(Color.WHITE);
		updStdDet.addActionListener(this);
		updateInfo.add(updStdDet);
		 
		// Fees
		JMenu fees = new JMenu("Fee Details");
		fees.setForeground(Color.BLUE);
		mb.add(fees);
				
		JMenuItem feeStruc = new JMenuItem("Fees Structure");
		feeStruc.setBackground(Color.WHITE);
		feeStruc.addActionListener(this);
		fees.add(feeStruc);
				
		JMenuItem feeForm = new JMenuItem("Student Fee Form");
		feeForm.setBackground(Color.WHITE);
		fees.add(feeForm);
		
		// Exit
		JMenu exit = new JMenu("Exit");
		exit.setForeground(Color.BLUE);
		mb.add(exit);
				
		JMenuItem ex = new JMenuItem("Exit");
		ex.setBackground(Color.WHITE);
		ex.addActionListener(this);
		exit.add(ex);
		
		setJMenuBar(mb);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String msg = ae.getActionCommand();
		if(msg.equals("Exit")) {
			setVisible(false);
		} else if(msg.equals("New Faculty Info")) {
			new AddTeacher();
		} else if(msg.equals("New Student Info")) {
			new AddStud();
		} else if(msg.equals("Student Details")) {
			new StudentDetails();
		} else if(msg.equals("Faculty Details")) {
			new TeacherDetails();
		} else if(msg.equals("Student Leave")) {
			new StudentLeave();
		} else if(msg.equals("Faculty Leave")) {
			new TeacherLeave();
		} else if(msg.equals("Student Leave Details")) {
			new StdLeaveDetails();
		} else if(msg.equals("Faculty Leave Details")) {
			new FacLeaveDetails();
		} else if(msg.equals("Update Student Details")) {
			new UpdateStudent();
		} else if(msg.equals("Update Faculty Details")) {
			new UpdateTeacher();
		} else if(msg.equals("Fees Structure")) {
			new FeeStructure();
		} else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new Project();
	}

}
