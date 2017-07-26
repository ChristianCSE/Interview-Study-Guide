/*
All evens in the front, all odds in the back 
No Auxillary Array!
 */

class Solution {
  static public int[] evenThenOdd(int[] A) {
    int evenCandidate = 0, oddCandidate = A.length -1;
    //two pointer 
    while(evenCandidate < oddCandidate) {
      if(A[evenCandidate]%2==0) {
        evenCandidate++; //keep it here
      } else {
        int temp = A[oddCandidate]; //let's see if even 
        A[oddCandidate] = A[evenCandidate]; //even gets position of odd now
        A[evenCandidate] = temp;
        oddCandidate--;
      }
    }
    return A;
  }

  public static void main(String[] args) {
    System.out.println(java.util.Arrays.toString(evenThenOdd(new int[]{1, 3, 4, 6, 8, 2, 3})));
  }
}