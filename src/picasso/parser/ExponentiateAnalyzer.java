package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Floor;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;
import picasso.parser.language.expressions.Divide;
import picasso.parser.language.expressions.Exponentiate;
/**
 * Handles parsing the exponent or "exponentiate function".
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * 
 */
public class ExponentiateAnalyzer implements SemanticAnalyzerInterface {
	ExpressionTreeNode exp1;
	ExpressionTreeNode exp2;
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the Exponentiate token
		// the parameters are the next tokens on the stack.
		// But, they need to be processed
		// TODO: Need to finish.
		
		exp2 = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens); 
		exp1 = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		Token token = tokens.pop();
		if (token instanceof StringToken) {
			StringToken temp = (StringToken) token;
			return new Exponentiate(exp1,exp2);
		}
		return null;//throw exception error "expeced image name, recieved : "
	
		
	}
}
