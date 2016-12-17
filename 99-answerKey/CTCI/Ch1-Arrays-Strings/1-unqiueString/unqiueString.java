/**
 * Created by christian on 5/15/16.
 */
import java.util.*;
public class unqiueString {

/*Chapter 1 Problem 1:
    See if the string contains all unique characters
    There are only 256 possible characters **/
    
    public static boolean unqiueString(String test)
    {

        int length = test.length();
        if(length == 0) return true; //not 1 b/c can have 2 blanks
        if(length >= 256) return false; //pigeon hole
        boolean[] sliceString = new boolean[256]; //256 unique
        for(int i = 0; i < length; i++)
        {
            int checkChar = test.charAt(i);
            if(!sliceString[checkChar])
            {
                sliceString[checkChar] = true;
            }
            else {return false;}
        }
        return true;

    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("True or false, this String contains all unique chars?");
        String myString = input.nextLine();
        System.out.println(unqiueString(myString));
    }

} 
