import java.util.*;
public class Solution {
	//factorial Dynamic
	public static int dynamicFactorial(int n) {
		if (n == 0)
			return 1;
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}

	public static int recursiveFactorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * recursiveFactorial(n-1);
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int r;
		System.out.println("What factorial  do you want to know?");
		r = input.nextInt();
		System.out.println(r+"! = " + recursiveFactorial(r));

	}
}
