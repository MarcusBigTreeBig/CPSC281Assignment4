package question2;

/**
 * Binary Tree where the value of each node is stored as an int
 *
 * Has a huffmanValue so this tree can be used in a huffman algorithm
 */

public class IntBinaryTree {
    private IntBinaryTree left;
    private IntBinaryTree right;
    private IntBinaryTree parent;
    private int value;

    /**
     * creates a binary tree with a root
     *
     * @param value the value of the root
     */
    IntBinaryTree (int value) {
        this.value = value;
    }

    /**
     *
     * @return the value of the root
     */
    public int getValue() {
        return value;
    }

    /**
     *
     * @return the root of the left subtree
     */
    public IntBinaryTree getLeft() {
        return left;
    }

    /**
     *
     * @return the root of the right subtree
     */
    public IntBinaryTree getRight() {
        return right;
    }

    /**
     *
     * @return the parent of this node, null if there is no parent
     */
    public IntBinaryTree getParent() {
        return parent;
    }

    /**
     * Sets the left subtree
     *
     * @param left
     */
    public void setLeft(IntBinaryTree left) {
        this.left = left;
    }

    /**
     * Sets the right subtree
     *
     * @param right
     */
    public void setRight(IntBinaryTree right) {
        this.right = right;
    }

    /**
     * sets the parent of this node
     *
     * @param parent
     */
    public void setParent(IntBinaryTree parent) {
        this.parent = parent;
    }

    /**
     *
     * @return the path from the parent node to this node, 0 being left, 1 being right
     */
    public String huffmanValue () {
        if (parent == null) {
            return "";
        }else{
            if (parent.getLeft() == this) {
                return "0" + parent.huffmanValue();
            }
            else{
                return "1" + parent.huffmanValue();
            }
        }
    }

}
