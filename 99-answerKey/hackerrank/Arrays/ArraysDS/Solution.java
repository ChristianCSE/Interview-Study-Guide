class Solution {

 static public void reversit(int[] arr){
  int len = arr.length-1;
  for(int i = len; i >= 0; i--) {
   System.out.print(arr[i] + " ");
  }
  System.out.println("");
 }

 public static void main(String[] args) {
  reversit(new int[]{1, 2, 3, 4});
 }
}