package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class Clamp extends UnaryFunction {

	public Clamp(ExpressionTreeNode param) {
		super(param);
	}

	@Override
	public RGBColor evaluate( double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = result.clamp(result.getRed());
		double green = result.clamp(result.getGreen());
		double blue = result.clamp(result.getBlue());

		return new RGBColor(red, green, blue);
	}
}
