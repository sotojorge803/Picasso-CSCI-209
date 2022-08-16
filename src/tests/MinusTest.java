package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.expressions.Minus;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.Times;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;

public class MinusTest {


	
	@Test
	public void testMinusEvaluation() {
		Minus myTree = new Minus(new X(), new Y());
		
		assertEquals(new RGBColor(.3, .3, .3), myTree.evaluate(.5, .2));
		assertEquals(new RGBColor((.5 - .4), (.5 - .4), (.5 - .4)), myTree.evaluate(.5, .4));
		Minus myTree2 = myTree;
		assertTrue(myTree.equals(myTree2));
		assertTrue(myTree.toString().equals("x-y"));

		}
		
		
	}
