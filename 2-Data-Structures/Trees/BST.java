class BST{
  
   //node is not built in 
  Node root; 
  
  public BST()
  {
    root = null; 
  }

  //declared a what a node is with constructor
  public class Node
  {
    String sortKey; 
    String data; 
    Node left, right; 

    public Node(String sortKey, String data)
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

  public Node insert(Node node, String data, String sortKey)
  {
    if(node == null){return new Node(data, sortKey);}//empty tree 
    
    //node does exist, but now where should our node go? 
    int abcOrder = sortKey.compareToIgnoreCase(node.sortKey);
    
    if(abcOrder > 0)
    {
      node.right = insert(node.right, data, sortKey);
    }
    else if(abcOrder < 0)
    {
      node.left = insert(node.left, data, sortKey);
    }
    // else dumb mistake; you would just return since it's equal
      return node; 
  }

  //key is just how our nodes are filed in our tree
  public String findData(String sortKey) 
  {
    return findData(root, sortKey);
  }

  public String findData(Node node, String sortKey)
  {
    if(node == null){return null;} //this sortKey DNE
    int abcOrder = sortKey.compareToIgnoreCase(node.sortKey);
    if(abcOrder > 0){ return findData(node.right, sortKey);} //node.right = findData(x.right, sortKey);} No you want data not a node
    else if(abcOrder < 0){ return findData(node.right, sortKey);}
    return node.data;
  }
}//BinaryST






