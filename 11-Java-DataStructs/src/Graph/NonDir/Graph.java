package Graph.NonDir;
import java.util.*;

class Graph {

  Map<String, Node> graph;
  public Graph(int size){
    graph= new HashMap<>(size);
  }

  public void insertEdge(String source, String target, double weight){
    Node node;
    if(graph.containsKey(source)){
      node = graph.get(source);
      node.insertEdge(target, weight);
    }
    else{
      node = new Node(source);
      node.insertEdge(target, weight);
      graph.put(source, node);
    }
  }


  public Deque<String> pathPrint(Map<String, String> children, String source, String end){
    //from end ==> to start
    Deque<String> path = new ArrayDeque<>();
    String fromTo = end;
    while(fromTo!= source){
      path.push(fromTo);
      String backw = children.get(fromTo); //gets the parent <Target->Source>
      fromTo = backw;
    }
    path.push(fromTo);
    while(!path.isEmpty()){
      String node = path.poll();
      if(node == end){
        System.out.print(node);
      }
      else{
        System.out.print(node + "->");
      }
    }
    return path;
  }

  public Deque<String> BFS(String source, String end) {
    Deque<String> queue = new ArrayDeque<>();
    List<String> visted = new ArrayList<>();
    Map<String,String> children = new HashMap<>();
    queue.push(source);
    while(!queue.isEmpty()){
      String parent = queue.poll();
      // visted.add(parent);
      if(end == parent){
        return pathPrint(children, source, end);
      }
      Node nodes = graph.get(parent);
      for(Edge kids: nodes.targets){
        String targets= kids.target;
        if(!visted.contains(targets)){
          children.put(targets, parent);
          queue.add(targets);
        }
      }
    }
    return null;
  }


  class Node{
    List<Edge> targets;
    String vertex;
    public Node(String vertex) {
      this.vertex = vertex;
      targets = new ArrayList<>();
    }
    public void insertEdge(String target, double weight){
      Edge edge = new Edge(vertex, target, weight);
      targets.add(edge);
    }
    public List<String> getTargets(){
      List<String> list = new ArrayList<>();
      for(Edge target: targets) {
        list.add(target.target);
      }
      return list;
    }
  }

  class Edge{
    double weight;
    String source;
    String target;
    public Edge(String source, String target, double weight) {
      this.source =source;
      this.target = target;
      this.weight = weight;
    }
  }
}