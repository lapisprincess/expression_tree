public class BinaryOpNode implements EvaluableNode {
    char operator;
    EvaluableNode lnode;
    EvaluableNode rnode;

    public BinaryOpNode(char operator, EvaluableNode a, EvaluableNode b) {
        this.operator = operator;
        this.lnode = a;
        this.rnode = b;
    }

    @Override
    public double evaluate() {
        if (operator == '+') {
            return lnode.evaluate() + rnode.evaluate();
        } else if (operator == '-') {
            return lnode.evaluate() - rnode.evaluate();
        } else if (operator == '/') {
            return lnode.evaluate() / rnode.evaluate();
        } else if (operator == '*') {
            return lnode.evaluate() * rnode.evaluate();
        }
        return 0;
    }

    @Override
    public String toString() {
        String out = "( ";
        out += lnode.toString() + " ";
        out += String.valueOf(operator) + " ";
        out += rnode.toString();
        out += " )";
        return out;
    }
}
