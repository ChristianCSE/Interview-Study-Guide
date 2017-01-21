/*
 You are climbing a stair case. 
 It takes n steps to reach to the top.
 Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top?
 **/

import java.util.*;
class Solution {


 public static int numWays(int endPoint){
  int[] steps = {1,2};
  int[][] dpTable = new int[steps.length+1][endPoint+1];
  //now all col 0's should be 1
  for(int i = 0; i < 3; i++){
   dpTable[i][0]= 1; 
  }
  //have all 1 
  //top row should be [coin = 0 ]1 0... 
  //it's a safety recall
  int currentStep; 
  for(int i = 1; i < 3; i++) {
   for(int stepsAvailable = 1; stepsAvailable <= endPoint; stepsAvailable++){
    currentStep=i;
    if(currentStep > stepsAvailable){
     //get the above row 
     dpTable[i][stepsAvailable]=dpTable[i-1][stepsAvailable];
    }
    else{
     dpTable[i][stepsAvailable] = dpTable[i][stepsAvailable-i]+dpTable[i-1][stepsAvailable];
    }
   }
  }
  return dpTable[steps.length][endPoint];
 }

 public static int stairClimbing(int n){
  //can climb 1 or 2 
  int distinct_ways = 0;
  int onestep=0;
  int twostep=0;
  int curr = 0;
  Deque<Integer> path = new ArrayDeque<>();
  path.push(0);
  while(!path.isEmpty()){
   curr = (int)path.poll();
   if(curr==n){distinct_ways++;}
   if((onestep=curr+1)==n){distinct_ways++;}
   if((twostep=curr+2)==n){distinct_ways++;}
   if(onestep<n){path.push(onestep);}
   // if(curr!=0) {if(twostep<n){path.push(twostep);}}
   if(twostep<n){path.push(twostep);}
  }
  // return 1+ (2*(distinct_ways-1));
  return distinct_ways;
 }



 public static void callClimbing(int n){
  System.out.println("Num of ways to form the number "+ n+ " by only using 1 and 2 =>" + +stairClimbing(n));
 }
 public static void main(String[] args) {
 	int onestep, twostep, threestep;
  //549658443
  // callClimbing(4);
  long startTime = System.nanoTime();
  callClimbing(5);
  long endTime = System.nanoTime();
  long duration = (endTime - startTime);
  System.out.println(duration);
  startTime = System.nanoTime();
  System.out.println("=>" + numWays(34));
  endTime = System.nanoTime();
  System.out.println(duration);
 }
}