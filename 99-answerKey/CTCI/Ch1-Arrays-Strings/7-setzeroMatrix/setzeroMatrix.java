/**
 * Created by christian on 5/15/16.
 */

import java.util.*;
public class setzeroMatrix{

	//assuming nbyn
	//zero matrix: if index contains 0, then its entire row and col = 0
		public static int[][] setZeros(int[][] matrix)
    {
        int nbyn = matrix.length;
        boolean[] rows = new boolean[nbyn];
        boolean[] cols = new boolean[nbyn];
        int i,j; 
        
        //look for zeros
        for( i = 0; i < nbyn; i++)
        {
            for( j = 0; j < nbyn; j++)
            {
                if(matrix[i][j] == 0) //found one
                {
                    rows[i] = true;
                    cols[j] = true;
                    break;
                }
            }
        }
        for( i = 0; i < nbyn; i++)
        {
            for( j = 0; j < nbyn; j++)
            {
                if(rows[i] || cols[j]) //found one
                {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }
    public static void main(String[] args)
    {
        int[][] matrix = new int[][]{{1, 2, 0},{3, 4, 0},{1, 2, 3}};
        System.out.println(Arrays.deepToString(matrix));
        System.out.println( Arrays.deepToString(setZeros(matrix)) );
    }
	}
