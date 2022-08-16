package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.operations.BangToken;

/**
 * Represents the Negate function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * 
 */
public class Negate extends UnaryFunction {
	BangToken b;

	/**
	 * Create a Negate expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to floor
	 */
	public Negate(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the negation of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the negation of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = -(result.getRed());
		double green = -(result.getGreen());
		double blue = -(result.getBlue());

		return new RGBColor(red, green, blue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Negate)) {
			return false;
		}
		Negate f = (Negate) obj;
		return param.equals(f.param);
	}


	@Override
	public String toString() {
		return "" + b + param;
	}

}
