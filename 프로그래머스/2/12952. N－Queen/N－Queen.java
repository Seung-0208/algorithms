class Solution {
    boolean[] colVisited;
    boolean[] plusDiagonal;
    boolean[] minusDiagonal;
    int ans = 0;
    public int solution(int n) {
        
        colVisited = new boolean[n];
        plusDiagonal = new boolean[(n-1)*2+1];
        minusDiagonal = new boolean[(n-1)*2+1];
        
        tracking(n, 0);
        return ans;
    }
    
    void tracking(int n, int row) {
        if(row == n) {
            ans++;
            return;
        } 
        
        for(int j=0; j<n; j++) {
            int gap = (row-j) < 0 ? (row-j)*(-1)+(n-1) : (row-j);
            if(!colVisited[j] && !plusDiagonal[row+j] && !minusDiagonal[gap]) {
                colVisited[j] = true;
                plusDiagonal[row+j] = true;
                minusDiagonal[gap] = true;
                tracking(n, row+1);
                colVisited[j] = false;
                plusDiagonal[row+j] = false;
                minusDiagonal[gap] = false;
            }
        }
    }
}