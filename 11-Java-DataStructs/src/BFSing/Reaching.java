package BFSing;

/**
 * Created by Christian on 12/12/16.
 */
import java.util.*;
public class Reaching{

  public class Graph{
    Map<Integer, Node> graph;
    public Graph(){
      graph = new HashMap<>();
    }
    public void insertPair(Integer source, Integer target) {
      if(graph.containsKey(source)){
        graph.get(source).insertEdge(target);
      }
      else{
        graph.put(source, new Node(source)).insertEdge(target);
      }
    }
  }

  class Node{
    int source;
    List<Node> targets;
    public Node(int source){
      this.source = source;
    }
    public void insertEdge(Integer target){
      targets.add(new Node(target));
    }
  }



  public boolean landZero(int[] bridge, int starting) {
    int len = bridge.length;
    int ops = 0;
    System.out.println(len);
//    for(int i : bridge){
//      System.out.println("[" +ops++ + "] = " + i );
//    }
    Deque<Integer> traveling = new ArrayDeque<>();
    traveling.push(starting);
    int looped = 0;
    Set<Integer> gone = new HashSet<>();
    while(!traveling.isEmpty()){
      looped = 0;
      int index = (int)traveling.poll();
      int currPosition = bridge[index];
      gone.add(index);
      System.out.println("curr = "+ currPosition);
      int left = (index - currPosition) >= 0 ? (index - currPosition) : -1;
      int right = (index + currPosition) < len ? (index + currPosition)  : -1;
      if(left>0){
        if(bridge[left]==0){
          return true;
        }
      }
      if(right>0){
        if(bridge[right]==0){
          return true;
        }
      }
      if(!gone.contains(left) && left > 0){
        traveling.push(left);
      }
      if(gone.contains(left)){
        looped++;
      }
      if(!gone.contains(right) && right > 0){
        traveling.push(right);
      }
      if(gone.contains(right)){
        looped++;
      }
      if(looped == 2){
        break;
      }
    }

    return false;
  }

  public static void main(String[] args){
    Reaching games = new Reaching();
    System.out.println(games.landZero(new int[]{1, 2, 3, 1, 0}, 0));
  }
}
