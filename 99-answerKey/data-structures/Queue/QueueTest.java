

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest
{

	public static void putTo(String words, Queue<String> myQueue)
	{
		String[] letter = words.split("");
		for(String s : letter)
			myQueue.add(s);
	}
	
	
	@Test
	public void test() {
		Queue<String> queue = new Queue<>(); 
		String aBet = "abcdefghijklmnopqrstuvwxyz";
		putTo(aBet, queue);
		testSize(queue);
		testPeek(queue, "a");
		testPoll(queue, "a");
		testPeek(queue, "b");
	}
	
	//make assertion in void 
	 void testSize(Queue<String> queue)
	{
		assertEquals(26, queue.size());
	}
	
	
	 void testPeek(Queue<String> queue, String want)
	{
		assertEquals(want, queue.peek());
	}
	
	
	 void testPoll(Queue<String> queue, String expect)
	{
		assertEquals(expect, queue.poll());
	}
	
	
	
	
	

}
