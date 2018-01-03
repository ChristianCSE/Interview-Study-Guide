// import java.util.*;

// class Solution {


//   public static int minStepsToEnd(List<Integer> list) {
//     int newJump = 0;
//     int reachableRange = 0;
//     int ending = list.size() - 1;
//     List<Integer> fromStep = new ArrayList<>();
//     for(int i = 0; i <= reachableRange && reachableRange < ending; i++) {
//       int determinedMax = Math.max(i + list.get(i), reachableRange);

//       newJump += (determinedMax != reachableRange) ? 1 : 0;

//     }
//     return 0;
//   }


//   public static void main(String[] args) {

//   }
// }