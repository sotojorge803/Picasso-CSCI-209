/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * @author asend
 *
 */
public class Tan extends UnaryFunction {

	/**
	 * Create a Tangent expression that takes as a parameter the given expression
	 * 
	 * @param param
	 */
	public Tan(ExpressionTreeNode param) {
		super(param);

	}

	@Override
	public RGBColor evaluate(double x, double y) {
		
		RGBColor result = param.evaluate(x, y);
		double red = Math.tan(result.getRed());
		double green = Math.tan(result.getGreen());
		double blue = Math.tan(result.getBlue());
		
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
		if (!(obj instanceof Tan)) {
			return false;
		}
		Tan t = (Tan) obj;
		return param.equals(t.param);
	}

}
