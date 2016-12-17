// 219. Contains Duplicate II
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
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
          else
          {
            map.put(curr,i);
          }
        }
        return false;
        }
}
