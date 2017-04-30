import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import org.junit.Test;

public class TestLinkedList{
		@Test
		public void testSinglyLinkedList()
		{
			SinglyLinkedList list = new SinglyLinkedList();
			int[] nodes = {0, 1, 2, 3, 4, 5, 6, 7};
			list.setAutoLinkedList(nodes);
			list.getPrintedList();
		}
