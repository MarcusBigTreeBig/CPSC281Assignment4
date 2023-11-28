package question1;

public class Stack <T> {

    private StackNode<T> top;

    /**
     * creates an empty stack
     */
    public Stack () {
        top = null;
    }

    /**
     * pushes the input to the stack
     *
     * @param input
     */
    public void push (T input) {
        StackNode<T> node = new StackNode<T>(input);
        if (top != null) {
            node.down = top;
        }
        top = node;
    }

    /**
     * removes the top element from the stack
     */
    public void pop () {
        if (top != null) {
            top = top.down;
        }
    }

    /**
     *
     * @return the top element of the stack
     */
    public T top () {
        if (top != null) {
            return top.value;
        }else{
            return null;
        }
    }

    private class StackNode <T> {
        private T value;
        private StackNode<T> down;

        /**
         * creates a Node for a stack holding a value
         *
         * @param value
         */
        private StackNode (T value) {
            this.value = value;
            down = null;
        }

        /**
         *
         * @return the value of the node
         */
        private T getValue () {
            return value;
        }

        /**
         *
         * @return the node further down the stack
         */
        private StackNode<T> getDown () {
            return down;
        }

        /**
         * sets what node will be below this one in the stack
         *
         * @param down the node below this node
         */
        private void setDown (StackNode<T> down) {
            this.down = down;
        }

    }
}
