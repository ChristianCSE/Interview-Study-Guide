// 49. Group Anagrams

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
      else{
      ArrayList<String> unseen = new ArrayList<>();
      unseen.add(strs[i]);
      abcMap.put(candidate, unseen);
      }
    }
    gramMaster.addAll(abcMap.values());
    return gramMaster;
  }
}
