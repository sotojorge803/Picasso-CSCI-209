package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Floor;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;
import picasso.parser.language.expressions.Plus;
/**
 * Handles parsing the plus or "addition function".
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * 
 */
public class PlusAnalyzer implements SemanticAnalyzerInterface {
	ExpressionTreeNode exp1;
	ExpressionTreeNode exp2;
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the Plus token
		// the parameters are the next tokens on the stack.
		// But, they need to be processed
		// TODO: Need to finish.
		
		exp2 = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens); 
		exp1 = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
			return new Plus(exp1,exp2);
		
	
		
	}
}
