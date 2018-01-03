package Trees;

/**
 * Created by Christian on 12/9/16.
 */
public class TesterTree {


  public static void main(String[] args) {
    System.out.println("hello");
    BST tree = new BST(1);
    tree.insert(6);
    tree.insert(15);
    tree.insert(3);
    tree.insert(3);
    tree.insert(5);
    tree.insert(4);
    tree.inOrderTraversal(tree.getTree());
  }
}
