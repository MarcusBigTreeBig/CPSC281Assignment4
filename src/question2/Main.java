package question2;

import java.util.ArrayList;

public class Main {

    /**
     * assigns frequency of uses (weights) to each letter in the alphabet
     * applies a huffman code to the weights
     * prints the huffman code for each letter
     *
     * @param args
     */
    public static void main (String[] args) {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
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
        ArrayList<IntBinaryTree> roots = new ArrayList<>();
        ArrayList<IntBinaryTree> originalNodes = new ArrayList<>();
        int sum = 0;
        for (int i: weights) {
            roots.add(new IntBinaryTree(i));
            originalNodes.add(roots.get(roots.size()-1));
            sum += i;
        }

        //converting the weights into a tree until only 1 root node
        int minIndex1;
        int minIndex2;
        int min1;
        int min2;
        int current;
        IntBinaryTree tree;

        while (roots.size() != 1) {
            minIndex1 = -1;//-1 if hasn't found an index yet
            minIndex2 = -1;
            for (int i = 0; i < roots.size(); i++) {
                current = roots.get(i).getValue();
                if (minIndex1 > -1) {//checking if it has an index yet
                    min1 = roots.get(minIndex1).getValue();
                }else{
                    min1 = sum+1;//larger value than possible
                }
                if (minIndex2 > -1) {
                    min2 = roots.get(minIndex2).getValue();
                }else{
                    min2 = sum+1;
                }
                //considering all cases, these are the ones where something should be done
                if (current <= min1 && min1 <= min2 || min1 < current && current < min1) {
                    minIndex2 = i;
                } else if (current <= min2 && min2 < min1 || min2 < current && current < min1) {
                    minIndex1 = i;
                }
            }
            tree = new IntBinaryTree(roots.get(minIndex1).getValue() + roots.get(minIndex2).getValue());
            tree.setLeft(roots.get(minIndex1));
            tree.setRight(roots.get(minIndex2));
            tree.getLeft().setParent(tree);
            tree.getRight().setParent(tree);
            if (minIndex1 > minIndex2) {
                roots.remove(minIndex1);
                roots.remove(minIndex2);
            }else{
                roots.remove(minIndex2);
                roots.remove(minIndex1);
            }
            roots.add(tree);

        }

        //finding the huffman value for each starting node
        String[] codes = new String[weights.length];
        for (int i = 0; i < originalNodes.size(); i++) {
            codes[i] = originalNodes.get(i).huffmanValue();
        }

        return codes;
    }

}
