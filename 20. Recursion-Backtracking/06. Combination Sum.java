class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>target) continue;
            curr.add(nums[i]);
            genCombinations(curr, nums, target-nums[i], i);
            curr.remove(curr.size()-1);
        }
        return res;
    }
    void genCombinations(List<Integer> curr, int[] nums, int target, int idx) {
        if(target==0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=idx;i<nums.length;i++) {
            if(target-nums[i]>=0) {
                curr.add(nums[i]);
                genCombinations(curr, nums, target-nums[i], i);
                curr.remove(curr.size()-1);
            }
        }
        
        /*if(target-nums[idx]>=0) { // it can be used
            curr.add(nums[idx]);
            genCombinations(curr, nums, target-nums[idx], idx);
            curr.remove(curr.size()-1);
        }
        if(idx+1<nums.length) genCombinations(curr, nums, target, idx+1);*/
    }
}
