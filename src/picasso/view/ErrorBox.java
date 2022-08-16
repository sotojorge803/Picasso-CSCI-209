package picasso.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.FlowLayout;
public class ErrorBox {
	
	/**
	 * Prints an expression into a visible box for user to read error from.
	 */
	
	public ErrorBox() {
		
	}
    
	public void CreateErrorBox(String error) {
	
		// Creates a new Window
		JPanel panel = new JPanel();
		
		// Creates top header for the Error Window
		JFrame frame = new JFrame("Error Window");

		//Creates a Label Which reads the variable given.
		JLabel label = new JLabel(error);
		
		// Adds the error message to the window
		panel.add(label);
		
		// Adds the blank panel to the frame		
		frame.add(panel);
		
		//Sets the size of the window to 500 width and 300 length.
		frame.setSize(500, 300);
		
		// Places the Window relative to nothing on the screen.
		frame.setLocationRelativeTo(null);
		
		// Makes the window visible.
		frame.setVisible(true);
	}
	
	
}
	
