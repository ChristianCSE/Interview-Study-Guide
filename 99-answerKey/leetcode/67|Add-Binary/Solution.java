public class Solution {

    public String addBinary(String a, String b)
    {
    	int diff = a.length() - b.length(), i, bin;
    	int len = a.length(); //in case equal
    	if(diff > 0){
    		b = stringCap(diff, b);
    		len = a.length();
    		System.out.println(b);
    	}
    	else if(diff < 0){
    		a = stringCap((int)Math.abs(diff) , a);
    		len = b.length(); //doesn't matter
    	}
    	int rem = 0;
    	String result = "";
    	for(i = len-1 ; i >-1; i--)
    	{
    		bin =  Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(i)) + rem;
    		if(bin > 1)
    		{
    			rem = 1;
    			result = Integer.toString(bin%2) + result;
    		}
    		else
    		{
    			rem = 0;
    			result = Integer.toString(bin) + result;
    		}
    	}
    	if(rem == 1){
    		result = "1" + result;
    	}
    	System.out.println(result);
    	return result;
    }

    public static String stringCap(int n, String addTo)
    {
    	while(n!=0)
    	{
    		addTo = "0" + addTo;
    		n--;
    	}
    	return addTo;
    }


    public static void main(String[] args)
    {
    		Solution caller = new Solution();
    		caller.addBinary("101", "1111");
		}


}
