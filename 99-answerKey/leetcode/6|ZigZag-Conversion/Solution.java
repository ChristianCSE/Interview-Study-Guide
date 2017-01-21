//17.66 percentile
class Solution {

  public static String convert(String s, int numRows){
   if(s == null){return "";}
   if(numRows == 1){return s;}
   //need to init arr with empties could do Arrays.fill(row, ""); 
   String[] row = new String[numRows];
   for(int i = 0; i < numRows; i++){
    row[i]="";
   }
   int currIndex = 0;
   int len = s.length(); 
   boolean direction = true; //true=> + & false -
   
   for(int i = 0; i < len; i++){
    row[currIndex] = row[currIndex] +""+s.charAt(i) ;
    if(currIndex==0){direction = true;}
    if(currIndex+1==numRows){direction=false;}
    currIndex = (direction) ? currIndex+1:currIndex-1;
   }
   String zigzag = "";
   for(String horiz : row){
    zigzag += horiz;
   }
   return zigzag;
  }

  public static void main(String[] args){
   System.out.println(convert("PAYPALISHIRING", 3));
  }
}