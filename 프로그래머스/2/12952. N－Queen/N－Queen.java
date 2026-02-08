class Solution {
    // int plusDiagVisit = 0;
    // int minusDiagVisit = 0;
    // int colVisit = 0;
    int cnt = 0;
    public int solution(int n) {
        backtracking(0, n, 0, 0, 0);
        int answer = cnt;
        return answer;
    }

    void backtracking(int row, int n, int colIsUsed, int pDiagIsUsed, int mDiagIsUsed) {
        if(row == n) {
            cnt++;
            return;
        }

        for(int i=0; i<n; i++) {
            int plusTemp = row+i;
            int minusTemp = row-i < 0 ? (n-1)*2+(row-i) : row-i;
            boolean checkCol = (colIsUsed & (1 << i)) == 0;
            boolean checkPlusDiag = ((1 << plusTemp) & pDiagIsUsed) == 0;
            boolean checkMinusDiag = ((1 << minusTemp) & mDiagIsUsed) == 0;
            if(checkCol && checkPlusDiag && checkMinusDiag) {
                backtracking(row+1, n, colIsUsed | (1<<i), pDiagIsUsed | (1<<plusTemp), mDiagIsUsed | (1<<minusTemp));
            }
        }
    }
}