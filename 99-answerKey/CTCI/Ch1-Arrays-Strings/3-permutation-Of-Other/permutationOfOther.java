/**
 * Created by christian on 5/15/16.
 */

import java.util.*;

public class permutationOfOther {
/*Chapter 1 Problem 3:
Given two strings, write a method to decide
if one is a permutation of the other.
Q's: Is it case sensitive?
**/

    public static boolean permutationOfOther(String word1, String word2)
    {
        try{
            if(word1.length() != word2.length()) { return false;}
        }catch(NullPointerException e)
        {
            System.out.println("bad input");
            return false; 
        }
        word1 = sortThem(word1);
        word2 = sortThem(word2);
        return word1.equals(word2);
    }

    public static String sortThem(String word)
    {
        char[] seperateIt = word.toCharArray();
        Arrays.sort(seperateIt);
        return Arrays.toString(seperateIt);
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String att = "hello ello"; 
        String[] attt = att.split(" ");

        System.out.println(Arrays.deepToString(attt) + " " + attt.length);
        String usr;
        System.out.println("Please input two words seperated by a space");

        while( (usr = input.nextLine() ) != null)
        {
            String[] canidates = usr.split(" "); 
            if(canidates.length != 2)
            {
                System.out.println("bad input");
                continue; 
            }
            else{
                System.out.println(permutationOfOther(canidates[0], canidates[1]));
            }
            
            System.out.println("Please input two words seperated by a space");
        }
    }
}
