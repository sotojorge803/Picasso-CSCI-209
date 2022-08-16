package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.Tan;
import picasso.parser.language.expressions.X;

public class TanTest {

	
	
	@Test
	public void testTanEvaluation() {
		Tan myTree = new Tan(new X());
		
		// some straightforward tests
		assertEquals(new RGBColor(Math.tan(.4), Math.tan(.4), Math.tan(.4)), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(Math.tan(.999), Math.tan(.999), Math.tan(.999)), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(Math.tan(-.7), Math.tan(-.7), Math.tan(-.7)), myTree.evaluate(-.7, -1));
		
		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.tan(i), Math.tan(i), Math.tan(i)), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(Math.tan(i), Math.tan(i), Math.tan(i)), myTree.evaluate(i, i));
		}
		
		double[] tests = {-.7, -.00001, .000001, .5};
		
		for( double testVal : tests) {
			double TanOfTestVal = Math.tan(testVal);
			assertEquals(new RGBColor(TanOfTestVal, TanOfTestVal, TanOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(TanOfTestVal, TanOfTestVal, TanOfTestVal), myTree.evaluate(testVal, testVal));
		}
		
	}

}
