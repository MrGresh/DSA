class Solution {
    public double minMaxDist(int[] stations, int k) {
        if (stations.length < 2) return 0.000000;
        PriorityQueue<Gap> pq = new PriorityQueue<>((a, b) -> Double.compare(b.originalSize/b.sections, a.originalSize/a.sections));

        for (int i = 0; i < stations.length - 1; i++) {
            double gapLen = (double) stations[i + 1] - stations[i];
            pq.add(new Gap(gapLen, 1));
        }

        for (int i = 0; i < k; i++) {
            Gap largestCurrentSizeGap = pq.poll();
            largestCurrentSizeGap.sections++;
            pq.add(largestCurrentSizeGap);
        }
        Gap largestCurrentSizeGap = pq.poll();
        double currentSize = largestCurrentSizeGap.originalSize/largestCurrentSizeGap.sections;
        return Math.round(currentSize * 1e6) / 1e6;
    }

    class Gap {
        double originalSize;
        int sections;

        Gap(double originalSize, int sections) {
            this.originalSize = originalSize;
            this.sections = sections;
        }
    }
}
-----------------------------------------------------------------------------
class Solution {
    public double minMaxDist(int[] stations, int k) {
        double low = 0;
        double high = stations[stations.length - 1] - stations[0];
        
        double ans = 0;
        double precision = Math.pow(10, -6);
        while (low<=high) {
            double mid = low + (high - low) / 2;
            if (isPossible(stations, k, mid)) {
                ans = mid;
                high = mid-precision;
            } else {
                low = mid+precision;
            }
        }
        
        return ans;
    }
    private boolean isPossible(int[] stations, int k, double maxDist) {
        int reqStations = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            double gap = stations[i + 1] - stations[i];
            // Calculate how many stations are needed to make every gap <= maxDist
            reqStations += (int) (gap / maxDist);
            if(reqStations>k) return false;
        }
        return true;
    }
}
