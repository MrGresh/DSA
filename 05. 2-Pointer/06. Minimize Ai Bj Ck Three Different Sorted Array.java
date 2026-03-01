public class codefile{
    public static int solve(int[]  a,int[] b, int[] c){
        int ans = Integer.MAX_VALUE;
        int i=0,j=0,k=0;
        while(i<a.length && j<b.length && k<b.length) {
            int min = Math.min(a[i], Math.min(b[j], c[k]));
            int max = Math.max(a[i], Math.max(b[j], c[k]));
            ans = Math.min(ans, max-min);
            if(min==a[i]) i++;
            else if(min==b[j]) j++;
            else k++;
        }
        return ans;
    }
}
