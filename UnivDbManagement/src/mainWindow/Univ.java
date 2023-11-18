package mainWindow;

import java.awt.*;
import javax.swing.*;

public class Univ extends JFrame implements Runnable {

	Thread t;
	
	Univ() {
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		try {
			new Login();
		} catch(Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		new Univ();
	}

}
