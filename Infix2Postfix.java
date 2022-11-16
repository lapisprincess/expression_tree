import java.util.Stack;

/**
 * This class provides a single static method that converts between
 * infix and postfix (RPN) expressions.
 *
 * @author David
 * @version 3/10/18
 */
public class Infix2Postfix
{
    /**
     * Converts infix to postfix (RPN)
     * @param infix An infix expression with space separating every symbol. 
     * For instance
     * "( ( 4 + 4 ) / ( 0 - 3 ) )" => "4 4 + 0 3 - /"
     */
    public static String convert(String infix) {
        String postfix = "";                    // to be returned
        Stack<String> opStack = new Stack<>();  // holds operators that we enounter left to right
        Stack<String> valStack = new Stack<>(); // holds intermediate expressions
        
        String[] tokens = infix.split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            //ignore left paren
            if (tokens[i].equals("(")) {
                continue;
            }

            // push known operators onto the opstack!
            else if (tokens[i].equals("+") || tokens[i].equals("*") || 
            tokens[i].equals("-") || tokens[i].equals("/")) {
                opStack.push(tokens[i]);
            }

            // evaluate 
            else if (tokens[i].equals(")")) {
                // pop two operands off the val stack
                String a = valStack.pop();
                String b = valStack.pop();

                // pop the operator off the op stack
                String op = opStack.pop();
                valStack.push(b + " " + a + " " + op);
            }

            // push operand onto val stack
            else {
                valStack.push(tokens[i]);
            }
        }
        return valStack.pop();
    }
}
