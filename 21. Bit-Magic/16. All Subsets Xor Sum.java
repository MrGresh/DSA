class Solution {
    int subsetXORSum(int arr[]) {
        return rec(arr, 0, 0);
    }
    int rec(int[] arr, int i, int val) {
        if(i==arr.length) return val;
        return rec(arr, i+1, val) + rec(arr, i+1, val^arr[i]);
    }
}
---------------------------------------------------------------------------------
class Solution {
    public int subsetXORSum(int[] arr) {
        int n = arr.length;
        int totalXor = 0;
        for (int num : arr) {
            totalXor |= num; // union of bits
        }
        return totalXor * (1 << (n - 1));
    }
}
