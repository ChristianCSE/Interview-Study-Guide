package datastructures.stack;
import static org.junit.Assert.*;
import java.util.Map.Entry;
import org.junit.Test;
public class StackTest
{
	@Test
	public void testStack() {
		Stack<String> stack = new Stack<>(); 
		String aBet = "abcdefghijklmnopqrstuvwxyz";
		String[] input = aBet.split("");
		for(String letter: input){
			stack.push(letter);
		}
		assertEquals("z", stack.pop());
		assertEquals("y", stack.pop());
		assertEquals("x", stack.pop());
		assertEquals("w", stack.pop());
		assertEquals("v", stack.pop());
	}
}
