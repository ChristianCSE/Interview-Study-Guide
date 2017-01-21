import java.util.*;
class Solution {


 public static String countAndSay(int n){
  String count = "1";
  String say = Integer.parseInt(count) + count;
  String total = say;
  boolean wire = true; 
  int me =1;
  int saying = 1;
  while(me!=n){
  for(int i = 0;  i < total.length(); i=i){

    for(int j = i+1; j<total.length();j++){
     if(total.charAt(i) != total.charAt(j))
     {
      System.out.println(total.charAt(i)+""+""+total.charAt(j));
      break;
     } else{
      saying++;
      System.out.println("saying=" + saying);
     }
    }//say

   System.out.println("saying=" + saying);
   total=  Integer.toString(saying)+total.charAt(i);
   me++;
   i = total.length()-1;
  
  }
 }
  System.out.println(total);
  return total;
 }


 public static String countSay(int n){ 
  String start = "1";
  String say = Integer.parseInt(start)+start;
  String prev = say;
  boolean wire = true;
  int want = 1;
  int saying = 1;
  int count = 1;
  while(want!=n){
   for(int i = 0; i < prev.length()-1; i++){
    if(prev.charAt(i)!=prev.charAt(i+1)){
     if(count > 1 || prev.length()+1 == prev.length()) {
      say = Integer.toString(count) + prev.charAt(i);
     }
    } else{
     count++;
    }
   }
   want++;
  }
  return prev;
 }

  public static void main(String[] args){
  countAndSay(3);
  countAndSay(4);
  }
}