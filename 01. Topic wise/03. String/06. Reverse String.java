class Solution {
    public void reverseString(char[] arr) {
        int i=0, j=arr.length-1;
        while(i<j) {
            char t = arr[i];
            arr[i++] = arr[j];
            arr[j--] = t;
        }      
    }
}
