package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.operations.EqualToken;

import java.util.HashMap;
import java.util.Map;

import picasso.parser.IdentifierAnalyzer;


/**
	 * Create a Plus expression that takes as a parameter the given expression
	 * 
	 * @param param
	 * 
	 * 
	 */

public class Equal extends ExpressionTreeNode {
	
	/**
	 * Updates variable assignment given an identifier token and an expression
	 * 
	 * 
	 */
	
	Variable param1;
	ExpressionTreeNode param2;
	EqualToken equal;
	

	
	public Equal(Variable param1, ExpressionTreeNode param2) {
		this.param2 = param2;
		this.param1 = param1;
		IdentifierAnalyzer.addVariable(param1.getName(), param2);

	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		return new RGBColor (-1, -1, -1);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Equal)) {
			return false;
		}
		
		return true;
	}

	/**
	 * Returns "=", the representation of this variable in Picasso expressions
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "" + param1 + equal + param2;
	}
	

}
