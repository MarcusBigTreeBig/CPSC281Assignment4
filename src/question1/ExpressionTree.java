package question1;

public class ExpressionTree {

    public static char[] operators = {'/', '*', '+', '-'};//in order of precedence

    ExpressionNode root;

    /**
     * takes an expression, and creates a binary tree from the expression
     * needs spaces between operands, operators, parentheses
     *
     * @param expression fully parenthesized infix expression
     */
    public ExpressionTree (String expression) {
        Stack<String> stack = new Stack<String>();
        String substring;
        int inside = 0;//how many sets of parentheses inside
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                inside++;
            }else if (expression.charAt(i) == ')') {
                inside--;
            }else if (isOperator(expression.charAt(i) + "")) {
                root = new ExpressionNode(expression.charAt(i) + "");
                root.setLeft(new ExpressionTree(expression.substring(0, i-1)).root);
                root.setRight(new ExpressionTree(expression.substring(i+1, expression.length()-1)).root);
            }
        }
    }

    /**
     * turns a node into a tree
     *
     * @param node
     */
    private ExpressionTree (ExpressionNode node) {
        root = node;
    }

    /**
     *
     * @return the expression in prefix notation
     */
    public String prefix () {
        if (root.getLeft() == null || root.getRight() == null) {
            return root.getValue();
        }else{
            ExpressionTree leftTree = new ExpressionTree(root.getLeft());
            ExpressionTree rightTree = new ExpressionTree(root.getRight());
            return root.getValue() + leftTree.root.getValue() + rightTree.root.getValue();
        }
    }

    /**
     *
     * @return the expression in infix notation, fully parenthesized
     */
    public String infix () {
        if (root.getLeft() == null || root.getRight() == null) {
            return root.getValue();
        }else{
            ExpressionTree leftTree = new ExpressionTree(root.getLeft());
            ExpressionTree rightTree = new ExpressionTree(root.getRight());
            return "(" + leftTree.root.getValue() + rightTree.root.getValue() + root.getValue() + ")";
        }
    }

    /**
     *
     * @return the expression in postfix notation
     */
    public String postfix () {
        if (root.getLeft() == null || root.getRight() == null) {
            return root.getValue();
        }else{
            ExpressionTree leftTree = new ExpressionTree(root.getLeft());
            ExpressionTree rightTree = new ExpressionTree(root.getRight());
            return leftTree.root.getValue() + rightTree.root.getValue() + root.getValue();
        }
    }

    /**
     * lower number for higher precedence
     *
     * @return precedence, -1 if the value is not an operator
     */
    public static int precedence (String value) {
        if (value.length() == 1)
            for (int i = 0; i < operators.length; i++) {
                if (value.charAt(0) == i) {
                    return i;
                }
            }
        return -1;
    }

    /**
     *
     * @return true if the value is an operator
     */
    public static boolean isOperator (String value) {
        return precedence(value) > -1;
    }

}
