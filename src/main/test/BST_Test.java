import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

/**
 * Created by valeriyartemenko on 21.10.17.
 */
public class BST_Test {
    private BST<Integer> bst;

    @Before
    public void setUp() throws Exception {
        bst = new BST<Integer>();
        bst.insert(20);
        bst.insert(14);
        bst.insert(10);
        bst.insert(2);
        bst.insert(13);
        bst.insert(11);
        bst.insert(8);
    }

    @Test
    public void testSize(){
        assertEquals (7,bst.getSize());
    }

    @Test
    public void testSearch(){
        boolean result = bst.search(10);
        assertEquals (true,result);
    }

    @Test
    public void testDelete(){
        boolean result = bst.delete(10);
        assertEquals(true,result);
        assertEquals(6,bst.getSize());
    }

    @Test
    public void testGetNode(){
        BST.TreeNode<Integer> result = bst.get(8);
    }
  @Test
    public void testClear(){
      assertEquals(7,bst.getSize());
      bst.clear();
      assertEquals(0,bst.getSize());
  }

    @Test
    public void testIsLeaf(){
        boolean result = bst.isLeaf(14);
        assertEquals(false,result);
    }

    @Test
    public void testGetPath(){
        ArrayList<Integer> result = bst.getPath(8);
        ArrayList<Integer> actually = new ArrayList<>();
        actually.add(20);
        actually.add(14);
        actually.add(10);
        actually.add(2);
        actually.add(8);
        assertEquals(result,actually);
    }

    @Test
    public void testIterator(){
        for (Iterator<Integer> iterator = bst.iterator(); iterator.hasNext(); ) {
            iterator.next();
        }
    }


}
