import java.util.*;
class Solution {


 static public int getHeight(Node root){
  if(root==null){return -1;}
  int leftPath = getHeight(root.left)+1;
  int rightPath = getHeight(root.right)+1;
  return leftPath>rightPath?leftPath:rightPath;
 }

 static public boolean isBalanced(Node node){
  return checkBalance(node.left, node.right);
 }
 static public boolean checkBalance(Node nLeft, Node nRight){
  
  int leftSubtree = getHeight(nLeft); //if null => -1
  int rightSubtree = getHeight(nRight); //if null => -1 
  int diff = leftSubtree-rightSubtree; 
  // -1,0,1
  if(diff == 0 || diff == 1 || diff == -1){
   boolean leftsubtrees = checkBalance(nLeft.left, nLeft.right);
   boolean rightsubtrees = checkBalance(nRight.left, nRight.right);
  }
  else{
   return false;
  }
  return true;
 }

 public static void main(String[] args){
  // for(int data: new int[]{1, 2, 3, 4, 5, 6, 7, 8}){

  // }
  int[] mm = new int[]{1, 2, 3, 4, 5};
  List<Integer> dummy = new ArrayList<>();
  for(int h: mm){
   dummy.add(h);
  }
  int uhh = dummy.indexOf(3)!=-1 ? dummy.get(dummy.indexOf(3)): -1;

  Tree tree = new Tree(10);
  tree.insertSubTrees(new int[]{1, 2, 3, 4, 5, 6, 7});
  tree.print();
 }
}


class Tree {
 Node root;
 public Tree(int data){
  root = new Node(data);
 }

 public void insertSubTrees(int[] nums){
  Deque<Integer> queue = new ArrayDeque<>();
  for(int data : nums){
   queue.push(data);
  }
  Node ptr = root;
  makeMyTree(ptr, queue, queue.size());
 }
 public void print(){
  Node ptr = root; 
  printInorder(ptr, 0);
 }
 public void printInorder(Node node, int index){
  if(node!=null){
   System.out.println("["+index+++"]      "+node.data);
   printInorder(node.left, index);
   printInorder(node.right, index);

   }
 }

 public void makeMyTree(Node ptr, Deque q, int size){
  if(size==0){return;}
  ptr.left = size>0 ? new Node((int)q.poll()) : null;
  ptr.right = size>0 ? new Node((int)q.poll()) : null;
  makeMyTree(ptr.right, q, (int)Math.ceil(q.size()/2));
  makeMyTree(ptr.right, q, (int)Math.ceil(q.size()/2));
 }

 public void insertRight(int num){
  Node pointer = root;
  while(pointer.right!=null){
   pointer = pointer.right;
  }
  pointer.right = new Node(num);
 } 

public void insertLeft(int num){
 Node pointer = root;
 while(pointer.left!=null){
  pointer = pointer.left; 
 }
 pointer.left = new Node(num);
 }
 
 
}

class Node{
 int data; 
 Node right, left; 
 public Node(int data){
  this.data = data;
  right = null;
  left = null;
 }
}