public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) 
    {
        int mask = 1, i; 
        int counted1s = 0; 
        for(i = 0; i < 32; i++)
        {
          if( (n&mask) != 0)
          {
            counted1s++; 
          }
          mask = mask << 1;
        }
        return counted1s;
    }
}