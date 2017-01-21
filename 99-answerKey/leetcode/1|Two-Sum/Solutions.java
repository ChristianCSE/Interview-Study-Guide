// 1. Two Sum
public class Solution {
    public int[] twoSum(int[] nums, int target) {
         // Arrays.sort(nums);
    if(nums == null || nums.length == 0) {return null;}

    int i, len = nums.length;

    Map<Integer, Integer> map = new HashMap<>(len);
    for(i = 0; i < len; i++)
    { //K = i
      //i will always be diff => key //nums[i] won't always be diff => value
      map.put(nums[i], i);
    }
    for(i = 0; i < len; i++)
    {
      int remainder = target - nums[i];
      if( map.containsKey(remainder) )
      {
        if( map.get(remainder) != null ){
          if(map.get(remainder) != i ){
            return new int[]{i, map.get(remainder)};
          }
        }
      }
    }
    //DNE
    return null;
  }
}
