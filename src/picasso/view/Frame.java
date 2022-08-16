package picasso.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.*;

import picasso.model.Pixmap;
import picasso.util.ThreadedCommand;
import picasso.view.commands.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


/**
 * Main container for the Picasso application
@@ -16,22 +22,34 @@
 */
@SuppressWarnings("serial")
public class Frame extends JFrame {
	
	Evaluator el = new Evaluator();
	static JTextField textBox = new JTextField("", 30);
	static JLabel label1 = new JLabel("Enter your function here:");
	public Frame(Dimension size) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// create GUI components
		Canvas canvas = new Canvas(this);
		canvas.setSize(size);
			
		
			// Create a panel for the frame
			JPanel panel=new JPanel(); 
		 
	        panel.setBounds(40,80,200,200); 
	        
	        panel.setBackground(Color.white);  
	        
	        
	        label1.setBounds(50,100,80,30);    
	        textBox.setBackground(Color.yellow);   
	        textBox.setBounds(100,100,80,30);    
	        textBox.setBackground(Color.white);   
	        panel.add(label1); panel.add(textBox);  
	                 
		

		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		commands.add("Save", new Writer());
		
		commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, el));
		commands.add("Combine", new Combination(el,canvas));


		// add our container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		getContentPane().add(panel, BorderLayout.SOUTH);
		pack();
		
	}

	public static String getText() {
		return textBox.getText();
	}
	
	public static void setText(String expres) {
		textBox.setText(expres);
	}
	


}
