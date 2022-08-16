package picasso.parser;

import java.util.Stack;
import picasso.parser.language.expressions.Variable;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.Token;
import picasso.parser.language.expressions.Equal;
import picasso.parser.tokens.IdentifierToken;

/**
 * 
 * Handles parsing the plus or "addition function".
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * 
 */
public class EqualAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		// Remove the Equal token
		ExpressionTreeNode valueOfAssignment = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		
		
		if (tokens.peek() instanceof IdentifierToken){
			IdentifierToken token = (IdentifierToken) tokens.pop();
			Variable variable = new Variable(token.getName());
			 return new Equal(variable, valueOfAssignment);
		}
		else {
			throw new ParseException("ERROR: Required variable for assignment "); 
		}
		
  }
	
}
