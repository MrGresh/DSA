class Solution {
    public long subarrayXor(int nums[], int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int res = 0;
        for(int i=0;i<nums.length;i++) {
            if(i>0) nums[i] ^= nums[i-1];
            if(nums[i]==k) res+=1;
            if(m.containsKey(nums[i]^k)) res += m.get(nums[i]^k);
            m.put(nums[i], m.getOrDefault(nums[i], 0)+1);
        }
        return res;        
    }
}
