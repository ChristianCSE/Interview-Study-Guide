/**
 * Created by christian on 5/22/16.
 */
package wordLadder;
import java.util.*;
public class TestWordLadder {
    String[] arrayWord = new String[]{"hot","dot","dog","lot","log"};
    Set<String> fakeTree = new HashSet<>(Arrays.asList(arrayWord));
    String startWord = "hit";
    String endWord = "cog";
    WordLadder result = DFSWordLadder.getPathNow(startWord, endWord, fakeTree);
    System.out.println(result.getPathLength());
//    result.getPath();



}
