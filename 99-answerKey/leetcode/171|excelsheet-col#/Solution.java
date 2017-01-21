class Solution {

 public static int titleToNumber(String s){
  char[] c = s.toCharArray(); 
  int len = c.length; 
  int excel = 0; 
  for(int i = 0; i < len ; i++){
    int helper = (c[i]-64)*(int)(Math.pow(26, (len-1-i)));
    excel = excel + helper;
  }
  return excel;
 }



 public static void main(String[] args){
  System.out.println(titleToNumber("AB")); // 28
  System.out.println(titleToNumber("BA"));
  System.out.println(titleToNumber("AA"));//27
  System.out.println(titleToNumber("A"));
  
  
 }
}