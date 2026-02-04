class Solution {
    StringBuilder sb = new StringBuilder();
    public int solution(int[][] triangle) {
        int rowSize = triangle.length;
        int[][] dp = new int[rowSize][];
        for(int i=0; i<rowSize; i++) {
            dp[i] = new int[i+1];
        }
        sb.append(triangle[0].length);
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<triangle.length; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                if(j==0) {
                    dp[i][j] = dp[i-1][0] + triangle[i][j];
                } else if(j==triangle[i].length - 1) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
                }
            }   
        }
        int max = 0;
        for(int v : dp[dp.length-1]) {
            max = Math.max(v, max);
        }
        sb.append(max);
        int answer = triangle[rowSize-1][triangle[rowSize-1].length - 1];
        return max;
        // return sb.toString();
    }
}