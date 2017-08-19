import java.util.*;


class Solution {


  public static void deletingDuplicates(List<Integer> A) {
    int validEntry = 1;
    int len = A.size() - 1;
    for(int i = 1; i <= len; ++i) {
      //if not duplicates from prev => add it to our new list!
      if(!A.get(validEntry -1 ).equals(A.get(i))) {
        A.set(validEntry++, A.get(i));
      }
    }

    System.out.println(A);

  }

  ///bad since extra storage
  public static void bruteForceSolution(List<Integer> A) {
    //keep track of duplicate 
    // int duplicate;
    List<Integer> container = new ArrayList<>(); 
    for(int i = 1; i < A.size(); i++) {
      if( !A.get(i).equals(A.get(i-1)) ) {
        container.add(A.get(i));
      }
    }
    System.out.println(container);
  }

  public static void main(String[] args) {
    deletingDuplicates(Arrays.asList(2, 3, 5, 7, 7, 7, 11, 11, 11, 13, 15));
    bruteForceSolution(Arrays.asList(2, 3, 5, 7, 7, 7, 11, 11, 11, 13, 15));
    int[] ne = new int[]{1, 2};
    
  }
}