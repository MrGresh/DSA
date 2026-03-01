class Solution {
    public int findPairs(int[] nums, int k) {
        if(k==0) {
            int res = 0;
            Map<Integer, Integer> counts = new HashMap<>();
            for(int x : nums) counts.put(x, counts.getOrDefault(x, 0) + 1);
            for(int count : counts.values()) {
                if(count > 1) res++;
            }
            return res;
        } else {
            Set<Integer> s = new HashSet<>();
            for(int x : nums) s.add(x);
            Set<String> unique = new HashSet<>();
            for(int x : s) {
                if(s.contains(x-k)) {
                    String pair = (x - k) + "," + x; // pair = "small_ele,big_ele"
                    unique.add(pair);
                } else if(s.contains(x+k)) {
                    String pair = x + "," + (x + k);
                    unique.add(pair);
                }
            }
            return unique.size();
        }
    }
}
---------------------------------------------------------------------------------------------
class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        
        int left = 0;
        int right = 1;
        int count = 0;
        int n = nums.length;
        
        while (left < n && right < n) {
            // Ensure we aren't comparing the same index
            if (left == right) {
                right++;
                continue;
            }
            
            int diff = nums[right] - nums[left];
            
            if (diff == k) {
                count++;
                left++;
                
                // Skip duplicates
                while (left < n && nums[left] == nums[left - 1]) left++;
                
                // Ensure right is always ahead of left
                if (right < left) right = left + 1;
            } else if (diff < k) {
                right++;
            } else {
                left++;
            }
        }
        
        return count;
    }
}
