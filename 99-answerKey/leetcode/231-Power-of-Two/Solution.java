// 231. Power of Two
public class Solution {
    public boolean isPowerOfTwo(int n)
    {
    if(n>0)
    {
      if( (n&n-1) == 0)
      {
        return true;
      }
      else
        return false;
    }
    else
      return false;
    }
}
