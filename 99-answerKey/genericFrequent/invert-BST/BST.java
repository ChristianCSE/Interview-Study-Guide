import java.util.*; 
public class BST{
  
   //TreeNode is not built in 
  TreeNode root; 
  
  public BST()
  {
    root = null; 
  }

  //declared a what a TreeNode is with constructor
  public class TreeNode
  {
    String sortKey; 
    String data; 
    TreeNode left, right; 

    public TreeNode(String sortKey, String data)
    {
      this.sortKey = sortKey;
      this.data = data; 
    }
  }



  //alphabetical order
  public void insert(String data, String sortKey) 
  {
    root = insert(root, data, sortKey);
  }

  public TreeNode insert(TreeNode root, String data, String sortKey)
  {
    if(root == null){return new TreeNode(data, sortKey);}//empty tree 
    
    //TreeNode does exist, but now where should our TreeNode go? 
    int abcOrder = sortKey.compareToIgnoreCase(root.sortKey);
    
    if(abcOrder > 0)
    {
      root.right = insert(root.right, data, sortKey);
    }
    else if(abcOrder < 0)
    {
      root.left = insert(root.left, data, sortKey);
    }
    // else dumb mistake; you would just return since it's equal
      return root; 
  }

  //key is just how our TreeNodes are filed in our tree
  public String findData(String sortKey) 
  {
    return findData(root, sortKey);
  }

  public String findData(TreeNode root, String sortKey)
  {
    if(root == null){return null;} //this sortKey DNE
    int abcOrder = sortKey.compareToIgnoreCase(root.sortKey);
    if(abcOrder > 0){ return findData(root.right, sortKey);} //TreeNode.right = findData(x.right, sortKey);} No you want data not a TreeNode
    else if(abcOrder < 0){ return findData(root.right, sortKey);}
    return root.data;
  }
}//BinaryST
