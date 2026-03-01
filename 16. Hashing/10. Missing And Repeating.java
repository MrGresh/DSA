class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        Set<Integer> s = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        long sum = 0;
        for(int x : arr) {
            if(s.contains(x)) ans.add(x);
            sum += x;
            s.add(x);
        }
        int n = arr.length;
        long aSum = (long)n*(n+1)/2;
        ans.add((int)(aSum - (sum - (long)ans.get(0))));
        return ans;
    }
}
------------------------------------------------------------------------
class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        long reqsum = (long)n*(n+1)/2;
        long sum = 0;
        for(int x: arr) {
            int val = Math.abs(x);
            if(arr[val-1]<0) res.add(val);
            else arr[val-1] *= -1;
            sum += val;
        }
        res.add((int)(reqsum-(sum-res.get(0))));
        return res;
    }
}
