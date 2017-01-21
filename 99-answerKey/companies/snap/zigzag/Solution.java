//zig zag 
import java.util.*;

class Solution {
//Given a binary tree, return the zigzag level order traversal of its nodes' values. 
//(ie, from left to right, then right to left for the next level and alternate between).
/* 
	 3
	 / \
	9  20
			/  \
		15   7 */
 /*
 [
	[3],
	[20,9],
	[15,7]
]
	*/    
 public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
	List<List<Integer>> list = new ArrayList<>(); 
	if(root == null){return list;}
	//root->left->right
	boolean right = false; 
	Deque<TreeNode> q = new ArrayDeque<>(); 
	Deque<TreeNode> q2 = new ArrayDeque<>(); 
	TreeNode ptr = root; 
	int level = 0;
	q.push(ptr);
	list.add(new ArrayList<>()); 
	list.get(level).add(ptr.val);

	while(!q.isEmpty()) {
		// System.out.print("[");
	 while(!q.isEmpty()){
	 	// System.out.print(" "+ q.peekLast().val+",  ");
	 	q2.push(q.pollLast());
	 }
	 // System.out.print("]");
	 level++;
	 right = !right;
	 // System.out.println("  flipped "+right);
	 list.add(new ArrayList<>());
		while(!q2.isEmpty()){
			TreeNode temp = q2.poll();
			if(right){
				if(temp.right != null){
					q.push(temp.right);
					list.get(level).add(temp.right.val);
				}
				if(temp.left != null) {
					q.push(temp.left);
					list.get(level).add(temp.left.val);
				}
			}
			else{
				if(temp.left != null){
					q.push(temp.left);
					list.get(level).add(temp.left.val);
				}
				if(temp.right != null) {
					q.push(temp.right);
					list.get(level).add(temp.right.val);
				}
			}
	 	}//while()
	 }//while()

	if(list.get(level).isEmpty()){
		list.remove(level);
	} 
	return list; 
 }




 public static void main(String[] args){
 	Tree tree = new Tree(10);
 	for(int i : new int[]{5, 20, 1, 6, 15, 25, 16, 17, 18, 22, 26, 27, 30}){
 		tree.insertBalenced(i);
 	}
 	tree.printTree();
 	zigzagLevelOrder(tree.root);

 }
}
class Tree {
 TreeNode root;
 int val; 
 public Tree(int val){
	root = new TreeNode(val);
	this.val = val;
 }
 public void insertBalenced(int data){
	TreeNode ptr = root;
	TreeNode node = new TreeNode(data);
	insertBalenced(ptr, node);
 }
 public void printTree(){
 	TreeNode ptr = root;
 	printTree(ptr, 0);
 }
 public void printTree(TreeNode node, int index){
 	if(node != null){
 		System.out.println("["+index+"] :"+ node.val);
 		printTree(node.right, index++);
 		printTree(node.left, index++);
 	}
 }

 public void insertBalenced(TreeNode ptr, TreeNode node){
	int diff = ptr.val - node.val;
	if(diff > 0){
	 if(ptr.left == null){
		ptr.left = node;
	 } else{
	 	insertBalenced(ptr.left, node);
	 }
	}
	if(diff < 0){
	 if(ptr.right == null){
		ptr.right = node;
	 } else {
	 	insertBalenced(ptr.right, node);
	 }
	}
 }
}

class TreeNode{
 int val; 
 TreeNode left;
 TreeNode right; 
 public TreeNode(int val){
	this.val = val;
	left = null;
	right = null;
 }
}