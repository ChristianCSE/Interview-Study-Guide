package wordLadder;
import java.util.*;
/**
 * Created by christian on 5/22/16.
 */
 class DFSWordLadder {

    public static WordLadder getPathNow(String beginWord, String endWord, Set<String> wordList)
    {
        if(beginWord.length() != endWord.length()){return null;}
        wordList.add(endWord);

        List<String> startPath = new LinkedList<>(); //use this over AL, b/c faster remove/add
        startPath.add(beginWord);
        int pathLength = 1;
        Queue<WordLadder> queuePaths = new ArrayDeque<>(); //faster than LL
        queuePaths.add(new WordLadder(startPath, beginWord, pathLength));


        while(!queuePaths.isEmpty()) {
            String current = queuePaths.peek().getCurrentWord();

            if (current.equals(endWord)) { //we have a path were word->word->currentword = end
                return queuePaths.peek();
            }

            WordLadder aPath = queuePaths.remove();
            Iterator<String> iterList = wordList.iterator();

            while (iterList.hasNext()) {
                String candidate = iterList.next();
                if (diffByOne(current, candidate)) {
                    List<String> newPath = new LinkedList<>(startPath);
                    newPath.add(candidate);
                    queuePaths.add(new WordLadder(newPath, candidate, aPath.getPathLength() + 1));
                    iterList.remove(); //Don't want to reloop through this word
                }
            }
        }
        return null;
    }

    public static boolean diffByOne(String want, String candidate)
    {
        int i = 0;
        int length = want.length();
        int diffChar = 0;
        while(i < length)
        {
            String wantChar = want.charAt(i) + "";
            String candidateChar = candidate.charAt(i) + "";
            if(!wantChar.equals(candidateChar))
            {
                diffChar++;
                if(diffChar > 1){return false;}
            }
            i++;
        }
        return true;
    }
}
