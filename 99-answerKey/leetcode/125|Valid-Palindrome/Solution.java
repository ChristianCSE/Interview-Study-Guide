//give an alphanumeric phrase determine if it is a palindrome
//ignore punctutation, nonalpha, etc. Still consider the phrase
//as long as alphanumeric chars match. 
public class Solution {
    public boolean isPalindrome(String s) 
    {
          s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
  char[] letter = s.toCharArray();
  int len = letter.length;
  for(int i = 0; i < len/2; i++)
  {
   if(letter[i] != letter[len-i-1])
   {
    return false;
   }
  }
  return true;
    }
}