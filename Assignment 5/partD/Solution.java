package assignment5.partD;

public class Solution {

    //Given a target integer target and an integer array A sorted in
    //ascending order, find the index i in A such that A[i] is closest to
    //target. Please write main() method to test your code.
    //Assumptions:
    //1. There can be duplicate elements in the array, and we
    //can return any of the indices with same value.
    //2. if A is null or A is empty, return -1.


    public int getClosestValueIndex(int[] A, int target){
        if(A == null || A.length == 0)
            return -1;

        if(A[0] > target)
            return 0;
        if(A[A.length-1] < target)
            return A.length-1;

        int low = 0, high = A.length-1;
        while(low <= high){
            int mid = (low+high) / 2;
            if(A[mid] == target)
                return mid;
            else if(A[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }

        return (A[low] - target) < (target - A[high]) ? low : high;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] A = {1,3,3,4};
        int[] B = {0,1,5};
        System.out.println(sol.getClosestValueIndex(A,2));
        System.out.println(sol.getClosestValueIndex(B,7));
    }
}
