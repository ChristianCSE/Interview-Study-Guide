import java.util.*;

class Solution {



 public List<Integer> findAnagrams(String s, String p) {
  int sLen = s.length();
  int pLen = p.length();
  String[] parr = p.split("");
  Arrays.sort(parr);
  String[] sarr = s.split("");
  Deque<String> window = new ArrayDeque<>();
  List<Integer> list = new ArrayList<>();
  for(int i = 0; i < sLen; i++){
   // if(window.size() == pLen){
   //  window.pollFirst();
   // }
   window.addLast(sarr[i]);
   System.out.println("=>"+window);
   //check if matched sum aka 
   // if(comparisonNow(parr, window)){
   //  list.add(i);
   // }
  }
  System.out.println(list);
  return list;
 }

 public boolean comparisonNow(String[] parr, Deque<String> window){
  Deque<String> reference = new ArrayDeque<>();
  String[] arr = new String[window.size()];
  int i = 0;
  while(!window.isEmpty()){
   arr[i] = window.poll();//head
   reference.pushFirst(arr[i])l
   i++;
  }//need to push everything back now
  window = reference;
  Arrays.sort(arr);
  if(Arrays.toString(parr).equals(Arrays.toString(parr))){
   return true;
  }
  return false;
 }


  public static void main(String[] args){
   Solution invoker = new Solution();
   String s = "abab";
   String p = "abc";
   invoker.findAnagrams(s, p);
  }
}