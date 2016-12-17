import java.util.*;
public class Solution {

	public static int dynamicFibonacci(int n) {
		int[] fibarr = new int[n];
		if (n == 1 || n == 2) {
			return 1;
		}
		fibarr[0] = 1;
		fibarr[1] = 1;
		for (int i = 2; i < fibarr.length; i++) {
			fibarr[i] = fibarr[i - 2] + fibarr[i - 1];
		}
		return fibarr[n - 1];
	}

	public static int recusiveFibonacci(int n)
	{
		if (n <= 1) {
			return n;
			} else {
			return recusiveFibonacci(n - 1) + recusiveFibonacci(n - 2);
			}
	}
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int r;
		System.out.println("What fibonacci number do you want to know?");
		r = input.nextInt();
		System.out.println("the fibonacci number is " + dynamicFibonacci(r));
  }
}
