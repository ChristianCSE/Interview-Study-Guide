/**
 * Created by christian on 5/15/16.
 */

import java.util.*;

public class matrixtranspose {

//Has to be NxN matrix
		//Needs to be improved as of now too slow: O(N^2)
		public static void turn90(int[][] img)
	    {
	        // System.out.println("Before being flipped:\n" + Arrays.deepToString(img));
	        if(img.length == 1 || img.length != img[0].length)
	        	{
	        		System.out.println("Invalid matrix");
	        		return;
	        	}
	        int length = img.length, i;
	        int[] inverter = new int[length*length];
	        int count = 0;
	        for( i = 0; i < length; i++)
	        {
	            for(int j = length - 1; j >= 0; j--)
	            {
	                inverter[count] = img[j][i];
	                count++;
	            }
	        }
	        System.out.println(Arrays.toString(inverter));
	        count = 0;
	        for(  i = 0; i < length; i++)
	        {
	            for( int j = 0; j < length; j++)
	            {
	                img[i][j] = inverter[count];
	                count++;
	            }
	        }

	        
	        // System.out.println("It is flipped 90 degrees:\n" + Arrays.deepToString(img));

	    }

	    public static void main(String[] a)
	    {
	        turn90( new int[][]{ {1, 2, 3}, {4, 5, 6}, {7, 8, 9}} );
	    }

}
