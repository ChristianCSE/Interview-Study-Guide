import java.util.*;

class Solution {


  public static boolean isPalindromeHash(String candidate) {
    candidate = candidate.toLowerCase();
    Map<Character, Integer> map = new HashMap<>();
    for(Character c : candidate.toCharArray()) {
      if(c != ' '){
        if(map.containsKey(c)){
          map.put(c, map.get(c) + 1);
        } else {
          map.put(c, 1);
        }
      }
    }
    boolean allowableOdd = true;
    for(Map.Entry<Character, Integer> entry: map.entrySet()) {
      if(entry.getValue()%2 != 0) {
        if(allowableOdd) {
          allowableOdd = false;
        }
        else {
          //System.out.println(entry.getValue() + " " + entry.getKey());
          //can only have one odd instance
          return false;
        }
      }

    }
    return true;
  }


  public static int[] generateFreqTable(String str) {
    str = str.toLowerCase();
    str = str.replaceAll(" ", "");
    System.out.println(str);
    int size = 'z'-'a' + 1; //0->a & 25->z

    int[] table = new int[size];
    for(Character c: str.toCharArray()) {

      // check if valid char
      if('z' >= c && c >= 'a'){
        //update bucket 
        int tableIndex = c - 'a';
        //add count 
        table[tableIndex] += 1;
      } else {
        return new int[]{-1};
      }
    }
    return table;
  }

  public static boolean isPalindromeArray(String candidate) {

    int[] freqTable = generateFreqTable(candidate);
    if(freqTable[0] == -1) return false;
    boolean allowableOdd = true;

    for(int i : freqTable){
      if(i%2 != 0) {
        if(allowableOdd){
          allowableOdd = false;
        } else {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
   // System.out.println(isPalindromeHash("Rats live on no evil star"));
    // System.out.println(isPalindromeHash("Rats live on noo evil starr"));
    System.out.println(isPalindromeArray("heh01"));
    System.out.println(isPalindromeArray("Rats live on no evil star"));
    System.out.println(isPalindromeArray("aabaa"));
  }
}