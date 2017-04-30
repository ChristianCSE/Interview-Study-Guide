import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class sumints{

  /**
   * [sum] gets you the indices of the two integers
   * that sum up to target
   * @param  nums   [an array of integers]
   * @param  target [the integer you want to sum up for]
   * @return        [the indices of the numbers that sum up to target]
   */
  public static int[] sum(int[] nums, int target)
  {
    
    if(nums == null || nums.length == 0) {return null;}

    int i, len = nums.length; 
    Map<Integer, Integer> map = new HashMap<>(len); //Cost: O(N) 
    
    for(i = 0; i < len; i++)
    {  
      map.put(nums[i], i);
    }//Runtime: O(N)

    for(i = 0; i < len; i++)
    {
      int remainder = target - nums[i];
      if( map.containsKey(remainder) && map.get(remainder) != i)
      {
       return new int[]{i, map.get(remainder)};
      }
    }//Runtime: O(N)

    return null; 
  }

  public static void main(String[] args)
  {
    int[] nums = new int[]{1, 2, 13, 4, 9, 30, 39, 1000, 80, 900};
    int want = 8100;
    System.out.println( Arrays.toString(sum(nums, want) ) );
  }
}
