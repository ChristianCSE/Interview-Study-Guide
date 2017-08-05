import java.util.*;

class Solution {



  public static int highestProduct(int[] numbs, int k) {
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> negativeMinHeap = new PriorityQueue<Integer>();
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < k; i++) {
      if(numbs[i] > max) {
        max = numbs[i];
      }

      minHeap.add(numbs[i]);
    }

    for(int i = k; i < numbs.length; i++) {
      int numb = numbs[i];
      //is current number greater than min? If so pop it and add this 
      if(numb > minHeap.peek()) {
        minHeap.poll();
        minHeap.add(numb);
      }

    }
    int prod = 1;
    for(Integer numbr : minHeap) {
      //System.out.println(numbr);
      prod*= numbr;
    }

    return prod;
  }

  public static void main(String[] args) {
    int ans = highestProduct(new int[]{1, 2, 30, 3, 20, 4, 5, 10}, 3);
    System.out.println(ans);
  }
}