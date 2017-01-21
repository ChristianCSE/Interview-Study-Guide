

class Solution {

 public static int maxDepth(TreeNode root){
  TreeNode node = root; 
  return recursMax(node, 0);
 }

 public static int recursMax(TreeNode node, int depth){
  if(node == null){
   return depth;
  }
  depth = depth+1; 
  int left = recursMax(node.left, depth);
  int right = recursMax(node.right, depth);
  return left>right ? left : right;
 }



  public static void main(String[] args){


  }
}


class TreeNode {

  int val; 
  TreeNode left; 
  TreeNode right;
  public TreeNode(int val){
   this.val = val;
   left = null;
   right = null; 
  }
}