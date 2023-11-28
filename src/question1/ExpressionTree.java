package question1;

/**
 * A binary tree that holds an arithmetic expression
 * Can output the expression in infix, postfix, our prefix notation
 */

public class ExpressionTree {

    private ExpressionNode root;

    /**
     * takes an expression, and creates a binary tree from the expression
     *
     * @param expression fully parenthesized infix expression
     */
    public ExpressionTree (String expression) {
        int inside = 0;//how many sets of parentheses inside
        boolean noUnescessaryParentheses = false;
        boolean operatorFound = false;
        int i;
        expression = "(" + expression + ")";//so that in the first iteration of do while we don't remove potentially important parentheses
        do {//trims any unescessary parentheses from the start and end
            if (expression.charAt(0) == '(') {
                expression = expression.substring(1, expression.length()-1);
                for (i = 0; i < expression.length(); i++) {
                    if (expression.charAt(i) == '(') {
                        inside++;
                    } else if (expression.charAt(i) == ')') {
                        inside--;
                    } else if (inside == 0 && isOperator(expression.charAt(i) + "")) {//finding the top level operator
                        noUnescessaryParentheses = true;
                    }
                }
            }else{
                noUnescessaryParentheses = true;
            }
        }while (!noUnescessaryParentheses);//until no unescessary parentheses
        for (i = 0; i < expression.length() && !operatorFound; i++) {
            if (expression.charAt(i) == '(') {
                inside++;
            }else if (expression.charAt(i) == ')') {
                inside--;
            }else if (inside == 0 && isOperator(expression.charAt(i) + "")) {//finding the top level operator
                operatorFound = true;
                root = new ExpressionNode(expression.charAt(i) + "");
                root.setLeft(new ExpressionTree(expression.substring(0, i)).root);
                root.setRight(new ExpressionTree(expression.substring(i+1, expression.length())).root);
            }
        }
        if (i == expression.length()) {
            root = new ExpressionNode(expression);
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
        if (root == null) {
            return "";
        }else if (root.getLeft() == null || root.getRight() == null) {
            return root.getValue();
        }else{
            ExpressionTree leftTree = new ExpressionTree(root.getLeft());
            ExpressionTree rightTree = new ExpressionTree(root.getRight());
            return root.getValue() + leftTree.prefix() + rightTree.prefix();
        }
    }

    /**
     *
     * @return the expression in infix notation, fully parenthesized
     */
    public String infix () {
        if (root == null) {
            return "";
        }else if (root.getLeft() == null || root.getRight() == null) {
            return root.getValue();
        }else{
            ExpressionTree leftTree = new ExpressionTree(root.getLeft());
            ExpressionTree rightTree = new ExpressionTree(root.getRight());
            return "(" + leftTree.infix() + root.getValue() + rightTree.infix() + ")";
        }
    }

    /**
     *
     * @return the expression in postfix notation
     */
    public String postfix () {
        if (root == null) {
            return "";
        }else if (root.getLeft() == null || root.getRight() == null) {
            return root.getValue();
        }else{
            ExpressionTree leftTree = new ExpressionTree(root.getLeft());
            ExpressionTree rightTree = new ExpressionTree(root.getRight());
            return leftTree.postfix() + rightTree.postfix() + root.getValue();
        }
    }

    /**
     *
     * @return true if the value is an operator
     */
    public static boolean isOperator (String value) {
        if (value.length() == 1) {
            if (value.charAt(0) == '/' || value.charAt(0) == '*' || value.charAt(0) == '+' || value.charAt(0) == '-') {
                return true;
            }
        }
        return false;
    }

}
