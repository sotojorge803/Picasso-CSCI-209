package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.Token;

/**
 * Parses a function that takes two expression as a parameter.
 * 
 * XXX: Not sure if this class is necessary.
 * 
 * @author Sara Sprenkle
 * 
 */
public abstract class BinaryFunctionAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public abstract ExpressionTreeNode generateExpressionTree(
			Stack<Token> tokens);

}