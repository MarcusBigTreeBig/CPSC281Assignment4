package question2;

public class IntBinaryTree {
    private IntBinaryTree left;
    private IntBinaryTree right;
    private IntBinaryTree parent;
    private int value;

    IntBinaryTree (int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public IntBinaryTree getLeft() {
        return left;
    }

    public IntBinaryTree getRight() {
        return right;
    }

    public IntBinaryTree getParent() {
        return parent;
    }

    public void setLeft(IntBinaryTree left) {
        this.left = left;
    }

    public void setRight(IntBinaryTree right) {
        this.right = right;
    }

    public void setParent(IntBinaryTree parent) {
        this.parent = parent;
    }

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
