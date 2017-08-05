import java.util.*; 


class Solution {
  
  public static List<Integer> mutliply(List<Integer> listOne, List<Integer> listTwo) {
    // save sign reference now and just apply in the end!
    int sign = ( (listOne.get(0) * listTwo.get(0)) > 0) ? 1: -1;
    
    //prevent spotty negatives in final product
    listOne.set(0, Math.abs(listOne.get(0)));
    listTwo.set(0, Math.abs(listTwo.get(0)));

    //ex. 3 + 3 = 6  & last index is 5
    List<Integer> totalProduct = new ArrayList<>(Collections.nCopies(listOne.size()+listTwo.size(), 0));

    // to reach last index it's lenOne + lenTwo + 1
    int lenOne = listOne.size() - 1; // ex. 3 => 2
    int lenTwo = listTwo.size() - 1; // ex. 3 => 2

    //bottom number
    for(int i = lenOne; i >= 0; i--) {
      //top number
      for(int j = lenTwo; j >= 0; j--) {
        //get what is currently stored in your index
        int prevStored = totalProduct.get(i + j + 1);
        //new product (could be > 9)
        int currProduct = prevStored + (listOne.get(i) * listTwo.get(j));
        int carryOver = currProduct/10;
        int finalProduct = currProduct%10;
        //next index
        totalProduct.set(i+j, totalProduct.get(i+j) + carryOver);
        //update curr index
        totalProduct.set(i+j+1, finalProduct);
      }
    }

    //remove all starting zeros! 
    // start from the beginning! 
    int is_zero = 0;
    while(is_zero < totalProduct.size() && totalProduct.get(is_zero) == 0) {
      is_zero++;
    }
    totalProduct = totalProduct.subList(is_zero, totalProduct.size());

    if(totalProduct.size() == 0) {
      return Arrays.asList(0);
    }

    //now apply sign to product
    totalProduct.set(0, totalProduct.get(0)*sign);
    System.out.println("Total Product => " + totalProduct);
    return null;
  }


  public static void doProblem(int[] one, int[] two) {
    List<Integer> l = new ArrayList<>();
    for(int i: one) {
      l.add(i);
    }
    List<Integer> l_two = new ArrayList<>();
    for(int i : two){
      l_two.add(i);
    }
    mutliply(l, l_two);

  }

  public static void main(String[] args) {
    doProblem(new int[]{1, 2, 3, 4}, new int[]{-4, 5, 4});
    System.out.println(1234*-454);

    doProblem(new int[]{1, 2, 3, 4}, new int[]{1, 3, 4, 5, 4});
    System.out.println(1234*13454);    
    
  

  }
  
}