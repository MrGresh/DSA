class Solution {
    public String reverseWords(String s) {
        char[] arr = s.trim().replaceAll("\\s+", " ").toCharArray();
        
        if(arr.length>1) rev(arr, 0, arr.length - 1);
        
        int i = 0, j = 0;
        while (j < arr.length) {
            if (arr[j] == ' ') {
                rev(arr, i, j - 1);
                i = j + 1;
                j = j + 2;
            }
            else j++;
        }
        if(i!=arr.length - 1) rev(arr, i, arr.length - 1);
        return new String(arr);
    }

    void rev(char[] arr, int i, int j) {
        while (i < j) {
            char c = arr[i];
            arr[i++] = arr[j];
            arr[j--] = c;
        }
    }
}
