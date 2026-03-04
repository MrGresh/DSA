class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Integer cand1 = null, cand2 = null;
        int count1 = 0, count2 = 0;

        for (int x : nums) {
            if (cand1 != null && x == cand1) count1++;
            else if (cand2 != null && x == cand2) count2++;
            else if (count1 == 0) {
                cand1 = x;
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = x;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> result = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int x : nums) {
            if (cand1 != null && x == cand1) count1++;
            if (cand2 != null && x == cand2) count2++;
        }

        if (count1 > n / 3) result.add(cand1);
        if (count2 > n / 3) result.add(cand2);

        return result;
    }
}
