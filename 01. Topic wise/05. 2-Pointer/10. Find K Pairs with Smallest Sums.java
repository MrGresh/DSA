class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> nums1[a[0]] + nums2[a[1]]));
        Set<String> seen = new HashSet<>();

        pq.offer(new int[]{0, 0});
        seen.add("0,0");

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0], j = cur[1];
            res.add(Arrays.asList(nums1[i], nums2[j]));
            if(res.size()==k) break;
            
            if (i + 1 < nums1.length && seen.add((i + 1) + "," + j)) {
                pq.offer(new int[]{i + 1, j});
            }
            if (j + 1 < nums2.length && seen.add(i + "," + (j + 1))) {
                pq.offer(new int[]{i, j + 1});
            }
        }

        return res;
    }
}
-------------------------------------------------------------
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums1.length, m = nums2.length;
        if (n == 0 || m == 0 || k == 0) return res;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for (int i = 0; i < Math.min(n, k); i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            res.add(Arrays.asList(cur[0], cur[1]));

            if (cur[2] + 1 < m) {
                pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
            }
        }

        return res;
    }
}
