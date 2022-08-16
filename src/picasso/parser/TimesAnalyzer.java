package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Floor;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;
import picasso.parser.language.expressions.Times;
/**
 * Handles parsing the times or "multiplication function".
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * 
 */
public class TimesAnalyzer implements SemanticAnalyzerInterface {
	ExpressionTreeNode exp1;
	ExpressionTreeNode exp2;
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the Times token
		// the parameters are the next tokens on the stack.
		// But, they need to be processed
		// TODO: Need to finish.
		
		exp2 = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens); 
		exp1 = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
			return new Times(exp1,exp2);
	
		
	}
}
