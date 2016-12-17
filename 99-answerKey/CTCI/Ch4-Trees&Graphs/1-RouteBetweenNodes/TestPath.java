import java.util.*; 
class TestPath {


  

  public static void main(String[] args) {
   Graph graph = new Graph(); 
   graph.insertEdge("A", "B");
   graph.insertEdge("A", "C");
   graph.insertEdge("A", "B");
   graph.insertEdge("A", "E");
   graph.insertEdge("A", "M");
   graph.insertEdge("A", "B");
   graph.insertEdge("C", "D");
   graph.insertEdge("A", "V");
   graph.insertEdge("V", "B");
   graph.insertEdge("D", "Z");   
   graph.insertEdge("D", "E");   
   graph.insertEdge("D", "J");
   graph.insertEdge("C", "E");   
   System.out.println(graph.pathExists("A", "Z")); //yes!
   System.out.println(graph.pathExists("C", "J")); //yes
   System.out.println(graph.pathExists("Z", "J")); //no
   System.out.println(graph.pathExists("A", "K")); //no
   
   List<String> hellos = new ArrayList<>();
   String yop = "hjl";
   int index = hellos.indexOf(yop);
   if(index >= 0){
    hellos.get(index);
   }
   hellos.size();

  }
}