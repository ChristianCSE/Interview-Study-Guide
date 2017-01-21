import java.util.*;  

/*
dir
    subdir1
    subdir2
        file.ext
==>
"dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"        
 */

/*
Time complexity required: O(n) where n is the size of the input string.
Notice that a/aa/aaa/file1.txt is not the longest file path, 
if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png
 */

class Solution {




 public static int lengthLongestPath(String input) {

  String parent = "";
  int curr=0; 
  while(input.charAt(curr)!= '/'){
   parent += input.charAt(curr);
  }
  curr = curr + 3; 
  Syste

  return 0;
 }

 public static void main(String[] args){

 }
}