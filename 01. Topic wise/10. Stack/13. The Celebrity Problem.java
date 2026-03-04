class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int[] inDeg = new int[n];
        int[] outDeg = new int[n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j]==1) {
                    outDeg[i]++;
                    inDeg[j]++;
                }
            }
        }
        for(int i=0;i<n;i++) {
            if(inDeg[i]==n && outDeg[i]==1) return i;
        }
        return -1;
    }
}
-------------------------------------------------------------------
class Solution {
    public int celebrity(int mat[][]) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<mat.length;i++) st.push(i);
        while(st.size()>1) {
            int p1 = st.pop();
            int p2 = st.pop();
            if (mat[p1][p2] == 1 && mat[p2][p1] == 0) st.push(p2);
            if (mat[p1][p2] == 0 && mat[p2][p1] == 1) st.push(p1);
        }
        if (st.isEmpty()) return -1;
        int candidate = st.pop();
        
        for (int i = 0; i < mat.length; i++) {
            if (i == candidate) continue;
            if (mat[i][candidate] == 0 || mat[candidate][i] == 1) {
                return -1;
            }
        }
        return candidate;
    }
}
---------------------------------------------------------------------
class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int top = 0;
        int down = n - 1;

        while (top < down) {
            if (mat[top][down] == 1) top++;
            else down--;
        }

        int candidate = top; // down will also work
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;
            
            if (mat[i][candidate] == 0 || mat[candidate][i] == 1) {
                return -1;
            }
        }
        return candidate;
    }
}
