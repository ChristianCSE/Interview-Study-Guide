class BST_Node {

  private double data;
  BST_Node left;
  BST_Node right;

  public BST_Node(double data) {
   this.data = data;
   left = null;
   right = null;
  }

  public BST_Node getLeft(){
   return left;
  }

  public BST_Node getRight() {
   return right;
  }


}