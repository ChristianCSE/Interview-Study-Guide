import java.util.*;
class appleStocks{

//stockPrice[i = minutes]
//Want best return
// stock_prices_yesterday = [10, 7, 5, 8, 11, 9]
//buy at minute 5 and sell at 11 => Profit 6

	public static int profit(int[] stocks)
	{
		int len = stocks.length;
		int stopper = len -1;
		boolean[] track = new boolean[stopper];
		int mindex = stopper;
		Arrays.fill(track, true);

		int min = (int)Integer.MAX_VALUE;
		int i;
		int max = (int)Integer.MIN_VALUE;
		int payoff = 0;
		int potPayoff;
		boolean tripped = true;
		while(tripped)
		{
			tripped = false;
			for( i = 0; i <= stopper; i++)
			{
				if(stocks[i] < min && track[i])
				{
					min = stocks[i];
					mindex = i;
				}
			}
			if(mindex+1 != len){
			for( i = mindex; i <= stopper; i++)
			{
					if(stocks[i] > max)
					{
						track[mindex] =  false;
						max = stocks[i];
						tripped = true;
					}
			}
		}//check if in scope
			potPayoff = max - min;
			if(payoff < potPayoff)
			{
				payoff = potPayoff;
			}
			min = (int)Integer.MAX_VALUE; //reset min so it can be reset
			//don't need to reset max
		}//while
		return payoff;
	}

	public static void main(String[] args)
	{
		System.out.println(profit(new int[]{4, 211, 0, 3, 1118, 10, 19}));
			profit(new int[]{1, 21, 0, 15, 8, 10, 19});
	}
}

