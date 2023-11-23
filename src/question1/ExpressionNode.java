package question1;

/**
 * Tree node where the value is a string
 * Has a reference to it's left and right children
 */

public class ExpressionNode {

    private String value;
    private ExpressionNode left;
    private ExpressionNode right;

    /**
     * creates a node for an expression tree
     *
     * @param value of the node
     */
    public ExpressionNode (String value) {
        this.value = value;
        left = null;
        right = null;
    }

    /**
     *
     * @return the value of the node
     */
    public String getValue () {
        return value;
    }

    /**
     *
     * @return the left child
     */
    public ExpressionNode getLeft () {
        return left;
    }

    /**
     *
     * @return the right child
     */
    public ExpressionNode getRight () {
        return right;
    }

    /**
     *
     * @param node new left child node
     */
    public void setLeft (ExpressionNode node) {
        left = node;
    }

    /**
     *
     * @param node new right child node
     */
    public void setRight (ExpressionNode node) {
        right = node;
    }

}
