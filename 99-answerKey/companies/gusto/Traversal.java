class Traversal {



  public static void main(String[] args){
   Tree tree = new Tree(10);
   Node refLeft = tree.insert(tree.root, new Node(11), true);
   Node reRight = tree.insert(tree.root, new Node(12), false);
   refLeft = tree.insert(refLeft, new Node(13), true);
   reRight = tree.insert(reRight, new Node(100), false);
   tree.preorder(tree.root);
  }
}

class Tree {

 Node root; 
 
  public Tree(int data){
   this.root = new Node(data);
  }
  public Node insert(Node ref, Node here, boolean dir){
   return dir ? ref.insertLeft(here) : ref.insertRight(here); 
  }
  public void preorder(Node ref){
   if(ref != null){
    System.out.println(ref.data);
    preorder(ref.left);
    preorder(ref.right);
    }
   }
  public void inorder(Node ref){
   if(ref != null){
    inorder(ref.left);
    System.out.println(ref.data);
    inorder(ref.right);
   }
   }

  public void postorder(Node ref){
   if(ref != null){
    postorder(ref.left);
    postorder(ref.right);
    System.out.println(ref.data);
   }
  }

}

class Node {
 Node left, right; 
 int data; 
 public Node(int data){
  this.left= null;
  this.right = null;
  this.data = data; 
 }
 public Node insertLeft(Node left){
  this.left = left;
  return left;
 }
  public Node insertRight(Node right){
  this.right = right; 
  return right;
 }
}