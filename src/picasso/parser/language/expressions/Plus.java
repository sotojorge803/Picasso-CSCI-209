package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;  
/**
	 * Create a Plus expression that takes as a parameter the given expression
	 * 
	 * @param param
	 */
	public class Plus extends BinaryFunction {
		String operator = "+";
		
	public  Plus(ExpressionTreeNode param1, ExpressionTreeNode param2) { 
		super(param1, param2);

	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor resultp1 = param1.evaluate(x, y);
		RGBColor resultp2 = param2.evaluate(x, y);
		double red1 = (resultp1.getRed());
		double green1 = (resultp1.getGreen());
		double blue1 = (resultp1.getBlue());

		double red2 = (resultp2.getRed());
		double green2 = (resultp2.getGreen());
		double blue2 = (resultp2.getBlue());

		double red = red1 + red2;
		double green = green1 + green2;
		double blue = blue1 + blue2;

//		if (red > 1) { red = 1;}
//
//		else if (red < -1) {red = -1;}
//
//
//		if (green > 1) { green = 1;}
//
//		else if (green < -1) {green = -1;}
//
//		if (blue > 1) {blue = 1;}
//
//		else if (blue < -1) {blue = -1;}


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
		if (!(obj instanceof Plus)) {
			return false;
		}
		Plus t = (Plus) obj;
		return param1.equals(t.param1) && param2.equals(t.param2);
	}

	@Override
	public String toString() {
		return "" + param1 + operator + param2;
	}
  }
	
