import java.util.*;
/*Given: Direct Graph. Design an algorithm to find out if a route exists!**/



class Graph {

  Map<String, Node> edges;
  public Graph(){
   edges = new HashMap<>();
  }
  public void insertEdge(String source, String target){
   if(edges.containsKey(source)){
    edges.get(source).insertTarget(new Node(target));
   } else {
    Node node = new Node(source);
    edges.put(source, node);
     edges.get(source).insertTarget(new Node(target));
   }
  }
 class Node{
  String node; 
  List<Node> targets;
  public Node(String node){
   targets = new ArrayList<>();
   this.node = node;  
  }
  public void insertTarget(Node x){
   targets.add(x);
  }
 }


 public boolean pathExists(String source, String target) {
  Set<String> visted = new HashSet<>(); 
  Deque<String> path = new ArrayDeque<>();
  Map<String, String> parentChild = new HashMap<>();
  path.push(source);
  while(!path.isEmpty()){
   String node = path.poll();
   if(node == target){
    return true;
   }
   if(!visted.contains(node) && edges.containsKey(node)){
    visted.add(node);
    Node objNode = edges.get(node); 
    if(objNode.targets.size() > 0){
     for(Node targets:objNode.targets){
      path.push(targets.node);
      parentChild.put(node, targets.node);
     }
    }
   }
 }
  return false; 
 }

}










