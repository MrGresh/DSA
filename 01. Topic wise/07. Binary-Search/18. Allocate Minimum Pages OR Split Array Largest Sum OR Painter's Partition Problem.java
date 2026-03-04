class Solution {
    public int findPages(int[] books, int students) {
        if(students>books.length) return -1;
        int max = Integer.MIN_VALUE, sum = 0;
        for(int b: books) {
            max = Math.max(max, b);
            sum += b;
        }
        int l=max, r=sum, ans = 0;
        while(l<=r) {
            int m = l+(r-l)/2;
            if(isPossible(books, students, m)) {
                ans = m;
                r = m-1;
            } else l=m+1;
        }
        return ans;
    }
    boolean isPossible(int[] books, int students, int pages) {
        int curr_pages = 0;
        for(int p: books) {
            if(curr_pages+p<=pages) curr_pages += p;
            else {
                curr_pages = p;
                students--;
                if(students==0) return false;
            }
        }
        return true;
    }
}
