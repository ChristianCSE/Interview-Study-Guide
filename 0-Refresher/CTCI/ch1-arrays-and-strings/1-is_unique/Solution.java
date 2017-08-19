import java.util.*;

class Solution {


  public static boolean isUnique(String candidate) {
    Set<Character> set = new HashSet<>();

    for(char c: candidate.toCharArray()) {
      if(set.contains(c)) {
        return false;
      } else {
        set.add(c);
      }
    }
    return true;
  }

  public static boolean isUniqueNoDS(String candidate) {
    
    return true; 
  }

  public static void main(String[] args) {
    String candidate = "helloperson";
    System.out.println( candidate + " all unique chars: " + isUnique(candidate));
    candidate = "abcd";
    System.out.println( candidate + " all unique chars: " + isUnique(candidate));
  }
}