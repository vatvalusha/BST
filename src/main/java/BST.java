import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;


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
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else
                return true;
        }
        return false;
    }

    @Override
    /** Insert element e into the binary search tree.
     35 * Return true if the element is inserted successfully. */
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e);
        else {
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
                    return false;
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true;
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<E>(e);
    }

    @Override
    /** Delete an element from the binary search tree.
     * Return true if the element is deleted successfully.
     * Return false if the element is not in the tree. */
    public boolean delete(E e) {
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
                break;
        }
        if (current == null)
            return false;
        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        } else {
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;
            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }
            current.element = rightMost.element;

            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                parentOfRightMost.left = rightMost.left;
        }
        size--;
        return true;
    }


    @Override
    public void breadthFirstTraversal() {

    }

    @Override
    /** Get the number of nodes in the tree */
    public int getSize() {
        return size;
    }

    /**
     * Returns the root of the tree
     */
    public TreeNode<E> getRoot() {
        return root;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        Stack<TreeNode<E>> stk = new Stack<TreeNode<E>>();

        public MyIterator() {
            if (root != null)
                stk.push(root);
        }

        public boolean hasNext() {
            return !stk.isEmpty();
        }

        public E next() {
            TreeNode<E> cur = stk.peek();
            if (cur.left != null) {
                stk.push(cur.left);
            } else {
                TreeNode<E> tmp = stk.pop();
                while (tmp.right == null) {
                    if (stk.isEmpty()) return cur.element;
                    tmp = stk.pop();
                }
                stk.push(tmp.right);
            }
            return cur.element;
        }

        public void remove() {

        }
    }

    /**
     * Returns the node for the specified element.
     * Returns null if the element is not in the tree.
     */
    public TreeNode<E> get(E key) {
        return get(root, key);
    }

    private TreeNode<E> get(TreeNode<E> x, E value) {
        if (value == null)
            throw new IllegalArgumentException("calls get() with a null value");
        if (x == null)
            return null;
        int cmp = value.compareTo(x.element);
        if (cmp < 0)
            return get(x.left, value);
        else if (cmp > 0)
            return get(x.right, value);
        else
            return x;
    }

    /**
     * Returns true if the node for the element is a leaf
     */
    public boolean isLeaf(E item) {
        return this.isLeaf(this.root, item);
    }

    private boolean isLeaf(TreeNode<E> current, E value) {
        if (current == null) {
            return false;
        } else if (current.left == null && current.right == null) {
            return true;
        } else {
            return isLeaf(current.left, value) && isLeaf(current.right, value);
        }
    }

    public boolean isLeaf(TreeNode<E> node) {
        if (node.left == null && node.right == null) {
            return true;
        } else {
            return false;
        }
    }


    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (E data : this) sb.append(data.toString() + " ");

        return sb.toString();
    }


    /**
     * Return a path from the root leadting to the specified element
     */
    public ArrayList<E> getPath(E e) {
        ArrayList<E> list = new ArrayList<E>();
        TreeNode<E> current = root; // Start from the root

        while (current != null) {
            list.add(current.element); // Add the node to the list
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else
                break;
        }

        return list;
    }


    /**
     * Remove all elements from the tree
     */

    public void clear() {
        root = null;
        size = 0;
    }



    public static class TreeNode<E extends Comparable<E>> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;
        protected TreeNode<E> parent;

        public TreeNode(E e) {
            element = e;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "element=" + element +
                    ", left=" + left +
                    ", right=" + right +
                    ", parent=" + parent +
                    '}';
        }
    }
}
