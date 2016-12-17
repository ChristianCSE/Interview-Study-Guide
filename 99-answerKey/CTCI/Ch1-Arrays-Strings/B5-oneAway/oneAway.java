
import java.util.*;
//problem 1.5 from new edition. 
//can one edit make a word into the other: insert,delete,remove one char?
public class oneAway
{

	public static void turnTo(String want, String have)
	{

		try{
			if(want.length() - have.length() != 1 && 
				want.length() - have.length() != -1 && 
				want.length() - have.length() != 0) 
			{
			System.out.println("This cannot be one change away");
			return;
			}
		} catch(NullPointerException e)
		{
			System.out.println("Invalid input");
			return; 
		}

		if( want.length() < have.length() )
		{
			 String temp = have; 
			 want = have; 
			 have = temp;
		}
		//guarantees want the longer string and have is the shorter string
		//just makes easier to keep track of things logic is still the same

		boolean oneAway = false; 

		if(want.length() == have.length())
		{
			oneAway = replaceChar(want, have);
		}
		else
		{
			
			oneAway = insertmove(want, have + " "); 
		}

		if(oneAway)
		{
			System.out.println(have + "  is one change away from being   " + want);
		}
		else
		{
			System.out.println(have + "  is not a valid string to be one away  " + want);
		}
	}

	//we don't return false for end of loop in case we have the same word 
	public static boolean replaceChar(String want, String have)
	{
		int len = have.length(), i; 
		for(i = 0; i < len; i++)
		{
			if(want.charAt(i) != have.charAt(i))
			{
				//substring = (0, i]
				have = have.substring(0,i) + want.charAt(i) + have.substring(i+1);
				break;
			}
		}
		return have.equals(want); 
	}



	public static boolean insertmove(String want, String have)
	{
		//we made shorter string have extra blank space; hence, length priority goes to whichever
		int len = want.length(), i; 
		for( i = 0; i < len; i++)
		{
			if(want.charAt(i) != have.charAt(i))
			{
				have = have.substring(0,i) + want.charAt(i) + have.charAt(i)+ have.substring(i+1);
				have = have.trim();
				return want.equals(have); 
			}
		}
		return false;
	}

	public static void main(String[] args)
	{
		
		turnTo("hello", "jello");
		turnTo("jellos", "jello");
		turnTo("jellasddsaos", "jello");
		
	}
}
