import java.util.*;
class Solution {


  public static List<List<Integer>> verticalOrder(TreeNode root) {

    //care about root position => leftmost node (overall) & rightmost node (overall)
    int[] range = new int[]{0,0};
    columnRange(root, range, 0);
    List<List<Integer>> verticalTree = new ArrayList<>();

    for(int i = range[0]; i <= range[1]; i++) {
      verticalTree.add(new ArrayList<Integer>());
    }
    //System.out.println("=>" + verticalTree.size());

    //do bfs 
    //need to reference parent node's column #
    Deque<TreeNode> tree = new ArrayDeque<>();
    Deque<Integer> curr_column = new ArrayDeque<>();
    tree.addFirst(root);
    curr_column.addFirst(range[0]*-1);
    verticalTree.get(range[0]*-1).add(root.val);

    //do BFS and start categorizing in proper columns
    while(!tree.isEmpty()) {
      int parentColumn = curr_column.pollFirst();
      TreeNode currTreeNode = tree.pollFirst();

      if(currTreeNode.left != null) {
        TreeNode leftNode = currTreeNode.left;
        int leftCol = parentColumn-1;
        verticalTree.get(leftCol).add(leftNode.val);
        tree.addLast(leftNode);
        curr_column.addLast(leftCol);
      }

      if(currTreeNode.right != null) {
        TreeNode rightNode = currTreeNode.right;
        int rightCol = parentColumn + 1;
        verticalTree.get(rightCol).add(rightNode.val);
        tree.addLast(rightNode);
        curr_column.addLast(rightCol);
      }

    }
    System.out.println(verticalTree);
    return verticalTree;
  }

  public static void columnRange(TreeNode root, int[] range, int i) {
    if(root == null) return;
    range[0] = Math.min(range[0], i); //leftmost node => minColumn
    range[1] = Math.max(range[1], i); //rightmost node => maxColumn 
    columnRange(root.left, range, i-1);
    columnRange(root.right, range, i+1);
  }


  public static TreeNode makeTree(int range) {
    TreeNode root = new TreeNode(1);
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.addFirst(root);
    int i = 2;
    while(i <= range){
      TreeNode ptr = queue.pollFirst();
      ptr.left = new TreeNode(i);
      queue.addLast(ptr.left);
      i+=1;
      ptr.right = new TreeNode(i);
      queue.addLast(ptr.right);
      i+=1;
    }
    return root;
  }

  public static TreeNode makeSpecificTree(int[] numbs) {
    return null;
  }

  public static void treeTraversal(TreeNode root) {
    Deque<TreeNode> q = new ArrayDeque<>();
    q.addFirst(root);
    while(q.peek() != null) {
      TreeNode currNode = q.pollFirst();
      System.out.println(currNode.val);
      if(currNode.left!=null) q.addLast(currNode.left);
      if(currNode.right!=null) q.addLast(currNode.right);
    }

  }

  public static void main(String[] args) {
    TreeNode root = makeTree(15);
    //treeTraversal(root);
    verticalOrder(root);
  }
}

class TreeNode {
  int val; 
  TreeNode left; 
  TreeNode right; 
  public TreeNode(int val) {
    this.val = val; 
  }
}