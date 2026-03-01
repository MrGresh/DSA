class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        int diff = Integer.MAX_VALUE, e1 = -1, e2 = -1;
        int i=0, j=arr2.length-1;
        while(i<arr1.length && j>=0) {
            int curr = arr1[i]+arr2[j]-x;
            if(Math.abs(curr)<diff) {
                diff = Math.abs(curr);
                e1 = arr1[i];
                e2 = arr2[j];
            }
            if(curr==0) break; // equal to x
            else if(curr>0) j--; // greater then x
            else i++; // less then x
        }
        return new ArrayList<>(Arrays.asList(e1, e2));
    }
}
