class Solution {
    boolean[] isColVisited;
    boolean[] isPlusDiagVisited;
    boolean[] isMinusDiagVisited;
    int cnt = 0;
    
    public int solution(int n) {
        isColVisited = new boolean[n];
        isPlusDiagVisited = new boolean[n*2+1];
        isMinusDiagVisited = new boolean[n*2+1];
        tracking(0, n);
        
        return cnt;
    }
    
    void tracking(int row, int n) {
        if(n==row) {
            cnt++;
            return;
        }
        
        for(int i=0; i<n; i++) {
            int gap = row-i;
            
            //-1 -2 -3
            if(gap < 0) gap = n*2+1+gap;
            if(!isColVisited[i] && !isPlusDiagVisited[i+row] && !isMinusDiagVisited[gap]) {
                isColVisited[i] = true;
                isPlusDiagVisited[i+row] = true;
                isMinusDiagVisited[gap] = true;
                
                tracking(row+1, n);
                
                isColVisited[i] = false;
                isPlusDiagVisited[i+row] = false;
                isMinusDiagVisited[gap] = false;
            }
        }
    }
}