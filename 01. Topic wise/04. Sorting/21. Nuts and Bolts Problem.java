class Solution {
    Map<Character, Integer> m;
    void matchPairs(int n, char nuts[], char bolts[]) {
        m = new HashMap<>();
        m.put('!', 1);
        m.put('#', 2);
        m.put('$', 3);
        m.put('%', 4);
        m.put('&', 5);
        m.put('*', 6);
        m.put('?', 7);
        m.put('@', 8);
        m.put('^', 9);
        quicksort(nuts, bolts, 0, n-1);
    }
    void quicksort(char[] nuts, char[] bolts, int low, int high) {
        if (low < high) {
            char piv = nuts[high];
            partition(nuts, low, high, piv);
            int pivLoc = partition(bolts, low, high, piv);
            quicksort(nuts, bolts, low, pivLoc - 1);
            quicksort(nuts, bolts, pivLoc + 1, high);
        }
    }
    int partition(char[] arr, int low, int high, char piv) {
        int a=low-1, pivLoc = -1;
        for(int i = low;i <= high;i++) {
            if(m.get(arr[i])<=m.get(piv)) {
                ++a;
                char t = arr[a];
                arr[a] = arr[i];
                arr[i] = t;
                if(arr[a]==piv) pivLoc = a;
            }
        }
        arr[pivLoc] = arr[a];
        arr[a] = piv;
        return a;
    }
}
