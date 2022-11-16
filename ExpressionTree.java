import java.util.Stack;

public class ExpressionTree {
    private EvaluableNode root; //root of the expression tree

    /**
     * The constructor takes an infix expression as a String, builds and 
     * stores a tree to represent it
     * @param infix A parenthesized infix expression
     */
    public ExpressionTree(String infix) throws SyntaxErrorException {
        String postfix = Infix2Postfix.convert(infix);
        this.root = this.buildTree(postfix);
    }
    
    /**
     * Takes an expression in postfix form (as a string), and
     * builds an expression tree.
     * @param expr A postfix expression
     * @return root of the expression tree you built
     */
    private EvaluableNode buildTree(String expr) {
        Stack<EvaluableNode> tree = new Stack<>();
        while (!expr.isEmpty()) {
            expr = expr.trim();
            int end_index = (expr.contains(" "))
                ? expr.indexOf(" ")
                : expr.length();
            String val = expr.substring(0, end_index);
            if (this.isNumeric(val)) {
                ValueNode num = new ValueNode(this.numeric(val));
                tree.push(num);
            } else {
                EvaluableNode a = tree.pop();
                EvaluableNode b = tree.pop();
                BinaryOpNode op = new BinaryOpNode(val.charAt(0), b, a);
                tree.push(op);
            }
            expr = (end_index != expr.length()) 
                ? expr.substring(end_index + 1, expr.length())
                : "";
        }

        if (!tree.empty()) {
            return tree.peek();
        }
        return null;
    }

    /**
     * Evaluate the expression and return its value as a double. 
     * All we need to do is ask the root node in the tree to evaluate itself.
     * @return
     */
    public double evaluate() {
        return root.evaluate();
    }


    /**
     * Returns String str as a number (only use once confirmed with isNumeric()
     * @param str A string that should be confirmed to be convertible
     * @return value of str as a double
     **/
    private double numeric(String str) {
        return Double.parseDouble(str);
    }

    /**
     * Checks to see if str is convertible to a double
     * @param str A string that may or may not be a double
     * @return true if it is convertible, false otherwise
     **/
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @returns a String containing a fully-parenthesized representation of the expression. 
     * This expression should have spaces separating the operators, operands, and parentheses 
     * so that the resulting string could be used as input to the Expression constructor. 
     * All we need to do is ask the root node to print itself.
     */
    @Override
    public String toString() {
        return root.toString();
    }
}
