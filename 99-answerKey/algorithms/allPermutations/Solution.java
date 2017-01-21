class Solution {


 public static void permute(int[] arr){
  int len = arr.length; 
  permute(arr, len);
 }

public static void permute(int[] arr, int len){
 if(len == 1){
  System.out.println("permutation: " + java.util.Arrays.toString(arr));
 }
 else{
  for(int i = 0; i < len; i++){
   permute(arr, len-1);
   if(i%2==1){
    //if odd indexing
    swap(arr, 0, len-1);
   } else {
    //even indexing
    swap(arr, i, len-1);
   }
  }
 }

}

 public static void swap(int[] arr, int a, int b){
  int temp = arr[a];
  arr[a] = arr[b];
  arr[b] = temp;
 }

 public static void main(String[] args){
  int[] arr = new int[]{1, 2, 3};
  permute(arr);

 }
}