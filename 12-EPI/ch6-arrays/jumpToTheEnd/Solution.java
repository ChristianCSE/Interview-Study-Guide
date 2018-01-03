/*
You can jump arr[i] steps, see if you can reach the end of the board
 */
import java.util.*;

class Solution {


  public static boolean canReachEnd(List<Integer> list) {
    //we just care about reaching the end! 
    int end = list.size() - 1; //last index
    int reachableRange = 0;

    //keep going as long as this index is reachable & we haven't landed 
    //to the end
    for(int i = 0; i <= reachableRange && reachableRange < end; i++) {
      //index + jumpingMax
      reachableRange = Math.max(i+list.get(i), reachableRange);
    }
    return (reachableRange >= end) ? true : false;
  }


  public static void main(String[] args) {
    System.out.println(canReachEnd(Arrays.asList(0, 1, 2, 3)));

    System.out.println(canReachEnd(Arrays.asList(1, 0, 2, 3)));

    System.out.println(canReachEnd(Arrays.asList(1, 1, 2, 3)));

    System.out.println(canReachEnd(Arrays.asList(3, 3, 1, 0, 2, 0, 1)));
  }

}