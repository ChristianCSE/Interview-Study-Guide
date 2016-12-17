class TestBST{

 public static void inOrder(BST.Node node, String dir, int stem){
  if(node!=null){
   if(node.data != stem) System.out.println(dir+ stem + " -> "+node.data);
   else System.out.println(dir+ " : " + node.data);
   inOrder(node.left, "left of  ", node.data);
   inOrder(node.right, "right of  ", node.data);
  }
  else{
   System.out.println(" /stop/");
  }
 }
 public static void main(String[] args) {
  BST tree = new BST(0);
  int[] incr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  BST.Node root = tree.getMinHeightBST(incr, 0, incr.length-1);
  inOrder(root, "root", root.data);
 }
}