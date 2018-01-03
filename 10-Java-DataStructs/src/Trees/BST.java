package Trees;

/**
 * Created by Christian on 12/10/16.
 */
public class BST {

  Node root;

  class Node {
    int data;
    Node left;
    Node right;
    public Node(int data){
      this.data = data;
    }
  }

  public BST(int data) {
    root = new Node(data);
  }

  public Node getTree(){
    return root;
  }

  public void inOrderTraversal(Node node){
    //left parent right
    if(node != null) {
      inOrderTraversal(node.left);
      System.out.print(node.data + " ");
      inOrderTraversal(node.right);
    }
  }

  //parent then children
  public void preOrderTraversal(Node node) {
    if(node != null) {
      System.out.println(node.data + " ");
      preOrderTraversal(node.right);
      preOrderTraversal(node.left);
    }

  }

  //children then parent
  public void postOrderTraversal(Node node){
    if(node != null) {
      postOrderTraversal(node.right);
      postOrderTraversal(node.left);
      System.out.println(node.data + " ");
    }
  }


  public void insert(int data) {
    Node node = new Node(data);
    if(root == null){
      root = node;
    }
    else {
      insert(node, root);
    }
  }

  public void insert(Node node, Node current) {
    int diff = node.data - current.data;
    //neg => less than || post => greater than
    if(diff > 0){
      if(current.right == null) {
        current.right = node;
      }
      else {
        insert(node, current.right);
      }
    }
    else{
      if(current.left == null) {
        current.left = node;
      }
      else {
        insert(node, current.left);
      }
    }
  }

}
