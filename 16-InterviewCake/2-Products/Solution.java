import java.util.*;

class Solution {


  public static int[] productArrays(int[] arr) {
    int len = arr.length;
    List<Integer> behind = new ArrayList<>();
    
    List<Integer> ahead = new ArrayList<>();
    int aheadProd = 1;
    int[] prodArr = new int[len];
    int prod = 1;
    for(int i = 0; i < len-1; i++) {
      behind.add(arr[i]);
      prod *= arr[i];
    }
    prodArr[len-1] = prod;
    behind.remove(behind.size()-1); //remove last el which is our next eval
    ahead.add(arr[len-1]); //add our curr element since ahead of next el
    
    aheadProd*=arr[len-1];

    for(int i = len -2; i >= 0; i--) {
      System.out.println("->" + prod);
      prod = 1;
      for(Integer back: behind){
        prod*= back;
      }

      if(!behind.isEmpty()) behind.remove(behind.size()-1); //remove upcoming from behind
      
      /*
      for(Integer front: ahead) {
        prod*= front;
      }
      ahead.add(arr[i]); //you will be ahead of upcoming 
      */
      prod *= aheadProd;
      aheadProd*=arr[i];

      prodArr[i] = prod;
    }
    return prodArr;
  }




  public static int[] prodArr(int[] arr) {
    int len = arr.length;
    int[] prodArray = new int[len];
    int behindProd = 1;
    for(int i = 0; i < len; i++) {
      prodArray[i] = behindProd;
      behindProd *= arr[i];
    }
    int aheadProd = 1;
    for(int i = len-1; i >= 0; i--) {
      prodArray[i] *= aheadProd;
      aheadProd *= arr[i];
    }

    return prodArray;
  }


  public static void main(String[] args) {
    Integer o = 10; 
    int p = 100;
    System.out.println(o*p);
    int[] container = prodArr(new int[]{1, 2, 3, 4});
    System.out.println(Arrays.toString(container));
  }
}