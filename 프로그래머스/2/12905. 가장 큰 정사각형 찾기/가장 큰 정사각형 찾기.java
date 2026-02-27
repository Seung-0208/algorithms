class Solution
{
    public int solution(int [][]board)
    {
        int n = board.length;
        int m = board[0].length;
        if(n==1 && m==1 && board[0][0]==1) return 1;
        int answer = Integer.MIN_VALUE;
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(board[i][j] == 1) {
                    int temp = Math.min(board[i-1][j], board[i][j-1]);
                    temp = Math.min(temp, board[i-1][j-1]);
                    board[i][j] = temp+1;
                    answer = Math.max(board[i][j], answer);
                }
            }
        }


        return answer*answer;
    }
}