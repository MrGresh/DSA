class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        rec(nums, 0, new ArrayList<>());
        return ans;
    }
    void rec(int[] nums, int i, List<Integer> curr) {
        if(i==nums.length) {
            if(!ans.contains(curr)) ans.add(new ArrayList<>(curr));
            return;
        }
        rec(nums, i+1, curr);
        curr.add(nums[i]);
        rec(nums, i+1, curr);
        curr.removeLast();
    }
}
------------------------------------------------------------------------------
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        rec(nums, 0, new ArrayList<>());
        return ans;
    }
    private void rec(int[] nums, int idx, List<Integer> curr) {
        ans.add(new ArrayList<>(curr));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            rec(nums, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
