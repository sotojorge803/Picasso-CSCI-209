package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
import java.awt.Color;


/**
 * Represents the ImageWrap function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Alex Sender
 * 
 */
public class ImageWrap extends ImageFunction{
	
	
	/**
	 * Create a ImageWrap expression that takes as parameters the given expression
	 * 
	 * @param param1 the expression for the new x
	 * @param param2 the expression for the new y
	 * @param imgName the name of the image 
	 */
	public ImageWrap(String name,ExpressionTreeNode param1,ExpressionTreeNode param2) {
		super(name, param1, param2);
	} 

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor xPrime = param1.evaluate(x, y);
		RGBColor yPrime = param2.evaluate(x, y);
		double xPrimeRed = Wrap.WrapColor(xPrime.getRed());
		double yPrimeRed = Wrap.WrapColor(yPrime.getRed());
		//convert from domain to image scale
		int newx = domainToImageScale(xPrimeRed, img.getWidth()-1);
		int newy = domainToImageScale(yPrimeRed, img.getHeight()-1);
		RGBColor result = new RGBColor(new Color(img.getRGB(newx,newy)));
		return result;
	}
	
}
