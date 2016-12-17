class Solution {
    static public int solution(int X, int[] A) {
        int req_leaves = X;
        boolean[] pond = new boolean[X+1];
        for(int i = 0; i < A.length; i++) {
         int spot = A[i];
         if(!pond[spot]) {
            pond[spot] = true;
            req_leaves--;
            if(req_leaves == 0) {return i;}
         }
        }
        return -1;
    }

    public static void main(String[] args) {
    	int[] pond = new int[]{1, 3, 1, 4, 2, 3, 5, 4};
    	int land = 5;
    	System.out.println(solution(land, pond));
    }
}

