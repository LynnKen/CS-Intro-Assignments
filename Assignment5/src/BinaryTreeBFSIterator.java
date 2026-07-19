import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTreeBFSIterator <T> implements Iterator<T> {
    // Fields
    private Queue<BinaryNode<T>> q;

    // Constructors
    public BinaryTreeBFSIterator(BinaryNode<T> root){
        q = new QueueAsLinkedList<>();
        q.enqueue(root);
    }

    // Methods
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        BinaryNode<T> node = q.dequeue();
        if(node.left != null) {
            q.enqueue(node.left);
        }
        if(node.right != null) {
            q.enqueue(node.right);
        }
        return node.data;
    }

    public boolean hasNext() {
        return !q.isEmpty() ;
    }

}
