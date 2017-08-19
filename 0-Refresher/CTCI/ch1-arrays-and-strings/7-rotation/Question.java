// import java.util.*;

// public class Question {

//   public static void printit(int n){
//     System.out.println(n);
//   }
//   public static boolean rotate(int[][] matrix) {
//     if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
//     int n = matrix.length;
    
//     for (int layer = 0; layer < n / 2; layer++) {
//       int first = layer;
//       int last = n - 1 - layer;
//       for(int i = first; i < last; i++) {
//         int offset = i - first;
//         int top = matrix[first][i]; // save top
//         // left -> top
//         matrix[first][i] = matrix[last-offset][first];      

//         // bottom -> left
//         matrix[last-offset][first] = matrix[last][last - offset]; 

//         // right -> bottom
//         matrix[last][last - offset] = matrix[i][last]; 

//         // top -> right
//         matrix[i][last] = top; // right <- saved top
//       }
//     }
//     return true;
//   }
  
//   public static void main(String[] args) {
//     int[][] matrix = new int[3][3];
//     matrix[0][0] = 1;
//     matrix[0][1] = 2;
//     matrix[0][2] = 3;

//     matrix[1][0] = 4;
//     matrix[1][1] = 5;
//     matrix[1][2] = 6;

//     matrix[2][0] = 7;
//     matrix[2][1] = 8;
//     matrix[2][2] = 9; 
//     for(int[] row : matrix) {
//       System.out.println(Arrays.toString(row));
//     }              
//     rotate(matrix);
//     System.out.println();
//     for(int[] row : matrix) {
//       System.out.println(Arrays.toString(row));
//     }
    
//   }
// }

