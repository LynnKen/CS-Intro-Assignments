import java.util.Arrays;

public class BalancedBinaryTreeTest<T extends Comparable<T>> extends BinaryTree<T> {
    private BinaryNode<T> root;

    public BalancedBinaryTreeTest() {
        root = null;
    }

    public void createBalancedTree(T[] array) {
        if (array == null || array.length == 0) {
            root = null;
            return;
        }

        Arrays.sort(array);
        root = createBalancedTreeRec(array, 0, array.length - 1);
    }

    private BinaryNode<T> createBalancedTreeRec(T[] array, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        BinaryNode<T> node = new BinaryNode<T>(array[mid]);

        node.left = createBalancedTreeRec(array, start, mid - 1);
        node.right = createBalancedTreeRec(array, mid + 1, end);

        return node;
    }

    public BinaryNode<T> getRoot() {
        return this.root;
    }
}
