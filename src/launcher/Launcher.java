package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	try {
            		Student yo = new Student(130411, "Oyarzún", "Agustín", "oyaagustin@gmail.com", "https://github.com/oyaagustin", "/images/Photo.png");
            		SimplePresentationScreen frame = new SimplePresentationScreen(yo);
            		frame.setVisible(true);
            	} catch(Exception e) {
            		e.printStackTrace();
            	}
            }
        });
    }
}