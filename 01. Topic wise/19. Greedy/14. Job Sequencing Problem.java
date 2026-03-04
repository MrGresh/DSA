class Solution {
    int[] parent;
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        int[][] jobs = new int[n][2];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = profit[i];
            jobs[i][1] = deadline[i];
        }

        // Sort jobs by increasing profit
        Arrays.sort(jobs, (a, b) -> b[0] - a[0]);

        // Find max deadline to size the slot array
        int maxDeadline = 0;
        for (int d : deadline) {
            maxDeadline = Math.max(maxDeadline, d);
        }
        
        parent = new int[maxDeadline + 1];
        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }

        // boolean[] slots = new boolean[maxDeadline + 1]; // 1-based indexing
        int jobCount = 0, totalProfit = 0;

        for (int[] job : jobs) {
            int deadLine = job[1];
            for (int date = deadLine; date >= 1; date--) {
                /*if (!slots[date]) {
                    slots[date] = true;
                    jobCount++;
                    totalProfit += job[0];
                    break;
                }*/
                int availableDate = find(date);
                if(availableDate>0) {
                    parent[availableDate] = find(availableDate-1);
                    jobCount++;
                    totalProfit += job[0];
                    break;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(jobCount);
        result.add(totalProfit);
        return result;
    }
    int find(int i) {
        if (i == parent[i]) return i;
        return parent[i] = find(parent[i]); // Path compression
    }
}
