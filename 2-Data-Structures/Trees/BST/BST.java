public class BST {

  public BST_Node root;

  public BST() {
   root = null;
  }

  public insert(double data){
   BST_Node node = new BST_Node(data);
   if(root == null){
    root = node;
    return;
   }
   //recursive insert!
   // re_insert(node, root);
  }

  public re_insert(Node node, Node curr) {

  }

}