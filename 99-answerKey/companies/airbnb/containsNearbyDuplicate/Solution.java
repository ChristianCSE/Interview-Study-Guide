import java.util.AbstractMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator; //needed in case iterate through map 
/**
 *  Topics: Array & HashTables
 */


public class Solution{


  /**
   * [containsNearbyDuplicate finds insance of duplicates]
   * @param  nums [arr of integers]
   * @param  k    [maximum distance b/w duplicates]
   * @return boolean     [is i-j => k]
   */
  public static boolean containsNearbyDuplicate(int[] nums, int k)
  {
    int len = nums.length, i; 
    Integer curr = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for(i = 0; i < len; i++)
    {
      curr = nums[i];
      if(map.containsKey(curr))
      {
        Integer diff = i - map.get(curr);
        if(diff <= k)
        {
          return true; 
        }
        //else make this the new entry since 
        //this will be closer than the previous
        else
        {
          map.put(curr, i);
        }
      }
      //haven't seen, should place in map 
      else
      {
        map.put(curr,i);
      }
    }
    return false; 
  }


/**
 * [betterSolution: not mine ]
 * @param  nums [arr of number]
 * @param  k    [max space b/w indices]
 * @return boolean     [is distance b/w: curr - prev <= k]
 */
  public static boolean betterSolution(int[] nums, int k) {
    //maintains order added
    int len = nums.length, i; 
    //Set should only be of size = k
    Set<Integer> set = new TreeSet<>();
    for ( i = 0; i < len; ++i) {
        Integer curr = nums[i];
        if (set.contains(curr)) 
        {
          return true;
        }
        set.add(nums[i]);
        if (set.size() > k) {
            set.remove(nums[i - k]);
            //
        }
    }
    return false;
}



  public static void main(String[] args)
  {

    System.out.println(containsNearbyDuplicate(new int[]{99, 99}, 2));
    System.out.println(betterSolution(new int[]{99, 99}, 2));
  }


}
