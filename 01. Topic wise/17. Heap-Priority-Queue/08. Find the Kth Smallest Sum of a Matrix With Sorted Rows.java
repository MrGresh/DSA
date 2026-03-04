class Solution {
    PriorityQueue<Integer> pq;
    public int kthSmallest(int[][] mat, int k) {
        pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int col=0;col<mat[0].length;col++) {
            helper(mat, 1, mat[0][col], k);
        }
        return pq.peek();
    }
    void helper(int[][] mat, int row, int sum, int k) {
        if(row==mat.length) {
            pq.offer(sum);
            if(pq.size()>k) pq.poll();
            return;
        }
        for(int col=0;col<mat[row].length;col++) {
            helper(mat, row+1, sum + mat[row][col], k);
        }
    }
}
---------------------------------------------------------------------------------
class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        int[] init = new int[m];
        int sum = 0;

        for (int i = 0; i < m; i++) sum += mat[i][0];

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.sum));
        Set<String> seen = new HashSet<>();
        pq.offer(new State(sum, init));
        seen.add(Arrays.toString(init));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (--k == 0) return cur.sum;

            for (int i = 0; i < m; i++) {
                if (cur.indices[i] + 1 < mat[i].length) {
                    int[] next = cur.indices.clone();
                    next[i]++;
                    int newSum = cur.sum - mat[i][cur.indices[i]] + mat[i][next[i]];
                    String key = Arrays.toString(next);
                    if (seen.add(key)) pq.offer(new State(newSum, next));
                }
            }
        }

        return -1; // Should never reach here
    }

    static class State {
        int sum;
        int[] indices;
        State(int sum, int[] indices) {
            this.sum = sum;
            this.indices = indices;
        }
    }
}
