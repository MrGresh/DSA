class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingZeros = new int[n];
        
        // Step 1: Count trailing zeros for each row
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }
            trailingZeros[i] = count;
        }
        
        int totalSwaps = 0;
        
        // Step 2: Greedily satisfy requirements for each row i
        for (int i = 0; i < n; i++) {
            int required = n - 1 - i;
            int foundIdx = -1;
            
            // Find the first row that satisfies the requirement
            for (int j = i; j < n; j++) {
                if (trailingZeros[j] >= required) {
                    foundIdx = j;
                    break;
                }
            }
            
            // If no such row is found, it's impossible
            if (foundIdx == -1) return -1;
            
            // Step 3: "Bubble" the found row up to the current position i
            while (foundIdx > i) {
                // Swap current with the one above it
                int temp = trailingZeros[foundIdx];
                trailingZeros[foundIdx] = trailingZeros[foundIdx - 1];
                trailingZeros[foundIdx - 1] = temp;
                
                totalSwaps++;
                foundIdx--;
            }
        }
        
        return totalSwaps;
    }
}
