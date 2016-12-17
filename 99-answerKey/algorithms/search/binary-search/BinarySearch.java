/**
 * Created by christian on 5/16/16.
 */
public class BinarySearch {



    public static int binarySearch(int[] numbers, int want)
    {
        int low = 0;
        int high = numbers.length;
        int mid;
        while(low < high)
        {   //the (high-low)/2 is done for avoiding overflow
            mid = low + (high-low)/2;
            if(numbers[mid] > want)
            {
                high = mid - 1;
            }
            else if(numbers[mid] < want)
            {
                low = mid + 1;
            }
            else
                return mid;

        }

        return -1;
    }

    public static void main(String[] args)
    {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 99, 101, 432, 890};
        int index = binarySearch(numbers, 900);
        System.out.println(index);
    }
}
