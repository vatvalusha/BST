import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Valera on 18.10.2017.
 */

public class BST<E extends Comparable<E>> extends AbstractTree<E> implements Cloneable {
    @Override
    public boolean search(E e) {
        return false;
    }

    @Override
    public boolean insert(E e) {
        return false;
    }

    @Override
    public boolean delete(E e) {
        return false;
    }

    @Override
    public void breadthFirstTraversal() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /** Returns the node for the specified element.
     * Returns null if the element is not in the tree. */
    private TreeNode<E> getNode(E element){
        return null;
    }

    /** Returns true if the node for the element is a leaf */
    private boolean isLeaf(E element){
        return false;
    }

    public ArrayList<E> getPath(E e){
        return null;
    }

    public static class TreeNode<E extends Comparable<E>> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;
        protected TreeNode<E> parent;

        public TreeNode(E e) {
            element = e;
        }
    }
}
