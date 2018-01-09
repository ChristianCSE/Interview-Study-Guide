
import java.util.Arrays;

class Bubble {
  public static void sort(int[] array){
    boolean trip_wire = false;
    int unsorted_len = array.length - 1; 
    while(!trip_wire){
      trip_wire = true;
      for(int i = 0; i < unsorted_len; i++){
        //if we go through the entire array without having prev > next
        //we can imply it's sorted, since we would just be going over: prev < next < next.next
        if(array[i] > array[i+1]){
          swap(array, i, i+1);
          trip_wire = false; 
        }
      }
      unsorted_len--;
    }
  }
  public static void swap(int[] array, int i, int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}


class Solution {

  public static void main(String[] args) {
    int[] array = {2, 3, 5, 1, 10};
    System.out.println("Before: "+Arrays.toString(array));
    Bubble.sort(array);
    System.out.println("After: "+Arrays.toString(array));
  }
}