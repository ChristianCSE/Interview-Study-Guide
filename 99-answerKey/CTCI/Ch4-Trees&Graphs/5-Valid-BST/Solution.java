
class Solution{

 public static boolean validBST(Node root){
  int lo = Integer.MIN_VALUE;
  int hi = Integer.MAX_VALUE;

  return validBST(root, lo, hi);
 }//, boolean curr)
 public static boolean validBST(Node parent, int lo, int max){
  boolean valid = true;
  boolean leftValid = true; 
  boolean rightValid=true; 
  // System.out.println(parent.data + "<=======Printing parent.data");
  if(parent==null){return true;}
  else if(parent.right==null && parent.left==null){
   return true;
  }
  else if(parent.left==null){
   valid =  parent.right.data > parent.data ? true:false;
   leftValid=false;
  }
  else if(parent.right==null){
   valid= parent.left.data < parent.data ? true:false;
   rightValid=false;
  }
  else if(parent.right.data > parent.data && parent.left.data < parent.data) {
   valid = true;
  }
  //auto true if null
  if(!valid){return false;}
  boolean leftSide = leftValid ? validBST(parent.left, lo, parent.data): true;
  boolean rightSide = rightValid  ? validBST(parent.right, parent.data, max): true; 
  return (leftSide&&rightSide==true) ? true:false;
 }


 public static void main(String[] args){
  Tree tree = new Tree(20);
  int[] nodes = new int[]{1, 39, 12, 10, 23, 42, 48, 84, 9, 11};
  for(int node : nodes){
   tree.insert(node);
  }
  // tree.inOrder();
  System.out.println(validBST(tree.root));
  tree.unBST(); // test that it words for invalid BST
  // tree.inOrder();
  System.out.println(validBST(tree.root));
 }
 
}

class Tree{
 Node root; 
 public Tree(int data){
  root = new Node(data);
 }

 public void insert(int curr){
  if(root==null){
   root = new Node(curr);
  }else{
   Node pointer = this.root;
   insertNode(pointer, curr);
  }
 }
 //if(null){return new Node(data)}
 public void insertNode(Node node, int newData){
  int diff= newData - node.data;
  if(diff > 0){
   if(node.right == null){
    node.right = new Node(newData);
   }
   else{
    insertNode(node.right, newData);
   }
  }
else{
 if(node.left == null){
  node.left = new Node(newData);
 }
 else{
  insertNode(node.left, newData);
 }
}
}

 public void inOrder(){
  Node traversal = root;
  printInOrder(traversal);
 }
 public void printInOrder(Node node){
  if(node!=null){
   printInOrder(node.left);
   System.out.println(node.data);
   printInOrder(node.right);
  }
 }

 public void unBST() {
  System.out.println();
  Node pointer = root;
  while(pointer!=null){
   if(pointer.data==84){
    pointer.data = 43;
   }
   pointer = pointer.right;
  }
 }

}
class Node{
 int data;
 Node left, right;
 public Node(int data){
  this.data = data;
  left = null;
  right = null;
 }
}


