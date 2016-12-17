import java.util.*;

public class Solution {

    static public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> zeroSum = new ArrayList<>();
        int len = nums.length;
        if(len < 2)
            return zeroSum;
        else{

            Set<String> repeats = new HashSet<>();
            int[] candidate = new int[3];
            getComb(zeroSum, nums, len, 0, candidate, 0, repeats);
            return zeroSum;
        }
    }

    static public void getComb(List<List<Integer>> zeroSum, int nums[],
     int len, int canIn, int candidate[], int numberLine, Set<String> repeats){
        if(canIn == 3)
        {
            String arrString = stringIt(candidate);
            if(repeats.contains(arrString)){
                return;
            }
            if(getSum(candidate)){
                zeroSum.add(getIntArr(candidate));
                repeats.add(arrString);
                return;
            }
            else{
                return;
            }
        }
        if(numberLine >= len) //array index out of bounds
        {
            return;
        }
        candidate[canIn] = nums[numberLine];
        //new index swap
         getComb( zeroSum,  nums,  len, canIn+1,  candidate,  numberLine+1, repeats);
        //same index, new number
        getComb( zeroSum,  nums,  len, canIn,  candidate,  numberLine+1, repeats);
    }

    static public boolean getSum(int[] arr)
    {
        int sum = 0;
        for(int i : arr)
            sum+=i;
        if(sum == 0)
            return true;
        else
         return false;
    }

    static public List<Integer> getIntArr(int[] oldarr)
    {
        int len = oldarr.length;
        Integer[] newarr = new Integer[len];
        for(int i = 0; i < len; i++)
        {
            newarr[i] = Integer.valueOf(oldarr[i]);
        }
        return Arrays.asList(newarr);
    }

    static public String stringIt(int[] arr)
    {
        String cand = "";
        for(int i: arr){
            cand+= i;
        }
        char[] chars = cand.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }



    public static void main(String[] args)
    {
        int[] arr = {};
        System.out.println( threeSum(arr));
    }



}
