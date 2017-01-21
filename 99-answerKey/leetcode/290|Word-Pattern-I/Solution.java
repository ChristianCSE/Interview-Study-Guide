import java.util.*; 

class Solution {

    public  static boolean wordPattern(String pattern, String str){
   Map<String, String> map = new HashMap<>();
   int plen = pattern.length();
   String[] words = (plen==1)? new String[]{str}: str.split(" ");
   if(plen != words.length){return false;}
   for(int i = 0; i < plen; i++){
    String  holdit = "" +pattern.charAt(i);
    String  wordnow = words[i];
    if(map.containsKey(holdit)){
     if(!map.get(holdit).equals(wordnow)){
      return false;
     }
    } else {
    if(map.containsValue(wordnow)){
      return false;
     }
     map.put(holdit, wordnow);
    }
   }
   return true;
  }

 public static void main(String[] args){
  String ptrn = "abc";
  String words = "dog dog dog";
  System.out.println(wordPattern(ptrn, words));
  ptrn = "abba";
  words = "dog dog dog dog";
  System.out.println(wordPattern(ptrn, words));
  ptrn = "abba";
  words = "dog cat cat fish";
  System.out.println(wordPattern(ptrn, words));
  ptrn = "aaa";
  words = "dog cat cat dog";
  System.out.println(wordPattern(ptrn, words));

 }
}