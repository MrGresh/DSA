class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>target) continue;
            if(i>0 && nums[i]==nums[i-1]) continue;
            List<Integer> curr = new ArrayList<>();
            curr.add(nums[i]);
            genCombinations(curr, nums, target-nums[i], i+1);
        }
        return res;        
    }
    void genCombinations(List<Integer> curr, int[] nums, int target, int idx) {
        if(target==0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<nums.length;i++) {
            if(i>idx && nums[i]==nums[i-1]) continue;
            if(target-nums[i]>=0) {
                curr.add(nums[i]);
                genCombinations(curr, nums, target-nums[i], i+1);
                curr.removeLast();
            }
        }

        /*if(target-nums[idx]>=0) { // it can't be used because it'll give duplicates
            curr.add(nums[idx]);
            genCombinations(curr, nums, target-nums[idx], idx+1);
            curr.remove(curr.size()-1);
        }
        if(idx+1<nums.length) genCombinations(curr, nums, target, idx+1);*/
    }    
}
