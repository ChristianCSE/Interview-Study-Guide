# Works!  :rocket:

Only faster than 10.41% of java submissions, so better solutions do exist! 

``` 
 public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
    List<List<Integer>> list = new ArrayList<>(); 
    if(root == null){return list;}
    //root->left->right
```

```    
    boolean right = false; 
```
We traverse the binary tree in zig zag order [ level 1 : root, level 2: come from the leftmost node, level 3: come from the rightmost node, etc] 
Remember, level : the level of a node is defined as the number of connections between the node and the tree's root node + 1. Or Depth+1. 
The level of the tree we are on determines if we zig or zag. 

```     
    Deque<TreeNode> q = new ArrayDeque<>(); 
```
This tracks the upcoming level. We don't want to have an infinite loop in or second while() statement; hence q = the nodes in the next level and q2 = the current nodes. We could; however, have a counter and track the number of nodes per level and break out of the loop rather than having 2 Deques. This would remove space complexity. 

```    
    Deque<TreeNode> q2 = new ArrayDeque<>(); 
    TreeNode ptr = root; 
    int level = 0;
    q.push(ptr);
    list.add(new ArrayList<>()); 
    list.get(level).add(ptr.val);
```
Since root is an exception case we can do it immediately and setup the problem. 

Since we are traversing per a level we should do a BFS. 
```
    while(!q.isEmpty()) {
```


```        
        // System.out.print("[");
     while(!q.isEmpty()){
        // System.out.print(" "+ q.peekLast().val+",  ");
        q2.push(q.pollLast());
     }
```
We empty our q deque (our next level) and empty it into q2 (the level we are tracking). NOTE: pollLast().

```
     // System.out.print("]");
     level++;
     right = !right;
     // System.out.println("  flipped "+right);
     list.add(new ArrayList<>());
```
New level, hence new list to track the nodes and flip the direction of traversal. 

```
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
```
Prepare the next level, add nodes to their level list too. 

```
    if(list.get(level).isEmpty()){
        list.remove(level);
    } 
```
in the case of having an extra arraylist, remove it. 
```    
    return list; 
 }
 ``` 
