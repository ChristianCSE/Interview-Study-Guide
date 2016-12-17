/*
Given a string, determine if a permutation of the
 string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.
 **/
import java.util.*;
public class Solution {
    public boolean canPermutePalindrome(String s) {
      String[] characters = s.split("");




      if(s.length() == 0){return true;}
      String[] container = s.replaceAll(" ", "").split("");
     Map<String, Integer> map = new HashMap<>();
     for(String c : container)
     {
      if(map.containsKey(c))
      {
       map.put(c, map.get(c)+1);
      }
      else
      {
       map.put(c, 1);
      }
     }

     Iterator iter = map.entrySet().iterator();
     boolean tripwire = false;
     while(iter.hasNext())
     {
      Map.Entry paired = (Map.Entry) iter.next();
      int val = (int)paired.getValue();
      if(val%2 != 0)
      {
          if(tripwire)
          {
              return false;
          }
          else
          {
              tripwire=true;
          }
      }
     }
     return true;

    }

    public static void main(String[] args) {

    }

}