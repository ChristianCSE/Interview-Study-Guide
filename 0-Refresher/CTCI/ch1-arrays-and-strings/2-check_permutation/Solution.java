import java.util.*;

class Solution {

  //should just have the same count of characters
  public static boolean isPermutation(String desired, String candidate) {
    
    if(desired.length() != candidate.length()) return false;

    //O(n)
    Map<Character, Integer> desiredMap = new HashMap<>();
    mapOrdering(desiredMap, desired);

    //O(n)
    Map<Character, Integer> candidateMap = new HashMap<>();
    mapOrdering(candidateMap, candidate);

    //O(n)
    for( Map.Entry<Character, Integer> entry : candidateMap.entrySet() ) {
      if( !desiredMap.get(entry.getKey()).equals(entry.getValue()) ) {
        return false;
      }
    }


    return true;
  }

  public static void mapOrdering(Map<Character, Integer> map, String str) {
    for(Character c : str.toCharArray()) {
      if(map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }
  }

  public static String sortit(String str) {
    char[] c = str.toCharArray();
    Arrays.sort(c); //array is sorted, not the string
    return new String(c);
  }

  //easier implementaiton 
  public static boolean canPermuteTo(String a, String b) {
    if(a.length() != b.length()) return false;
    a = sortit(a);
    b = sortit(b);

    for(int i = 0; i < a.length(); i++) {
      if(a.charAt(i) != b.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPermutation("abc", "cba"));
    System.out.println(isPermutation("abc", "bbb"));
    System.out.println(isPermutation("abc", "j"));
    System.out.println(isPermutation("looper", "repolo"));
    System.out.println("\n\n");
    System.out.println(canPermuteTo("abc", "cba"));
    System.out.println(canPermuteTo("abc", "bbb"));
    System.out.println(canPermuteTo("abc", "j"));
    System.out.println(canPermuteTo("looper", "repolo"));

  }
}