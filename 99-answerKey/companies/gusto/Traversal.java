import java.util.*;
class Traversal {



  public static void main(String[] args){
   Tree tree = new Tree(10);
   Node refLeft = tree.insert(tree.root, new Node(11), true);
   Node reRight = tree.insert(tree.root, new Node(12), false);
   refLeft = tree.insert(refLeft, new Node(13), true);
   reRight = tree.insert(reRight, new Node(100), false);
   tree.rePostorder(tree.root);

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
  public void rePreorder(Node ref){
   if(ref != null){
    System.out.println(ref.data);
    rePreorder(ref.left);
    rePreorder(ref.right);
    }
   }
  public void reInorder(Node ref){
   if(ref != null){
    reInorder(ref.left);
    System.out.println(ref.data);
    reInorder(ref.right);
   }
   }

  public void rePostorder(Node ref){
   if(ref != null){
    rePostorder(ref.left);
    rePostorder(ref.right);
    System.out.println(ref.data);
   }
  }

  public void nonRePostOrder(Node ref){
   Deque<Node> postOrder = new ArrayDeque<>(); 
   Node ptr = ref;
   while(ptr != null){
    postOrder.push(ptr);
    ptr = ref.left;
   }//leftMost is now in here 
   
   while(!postOrder.isEmpty()){
    
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