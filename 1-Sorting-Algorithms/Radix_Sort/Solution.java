

/*
This algorithm is sorting by digits -- this is not a comparison based sort!
Runtime: O(kn) 
k: number of passes of sorting algorithm 
n: iumber of elements 
For all comparison based sorting cannot run faster than O(n*log(n))
I choose to use static functions since Java's built-in sorting functions are static
i.e. Array.sort(), List.sort(), etc. 
 */
import java.util.*;

class Radix {

  //Bucket corresponds to the value of the integer in the nth digit spot 
  //so 549: 1th spot = 9, 2nd spot = 4, 3rd spot = 5
  public static void sort(int[] array){
    System.out.println("Before: "+Arrays.toString(array));
    List<Integer>[] buckets = (ArrayList<Integer>[])new ArrayList[10];
    init(buckets);
    int maxDigits = getMaxDigits(array);
    int len = array.length;
    for(int i = 0; i < maxDigits; i++){
      int digit = (int)Math.pow(10, i);
      distribute(array, 0, len, digit, buckets);
    }
    System.out.println("After: "+Arrays.toString(array));
  }

  public static void distribute(int[] array, int beginIn, int endIn, int nthDigit, List<Integer>[] buckets){
    for(int i = beginIn; i < endIn; i++){
      int nthValue = (array[i]/nthDigit) % 10; //ex. 130/10 = 13 % 10 = 3
      buckets[nthValue].add(array[i]);
    }

    for(List<Integer> bucket : buckets){
      for(Integer number : bucket){
        array[beginIn++] = number;
      }
      bucket.clear(); //use again with new numbers
    }
  }

  //this so we know when to stop placing our numbers into buckets
  public static int getMaxDigits(int[] array){
    int maxDigits = 0;
    StringBuilder str = new StringBuilder();
    for(int number : array){
      str.append(number);
      maxDigits = str.length() > maxDigits ? str.length() : maxDigits;
      str.setLength(0);
    }
    return maxDigits;
  }

  //need to init each bucket with an empty array!
  public static void init(List<Integer>[] buckets){
    for(int i = 0; i < buckets.length; i++){
      buckets[i] = new ArrayList<>();
    }
  }
}
class Solution {
  public static void main(String[] args) {
    int[] test_one = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    int[] test_two = {100, 1123, 122, 93, 4, 211};
    Radix.sort(test_one);
    //System.out.println(Arrays.toString(test_one));
    Radix.sort(test_two);
    //System.out.println(Arrays.toString(test_two));
  }
}