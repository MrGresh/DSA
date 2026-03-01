class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        for (int i = 0; i < gas.length; i++) totalTank += gas[i] - cost[i];
        if(totalTank<0) return -1;
        
        int currTank = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            currTank += gas[i] - cost[i];
            // If we can't reach the next station from here, reset start
            if (currTank < 0) {
                startIndex = i + 1;
                currTank = 0;
            }
        }

        return startIndex;
    }
}
