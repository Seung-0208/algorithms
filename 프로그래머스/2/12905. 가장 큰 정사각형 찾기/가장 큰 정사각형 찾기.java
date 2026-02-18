class Solution
{
    public int solution(int [][]dp)
    {
        int N = dp.length;
        int M = dp[0].length;
        
        int max = 0;
        
        for(int i=1; i<N; i++) {
            for(int j=1; j<M; j++) {
                if(dp[i][j] == 1) {
                    int temp = Math.min(dp[i][j-1], dp[i-1][j]);
                    dp[i][j] = Math.min(temp, dp[i-1][j-1])+1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        if(N==1 && M==1 && dp[0][0]==1) return 1;
        return max*max;
    }
}