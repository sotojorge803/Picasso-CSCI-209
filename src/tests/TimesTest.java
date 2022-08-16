package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.expressions.Times;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;

public class TimesTest {


	
	@Test
	public void testTimesEvaluation() {
		Times myTree = new Times(new X(), new Y());
		
		assertEquals(new RGBColor(.25, .25, .25), myTree.evaluate(.5, .5));
		assertEquals(new RGBColor((.25 * .25), (.25 * .25), (.25 * .25)), myTree.evaluate(.25, .25));
		Times myTree2 = myTree;
		assertTrue(myTree.equals(myTree2));
		assertTrue(myTree.toString().equals("x*y"));

		}
	
		
		
		
	}
