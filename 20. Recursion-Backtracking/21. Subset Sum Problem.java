class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        return rec(arr, 0, sum);
    }
    static boolean rec(int arr[], int i, int sum) {
        if(sum==0) return true;
        if(i==arr.length) return false;
        return rec(arr, i+1, sum-arr[i]) || rec(arr, i+1, sum);
    }
}
-------------------------------------------------------------------------
class Solution {
    Boolean[][] memo;
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        memo = new Boolean[n + 1][sum + 1];
        return rec(arr, 0, sum, memo);
    }
    static boolean rec(int arr[], int i, int sum) {
        if (sum == 0) return true;
        if (i == arr.length) return false;
        if (memo[i][sum] != null) return memo[i][sum];
        return memo[i][sum] = rec(arr, i+1, sum-arr[i]) || rec(arr, i+1, sum);
    }
}
