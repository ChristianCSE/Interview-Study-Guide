/**
 * Created by christian on 5/22/16.
 */
package wordLadder;
import java.util.*;
 class WordLadder {
    private List<String> path;
    private String currentWord;
    private int pathLength;

    public WordLadder(List<String> path, String currentWord, int pathLength)
    {
        this.path = path;
        this.currentWord = currentWord;
        this.pathLength = pathLength;
    }

    public List<String> getPath()
    {
        return path;
    }

    public String getCurrentWord()
    {
        return currentWord;
    }

    public int getPathLength()
    {
        return pathLength;
    }
}
