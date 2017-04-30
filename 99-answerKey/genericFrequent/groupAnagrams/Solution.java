import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList; 

public class Solution {
    
  public List<List<String>> groupAnagrams(String[] strs)
  {
    Arrays.sort(strs);
    
    List<List<String>> gramMaster = new ArrayList<>(); 
    int length = strs.length;
    

    if(length < 2)
    {
      gramMaster.add(Arrays.asList(strs));
      return gramMaster;
    } 
    //keyvalue
    Map<String, ArrayList<String>> abcMap = new HashMap<String, ArrayList<String>>();
  
   
    for(int i = 0; i < length; i++)
    {
      char[] abc = strs[i].toCharArray(); 
      Arrays.sort(abc);
      String candidate = new String(abc);
      if(abcMap.containsKey(candidate))
      {
        //get corresp. AL.add()
        abcMap.get(candidate).add(strs[i]);
       
      }//else make new AL and add sorted string as value
      ArrayList<String> unseen = new ArrayList<>(); 
      unseen.add(strs[i]);
      abcMap.put(candidate, unseen);
    }
    
    gramMaster.addAll(abcMap.values());
    return gramMaster;
  }

/*
  public String[] abcSortString(String[] strs)
  {
    for(int i = 0; i < strs.length; i++)
    {
      char[] abc = strs[i].toCharArray(); 
      Arrays.sort(abc);
      strs[i] = new String(abc);
    }
    return strs; 
  }
*/

  public static void main(String[] args)
  {
    compromise caller = new compromise(); 
    String[] test = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(caller.groupAnagrams(test)); 
  }
}
