package picasso.parser.language.expressions;

import java.awt.Color;

import picasso.parser.language.ExpressionTreeNode;

public class ImageClip extends ImageFunction{

	public ImageClip(String name,ExpressionTreeNode param1,ExpressionTreeNode param2) {
		super(name, param1, param2);
	} 
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor xPrime = param1.evaluate(x, y);
		RGBColor yPrime = param2.evaluate(x, y);
		double xPrimeRed = xPrime.clamp(xPrime.getRed());
		double yPrimeRed = yPrime.clamp(yPrime.getRed());
		//convert from domain to image scale
		int newx = domainToImageScale(xPrimeRed, img.getWidth()-1);
		int newy = domainToImageScale(yPrimeRed, img.getHeight()-1);
		RGBColor result = new RGBColor(new Color(img.getRGB(newx,newy)));
		return result;
	}


}
