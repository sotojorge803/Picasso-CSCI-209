package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class Wrap extends UnaryFunction{

	public Wrap(ExpressionTreeNode param) {
		super(param);
	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = WrapColor(result.getRed());
		double green = WrapColor(result.getGreen());
		double blue = WrapColor(result.getBlue());

		return new RGBColor(red, green, blue);
	}
	
	//create wrap method to apply to all colors
	//creat jUnit test
	
	public static double WrapColor(double color) {
		while( color < -1.00 ){
			color+=2;
			
		}
		while( color > 1.00 ){
			color-=2;
			
		}
		return color;
	}

}
