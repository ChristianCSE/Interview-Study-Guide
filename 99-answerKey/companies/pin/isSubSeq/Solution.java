class Solution {

 public static boolean isSubsequenceBAD(String s, String t){
  if(s==null || t == null){ return false;}
  int slen = s.length();
  int tlen = t.length();
  int confirmedMatch = 0;
  if(tlen < slen){return false; }
  int j = 0;
  byte[][] table = new byte[slen+1][tlen+1];
  //need to 0 row so skip index 0 
  for(int i = 1; i <= slen; i++){
   for( j = 1; j <= tlen; j++){
    //if match letter 
    if(s.charAt(i-1)==t.charAt(j-1)) {
     //get the count from diagonal + 1
     table[i][j]= (byte)(table[i-1][j-1] + 1);
     if(confirmedMatch < i){
      confirmedMatch++;
     }
    } 
    //don't match letter
    else{
     table[i][j]= (table[i-1][j] > table[i][j-1]) ? table[i-1][j] : table[i][j-1];
    }
   }//for j
   if(table[i][j-1] != i){
    return false;
   }
  }
  return (table[slen][tlen] == slen)? true: false; 
 }

 //we care for existence of a subsequence not 
 //length! 
 public static boolean isSubsequence(String s, String t) {
  if(s== null || t== null){return false;}
  int slen = s.length();
  int tlen = t.length();
  if(slen == 0 && (tlen != 0|| tlen==0)){return true;}
  if(slen > tlen){return false;}
  int count = 0;
  for(int i = 0; i < t.length(); i++){
   if(s.charAt(count) == t.charAt(i)){
    count++;
    if(count == slen){return true;}
   }
  }
  return false;
 }

  public static void main(String[] args) {
   String s = "abc";
   String  t = "ahbgdc";
   //s = new String("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
   System.out.println(isSubsequence(s, t));
  }
}