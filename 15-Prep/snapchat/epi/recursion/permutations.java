import java.util.*;

class permutations {

  static public List<List<Integer>> getAllPermutations(List<Integer> source) {
    List<List<Integer>> permutations = new ArrayList<>(); 
    int startPermutingIndex = 0;
    makePermutations(source, permutations, startPermutingIndex);
    return permutations;
  }

  static public void makePermutations(List<Integer> source, List<List<Integer>> perms, int startPermIndex) {

    if(startPermIndex == source.size() - 1) {
      perms.add(new ArrayList<>(source));
    }

    //we permutate subArrays and then backtrack 
    for(int i = startPermIndex; i < source.size(); i++) {
      //swap 
      Collections.swap(source, i, startPermIndex);
      //find permutation of sub 
      makePermutations(source, perms, startPermIndex+1);
      //swap back, since we only care for the original positioned # being swapped
      Collections.swap(source, i, startPermIndex);
    }
    
  }

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3, 4});
    List<List<Integer>> permutationsList = getAllPermutations(list);
    for(List<Integer> permute : permutationsList) {
      System.out.println(permute);
    }
  }
}