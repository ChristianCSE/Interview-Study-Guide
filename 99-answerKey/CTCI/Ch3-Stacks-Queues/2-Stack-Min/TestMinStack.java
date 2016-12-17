import static org.junit.Assert.*;
import org.junit.Test;
public class TestMinStack
{

	@Test
	public void testStack() {
		MinStack<String> stack = new MinStack<>(); 
		String aBet = "bcdefghijklmnopqrstuvwxyza";
		String[] input = aBet.split("");
		for(String letter: input){
			stack.push(letter);
		}
		assertEquals("a", stack.getMin());
		assertEquals("a", stack.pop()); 
		assertEquals("z", stack.pop());
		assertEquals("b", stack.getMin());
	}
}
