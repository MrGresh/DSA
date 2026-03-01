double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length, m = nums2.length;
    int totalLen = n + m;
    int target = totalLen / 2;
    int i = 0, j = 0, count = 0;
    int prev = 0, curr = 0;

    // 1. Both arrays have elements
    while (i < n && j < m && count <= target) {
        prev = curr;
        if (nums1[i] < nums2[j]) {
            curr = nums1[i++];
        } else {
            curr = nums2[j++];
        }
        count++;
    }

    while (i < n && count <= target) {
        prev = curr;
        curr = nums1[i++];
        count++;
    }

    while (j < m && count <= target) {
        prev = curr;
        curr = nums2[j++];
        count++;
    }

    if (totalLen % 2 == 0) {
        return (prev + curr) / 2.0;
    } else {
        return (double) curr;
    }
}
--------------------------------------------------------------------------------
double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
        return findMedianSortedArrays(nums2, nums1);
    }
    
    int m = nums1.length;
    int n = nums2.length;
    int low = 0, high = m;
    
    while (low <= high) {
        int partitionX = (low + high) / 2;
        int partitionY = (m + n + 1) / 2 - partitionX;
        
        int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
        int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
        
        int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
        int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
        
        if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
            if ((m + n) % 2 == 0) {
                return (double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
            } else {
                return (double)Math.max(maxLeftX, maxLeftY);
            }
        } else if (maxLeftX > minRightY) high = partitionX - 1;
        else if (maxLeftY > minRightX) low = partitionX + 1;
    }
    
    throw new IllegalArgumentException("Input arrays are not sorted.");
}
