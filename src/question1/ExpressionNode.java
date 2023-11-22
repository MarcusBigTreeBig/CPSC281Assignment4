package question1;

public class ExpressionNode {

    private String value;
    private ExpressionNode left;
    private ExpressionNode right;
    private ExpressionNode parent;

    /**
     * creates a node for an expression tree
     *
     * @param value of the node
     */
    public ExpressionNode (String value) {
        this.value = value;
        left = null;
        right = null;
        parent = null;
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
     * @return the parent node
     */
    public ExpressionNode getParent () {
        return parent;
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

    /**
     *
     * @param node new parent node
     */
    public void setParent (ExpressionNode node) {
        parent = node;
    }

}
