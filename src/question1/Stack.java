package question1;

public class Stack <T> {

    private class StackNode <T> {
        private T value;
        private StackNode<T> down;
        private StackNode<T> up;

        /**
         * creates a Node for a stack holding a value
         *
         * @param value
         */
        private StackNode (T value) {

        }


        private T getValue () {
            return value;
        }

    }
}
