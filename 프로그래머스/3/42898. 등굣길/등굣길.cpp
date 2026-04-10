#include <string>
#include <vector>
#include <bits/stdc++.h>
#include <climits>

using namespace std;

int solution(int m, int n, vector<vector<int>> paramPuddles) {
    vector<vector<int>> puddles(n+1, vector<int>(m+1, 0));
    
    for(vector<int> p : paramPuddles) {
        int c = p[0];
        int r = p[1];
        puddles[r][c] = 1;
    }
    
    vector<vector<int>> dp(n+1, vector<int>(m+1, 0));
    dp[1][1] = 1;
    
    for(int i=1; i<=n; i++) {
        for(int j=1; j<=m; j++) {
            if(puddles[i][j] == 1) continue;
            if(i != 1 || j != 1) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000007;
            }
        }
    }
    
    return dp[n][m];
}