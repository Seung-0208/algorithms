#include <iostream>
#include<vector>
#include<climits>

using namespace std;

int solution(vector<vector<int>> board)
{
    int n = board.size();
    int m = board[0].size();
    
    vector<vector<int>> dp(n+1, vector<int>(m+1, 0));
    int answer = INT_MIN;
    
    for(int i=1; i<n+1; i++) {
        for(int j=1; j<m+1; j++) {
            //최솟값 찾기
            int temp = dp[i-1][j];
            if(temp > dp[i][j-1]) temp = dp[i][j-1];
            if(temp > dp[i-1][j-1]) temp = dp[i-1][j-1];
            
            if(board[i-1][j-1] == 1) {
                dp[i][j] = temp + 1;
                if(answer < dp[i][j]) answer = dp[i][j];
            }
        }
    }
    
    if(answer == INT_MIN) return 0;
    else return (answer*answer);

}