package picasso.parser.language.expressions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import picasso.model.Pixmap;
import picasso.parser.language.ExpressionTreeNode;

public abstract class ImageFunction extends ExpressionTreeNode {
	
	BufferedImage img;
	String fileName;
	ExpressionTreeNode param1;
	ExpressionTreeNode param2;

	public ImageFunction(String name,ExpressionTreeNode param1,ExpressionTreeNode param2) {
		this.param1 = param1;
		this.param2 = param2;
		try {
			img = ImageIO.read(new File("images\\"+name));
		} catch (IOException e) {
			e.printStackTrace();
			//thro parse expeciton
		}
		this.fileName = name;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Convert from domain space to image space.
	 * @param value is pixel (from -1 to 1)
	 * @param bounds is either height or width
	 */
	protected int domainToImageScale(double value, int bounds) {
		return (int)((value+1)*bounds/2);
	}
	
	@Override
	public String toString() {
		String classname = this.getClass().getName();
		String temp =  classname.substring(classname.lastIndexOf(".")) + "(\"" + fileName +"\", "+ param1 +", "+ param2 +")"; //add spaces and commas
		return Character.toLowerCase(temp.charAt(1))+ temp.substring(2);
	}

}
