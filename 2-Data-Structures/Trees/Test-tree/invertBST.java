import java.util.*;
/*=================================
This inverts a BST
    4
   /   \
  2     7       
 / \   / \
1   3 6   9

    4
   /   \
  7     2 
  |     |
  -------   (still have the same children)
  |      |
 / \   / \
1   3 6   9

When you hit temp/right/left nodes 7 and 2 will still 
be pointing to their left and right children unitl you 
update them

     4
   /   \
  7     2
 / \   / \
9   6 3   1

=================================*/
public class invertBST{

  public TreeNode invertTree(TreeNode root)
  {
    //base case
    if(root == null) {return null;}

    //run 
    TreeNode temp = root.left; 
    root.left = root.right; 
    root.right = temp;

    //recursion 
    
    if(root.left != null)
    { 
      // System.out.println("Parent:  " + root.data  + "   new LEFT child:   " + root.left.data );
      invertTree(root.left); 
    }
    if(root.right != null)
    { 
      // System.out.println("Parent:  " + root.data  + "   new RIGHT child:   " + root.right.data );
      invertTree(root.right);
    }  
    return root; 
  }

  //do BFS: queue
  public TreeNode iterInvert(TreeNode root)
  {
    Queue<TreeNode> queue = new ArrayDeque<>();
    if(root != null){queue.add(root);}
    while(root != null)
    {
      TreeNode currNode = queue.poll(); 
      if(currNode.left != null)
      { 
        queue.add(currNode.left);
      }
      if(currNode.right != null)
      { 
        queue.add(currNode.right);
      }  

      TreeNode temp = currNode.left;
      currNode.left = currNode.right;
      currNode.right = temp;
    }
    return null;
  }
}

