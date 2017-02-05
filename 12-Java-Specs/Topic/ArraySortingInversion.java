import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;
class ArraySortingInversion {
 public static void main(String[] args){
  Integer[] arr = new Integer[]{2, 120, 1, 3, 10, 0};
  Comparator<Integer> comp =  Collections.reverseOrder();
  Arrays.sort(arr, comp);
  System.out.println(Arrays.deepToString(arr));
 }
}

