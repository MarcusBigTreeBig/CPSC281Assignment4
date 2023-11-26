package question2;

public class Main {

    /**
     * assigns frequency of uses (weights) to each letter in the alphabet
     * applies a huffman code to the weights
     * prints the huffman code for each letter
     *
     * @param args
     */
    public static void main (String[] args) {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int[] weights = {7, 2,  2, 3, 11, 2, 2, 6, 6, 1, 1, 4, 3, 7, 9, 2, 1, 6, 6, 8, 4, 1, 2, 1, 2, 1};
        String[] codes = huffman(weights);
        for (int i = 0; i < letters.length; i++) {
            System.out.println(letters[i] + ": " + codes[i]);
        }
    }

    /**
     * Applies a huffman algorithm to give a code for each weight inputted
     *
     * @param weights the weights for each letter
     * @return the huffman code for each letter, in the same order as the input
     */
    public static String[] huffman (int[] weights) {
        //initialize all weights as roots
        IntBinaryTree[] roots = new IntBinaryTree[weights.length];
        IntBinaryTree[] originalNodes = new IntBinaryTree[weights.length];
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            roots[i] = new IntBinaryTree(weights[i]);
            originalNodes[i] = roots[i];
            sum += weights[i];
        }

        //converting the weights into a tree until only 1 root node
        int minIndex1;
        int minIndex2;
        int min1;
        int min2;
        int current;
        IntBinaryTree tree;

        for (int j = 0; j < weights.length-1; j++) {
            minIndex1 = -1;//-1 if hasn't found an index yet
            minIndex2 = -1;
            for (int i = 0; i < roots.length; i++) {
                if (roots[i] != null) {
                    current = roots[i].getValue();
                    if (minIndex1 > -1) {//checking if it has an index yet
                        min1 = roots[minIndex1].getValue();
                    } else {
                        min1 = sum + 1;//larger value than possible
                    }
                    if (minIndex2 > -1) {
                        min2 = roots[minIndex2].getValue();
                    } else {
                        min2 = sum + 1;
                    }
                    //considering all cases, these are the ones where something should be done
                    if (current <= min1 && min1 <= min2 || min1 < current && current < min2) {
                        minIndex2 = i;
                    } else if (current <= min2 && min2 < min1 || min2 < current && current < min1) {
                        minIndex1 = i;
                    }
                }
            }
            tree = new IntBinaryTree(roots[minIndex1].getValue() + roots[minIndex2].getValue());
            tree.setLeft(roots[minIndex1]);
            tree.setRight(roots[minIndex2]);
            tree.getLeft().setParent(tree);
            tree.getRight().setParent(tree);
            roots[minIndex1] = null;
            roots[minIndex2] = null;
            roots[minIndex2] = tree;
        }

        //finding the huffman value for each starting node
        String[] codes = new String[weights.length];
        for (int i = 0; i < weights.length; i++) {
            codes[i] = originalNodes[i].huffmanValue();
        }

        return codes;
    }

}

/*
Output:

a: 1111
b: 011001
c: 010101
d: 00110
e: 010
f: 101001
g: 010001
h: 0100
i: 0011
j: 1000001
k: 0111001
l: 1100
m: 10110
n: 0111
o: 000
p: 001001
q: 0110001
r: 1110
s: 1011
t: 1101
u: 00101
v: 0000001
w: 100001
x: 1110001
y: 110101
z: 1111001
 */
