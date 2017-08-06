import java.util.*;

class Solution {

  //BAD NOT ORDERED!!!!!
  public static String hashCompression(String str){
    //NOT ORDERED!!!!!
    Map<Character, Integer> map = new HashMap<>();

    for(Character c : str.toCharArray()){
      if(map.containsKey(c)){
        map.put(c, map.get(c)+1);
      } else{
        map.put(c, 1);
      }
    }
    StringBuilder cmprsd = new StringBuilder();
    for(Map.Entry<Character, Integer> entry : map.entrySet()) {
      //cmprsd.append();
    }

    return "";
  }

  public static String compression(String str) {
    char prev = str.charAt(0);
    int count = 1;
    StringBuilder cmprsd = new StringBuilder();
    int len = str.length();
    for(int i = 1; i < len; i++) {
      if(prev == str.charAt(i)) {
        count++;
        if(i + 1 == len) {
          cmprsd.append(prev);
          cmprsd.append(count);
        }
      } else {
        cmprsd.append(prev);
        cmprsd.append(count);
        prev = str.charAt(i);
        count = 1;
      }
    }
    String candidate = cmprsd.toString();
    return (len > candidate.length()) ? candidate : str;
  }

  public static void main(String[] args) {
    System.out.println(compression("aabbcc"));
    System.out.println(compression("abc"));
    System.out.println(compression("aaaaaaaaaaaabc"));
  }
}