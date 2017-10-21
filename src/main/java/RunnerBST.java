import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * Created by valeriyartemenko on 21.10.17.
 */
public class RunnerBST {
    public static void main(String[] args) throws IOException {
        BST<Integer> bst = new BST<Integer>();
        bst.insert(100);
        bst.insert(99);
        bst.insert(111);
        bst.insert(109);
        bst.insert(100);
        bst.insert(134);
        bst.insert(64);
        bst.insert(45);
        bst.insert(146);
        System.out.println(bst.toString());
        simpleMenu(bst);
    }

    private static void simpleMenu(BST bst) throws IOException {
        int choice;
        int el;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Choose please:");
            System.out.println("1.INSERT \t2.DELETE \t3.SEARCH \t4.PATH \t5.EXIT");
            choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    System.out.println("\t\tEnter a number:");
                    System.out.print("\t\t");
                    el = Integer.parseInt(br.readLine());
                    bst.insert(el);
                    break;
                case 2:
                    System.out.println("\t\tEnter a number:");
                    System.out.print("\t\t");
                    el = Integer.parseInt(br.readLine());
                    bst.delete(el);
                    break;
                case 3:
                    System.out.println("\t\tEnter a number:");
                    System.out.print("\t\t");
                    el = Integer.parseInt(br.readLine());
                    if (bst.search(el))
                        System.out.println("\t\tElement is present");
                    else
                        System.out.println("\t\tElement is not present");

                    break;
                case 4:
                    for (Iterator<Integer> iterator = bst.iterator(); iterator.hasNext(); ) {
                        System.out.println(bst.getPath(iterator.next()));
                    }
                    break;
                case 5:
                    break;
            }
        } while (choice != 5);
    }
}
