class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(x<arr[0]) {
            for(int i=0;i<k;i++) res.add(arr[i]);
        } else if(x>arr[arr.length-1]) {
            int i=arr.length-1;
            while(k-->0) res.add(arr[i--]);
        } else {
            int piv = -1;
            int a=0, b=arr.length-1;
            while(a<=b) {
                int m = a+(b-a)/2;
                if(arr[m]<x) {
                    piv = m;
                    a=m+1;
                } else if(arr[m]==x) {
                    piv = m;
                    break;
                }
                else b=m-1;
            }
            int l=piv, r = piv+1;
            while(l>=0 && r<arr.length && k-->0) {
                if(Math.abs(arr[l]-x)<=Math.abs(arr[r]-x)) res.add(arr[l--]);
                else res.add(arr[r++]);
            }
            while(l>=0 && k-->0) res.add(arr[l--]);
            while(r<arr.length && k-->0) res.add(arr[r++]);
        }
        Collections.sort(res);
        return res;
    }
}
