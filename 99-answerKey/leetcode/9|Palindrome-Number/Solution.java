//is the given integer a palindrome

public class Solution {
    public boolean isPalindrome(int x) {
        String s = x + "";
  s = s.replace(" ", "");
  char[] c = s.toCharArray();
  int len = c.length;
  for(x = 0; x < len/2; x++)
  {
   if(c[x] != c[len-x-1])
   {
    return false;
   }
  }
  return true;
        
    }
}