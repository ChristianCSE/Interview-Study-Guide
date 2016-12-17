class Solution {


 public static void heapsort(int[] arr){
  //make it into a heap! 
  int len = arr.length;
  if(len <= 1){
   return;
  }
  int mid = len/2-1;
  //start at the rightmost node with a child!
  //bottom-up
  for(int i = mid; i >= 0; i--){
   heapit(arr, i, len);
  }
  System.out.println(java.util.Arrays.toString(arr));
  //have a maxHeap now! Now sort it! 
  //We start at the rightmost leaf! 
  for(int i = len-1; i >= 0; i--){
   //swap with root => sink [sunk=> permenantely there]
   swap(arr, i, 0);
   //then swim the new root down until we are a heap again. 
   //len should be decreasing per sink => make length = i
   heapit(arr, 0, i);
  }
  System.out.println(java.util.Arrays.toString(arr));
 }


 public static void heapit(int[] arr, int parent, int len){
  int newParent = parent;//could change
  int leftChild = parent*2 + 1; 
  int rightChidl = parent*2+2;
  if(leftChild<len && arr[leftChild]> arr[newParent]){
   newParent=leftChild;//do LC and Parent follow maxHeap rules?
  }
  if(rightChidl<len&&arr[rightChidl]>arr[newParent]){
   newParent=rightChidl;//is parent still the greatest of the 3?
  }
  if(newParent!=parent){
   //swap!
   swap(arr, newParent, parent);
   //is it in it's final position? 
   heapit(arr, newParent, len);
  }
 }

 public static void swap(int[] arr, int a, int b){
  int temp = arr[a];
  arr[a]=arr[b];
  arr[b]=temp;
 }




 public static void main(String[] args){
  heapsort(new int[]{4, 3, 2, 8, 10, 11});
 }
}