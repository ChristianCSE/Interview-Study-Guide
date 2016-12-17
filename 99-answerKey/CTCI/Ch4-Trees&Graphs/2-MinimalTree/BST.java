import java.util.*;
class BST {

  Node root; 
  public BST(int data){
   root = new Node(data); 
  }


  class Node{
   Node right;
   Node left;
   int data;
   public Node(int data){
    this.data = data;
    right = null;
    left = null;
   }
  }

  // public void printInOrder(){

  // }
  
  public void minHeightBST(int[] arr){
    // System.out.println(arr.toString());
    for(int i : arr){
      System.out.println(i + " ");
    }
    getMinHeightBST(arr, 0, arr.length-1);
  }
  public void insertNode(int node){
   insertNode(new Node(node), root);
  }

  public void insertNode(Node node, Node root){
   if(root == null){return;}
   int diff = root.data - node.data;
   if(diff > 0){
    if(root.right == null){
     root.right = node;
    }
    else
    {
     insertNode(node, root.right);
    }
   }
   else{
    if(root.left == null) {
     root.left = node;
    }
    else{
     insertNode(node, root.left);
    }
   }
  }

/**
 * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
 * getMid => 5 
 * pretty much binarySearch in keep splitting 
 * loMid => (lo+mid-1)/2
 * hiMid => (mid+1+hi)/2
 * Make sure to compute this after assigning new lo and hi
 * since int math will make -0.5 = 0
 * double maths = (double)-1/2;
 * System.out.println(maths/0.5 + " => lo > hi");
 */
  public Node getMinHeightBST(int[] arr, int lo, int hi){
    if(lo > hi){ 
      return null; //impllies Node has no children
    }
    int mid = (hi+lo)/2;
    Node midNode = new Node(arr[mid]);
    midNode.left = getMinHeightBST(arr, lo, mid-1);
    midNode.right = getMinHeightBST(arr, mid+1, hi);
    return midNode;
  }
  
}