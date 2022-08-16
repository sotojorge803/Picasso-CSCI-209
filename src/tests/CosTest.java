package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.expressions.Cos;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;

public class CosTest {


	
	@Test
	public void testCosEvaluation() {
		Cos myTree = new Cos(new X());
		
		assertEquals(new RGBColor(Math.cos(.4), Math.cos(.4), Math.cos(.4)), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(Math.cos(.999), Math.cos(.999), Math.cos(.999)), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(Math.cos(-.7), Math.cos(-.7), Math.cos(-.7)), myTree.evaluate(-.7, -1));
		
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.cos(i), Math.cos(i), Math.cos(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.cos(i), Math.cos(i), Math.cos(i)), myTree.evaluate(i, i));
		}
		
		double[] tests = {-.7, -.00001, .000001, .5};
		
		for( double testVal : tests) {
			double CosOfTestVal = Math.cos(testVal);
			assertEquals(new RGBColor(CosOfTestVal, CosOfTestVal, CosOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(CosOfTestVal, CosOfTestVal, CosOfTestVal), myTree.evaluate(testVal, testVal));
		}
		
	}
}
