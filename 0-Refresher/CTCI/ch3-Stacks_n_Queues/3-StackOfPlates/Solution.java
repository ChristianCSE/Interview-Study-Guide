
import java.util.*;

class Solution {




  public static void main(String[] args) {
    List<Deque<Integer>> stacks = new ArrayList<>();
    stacks.add(new ArrayDeque<>());
    stacks.get(0).push(10);
    // System.out.println(stacks.get(stacks.size()-1));
    stacks.add(new ArrayDeque<>());
    stacks.get(1).push(11);
    System.out.println("List => " + stacks);
    stacks.remove(0); //removes the list entirely!
    //shifts everything to the left for you
    System.out.println("List => " + stacks);
  }
}