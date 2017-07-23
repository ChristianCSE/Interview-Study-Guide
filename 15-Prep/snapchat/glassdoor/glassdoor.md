2/23/17
Find permutations, max sums

11/13/16
Graph/Stack/Trees/Trie

12/9/16
Return permutation of an array by equal probability.
http://www.geeksforgeeks.org/shuffle-a-given-array/

5/8/15
Sudoku verify = HackerRank
Print a 2D array diagonally

1/12/15
Tree & Word Ladder

9/2015
Implement a Big Integer class with an addition operation. 
Displaying the number in base 10 is a requirement.


6/27/17
Solve anagrams

6/21/17
Given an array of objects with a known set of properties, 
implement a function that finds all possible partial matches 
(one object's property value matches the same property on another 
object), and produce a results object that describes those 
matches in any format you want.  

A follow-up to the main exercise included discussions 
about non-exact matches for specific properties. 

5/1/17
identifying overlapping intervals, out of given intervals

5/10/17
Big Integer Addition

4/19/17
Backtracking, arrays

2/19/17
Solving squareroot from first principles

2/3/17 [Android?]
Box blur with a lot of follow-up

2/1/17
System design question about being able to 
implement a game which involves ordering 
n^2-1 pieces on an n^2 grid (one hole to put pieces in).  

1/13/17
Separate simple and compound words

1/31/17
A useless question of finding a 
target value of a commodity using individual items.

11/20/16
word split, parallel access lru cache, similarities of values in data streams, and a problem relating to conways game of life  

11/19/16
How would you convert 123 to 
One Two Three in code and other such inputs.  

10/16/16
write a function to return the kth largest 
element in a binary search tree  


8/4/16
hit counter

9/8/16
Randomly shuffle an array

10/12/16
DP, linked lists, graph, recursive backtracking, and one  open-ended design question (Design)

9/13/16
Given a XML file, translate the XML file into a tree
CreateTree(treeNode)
{
    while stack is not empty
        nextTag = read.nextTag
        if(nextTag is child)
        {
            if nextTag is open
                stack.push(nextTag)
                childNode = new node(nextTag)
                treeNode.add(nextTag)
            else
                stack.pop()
        }
        else{
            stack.pop()
            treeNode = treeNode.parent()
        }
    return treeNode;
}

stack.push(rootTag)
rootNode = new node(rootTag)
CreateTree(rootNode);


11/14/16

As an input, you have points on a 2D graph. You aim to find  a straight line that can fit as my points as possible. Return, the maximum number of points you can fit.


Connect all the dots two by two, and create a complete graph, Then for each edge, calculate the line formula in terms of x and y : y = mx + a
Keep the formulae in a hash table and attach the nodes that are the two end vertices of this edge to the table entry.
Once you calculate all the formulae for all the edges, go through the hash table and find the line with the most number of vertices there. That's the line you're looking for.
Run time complexity is O(n^2) as you have to go over all the edges between all vertices.




6/24/16
Given a Pattern and a dictionary, print out all the strings that match the pattern.
where a character in the pattern is mapped uniquely to a character in the dictionary ( this is what i was given first).

e.g 1. ("abc" , <"cdf", "too", "hgfdt" ,"paa">) -> output = "cdf"
      2. ("acc" , <"cdf", "too", "hgfdt" ,"paa">) -> output = "too", "paa"  

I used two unordered_map for pattern -> dictionary and dictionary->pattern


6/8/16
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

1.Only one letter can be changed at a time
2.Each intermediate word must exist in the word list  
https://www.glassdoor.com/Interview/Given-two-words-beginWord-and-endWord-and-a-dictionary-s-word-list-find-the-length-of-shortest-transformation-sequence-QTN_1555540.htm


7/7/16
Given an array of interger, find three numbers, their sum  is target.
def findThreeToSumToTarget(intSet, target, resultSet):
    if len(resultSet) == 3:
        if target == 0:
           return resultSet
        else:
            return None

    for i in intSet:
        result = findThreeToSumToTarget(intSet - i, target - i, resultSet + i)
        if resultSet != None:
            return resultSet

    return None





construct binary tree from inorder and preorder