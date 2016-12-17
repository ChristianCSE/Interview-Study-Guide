class maxDepth {
 
 public class Tree {
  Node root; 
  public Tree(int data){
   root = new Node(data);
  }
  public void insertLeft(int data){
    insertLeft(new Node(data));
  }
  public void insertLeft(Node leftNode){
   Node node = this.root;
   while(node!=null){
    if(node.left==null){
     node.left=leftNode;
     break;
    }
    else{
     node=node.left;
    }
   }
  }
  public void insertRight(int data){
    insertRight(new Node(data));
  }
  public void insertRight(Node rightNode){
   Node node = this.root;
   while(node!=null){
    if(node.right == null){
     node.right = rightNode;
     break;
    } else{
     node=node.right; 
    }
   }

  }
 }

 class Node{
  int data;
  Node left;
  Node right;
  public Node(int data){
   this.data = data;
   left=null;
   right=null;
  }
 }

 public Tree getTree(int data){
  return new Tree(data);
 }
 public static int findMaxDepth(Node node, int depth){
  //dig ->until hit null, keep track of depth
  //left or right 
  if(node==null){
   return -1;
  }
  depth++;

  int goLeft = findMaxDepth(node.left, depth)+1; //3
  if(node != null) System.out.println("left depth=> "+ goLeft+"   node "+node.data);
  int goRight = findMaxDepth(node.right, depth)+1;//4
  System.out.println("left=> "+ goLeft+"   right=>"+ goRight);
  return goRight >goLeft ?  goRight: goLeft;
 }


 public static void main(String[] args) {
  System.out.println("calling");
  maxDepth caller = new maxDepth();
  Tree t = caller.getTree(8);
  t.insertLeft(0);
  t.insertLeft(1);
  t.insertLeft(2);
  t.insertLeft(3);
  t.insertLeft(4);
  t.insertRight(9);
  t.insertRight(10);
  t.insertRight(11);
  t.insertRight(12);
  t.insertRight(13);  
  t.insertRight(14);
  t.insertRight(15);    
  t.insertRight(16);
  t.insertRight(17);
  Node keeper = t.root;
  while(keeper != null){
    System.out.println(keeper.data);
    keeper=keeper.left;
  }
  System.out.println("-");
  keeper = t.root;
  while(keeper != null){
    System.out.println(keeper.data);
    keeper = keeper.right;
  }  
  findMaxDepth(t.root, 0);
 }
}