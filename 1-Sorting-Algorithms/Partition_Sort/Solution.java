


import java.util.Arrays;
class Partition {
  //everything less than the kth largest goes to the left of it
  //everything greater than the kth largest goes to the right of it
  public static int placePivot(int[] array, int kth){
    int right = array.length - 1;
    //kth = nth highest, if you are 1st highest that means you are 
    //greater than/equal to = totalValues-1
    kth = array.length - kth;
    System.out.println("Before: "+Arrays.toString(array));
    int numberKth = getKth(array, 0, right, kth);
    System.out.println("After:  "+Arrays.toString(array));
    return numberKth;
  }

  public static int getKth(int[] array, int left, int right, int k){
    if(left==right) return nums[left];
    int parition = parition(array, left, right);
    
    if(parition == k) return array[parition];
    else if(parition > k) return getKth(array, left, parition-1, k);
    //
    else return getKth(array, left, parition+1, k)
    return 0;
  }
  
  /*
  NOTE (After paritioning the array): 
  [lte, you, gt] == [less than and equal to you, you, greater than you]
  we guarentee that anything on your right is always greater than your current value
  NOTE: 
  We don't know the kth-1 or kth+1 (or kth+n) index, since all we are guaranteeing
  if that the left is smaller or greater than the parition and that the right 
  is larger than the parition the array for all we know could look like this: 
  [3, 6, 1, 2, me, 30, 20, 12, 11] where me = 9
  That's why when we split the array we do parition (+/-) 1!
   */
  public static int parition(int[] array, int left, int right){
    
    return 0;
  } 
}


class Solution {
  public static void main(String[] args) {
    
  }
}