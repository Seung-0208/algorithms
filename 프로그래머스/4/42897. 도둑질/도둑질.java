class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[][] dp = new int[2][n];
        
        dp[0][0] = money[0];
        dp[0][1] = money[0];
        
        for(int i=2; i<n-1; i++) {
            dp[0][i] = Math.max(dp[0][i-1], dp[0][i-2]+money[i]);
        }
        dp[0][n-1] = dp[0][n-2];
        
        dp[1][1] = money[1];
        for(int i=2; i<n; i++) {
            dp[1][i] = Math.max(dp[1][i-1], dp[1][i-2]+money[i]);
        }
        
        int answer = Math.max(dp[1][n-1], dp[0][n-1]);
        return answer;
    }
}