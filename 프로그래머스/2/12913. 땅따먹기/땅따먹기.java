class Solution {
    int solution(int[][] land) {
        int N = land.length;
        
        int[][] dp = new int[N][4];
        System.arraycopy(land[0], 0, dp[0], 0, 4);
        
        for(int i=1; i<N; i++) {
            for(int j=0; j<4; j++) {
                for(int k=0; k<4; k++) {
                    if(j==k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i][j]);
                }
            }
        }
        int answer = 0;
        for(int i=0; i<4; i++) {
            answer = Math.max(answer, dp[N-1][i]);
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}