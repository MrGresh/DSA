class Solution {
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for(int x : nums) {
            if(m.containsKey(x)) res += m.get(x);
            else {
                int ans = getDivisorSum(x);
                res += ans;
                m.put(x, ans);
            }
        }
        return res;
    }
    int getDivisorSum(int n) {
        int sum = 0, count = 0;
        for(int i=1;i*i<=n;i++) {
            if(n%i==0) {
                if(i*i==n) return 0; // perfect square will not have 4 factors
                count++;  
                if(count>4) return 0; 
                sum += i;     
                if (i != n / i) {
                    count++;
                    sum += n / i;
                }
                if(count>4) return 0;
            }
        }
        if(count==4) return sum;
        else return 0;
    }
}
