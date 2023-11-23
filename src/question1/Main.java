package question1;

import java.util.Scanner;

public class Main {

    /**
     * Takes input from user as an infix expression,
     * creates an expression tree from the input,
     * prints the expression in prefix, infix, and postfix notation
     *
     * @param args
     */
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        ExpressionTree tree = new ExpressionTree(expression);
        System.out.println("Prefix: " + tree.prefix() + "\nInfix: " + tree.infix() + "\nPostfix: " + tree.postfix());
    }
}

/*
Sample Output:

(5+7)*(6+3)
Prefix: *+57+63
Infix: ((5+7)*(6+3))
Postfix: 57+63+*
 */
