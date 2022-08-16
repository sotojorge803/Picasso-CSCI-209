package picasso.parser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.view.Frame;
import picasso.view.commands.Evaluator;
import picasso.parser.language.expressions.Equal;

/**
 * Handle an identifier token
 * 
 * @author Sara Sprenkle
 *
 */
public class IdentifierAnalyzer implements SemanticAnalyzerInterface{

	ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
	Evaluator whatever = new Evaluator();

	static Map<String, ExpressionTreeNode> idToExpression = new HashMap<String, ExpressionTreeNode>();

	static {
		// We always have x and y defined.
		idToExpression.put("x", new X());
		idToExpression.put("y", new Y());
	}
	

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		IdentifierToken t = (IdentifierToken) tokens.pop();
		String id = t.getName();
		ExpressionTreeNode mapped = idToExpression.get(id);
		if (mapped != null) {
			return mapped;
		}


		// TODO : What should we do if we don't recognize the identifier?
		// Is that an error? Or, could there a valid reason?
		return null;
	}

	public static void addVariable(String q, ExpressionTreeNode t) {
		if (!q.equals("x") && !q.equals("y")) {
			idToExpression.put(q, t);
		} else {
			throw new ParseException("ERROR: Attempting to update defined functions ");
		}
	}
	
	public static Map<String, ExpressionTreeNode> getExpMap(){
		return idToExpression;
	}

}
