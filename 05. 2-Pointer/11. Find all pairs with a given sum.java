class Solution {
    public pair[] allPairs(int target, int arr1[], int arr2[]) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i=0, j=arr2.length-1;
        while(i<arr1.length && j>=0) {
            int val = arr1[i]+arr2[j];
            if(val==target) {
                List<Integer> curr = new ArrayList<>();
                curr.add(arr1[i]);
                curr.add(arr2[j]);
                
                int tempI = i, tempJ = j;
                while (tempI < arr1.length && arr1[tempI] == arr1[i]) tempI++;
                while (tempJ >= 0 && arr2[tempJ] == arr2[j]) tempJ--;
                for (int k = 1; k <= ((tempI-i)*(j-tempJ)); k++) ans.add(curr);
                
                i=tempI;
                j=tempJ;
            }
            else if(val>target) j--;
            else i++;
        }
        pair[] res = new pair[ans.size()];
        int idx=-1;
        for(List<Integer> li : ans) {
            res[++idx] = new pair((long) li.get(0), (long) li.get(1));
        }
        return res;
    }
}
