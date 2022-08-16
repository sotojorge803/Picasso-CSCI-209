package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.expressions.Ceil;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;

public class CeilTest {


	
	@Test
	public void testCeilEvaluation() {
		Ceil myTree = new Ceil(new X());
		
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(-.7, -1));
		
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}
		
		double[] tests = {-.7, -.00001, .000001, .5};
		
		for( double testVal : tests) {
			double CeilOfTestVal = Math.ceil(testVal);
			assertEquals(new RGBColor(CeilOfTestVal, CeilOfTestVal, CeilOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(CeilOfTestVal, CeilOfTestVal, CeilOfTestVal), myTree.evaluate(testVal, testVal));
		}
		
	}

}
