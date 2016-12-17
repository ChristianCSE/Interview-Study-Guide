package Trees;

/**
 * Created by Christian on 12/10/16.
 */
public class BT {
  Node root;
  class Node {
    int data;
    Node right;
    Node left;
    public Node(int data){
      this.data = data;
    }
  }

  public BT(int data){
    root = new Node(data);
  }

  public Node getTree(){
    return root;
  }


}
