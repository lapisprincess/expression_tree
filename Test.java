public class Test {
    public static void main(String[] args) throws Exception {
        ExpressionTree e = new ExpressionTree("( 45 / 4.5 )");
        System.out.print("Expression: ");
        System.out.println(e.toString());
        System.out.print("Result: ");
        System.out.println(e.evaluate());
        
        System.out.println("-------------");

        e = new ExpressionTree("( ( 1 + ( 2 * 3 ) ) - 4 )");
        System.out.print("Expression: ");
        System.out.println(e.toString());
        System.out.print("Result: ");
        System.out.println(e.evaluate());

        System.out.println("-------------");

        e = new ExpressionTree("( ( 1 + ( 2.9 * -3 ) ) - 4 )");
        System.out.print("Expression: ");
        System.out.println(e.toString());
        System.out.print("Result: ");
        System.out.println(e.evaluate());

        System.out.println("-------------");

        e = new ExpressionTree("( 1 + ( 2 * ( 3 - 4 ) ) )");
        System.out.print("Expression: ");
        System.out.println(e.toString());
        System.out.print("Result: ");
        System.out.println(e.evaluate());

        System.out.println("-------------");

        e = new ExpressionTree("( 1 + ( 5 / 3 ) )");
        System.out.print("Expression: ");
        System.out.println(e.toString());
        System.out.print("Result: ");
        System.out.println(e.evaluate());
    }
}
