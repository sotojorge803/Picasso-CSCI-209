package picasso.view.commands;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JToggleButton;

import picasso.model.Pixmap;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.util.Command;
import picasso.view.ErrorBox;
import picasso.view.Frame;



/**
 * Evaluate an expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 * @author Sara Sprenkle
 */
public class Evaluator implements Command<Pixmap> {
	public static final double DOMAIN_MIN = -1;
	public static final double DOMAIN_MAX = 1;
	static ArrayList<String> history = new ArrayList<String>();
	private static ErrorBox box = new ErrorBox();


	


	/**
	 * Evaluate an expression for each point in the image.
	 */




	public void execute(Pixmap target) {
		// create the expression to evaluate just once
			//Adds History Extension
			if (Frame.getText().contains("$")) {
				String historyElement = Frame.getText();
				String two = "$";
				String three= historyElement.replace(two, "");
				int i = Integer.parseInt(three); 
				int j = i - 1;
				String s= Integer.toString(j);
				if (history.size() == 0) {
					box.CreateErrorBox("You have not created any expressions yet!");
				}
				
				else if (i >= history.size()) {
					box.CreateErrorBox("You have not created that many expression yet. Index Size: " + (s));

				}
				
				String historyExpression = history.get(i);
				ExpressionTreeNode expr = createExpression(historyExpression);
				
				// evaluate it for each pixel
				Dimension size = target.getSize();
				for (int imageY = 0; imageY < size.height; imageY++) {
					double evalY = imageToDomainScale(imageY, size.height);
					for (int imageX = 0; imageX < size.width; imageX++) {
						double evalX = imageToDomainScale(imageX, size.width);
						Color pixelColor = expr.evaluate(evalX, evalY).toJavaColor();
						target.setColor(imageX, imageY, pixelColor);
			}
				}
			}
			
			else {
			ExpressionTreeNode expr = createExpression(Frame.getText());
			String s = Frame.getText();
			String s1 = s.substring(s.indexOf("=")+1);
			s1.trim();
			history.add(s1);
			
			// evaluate it for each pixel
			Dimension size = target.getSize();
			for (int imageY = 0; imageY < size.height; imageY++) {
				double evalY = imageToDomainScale(imageY, size.height);
				for (int imageX = 0; imageX < size.width; imageX++) {
					double evalX = imageToDomainScale(imageX, size.width);
					Color pixelColor = expr.evaluate(evalX, evalY).toJavaColor();
					target.setColor(imageX, imageY, pixelColor);
				
		}
		}
		}
		}
	//}

	/**
	 * Convert from image space to domain space.
	 */
	protected double imageToDomainScale(int value, int bounds) {
		double range = DOMAIN_MAX - DOMAIN_MIN;
		return ((double) value / bounds) * range + DOMAIN_MIN;
	}

	/**
	 * 
	 * A place holder for a more interesting way to build the expression.
	 */
	private ExpressionTreeNode createExpression(String q) {
		// Note, when you're testing, you can use the ExpressionTreeGenerator to
		// generate expression trees from strings, or you can create expression
		// objects directly (as in the commented statement below).

		//String test = "x + y";

		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		return expTreeGen.makeExpression(q);

		// return new Multiply( new X(), new Y() );
	}
	
	
	
	
} 
