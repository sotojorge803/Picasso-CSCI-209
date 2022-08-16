package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ImageClip;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;

public class ImageClipAnalyzer implements SemanticAnalyzerInterface {
	ExpressionTreeNode exp1;
	ExpressionTreeNode exp2;

	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the ImageWrap token
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
			return new ImageClip(temp.getName(), exp1,exp2);
		}
		return null;//throw exception error "expeced image name, recieved : "
	
	
}
}
