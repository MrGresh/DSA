int search(int[] nums, int k) {
        // pivot is the index of smallest element in array
        int l=0, r=nums.length-1;
        while(l<r) {
            int m = l+(r-l)/2;
            if(nums[m]<=nums[r]) r = m;
            else l=m+1;
        }
        if(l==0) {
            r = nums.length-1;
            while(l<=r) {
                int m = l+(r-l)/2;
                if(nums[m]==k) return m;
                else if(nums[m]>k) r = m-1;
                else l=m+1;
            }
        }
        else {
            if(k>=nums[0] && k<=nums[l-1]) {
                r = l-1;
                l=0;
                while(l<=r) {
                    int m = l+(r-l)/2;
                    if(nums[m]==k) return m;
                    else if(nums[m]>k) r = m-1;
                    else l=m+1;
                }
            } else {
                r = nums.length-1;
                while(l<=r) {
                    int m = l+(r-l)/2;
                    if(nums[m]==k) return m;
                    else if(nums[m]>k) r = m-1;
                    else l=m+1;
                }
            }
        }
        return -1;
    }
    ----------------------------------------------------------------------------------------
    int search(int[] nums, int k) {
        int l = 0, r = nums.length-1;
        while(l<=r) {
            int m = l+(r-l)/2;
            if(nums[m]==k) return m;

            // Determine which side is sorted
            else if(nums[m]>=nums[l]) { // Left side is sorted
                if(k>=nums[l] && k<nums[m]) r=m-1;
                else l=m+1;
            }
            else { // Right side is sorted means nums[m]<nums[l]
                if(k>nums[m] && k<=nums[r]) l=m+1;
                else r=m-1;
            }
        }
        return -1;
    }
    
