package mainWindow;

import javax.swing.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;

public class FeeStructure extends JFrame {

	public FeeStructure() {
		setSize(1000, 300);
		setLocation(250, 100);
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		
		JLabel heading = new JLabel("Fee Structure");
		heading.setBounds(50, 10, 400, 30);
		heading.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(heading);
		
		JTable table = new JTable();
		
		try {
			
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from fee");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(50, 60, 900, 153);
		add(jsp);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new FeeStructure();
	}

}
