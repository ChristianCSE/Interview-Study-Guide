/**
* 3.2: How would you design a stack which in addition to push and pop,
* has a function min which retruns the minimum element? Push, pop, and
*  min should all operate in O(1) time.
*/
import java.util.EmptyStackException;


public class MinStack <T extends Comparable<T>>
{


/*=================================
Adjustments wrt problem 3.2: Min-Stack
=================================**/
	/**
	 * min = the minimum wrt those below it; hence
	 * , |top||	 -3,[-3]	||	-1,[-1]	||	2,[1]	||	1,[1]	|bottom
	 * the min varies.
	 */
	public static class AdjustedMinNode<T>
	{
   	public T data;
   	public AdjustedMinNode<T> next;
   	public T min;
   public AdjustedMinNode(T data, T min)
   	{
       this.data = data;
       this.min = min;
  	 }
	}

	public AdjustedMinNode<T> top;

	public T pop()
	{
		if(top == null){
			throw new EmptyStackException();
		}
		T item = top.data;
		top = top.next;
		return item;
	}

/*=================================
Adjustments wrt problem 3.2: Min-Stack
=================================**/
	public void push(T item)
	{
		//now have to check for min
		T min = getMin();
		if(min==null)
		{
			min = item;
		}
		else
		{
			if(item.compareTo(min) < 0 )
			{
				min = item;
			}
		}
		AdjustedMinNode<T> node = new AdjustedMinNode<>(item, min);
		node.next = top;
		top = node;
	}
/*=================================
Adjustments wrt problem 3.2: Min-Stack
=================================**/
	public T getMin()
	{
		if(isEmpty())
		{
			return null;
		}
		else{
			return top.min;
		}
	}



/**
* LIFO stack
* @return top-most element on the stack
*/
	public T peek()
	{
		return top.data;
	}

/**
* This is used to see if the stack still has elements left in it.
* @return if Empty return true, else reeturn false
*/
	public boolean isEmpty()
	{
		return top == null;
	}


}
