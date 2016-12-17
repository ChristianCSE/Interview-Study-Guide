import java.util.EmptyStackException;
 public class Stack <T extends Comparable<T>>
 {

	public static class StackNode<T>
	{
 		public T data;
 		public StackNode<T> next;
 		public StackNode(T data)
 		{
 			this.data = data;
 		}
 	}

	public StackNode<T> top;

/**
 * LIFO, stack of dishes
 * @return the top-most (last placed) element
 */
	public T pop()
	{
		if(top == null){
			throw new EmptyStackException();
		}
		T item = top.data;
		top = top.next;
		return item;
	}

/**
 * LIFO, hence placed at the top
 * @param an Object item, that'll be placed on the top
 */
	public void push(T item)
	{
		StackNode<T> node = new StackNode<>(item);
		node.next = top;
		top = node;
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
