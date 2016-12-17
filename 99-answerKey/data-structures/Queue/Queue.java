import java.util.*;

public class Queue <T extends Comparable<T>>
{


	public static class QueueNode <T>
	{
		public T data;
		public QueueNode<T> next;
		public QueueNode(T data)
		{
			this.data = data;
		}
	}

	private int size;
	private QueueNode<T> first;
	private QueueNode<T> last;

	/**
	 * Queue Implementation
	 * @return Queue instance
	 */
	public Queue()
	{
		size = 0;
		first = null;
		last = null;
	}

	/**
	 * Place as tail, FIFO
	 * @param item
	 */
	public void add(T item)
	{
		size++;
		QueueNode<T> added = new QueueNode<>(item);
		if(first == null)
		{
			first = added;
			last = added;
		}
		else{
			QueueNode<T> node = first;
			while(node != null )
			{
				node = node.next;
			}
				node = added;
				added.next = null;
				last = added;//should last.nect = null? or left alone
		}
	}


	/**
	 * Client doesn't care about what gets removed
	 * they just want the head removed
	 */
	public void remove()
	{
		if(first == null)
		{
			throw new NoSuchElementException();
		}
		else
		{
			if(first == last)
			{
				first = first.next;
				last = null; //prevent floating pointer?
			}
			else{
				first = first.next;
			}
		}
	}

	/**
	 * You want to see what is in the front
	 * @return the data associated with the current object at the top
	 */
	public T peek()
	{
		return first.data;
	}

	/**
	 * Is the Queue still filled
	 * @return if yes, then true. if it is still filled, then return false.
	 */
	public boolean isEmpty()
	{
		return first == null;
	}

	/**
	 * This unlike remove doesn't return an error and it returns what
	 * was just  removed.
	 * @return return whatever is on the top. The data, not the object itself.
	 */
	public T poll()
	{
		//could do if(size == 0 ) too
		if(first == null)
		{
			return null;
		}
		else
		{
			size--;
			T temp = first.data;
			first = first.next;
			return temp;
		}
	}

	/**
	 * This implementation of Queue returns size
	 * @return current size
	 */
	public int size()
	{
		return size;
	}
}
