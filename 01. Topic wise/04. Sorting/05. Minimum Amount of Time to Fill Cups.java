class Solution {
    public int fillCups(int[] arr) {
        int ans = 0;
        while(arr[2]>0 || arr[1]>0 || arr[0]>0) {
            Arrays.sort(arr);
            if(arr[1]==0) {
                ans += arr[2];
                break;
            }
            else {
                ans++;
                arr[2]--;
                arr[1]--;
            }
        }
        return ans;
    }
}
-------------------------------------------------------------------------
class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[0] + amount[1] <= amount[2]) {
            return amount[2];
        } else {
            return (amount[0] + amount[1] + amount[2] + 1) / 2;
        }
    }
}
