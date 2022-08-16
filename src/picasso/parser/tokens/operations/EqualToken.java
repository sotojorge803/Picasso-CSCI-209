package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the plus sign token
 * 
 */
public class EqualToken extends CharToken implements OperationInterface {
	public EqualToken() {
		super(CharConstants.EQUAL);
	}
}
