/**
 * Created by christian on 5/13/16.
 */
import java.util.*; 
import java.lang.*;

public class aidIntel {


 //    /*
  // 1.2 Implement an algotihm to determine 
  // if string has all unqe chars. Can't use additional DS.
  // page 73 
 //    **/
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

  // /*1.2: implement reverse String**/ 
  // public static String reverseString(String forward)
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


/*
1.3. Given two Strings see if they are permutations of each other.
Permuation means that order matters in that ba and ba are two different
things. 
**/
  public static boolean permutationOfOther(String word1, String word2)
  {
    //previous was unnecessary since they don't care for all permutations
    //they just want to know if it is a permuation 
  int length1 = word1.length(); 
  int length2 = word2.length(); 
  if(length1 != length2){return false;}
  //to reduce complexity of method just call something here 
  word1 = sortThem(word1);
  word2 = sortThem(word2);
  boolean ond = word1.equals(word2); 
  return false;
  }

  public static String sortThem(String word)
  {
    char[] seperateIt = word.toCharArray(); 
    java.util.Arrays.sort(seperateIt);//need to turn back to string 
    return Arrays.toString(seperateIt);
  }


  public static String returnNull()
  {
   return null; 
  }

  public static void dothis()
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
      dothis(); 
      //prob 1
      System.out.println("True or false, this String contains all unique chars?"); 
      String myString = input.nextLine();
      System.out.println(unqiueString(myString));
      
      //prob2: Easy way
      System.out.println("What do you want me to reverse?"); 
      myString = input.nextLine();
      System.out.println(reverseString(myString));


      String wow = null; 
      if(wow == null ){ String nuller = "null"; System.out.println("hello there");}
      //turn null into string or catch exception 
      System.out.println(returnNull());

        
    }
}
