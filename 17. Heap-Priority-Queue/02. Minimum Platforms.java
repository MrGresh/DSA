// Priority Queue
class Solution {
    public int minPlatform(int[] arr, int[] dep) {
        int n = arr.length;

        int[][] trains = new int[n][2];
        for (int i = 0; i < n; i++) {
            trains[i][0] = arr[i];
            trains[i][1] = dep[i];
        }

        Arrays.sort(trains, Comparator.comparingInt(t -> t[0]));

        // Min-heap to track earliest departure time
        PriorityQueue<Integer> platformHeap = new PriorityQueue<>();

        int maxPlatforms = 0;

        for (int[] train : trains) {
            int arrival = train[0];
            int departure = train[1];

            while (!platformHeap.isEmpty() && arrival > platformHeap.peek()) platformHeap.poll();

            platformHeap.offer(departure);

            maxPlatforms = Math.max(maxPlatforms, platformHeap.size());
        }

        return maxPlatforms;
    }
}
----------------------------------------------------------------------------------------------------------------
// Line-Sweep
class Solution {
    public int minPlatform(int[] arr, int[] dep) {
        TreeMap<Double, Integer> map = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            double arrivalTime = (double) arr[i];
            map.put(arrivalTime, map.getOrDefault(arrivalTime, 0) + 1);

            double departureTime = dep[i] + 0.1; 
            map.put(departureTime, map.getOrDefault(departureTime, 0) - 1);
        }

        int maxPlatforms = 0;
        int currentPlatforms = 0;

        for (int count : map.values()) {
            currentPlatforms += count;
            maxPlatforms = Math.max(maxPlatforms, currentPlatforms);
        }

        return maxPlatforms;
    }
}
-------------------------------------------------------------------------------------------------------------------
class Solution {
    public int minPlatform(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
    
        int n = arr.length;
        int platformsNeeded = 0;
        int maxPlatforms = 0;
        
        int i = 0;
        int j = 0;
    
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platformsNeeded++;
                i++;
            } 
            else {
                platformsNeeded--;
                j++;
            }
            maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
        }
    
        return maxPlatforms;
    }
}
