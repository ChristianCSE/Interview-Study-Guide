// 336. Palindrome Pairs

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;
import java.util.Map;
import java.util.LinkedHashMap;
public class Solution {
       public static List<List<Integer>> palindromePairs(String[] words)
   {
    Map<String, Integer> map = new HashMap<>();
    int len = words.length, i;
    List<Integer> pair;
    List<List<Integer>> listOfPairs = new ArrayList<>();
    Set<List<Integer>> noduplicates = new LinkedHashSet<>();
  looper:  for(i = 0; i < len; i++)
    {
      map.put(words[i],i);
    }

    for(i = 0; i < len; i++)
    {
      String currWord = words[i];

      if( checkDrome(currWord) )
      {
        if( map.containsKey("") )
        {
          if( i != map.get("") )
          {
            //frwrd
            pair = new ArrayList<>(2);
            pair.add(i);
            pair.add(map.get(""));
            // listOfPairs.add(pair);
            noduplicates.add(pair);

            //bkwrd
            pair = new ArrayList<>(2);
            pair.add(map.get(""));
            pair.add(i);
            // listOfPairs.add(pair);
            noduplicates.add(pair);

          }
        }
      }
      int wordlen = currWord.length(), j;
      for(j = 1; j <= wordlen; j++)
      {
        String leftPointer = currWord.substring(0,j);
        String leftReverse = new StringBuilder(leftPointer).reverse().toString();


        if( checkDrome( currWord+leftReverse) )
        {
          if(map.containsKey(leftReverse))
          {

            if(i != map.get(leftReverse))
            {
              pair = new ArrayList<>(2);
              pair.add(i);
              pair.add(map.get(leftReverse));
              // listOfPairs.add(pair);
              noduplicates.add(pair);
            }
          }
        }

        String rightCurr = currWord.substring(wordlen-j,wordlen);
        String reverseRight = new StringBuilder(rightCurr).reverse().toString();
        if(checkDrome(reverseRight+currWord) )
        {
          if(map.containsKey(reverseRight))
          {
            if(i != map.get(reverseRight))
            {
              pair = new ArrayList<>(2);
              pair.add(map.get(reverseRight));
              pair.add(i); //still use i, not j
              // listOfPairs.add(pair);
              noduplicates.add(pair);
            }
          }
        }
    }
    }
    listOfPairs.addAll(noduplicates);
    return listOfPairs;
  }

 public static boolean checkDrome(String concat)
  {
    if(concat.length() == 1 || concat.length() == 0) {return true;}
    int len = concat.length() - 1, i;
    for(i = 0; i <= len/2; i++)
    {
      if(concat.charAt(i) != concat.charAt(len - i))
      {
        return false;
      }
    }
    return true;
  }
}
