/*
<9, 9, 9, 9> + 1 => <1, 0, 0, 0, 0>
<1, 9, 9, 9> + 1 => <2, 0, 0, 0>
In this case only add one to our list
take care of carryovers
 */

import java.util.*;
class Solution {

  public static void addOne(List<Integer> list) {
    //start from the end work to the beg!
    int len = list.size(); 
    list.set(len-1, list.get(len-1) + 1);
    //we only want to keep iterating if there is a carry over
    for(int i = len-1; i > 0 && list.get(i) == 10; i--) {
      list.set(i, 0); //make this 0 
      list.set(i-1, list.get(i-1) + 1); //ready up the next index
    }

    //does our head (first index) have a carry over? 
    if(list.get(0)==10) {
      list.set(0,0);
      list.add(0,1); //pushes all elements to the right
    }

    System.out.println("Done: " + list);
    
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    for(Integer i: new Integer[]{9, 9, 9, 9}) {
      list.add(i);
    }
    addOne(list);

    list = new ArrayList<>();
    for(Integer i: new Integer[]{1, 9, 9, 9}) {
      list.add(i);
    }
    addOne(list);
    System.out.println(true ^ false);
  }
}