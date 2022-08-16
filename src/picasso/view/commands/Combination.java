package picasso.view.commands;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import picasso.model.Pixmap;
import picasso.parser.IdentifierAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Variable;
import picasso.util.Command;
import picasso.util.ThreadedCommand;
import picasso.view.ButtonPanel;
import picasso.view.Canvas;
import picasso.view.Frame;

import java.awt.BorderLayout;

/**
 * Allow the user to create new expressions from the previously saved expressions
 * 
 *  * @author Alex Sender
 */
public class Combination extends Evaluator implements Command<Pixmap>, ActionListener {
	Canvas cs;
	Pixmap pm;
	//JFrame frame;
	Evaluator el;
	
	public Combination(Evaluator el, Canvas cs) {	
		this.el = el;
		this.pm = cs.getPixmap();
		//this.frame = new JFrame("Combine");
	}
	ActionListener actionListener;
	static Set<String> variables;
	// String key;
	static ArrayList<JToggleButton> boxes = new ArrayList<JToggleButton>();
	static ArrayList<JToggleButton> ops = new ArrayList<JToggleButton>();
	static Map<String, ExpressionTreeNode> idAndExps = IdentifierAnalyzer.getExpMap();
	static Iterator<String> variableIterator;
	static Iterator<String> operatorIterator;
	static String tempOp;

	/**
	 * Adds the expressions and operators to the panels and lays out
	 * 
	 */
	public static void addComponentsToPane(Container pane) {
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		JPanel expressionPanel = new JPanel();
		expressionPanel.setLayout(new BoxLayout(expressionPanel, BoxLayout.Y_AXIS));
		expressionPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
		JPanel combinePanel = new JPanel();
		JPanel southPanel = new JPanel();
		//southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
		JPanel mainPanel = new JPanel();
		southPanel.add(buttonPanel, BorderLayout.CENTER);
		southPanel.add(combinePanel, BorderLayout.SOUTH);
		mainPanel.add(expressionPanel, BorderLayout.CENTER);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		pane.add(mainPanel, BorderLayout.CENTER);
		variables = idAndExps.keySet();
		variableIterator = variables.iterator();
		while (variableIterator.hasNext()) {
			String key = variableIterator.next();
			if (key != "x" & key != "y") {
				JToggleButton button = new JToggleButton(key + "=" + idAndExps.get(key));
				button.setAlignmentX(Component.CENTER_ALIGNMENT);
				expressionPanel.add(button);
				boxes.add(button);
			}
		}

		// button.addActionListener(this);
		// how to add action to button
		// will need it go to a method that will make the new expression,
		// given the operation selected
		// button.addActionListener(this);
		// pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));

		// buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));

		JToggleButton MultBut = new JToggleButton("*");
		// MultBut.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		MultBut.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel.add(MultBut);
		ops.add(MultBut);
		MultBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				testToggle(MultBut);
				
			}
		});

		JToggleButton DivBut = new JToggleButton("/");
		// MultBut.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		DivBut.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel.add(DivBut);
		ops.add(DivBut);
		DivBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				testToggle(DivBut);
				
			}
		});

		JToggleButton AddBut = new JToggleButton("+");
		// MultBut.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		AddBut.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel.add(AddBut);
		ops.add(AddBut);
		AddBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				testToggle(AddBut);
				
			}
		});

		JToggleButton SubBut = new JToggleButton("-");
		// MultBut.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		SubBut.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel.add(SubBut);
		ops.add(SubBut);
		SubBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				testToggle(SubBut);
				
			}
		});

		JToggleButton RootBut = new JToggleButton("^");
		// MultBut.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		RootBut.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel.add(RootBut);
		ops.add(RootBut);
		RootBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				testToggle(RootBut);
				
			}
		});

		JToggleButton ModBut = new JToggleButton("%");
		// MultBut.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		ModBut.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel.add(ModBut);
		ops.add(ModBut);
		ModBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				testToggle(ModBut);
				
			}
		});

		// for(int i =0; i < boxes.size(); i++) {
		// JCheckBox temp = boxes.get(i);
		// if(temp.isSelected()) {
		// newExp += idAndExps.get(variableIterator.next());
		// newExp += " " ;
		// }
		// }
		JButton combineButton = new JButton("Combine!");
		combinePanel.add(combineButton);
		combineButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				combiner();
			}
		});


	}

	
	private static void testToggle(JToggleButton but) {
		for(int i =0; i < ops.size(); i++) {
			if (ops.get(i)!=but) {
				if(ops.get(i).isSelected()) {
					ops.get(i).setSelected(false);
				}
				}
		}
	}
	
	private static void combiner() {
		String newExp= "";
		for(int i =0; i < ops.size(); i++) {
			if(ops.get(i).isSelected()) {
				tempOp = ops.get(i).getText();
			}
		}
		for(int i =0; i < boxes.size(); i++) {
				if(boxes.get(i).isSelected()) {
					String temp = boxes.get(i).getText();
					String sep = "=";
					int sepPos = temp.indexOf(sep);
					
					newExp += temp.substring(sepPos + sep.length());
					if(i!=boxes.size()-1) {
						newExp +=" "+ tempOp;
					}
				}
		}
		Frame.setText(newExp);
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event-dispatching thread.
	 */
	//private static void createAndShowGUI() {
		// Create and set up the window.
//		JFrame frame = new JFrame("Combination");

		// Set up the content pane.
	//	addComponentsToPane(frame.getContentPane());

		// Display the window.
//		frame.pack();
	//	frame.setVisible(true);
	//}


	@Override
	public void execute(Pixmap target) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		//javax.swing.SwingUtilities.invokeLater(new Runnable() {
			//public void run() {
				//createAndShowGUI();
			//}
			JFrame frame = new JFrame("Combination");
			addComponentsToPane(frame.getContentPane());
	        frame.pack();
	        frame.setVisible(true);
	        el.execute(pm);

		//});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
