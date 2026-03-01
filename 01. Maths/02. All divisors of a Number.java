class Solution {
    public static void print_divisors(int n) {
        List<Integer> nums = new ArrayList<>();
        for(int i=1;i*i<=n;i++) {
            if(n%i==0) {
                nums.add(i);
                if(i!=n/i) nums.add(n/i);
            }
        }
        Collections.sort(nums);
        for(int x: nums) System.out.print(x+" ");
    }
}
