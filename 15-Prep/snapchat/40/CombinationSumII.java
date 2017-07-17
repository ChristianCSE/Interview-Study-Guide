import java.util.*;

class CombinationSumII {

  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    
    List<List<Integer>> sums = new ArrayList<>();

    if(candidates.length == 0){
      return sums; //return an empty list 
    }

    //we sort so we can do DFS 
    //[1, 2, 3, 4, 5, 6]
    //when we are at [1,5] we know to only look ahead since anything 
    //involving the previous #'s has been done 
    Arrays.sort(candidates);
    // (list, index, target, candidateSet)
    List<Integer> possibleSum = new ArrayList<Integer>();
    dfsGetCandidates(candidates, sums, possibleSum, 0, target);
    return sums;
  }

  public static void dfsGetCandidates(int[] candidates, List<List<Integer>> sums, 
    List<Integer> possibleSum, int start, int target) {
    //we are building up possibleSum 
    //target is what we need in order to store
    if(target == 0) {
      //sums.add(possibleSum); WRONG !!!!!! BLOCKS PASS BY REF
      sums.add(new ArrayList<Integer>(possibleSum));
      System.out.println("=>" + sums);
      return; //adding more would make it go above 
    }

    if(target < 0) {
      //we've gone past the threshold, skip this set entirely
      return;
    }
    int preventDupe = -1;
    for(int i = start; i < candidates.length; i++) {
      int currElement = candidates[i];
      if(preventDupe != currElement){
        possibleSum.add(currElement);
        dfsGetCandidates(candidates, sums, possibleSum, i+1, target-currElement);
        //now BACKTRACK! 
        possibleSum.remove(possibleSum.size()-1);
        preventDupe = currElement;
      }
    }

  }

  public static void main(String[] args) {
    //1, 2, 3, 4, 5, 6, 7
    //1, 3, 7, 6, 2, 4, 5
    int[] arr = new int[]{1, 3, 7, 6, 2, 4, 5};
    List<List<Integer>> pairs = combinationSum2(arr, 7);
    System.out.println(pairs);

  }
}