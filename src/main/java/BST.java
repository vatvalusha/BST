import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Valera on 18.10.2017.
 */

public class BST<E extends Comparable<E>> extends AbstractTree<E> implements Cloneable {

    protected TreeNode<E> root;
    protected int size = 0;

    /**
     * Create a default binary search tree
     */
    public BST() {
    }

    /**
     * Create a binary search tree from an array of objects
     */
    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    public boolean search(E e) {
        TreeNode<E> current = root; // Start from the root

        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else // element matches current.element
                return true; // Element is found
        }
        return false;
    }

    @Override
    /** Insert element e into the binary search tree.
     35 * Return true if the element is inserted successfully. */
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e); // Create a new root
        else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null)
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; // Duplicate node not inserted
            // Create the new node and attach it to the parent node
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true; // Element inserted successfully
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<E>(e);
    }

    @Override
    /** Delete an element from the binary search tree.
     * Return true if the element is deleted successfully.
     * Return false if the element is not in the tree. */
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                break; // Element is in the tree pointed at by current
        }
        if (current == null)
            return false; // Element is not in the tree
        // Case 1: current has no left child
        if (current.left == null) {
            // Connect the parent with the right child of the current node
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        } else {
            // Case 2: The current node has a left child.
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent.
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }
            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;

            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                // Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
        }

        size--;
        return true; // Element deleted successfully
    }


    @Override
    public void breadthFirstTraversal() {

    }

    @Override
    /** Get the number of nodes in the tree */
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * Returns the node for the specified element.
     * Returns null if the element is not in the tree.
     */
    private TreeNode<E> getNode(E element) {
        return null;
    }

    /**
     * Returns true if the node for the element is a leaf
     */
    private boolean isLeaf(E element) {
        return false;
    }

    public ArrayList<E> getPath(E e) {
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

    private static void testMethode(){
        System.out.println("Hello");
    }
}
