class Solution {
    public int solution(int[] money) {
        int[][] dp = new int[2][money.length];
        dp[0][0] = money[0]; //0번 집을 터는 경우
        dp[0][1] = money[0];
        for(int i=2; i<money.length-1; i++) {
            dp[0][i] = Math.max(dp[0][i-1], dp[0][i-2]+money[i]);
        }
        dp[0][money.length-1] = dp[0][money.length-2];
        
        dp[1][1] = money[1]; //0번 집을 안 터는 경우
        for(int i=2; i<money.length; i++) {
            dp[1][i] = Math.max(dp[1][i-1], dp[1][i-2]+money[i]);
        }
        int answer = Math.max(dp[0][money.length-1], dp[1][money.length-1]);
        return answer;
    }
}