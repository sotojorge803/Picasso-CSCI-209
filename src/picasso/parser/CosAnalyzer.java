package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Cos;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the floor function.
 * 
 * @author Sara Sprenkle
 * 
 */
public class CosAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the Cosine token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Cos(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}