package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.operations.PlusToken;

/**
 * Represents a function that takes one argument.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 *
 */
public abstract class BinaryFunction extends ExpressionTreeNode {

	ExpressionTreeNode param1;
	ExpressionTreeNode param2;
	String operator;
	//PlusToken token;

	/**
	 * 
	 * @param param
	 */
	public BinaryFunction(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		this.param1 = param1;
		this.param2 = param2;

	}

	/**
	 * Returns the string representation of the function in the format "<ClassName>:
	 * <parameter>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "" + param1 + operator + param2;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof BinaryFunction)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		BinaryFunction bf = (BinaryFunction) o;

		// check if their parameters are equal
		if (!this.param1.equals(bf.param1) && !this.param2.equals(bf.param2)) {
			return false;
		}
		return true;
	}

}