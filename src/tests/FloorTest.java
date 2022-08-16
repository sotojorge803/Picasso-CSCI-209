import static org.junit.Assert.assertEquals;

import org.junit.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.expressions.Floor;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;

public class FloorTest {

	
	
	@Test
	public void testFloorEvaluation() {
		Floor myTree = new Floor(new X());
		
		// some straightforward tests
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-.7, -1));
		
		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}
		
		double[] tests = {-.7, -.00001, .000001, .5};
		
		for( double testVal : tests) {
			double floorOfTestVal = Math.floor(testVal);
			assertEquals(new RGBColor(floorOfTestVal, floorOfTestVal, floorOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(floorOfTestVal, floorOfTestVal, floorOfTestVal), myTree.evaluate(testVal, testVal));
		}
		
	}

}
