/**
 * Created by christian on 5/15/16.
 */
import java.util.*;
public class reverseString{


    /*Chapter 1 Problem 2:
    Reverse a string.
    Do manually and easy way **/

    public static String reverseString(String forward)
    {
        StringBuilder reverser = new StringBuilder(forward);
        return reverser.reverse().toString();
    }

    public static String manReverse(String forward)
    {
        if(forward == null){ forward = "null";} //return null;
        int length = forward.length();
        if(length == 0 || length == 1) return forward;
        char[] reversed = new char[length];
        for(int i = 0; i < length; i++)
        {

        }
        return " ";
    }

    public static void manuallyReverse()
    {
        String hello = "abcdef";
        int length = hello.length();

        for(int i = 0; i < length; i++)
        {
            String seeforward = hello.substring(1, length - i);
            String seebackw = hello.substring(0,1);
            String seePasLimit = hello.substring(length-i, length);
            System.out.println("0,1 => " + seeforward + "\n1,0 => " + seebackw +
                    "\n5,6 (index max = 5) => " +  seePasLimit);
            hello = seeforward + seebackw + seePasLimit;
        }
        System.out.println(hello);
    }



    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("What do you want me to reverse?");
        String myString = input.nextLine();
        System.out.println(reverseString(myString));
    }


}
